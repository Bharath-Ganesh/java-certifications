package src.com.certifications.javase11.chapter14MultiThreading.project.mgmt;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import src.com.certifications.javase11.chapter14MultiThreading.project.prod.Product;
import src.com.certifications.javase11.chapter14MultiThreading.project.prod.ProductManager;
import src.com.certifications.javase11.chapter14MultiThreading.project.prod.Rating;

public class Shop {

    private static final Logger logger = Logger.getLogger(Shop.class.getName());

    public static void main(String[] args) {

        ProductManager pm = ProductManager.getInstance();

        // This variable will be shared btw concurrent callers.
        AtomicInteger clientCount = new AtomicInteger(0);

        Callable<String> client = () -> {
            String clientId = "Client" + clientCount.incrementAndGet();
            String threadName = Thread.currentThread()
                .getName();
            int productId = ThreadLocalRandom.current()
                .nextInt(5) + 101;
            String languageTag = ProductManager.getSupportedLocales()
                .stream()
                .skip(ThreadLocalRandom.current()
                    .nextInt(4))
                .findFirst()
                .get();
            StringBuilder log = new StringBuilder();
            log.append(clientId + " " + threadName + "\n-\tstart of the log\t-\n");

            // read lock
            log.append(pm.getDiscounts(languageTag)
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + "\t" + entry.getValue())
                .collect(Collectors.joining("\n")));
            // This method write lock
            Product product = pm.reviewProduct(productId, Rating.FOUR_STAR, "Yet another review!!!!!!!");
            log.append((product != null) ? "\nProduct " + productId + "reviewed" : "\nProduct " + productId + "not reviewed reviewed");
            pm.printProductReport(productId, languageTag, clientId);
            log.append(clientId + " Generated report for " + productId + " product");
            log.append("\n-\tend of the log\t-\n");
            return log.toString();
        };

        // Now invoke 5 concurrent client Callable objects
        List<Callable<String>> clients = Stream.generate(() -> client)
            .limit(5)
            .collect(Collectors.toList());

        // You have created 5 callable objects, that are going to execute using a pool of three threads.
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            List<Future<String>> results = executorService.invokeAll(clients);
            executorService.shutdown();
            results.forEach(result -> {
                try {
                    System.out.println(result.get());
                } catch (InterruptedException | ExecutionException ex) {
                    logger.log(Level.SEVERE, "Error invoking clients" + ex.getMessage());
                }
            });
        } catch (InterruptedException ex) {
            logger.log(Level.SEVERE, "Error retrieving client logs" + ex.getMessage());
        }

    }
}
