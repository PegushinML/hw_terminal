package com.company.terminal;

import com.company.account.Account;
import com.company.terminal.exceptions.ConnectionException;
import com.company.terminal.exceptions.InsufficientFundsException;
import com.company.terminal.exceptions.WrongMoneyValueExceptions;

/**
 * Created by Maxim on 11/13/2016.
 */
public class TerminalServer {
    private final Account account;

    public TerminalServer(Account account) {
        this.account = account;
    }

    public void connect() throws ConnectionException {
        if(Math.random() <= 0.01) {
            throw new ConnectionException("Connection failed!");
        }
    }

    public void moneyOperation (double value) throws WrongMoneyValueExceptions, InsufficientFundsException {
        double currentMoney = account.checkAccount();

        if(currentMoney + value < 0) {
            throw new InsufficientFundsException("Not enough money at account!");
        }

        if(value % 100 != 0) {
            throw new WrongMoneyValueExceptions("The amount should be a multiple of 100");
        }
    }


}
