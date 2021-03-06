package org.redquark.practice.designpatterns.prototype;

import java.util.Arrays;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        // Statement demo - shallow copy
        String sql = "Select * from movies where title = ?";
        List<String> parameters = Arrays.asList("Star Trek", "Star Wars");
        Record record = new Record();
        Statement firstStatement = new Statement(sql, parameters, record);
        // Print first statement
        System.out.println("Printing first statement:");
        System.out.println(firstStatement.getSql());
        System.out.println(firstStatement.getParameters());
        System.out.println(firstStatement.getRecord());
        // Create another statement
        Statement secondStatement = firstStatement.clone();
        System.out.println("Printing second statement:");
        System.out.println(secondStatement.getSql());
        System.out.println(secondStatement.getParameters());
        System.out.println(secondStatement.getRecord());

        // Working with registry - deep copy
        Registry registry = new Registry();
        Movie movie = (Movie) registry.createItem("Movie");
        movie.setTitle("Prototype pattern");

        System.out.println(movie);
        System.out.println(movie.getRuntime());
        System.out.println(movie.getTitle());
        System.out.println(movie.getUrl());

        Movie anotherMovie = (Movie) registry.createItem("Movie");
        anotherMovie.setTitle("Gang of Four");

        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getUrl());
    }
}
