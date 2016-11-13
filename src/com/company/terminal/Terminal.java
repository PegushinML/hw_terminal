package com.company.terminal;

import com.company.terminal.exceptions.TerminalException;

/**
 * Created by Maxim on 11/13/2016.
 */
public interface Terminal {
    double checkAccount(int pin) throws TerminalException;

    void putMoney(int pin, double amount) throws TerminalException;

    void getMoney(int pin, double amount) throws TerminalException;
}
