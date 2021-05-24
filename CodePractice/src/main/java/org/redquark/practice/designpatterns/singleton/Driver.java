package org.redquark.practice.designpatterns.singleton;

public class Driver {

    public static void main(String[] args) {
        // Test for eagerly loaded singleton
        EagerlyLoadedSingleton instance = EagerlyLoadedSingleton.getInstance();
        System.out.println("Memory address of first object of eagerly loaded singleton: " + instance);
        EagerlyLoadedSingleton anotherInstance = EagerlyLoadedSingleton.getInstance();
        System.out.println("Memory address of second object of eagerly loaded singleton: " + anotherInstance);
    }
}
