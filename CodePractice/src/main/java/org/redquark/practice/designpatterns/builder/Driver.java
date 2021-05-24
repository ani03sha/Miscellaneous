package org.redquark.practice.designpatterns.builder;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Lunch Order with everything: ");
        // Get the instance of Builder
        LunchOrder.LunchOrderBuilder builder = new LunchOrder.LunchOrderBuilder();
        // Build lunch order with everything
        builder
                .bread("Wheat")
                .dressing("Mayo")
                .condiments("Lettuce")
                .meat("Ham");
        LunchOrder lunchOrder = new LunchOrder(builder);
        System.out.println("Bread: " + lunchOrder.getBread());
        System.out.println("Condiments: " + lunchOrder.getCondiments());
        System.out.println("Dressing: " + lunchOrder.getDressing());
        System.out.println("Meat: " + lunchOrder.getMeat());

        System.out.println("Lunch Order with only bread and dressing");
        builder = new LunchOrder.LunchOrderBuilder();
        builder.bread("Rice").dressing("Mayo");
        lunchOrder = new LunchOrder(builder);
        System.out.println("Bread: " + lunchOrder.getBread());
        System.out.println("Condiments: " + lunchOrder.getCondiments());
        System.out.println("Dressing: " + lunchOrder.getDressing());
        System.out.println("Meat: " + lunchOrder.getMeat());
    }
}
