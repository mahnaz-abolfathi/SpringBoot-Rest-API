package com.example.firstrestapi.temp;

public class AnimalMaker {

    public static void main(String[] args) {
//        Dog dog = new Dog();
        Animal dog = new Dog();
        dog.eat();
        dog.move();

        Animal cat = null;

        if (args[0].equals("c")){
            cat = new Cat();
        } else if (args[0].equals("p")){
            cat = new CatPersian();
        }

        cat.eat();
        cat.move();
    }
}
