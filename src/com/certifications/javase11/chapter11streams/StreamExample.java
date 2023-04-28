package src.com.certifications.javase11.chapter11streams;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Product {

    String name;
    BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

class Order {
    List<Product> items = new ArrayList<>();
    String customer;
    LocalDate localDate;

    public Stream<Product> items() {
        return items.stream();
    }

    public Order(List<Product> items, String customer, LocalDate localDate) {
        this.items = items;
        this.customer = customer;
        this.localDate = localDate;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}

public class StreamExample {

    public static void main(String[] args) {

        // Stream processing can be sequential and parallel
        // Stream pipeline traversal uses method chaining.
        // Pipeline traversal is lazy.
        // Adv : You don't have to go through the entire source if an optimum result is obtained.

        IntSupplier intSupplier = () -> (int) (Math.random() * 10);

        // static method of the stream class
        int sum = IntStream.generate(intSupplier)
            .takeWhile(n -> n % 8 != 0)
            .sum();
        System.out.println(sum);

        Integer num = Stream.of(intSupplier)
            .map(i -> i.getAsInt())
            .findFirst()
            .orElse(0);
        System.out.println(num);

        // Basic functional interface
        //1. Predicate<T> defines a boolean test(T t) to apply condition to filter elements \\ 1. filter()
        //2. Function<T,R> defines a R apply(T t) to convert type of elements.   \\ 2. map()
        //3. UnaryOperator<T> defines a T apply(T t) to convert values.          \\3. map()
        UnaryOperator<String> unaryOperator = val -> val.toUpperCase();

        //4. Supplier<T> defines a void T get() to produce elements.      \\ 3. generate()
        Supplier<String> textGenerator = () -> {
            Random random = new Random();
            StringBuilder txt = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                txt.append((char) (random.nextInt(26) + 'a'));
            }
            return txt.toString();
        };
        //5. Consumer<T> defines a void accept(T t) to process elements.      \\ 4. peek()
        Consumer<String> consumer = (s) -> System.out.println(s);

        Stream.generate(textGenerator)
            .limit(5)
            .map(unaryOperator)
            .forEach(consumer);

        // The example demonstrates conversion from primitive to object and from object to primitive

        // create a stream of double numbers
        int sum1 = DoubleStream.of(1.234, 1.0, 3.987, 0.321, 4.0)
            // Remove whole numbers
            .filter(n -> n != (int) n)
            // Convert primitive stream to object stream.
            .boxed()
            // map double to BigDecimal
            .map(x -> BigDecimal.valueOf(x))
            .mapToInt(x -> x.intValue())
            .sum();

        // Bi Arguments
        // 6. BiPredicate<T,U> defines a boolean test(T t,U u) to apply condition to filter elements \\ 1. filter()
        // 7. BiFunction<T,U,R> defines a R apply(T t,U u) to convert two type of elements into a single result.   \\ 2. map()
        BiFunction<Character, Character, String> biFunction = (a, b) -> "" + a + b;
        //3. BiOperator<T> defines a T apply(T t1,T t2) to convert values.          \\3. map()
        //5. BiConsumer<T,U> defines a void accept(T t,U u) to process a pair of elements.      \\ 4. peek()
        List<Order> orders=new ArrayList<>();
        //FlatMap
        List<Product> products = new ArrayList<>();
        Product product1 = new Product("Tea", BigDecimal.valueOf(1.99));
        Product product2 = new Product("Cake", BigDecimal.valueOf(2.99));
        products.add(product1);
        products.add(product2);
        Order order1=new Order(products,"Joe",LocalDate.of(2018,11,9));
        orders.add(order1);


        product1 = new Product("Cookie", BigDecimal.valueOf(1.99));
        product2 = new Product("Coffee", BigDecimal.valueOf(1.99));
        Product product3 = new Product("Cake", BigDecimal.valueOf(2.99));
        products.add(product1);
        products.add(product2);
        products.add(product3);
        Order order2=new Order(products,"Bob",LocalDate.of(2018,11,9));
        orders.add(order2);


        product1 = new Product("Tea", BigDecimal.valueOf(1.99));
        product2 = new Product("Coffee", BigDecimal.valueOf(2.99));
        products.add(product1);
        products.add(product2);
        Order order3=new Order(products,"Joe",LocalDate.of(2018,11,22));
        orders.add(order3);

        //FlatMap combines multiple stream into a single one
        // Here the Order object, each containing a stream of Product objects,
        // flattened into a single stream of products
        double tea = orders.stream()
            .flatMap(order -> order.items())
            .filter(x -> x.name.equals("Tea"))
            .mapToDouble(x -> x.price.doubleValue())
            .sum();
        System.out.println(tea);

        // Reduce operation
        // Produces a single result from the stream of values

        BinaryOperator<String> accumulator = new BinaryOperator<String>() {
            @Override
            public String apply(String s1, String s2) {
                return s1 + " " + s2;
            }
        };

        String reduce = orders.stream()
            .flatMap(x -> x.items())
            .map(p -> p.name)
            .reduce(accumulator)
            .get();
        System.out.println(reduce);

        reduce = orders.stream()
            .flatMap(x -> x.items())
            .map(p -> p.name)
            .reduce("", accumulator);
        System.out.println(reduce);

        // Collect
        // method collect accepts Collector interface implementation
        // 1. Produces new result containers using supplier
        // 2. Accumulates data element into these results container using BiConsumer.
        // 3. Combine result container using BinaryOperator
        // 4. Optionally performs a final transform of the processing result using the Function.

        // Basic Collectors.

        // collect.(<collector>)
        DoubleSummaryStatistics collect = orders.stream()
            .flatMap(order -> order.items())
            .collect(Collectors.summarizingDouble(x -> x.getPrice()
                .doubleValue()));
        System.out.println(collect.getMax());

        String nameMapping = orders.stream()
            .flatMap(order -> order.items())
            .collect(Collectors.mapping(prod -> prod.getName(), Collectors.joining(",")));
        System.out.println(nameMapping);

        // collect.(<collector>)
        // Applying a finisher
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
        String collect1 = orders.stream()
            .flatMap(order -> order.items())
            .collect(Collectors.collectingAndThen(Collectors.averagingDouble(product -> product.getPrice()
                .doubleValue()), n -> format.format(n)));
        System.out.println(collect1);


        // Grouping or Partitioning of the Stream Content
        Map<Boolean, List<Product>> tea1 = orders.stream()
            .flatMap(order -> order.items())
            .collect(Collectors.groupingBy(p -> p.name.equals("Tea")));
        System.out.println(tea1);


        // Mapping and Filtering wrp to Grouping or Partitioning
//        orders.stream().collect(Collectors.groupingBy(o->o.customer,
//            Collectors.flatMapping(order -> order.items()),Collectors.toSet()));

    }

}
