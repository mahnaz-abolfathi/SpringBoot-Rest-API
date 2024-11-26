package com.example.firstrestapi.temp;

public class CatPersian implements Animal {
    @Override
    public void eat() {
        System.out.println("Cat Persian is eating!");
    }

    @Override
    public void move() {
        System.out.println("Cat Persian is moving!");
    }
}
