package com.company.terminal;

import com.company.account.Account;
import com.company.account.account_services.pin_validation.PinAccount;
import com.company.account.account_services.pin_validation.PinValidator;
import com.company.account.account_services.pin_validation.PinValidatorImpl;
import com.company.account.account_services.exceptions.AccountIsLockedException;
import com.company.account.account_services.exceptions.WrongPinException;
import com.company.terminal.exceptions.ConnectionException;
import com.company.terminal.exceptions.InsufficientFundsException;
import com.company.terminal.exceptions.TerminalException;
import com.company.terminal.exceptions.WrongMoneyValueExceptions;

/**
 * Created by Maxim on 11/13/2016.
 */
public class TerminalImpl implements Terminal {

    private final Account account;
    private final PinValidator validator;
    private final TerminalServer server;

    public TerminalImpl(Account account) {
        this.account = account;
        this.validator = new PinValidatorImpl((PinAccount) account);
        this.server = new TerminalServer(account);
    }

    @Override
    public double checkAccount(int pin) throws TerminalException {
        try {
            validator.checkPin(pin);
            System.out.println("Correct pin!");
            return account.checkAccount();
        } catch (AccountIsLockedException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (WrongPinException e) {
            e.printStackTrace();
            throw new TerminalException();
        }
    }

    @Override
    public void putMoney(int pin, double amount) throws TerminalException {
        try {
            validator.checkPin(pin);
            System.out.println("Correct pin!");
            server.connect();
            server.moneyOperation(amount);
        } catch (AccountIsLockedException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (WrongPinException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (ConnectionException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (WrongMoneyValueExceptions wrongMoneyValueExceptions) {
            wrongMoneyValueExceptions.printStackTrace();
            throw new TerminalException();
        }
    }

    @Override
    public void getMoney(int pin, double amount) throws TerminalException {
        try {
            validator.checkPin(pin);
            System.out.println("Correct pin!");
            server.connect();
            server.moneyOperation(-amount);
        } catch (AccountIsLockedException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (WrongPinException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (ConnectionException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (WrongMoneyValueExceptions wrongMoneyValueExceptions) {
            wrongMoneyValueExceptions.printStackTrace();
            throw new TerminalException();
        }
    }


}
