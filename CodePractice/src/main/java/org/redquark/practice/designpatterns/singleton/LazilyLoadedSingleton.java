package org.redquark.practice.designpatterns.singleton;

public class LazilyLoadedSingleton {

    private static LazilyLoadedSingleton instance;

    private LazilyLoadedSingleton() {
    }

    public static LazilyLoadedSingleton getInstance() {
        if (instance == null) {
            instance = new LazilyLoadedSingleton();
        }
        return instance;
    }
}
