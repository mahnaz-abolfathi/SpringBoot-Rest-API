package com.example.firstrestapi.temp;

public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating!");
    }

    @Override
    public void move() {
        System.out.println("Dog is moving!");
    }
}
