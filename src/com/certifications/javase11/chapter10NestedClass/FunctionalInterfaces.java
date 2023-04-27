package src.com.certifications.javase11.chapter10NestedClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Menu {

    String food;
    int price;

    public Menu(String food, int price) {
        this.food = food;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu{" + "food='" + food + '\'' + ", price=" + price + '}';
    }
}

public class FunctionalInterfaces {

    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu("Biriyani",200));
        menuList.add(new Menu("Chapati",10));
        menuList.add(new Menu("Porotta",12));
        menuList.add(new Menu("Kuruma",25));
        menuList.add(new Menu("Kurukure",20));
        menuList.add(new Menu("Biriyani",300));

        Comparator<Menu> comparator1 = (m1,m2)->m2.food.compareTo(m1.food);

        Comparator<Menu> comparator2= (m1,m2)->m2.price- m1.price;


        //Default methods which helps in comparing
        Comparator<Menu> menuComparator = comparator1.thenComparing(comparator2);

        Collections.sort(menuList, menuComparator);
        System.out.println(menuList);

        menuList.add(null);

        Collections.sort(menuList,Comparator.nullsFirst(menuComparator));
        System.out.println(menuList);
    }
}
