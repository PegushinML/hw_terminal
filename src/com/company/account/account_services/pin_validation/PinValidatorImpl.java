package com.company.account.account_services.pin_validation;


import com.company.account.account_services.exceptions.AccountIsLockedException;
import com.company.account.account_services.exceptions.WrongPinException;
import com.company.account.account_services.pin_validation.PinAccount;
import com.company.account.account_services.pin_validation.PinValidator;

import java.util.Timer;

/**
 * Created by Maxim on 11/13/2016.
 */
public class PinValidatorImpl implements PinValidator {

    private final PinAccount account;
    private int attempts;
    private ValidationTimer timer;

    private static final int TIMER_VALUE = 5;

    public PinValidatorImpl(PinAccount account) {
        this.account = account;
        attempts = 0;
        timer = new ValidationTimer(TIMER_VALUE);
    }


    @Override
    public boolean checkPin(int value) throws AccountIsLockedException, WrongPinException {
        if(attempts == 3) {
            if(timer.getTime() < TIMER_VALUE) {
                throw new AccountIsLockedException("Exceeded limit of attempts. Wait " + (TIMER_VALUE - timer.getTime()) + " seconds please");
            } else {
                timer.stop();
                attempts = 0;
            }
        }

        if(account.checkPin(value)) {
            return true;
        } else {
            attempts++;
            if(attempts == 3) {
                timer.start();
            }
            throw new WrongPinException("Incorrect pin. You have " + (3 - attempts) + " attempts");
        }
    }


}
