package com.company.account.account_services.exceptions;

/**
 * Created by Maxim on 11/13/2016.
 */
public class AccountIsLockedException extends  Exception {
    public AccountIsLockedException() {};

    public AccountIsLockedException(String message) {
        super(message);
    }
}
