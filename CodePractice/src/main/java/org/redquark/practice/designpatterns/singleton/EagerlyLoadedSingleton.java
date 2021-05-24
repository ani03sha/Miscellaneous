package org.redquark.practice.designpatterns.singleton;

public class EagerlyLoadedSingleton {

    private static final EagerlyLoadedSingleton instance = new EagerlyLoadedSingleton();

    private EagerlyLoadedSingleton() {
    }

    public static EagerlyLoadedSingleton getInstance() {
        return instance;
    }
}
