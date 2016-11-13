package com.company.terminal.exceptions;

/**
 * Created by Maxim on 11/13/2016.
 */
public class WrongMoneyValueExceptions extends Exception {
    public WrongMoneyValueExceptions() {};

    public WrongMoneyValueExceptions(String message) {
        super(message);
    }
}
