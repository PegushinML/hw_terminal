package com.company;

import com.company.account.Account;
import com.company.account.AccountImpl;
import com.company.account.account_services.pin_validation.ValidationTimer;
import com.company.terminal.Terminal;
import com.company.terminal.TerminalImpl;
import com.company.terminal.exceptions.TerminalException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Account account = new AccountImpl(1, 1111, 50000);
        Terminal terminal = new TerminalImpl(account);
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Checking funds. Write pin");
            System.out.println(terminal.checkAccount(scanner.nextInt()));
        } catch (TerminalException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Putting money. Write pin and money amount");
            terminal.putMoney(scanner.nextInt(), scanner.nextInt());
        } catch (TerminalException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Getting money. Write pin and money amount");
            terminal.getMoney(scanner.nextInt(), scanner.nextInt());
        } catch (TerminalException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Checking funds. Write pin");
            System.out.println(terminal.checkAccount(scanner.nextInt()));
        } catch (TerminalException e) {
            e.printStackTrace();
        }

    }
}
