package t1;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void prettyPrintApple(List<Apple> inventory,
                                        AppleFormatter formatter){
        for(Apple apple: inventory){
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple("red",100));
        inventory.add(new Apple("black",200));
        prettyPrintApple(inventory, new AppleFancyFormatter());
        System.out.println("-------");
        prettyPrintApple(inventory, new AppleSimpleFormatter());
    }
}
