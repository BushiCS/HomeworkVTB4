package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] cats = {
                "Барсик",
                "Мурзик",
                "Васька",
                "Рыжик",
                "Черныш",
                "Петька",
                "Мурка",
                "Машка",
                "Лиза",
                "Персик"};
        ExchangerElementsOfArray(cats, 4, 7);
        ArrayToListConverter(cats);

        FruitBox<Apple> appleBox = new FruitBox<>(new Apple(1.0f), new Apple(1.5f), new Apple(1.2f));
        FruitBox<Orange> orangeBox = new FruitBox<>(new Orange(1.0f), new Orange(0.8f), new Orange(1.3f));
        FruitBox<Apple> anotherAppleBox = new FruitBox<>(new Apple(1.4f), new Apple(1.6f));
        FruitBox<Fruit> fruitBox = new FruitBox<>(new Orange(1.0f), new Apple(2.2f));
        System.out.println(appleBox);
        System.out.println("---------------------");
        appleBox.transfer(anotherAppleBox);
        System.out.println(appleBox);
        System.out.println(anotherAppleBox);
        anotherAppleBox.putToBox(new Apple(2.1f), new Apple(2.3f));

        System.out.println(anotherAppleBox);
        anotherAppleBox.putToBox(new Apple(1.0f));
        System.out.println(anotherAppleBox);

    }

    public static <T> List<T> ArrayToListConverter(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static void ExchangerElementsOfArray(Object[] array, int firstElement, int secondElement) {
        Object s;
        System.out.println(array[firstElement] + " " + array[secondElement]);
        s = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = s;
        System.out.println(array[firstElement] + " " + array[secondElement]);
    }
}