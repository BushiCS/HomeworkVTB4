package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitBox<T extends Fruit> { // коробка содержит только тип-параметр класса Fruit включая его наследников (конкретных фруктов)

    List<T> fruitList; // создаем список по данному тип-параметру

    public FruitBox() {
        this.fruitList = new ArrayList<>();
    }

    public FruitBox(T... fruits) {
        this.fruitList = new ArrayList<>(Arrays.asList(fruits)); // заполняем список фруктами при создании объекта (если Apple, то яблоки, если Orange)
    }

    public void putToBox(T... fruits) {
        this.fruitList.addAll(Arrays.asList(fruits)); // метод упаковки как одного, так и массива фруктов (через переменную длины) в уже созданный список
    }

    public float getWeight() {
        float sum = 0;
        if (fruitList.size() == 0) {
            return 0.0f;
        }
        for (T t : fruitList) {
            sum += t.getWeight();
        }
        return sum;
    }

    public boolean compare(FruitBox<? super T> another) { // принимает на вход коробку с конкретными фруктами или их родителем (абстрактный Fruit)
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }

    public void transfer(FruitBox<T> another) {
        if (this == another) {
            return;
        }
        another.fruitList.addAll(this.fruitList);
        this.fruitList.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruitList=" + fruitList +
                '}';
    }
}
