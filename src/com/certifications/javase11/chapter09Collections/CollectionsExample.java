package src.com.certifications.javase11.chapter09Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

class Menu {

    int id;
    String food;

    public Menu(int id,String food){
        this.id=id;
        this.food=food;
    }

    @Override
    public String toString() {
        return  "{id:" + id + ", food:" + food + "}";
    }
}
public class CollectionsExample {

    public static void main(String[] args) {
        Menu menu1=new Menu(1,"Biriyani");
        Menu menu2=new Menu(2,"Rice");
        Menu menu3=new Menu(3,"Chapati");
        Menu menu4=new Menu(4,"Appam");

        /*
        1.  List.of() : Read only
        This would result into an error because the List.of() operation creates a read only list.
        You can't add or remove elements from the list
         */
        List<Menu> menuListOf = List.of(menu1, menu2, menu3, menu4);

        Menu menu5=new Menu(5,"Porotta");
        //menuList.add(menu5); Uncomment

         /*
        2.  Arrays.asList() : Fixed size list
        This would result into an error because the Arrays.asList() operation creates a list of fixed size.
        You can't add or remove elements from the list
         */
        List<Menu> menuAsList = Arrays.asList(menu1, menu2, menu3, menu4);
       // menus.add(menu5);


        List<Menu> menuList=new ArrayList<>(List.of(menu1,menu2));
        menuList.add(menu4);
        menuList.add(menu5);


        System.out.println(menuList);

        //The add method at a particular index will insert the element at the given index,
        // and also push forward all other element by an index
        menuList.add(2,menu3);
        System.out.println(menuList);

        // The set method will insert at a particular position keeping the other elements unchanged
        menuList.set(0,menu3);
        System.out.println(menuList);

        // null values are allowed in hashmap.
        Map<Integer,Integer> map=new HashMap<>();
        map.put(null,1);
        System.out.println(map.get(null));
        Integer put = map.put(2, 3);


        // Collections class have some useful method to play around with the collection
        Comparator<Menu> comparator=(m1,m2)->m2.id-m1.id;

        Collections.sort(menuList,comparator);
        System.out.println(menuList);

        Collections.reverse(menuList);
        Collections.shuffle(menuList);


        // How to make collections thread safe
        /*
        Only one thread to access it a time.
         */
        Collections.synchronizedList(menuList);

        /*
        Concurrent threads can access it at the same time, but they'll not corrupt because it's read only.
         */
        Collections.unmodifiableList(menuList);


        /*
        Creates a copy for each thread.
         */
        CopyOnWriteArrayList<Menu> menus = new CopyOnWriteArrayList<>(menuAsList);

    }
}
