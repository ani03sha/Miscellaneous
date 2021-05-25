package org.redquark.practice.designpatterns.abstractfactory;

public class Driver {

    public static void main(String[] args) {
        CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(775);
        CreditCard creditCard = abstractFactory.getCreditCard(CardType.PLATINUM);
        System.out.println(creditCard.getClass());
        abstractFactory = CreditCardFactory.getCreditCardFactory(600);
        creditCard = abstractFactory.getCreditCard(CardType.GOLD);
        System.out.println(creditCard.getClass());
    }
}
