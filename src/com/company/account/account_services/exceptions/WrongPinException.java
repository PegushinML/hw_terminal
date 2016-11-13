package com.company.account.account_services.exceptions;

/**
 * Created by Maxim on 11/13/2016.
 */
public class WrongPinException extends Exception {
    public WrongPinException() {};

    public WrongPinException(String message) {
        super(message);
    }
}
