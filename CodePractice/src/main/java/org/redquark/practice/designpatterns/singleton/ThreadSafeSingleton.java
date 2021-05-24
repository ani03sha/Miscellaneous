package org.redquark.practice.designpatterns.singleton;

public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
        // To protect from reflection
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create object");
        }
    }

    public static ThreadSafeSingleton getInstance() {
        // Double checked locking
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
