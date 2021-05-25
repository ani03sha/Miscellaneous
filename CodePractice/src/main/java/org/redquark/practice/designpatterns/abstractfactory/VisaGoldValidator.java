package org.redquark.practice.designpatterns.abstractfactory;

public class VisaGoldValidator implements Validator {

    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}
