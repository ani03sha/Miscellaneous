package org.redquark.practice.designpatterns.abstractfactory;

public class VisaValidator implements Validator {

    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}
