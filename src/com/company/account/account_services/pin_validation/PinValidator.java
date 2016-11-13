package com.company.account.account_services.pin_validation;

import com.company.account.account_services.exceptions.AccountIsLockedException;
import com.company.account.account_services.exceptions.WrongPinException;

/**
 * Created by Maxim on 11/13/2016.
 */
public interface PinValidator {

    boolean checkPin(int value) throws AccountIsLockedException, WrongPinException;
}
