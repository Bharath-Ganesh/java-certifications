package com.certifications.javase11;

import java.util.*;
import java.util.function.Predicate;

public class CollectionsAPI {
    class Gym implements Comparable<Gym> {
        int weight;
        String instructor;

        public Gym(int weight, String instructor) {
            this.weight = weight;
            this.instructor = instructor;
        }

        @Override
        public String toString() {
            return "Gym{" +
                    "weight=" + weight +
                    ", instructor='" + instructor + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Gym o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {


        CollectionsAPI obj = new CollectionsAPI();
        Gym gym1 = obj.new Gym(20, "Sajad");
        Gym gym2 = obj.new Gym(30, "Saranya");
        Gym gym3 = obj.new Gym(5, "Saranya");
        Gym gym4 = obj.new Gym(2, "Saranya");
        Gym gym5 = obj.new Gym(15, "Sajad");

        /**
         * The " List.of"  operator returns an immutable list of collections
         * So you can't add further elements;
         */
        //List<Gym> list= List.of(gym1,gym2);
        List<Gym> list = new ArrayList<>(4);
        list.add(gym1);
        list.add(gym2);
        list.add(gym3);
        list.add(gym4);
        list.add(gym5);


        /**
         * Collections class contain a lot of static methods which can be used to work with collection
         */
        Collections.sort(list);

        /**
         * Index out of bound exception as you can add element only in the continuous form
         */
        //list.add(7,gym5);
        Set<Gym> set = new HashSet<>(list);

        /**
         * Null values are not allowed in deque
         */

        /**
         * Collections other behaviour
         *
         */
        Gym[] gymans = new Gym[3];
        /**
         * This will re-size irrespective of the declared size
         */
        Gym[] gyms = list.toArray(gymans);
        System.out.println(Arrays.toString(gyms));


        /**
         * Predicate filter
         */
        Predicate<Gym> predicate = new Predicate<Gym>() {
            @Override
            public boolean test(Gym gym) {
                return gym.instructor.equals("Saranya");
            }
        };
        list.removeIf(predicate);
        System.out.println(list);



        String[] arr = {"Tea","Cake"};
        arr[2]="Coffee";
        List<String> texts = Arrays.asList(arr);
        texts.set(0,"Coffee");
        System.out.println(texts);

    }
}
