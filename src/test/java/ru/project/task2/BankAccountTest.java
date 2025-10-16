package ru.project.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalance_positive() {
        BankAccount bankAccount = new BankAccount(500);

        assertEquals(500, bankAccount.getBalance());
    }

    @Test
    void getBalance_negative() {
        BankAccount bankAccount = new BankAccount(-500);

        assertEquals(-500, bankAccount.getBalance());
    }

    @Test
    void deposit_positive() {
        BankAccount bankAccount = new BankAccount(500);

        bankAccount.deposit(100);

        assertEquals(600, bankAccount.getBalance());
    }

    @Test
    void deposit_max() {
        BankAccount bankAccount = new BankAccount(500);
        bankAccount.deposit(Double.MAX_VALUE);
        double balance = bankAccount.getBalance();

        bankAccount.deposit(balance * 2);

        assertEquals(Double.POSITIVE_INFINITY, bankAccount.getBalance());
    }

    @Test
    void deposit_negative() {
        BankAccount bankAccount = new BankAccount(500);

        bankAccount.deposit(-100);

        assertEquals(400, bankAccount.getBalance());
    }

    @Test
    void withdraw_positive() {
        BankAccount bankAccount = new BankAccount(500);

        bankAccount.withdraw(100);

        assertEquals(400, bankAccount.getBalance());
    }

    @Test
    void withdraw_max() {
        BankAccount bankAccount = new BankAccount(500);
        bankAccount.withdraw(Double.MAX_VALUE);
        double balance = bankAccount.getBalance();

        bankAccount.withdraw(balance * 2);

        assertEquals(Double.POSITIVE_INFINITY, bankAccount.getBalance());
    }

    @Test
    void withdraw_negative() {
        BankAccount bankAccount = new BankAccount(500);

        bankAccount.withdraw(-100);

        assertEquals(600, bankAccount.getBalance());
    }
}