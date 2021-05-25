package org.redquark.practice.designpatterns.abstractfactory;

public class VisaPlatinumValidator implements Validator {

    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}
