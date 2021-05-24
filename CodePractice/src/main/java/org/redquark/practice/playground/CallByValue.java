package org.redquark.practice.playground;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CallByValue {

    private int instanceVariable;

    private static void callByValueForLocalVariable(int argument) {
        argument += 200;
        System.out.println("Local variable inside call by value: " + argument);
    }

    private static void callByValueForInstanceVariable(int argument) {
        argument += 20;
        System.out.println("Instance variable inside call by value: " + argument);
    }

    public static void main(String[] args) {
        CallByValue obj = new CallByValue();
        obj.demo();
        System.out.println(obj.instanceVariable);
    }

    private void demo() {
        int localVariable = 100;
        System.out.println("Local variable before: " + localVariable);
        callByValueForLocalVariable(localVariable);
        System.out.println("Local variable after: " + localVariable);
        instanceVariable = 10;
        System.out.println("Instance variable before: " + instanceVariable);
        callByValueForInstanceVariable(instanceVariable);
        System.out.println("Instance variable after: " + instanceVariable);

        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        ids.add("3");
        ids.add("4");
        ids.add("5");
        System.out.println("List before call by value: " + ids);
        callByValueForList(ids);
        System.out.println("List after call by value: " + ids);

        Set<Integer> numbers = new HashSet<>();
        System.out.println("Object type of set before is: " + numbers.getClass());
        callByValueForSet(numbers);
        System.out.println("Object type of set after is: " + numbers.getClass());
    }

    private void callByValueForSet(Set<Integer> numbers) {
        numbers.add(1);
        numbers = new TreeSet<>();
        System.out.println("Object type of set inside call by value is: " + numbers.getClass());
    }

    private void callByValueForList(List<String> ids) {
        ids.add("6");
        ids.add("7");
    }
}
