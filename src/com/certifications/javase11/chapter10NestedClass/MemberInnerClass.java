package src.com.certifications.javase11.chapter10NestedClass;

import java.util.ArrayList;
import java.util.List;

public class MemberInnerClass {

    /**
     * The class is defined in the instance scope of the outer class.
     */
    class Item {

        String itemName;

        public Item(String itemName) {
            this.itemName = itemName;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "itemName='" + itemName + '\'' +
                    '}';
        }
    }


    private List<Item> items=new ArrayList<>();

    private void addItems(){
        items.add(new Item("Food"));
        items.add(new Item("Drinks"));
    }


    public static void main(String[] args) {
        MemberInnerClass obj=new MemberInnerClass();
        obj.addItems();
        obj.items.add(obj.new Item("Beverage"));
        System.out.println(obj.items);
    }
}
