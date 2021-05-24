package org.redquark.practice.designpatterns.singleton;

public class Driver {

    public static void main(String[] args) {
        // Test for eagerly loaded singleton
        EagerlyLoadedSingleton eagerlyLoadedSingletonInstaace = EagerlyLoadedSingleton.getInstance();
        System.out.println("Memory address of first object of eagerly loaded singleton: " + eagerlyLoadedSingletonInstaace);
        EagerlyLoadedSingleton anotherEagerlyLoadedSingletonInstance = EagerlyLoadedSingleton.getInstance();
        System.out.println("Memory address of second object of eagerly loaded singleton: " + anotherEagerlyLoadedSingletonInstance);

        System.out.println();

        // Test for Lazily loaded singleton
        LazilyLoadedSingleton lazilyLoadedSingletonInstance = LazilyLoadedSingleton.getInstance();
        System.out.println("Memory address of first object of lazily loaded singleton: " + lazilyLoadedSingletonInstance);
        LazilyLoadedSingleton anotherLazilyLoadedSingletonInstance = LazilyLoadedSingleton.getInstance();
        System.out.println("Memory address of second object of lazily loaded singleton: " + anotherLazilyLoadedSingletonInstance);

        System.out.println();

        // Test for Thread safe singleton
        ThreadSafeSingleton threadSafeSingletonInstance = ThreadSafeSingleton.getInstance();
        System.out.println("Memory address of first object of thread safe singleton: " + threadSafeSingletonInstance);
        ThreadSafeSingleton anotherThreadSafeSingletonInstance = ThreadSafeSingleton.getInstance();
        System.out.println("Memory address of second object of thread safe singleton: " + anotherThreadSafeSingletonInstance);
    }
}
