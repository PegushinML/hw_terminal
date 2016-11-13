package com.company.terminal.exceptions;

/**
 * Created by Maxim on 11/13/2016.
 */
public class ConnectionException extends Exception {
    public ConnectionException() {};

    public ConnectionException(String message) {
        super(message);
    }
}
