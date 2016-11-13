package com.company.account;

import com.company.account.account_services.pin_validation.PinAccount;

/**
 * Created by Maxim on 11/13/2016.
 */
public class AccountImpl implements Account, PinAccount {

    private final long id;
    private final int pin;
    private double money;

    public AccountImpl(long id, int pin, double money) {
        this.id = id;
        this.pin = pin;
        this.money = money;
    }

    public AccountImpl(AccountImpl account, double money) {
        this.id = account.id;
        this.pin = account.pin;
        this.money = money;
    }


    @Override
    public double checkAccount() {
        return money;
    }

    @Override
    public void changeMoneyValue(double money){this.money += money;}
    @Override
    public boolean checkPin(int value) {
        return this.pin == value;
    }
}
