package ru.project.task2;

/**
 * - В методе deposit нет проверки на отрицательные суммы, что позволяет увеличить баланс путем депозита отрицательного значения.
 * - В методе withdraw нет проверки на отрицательные суммы, что позволяет уменьшить баланс путем попытки снятия отрицательного значения.
 * - В методе withdraw нет проверки на достаточность средств на счете, что позволяет уйти в отрицательный баланс банковского счета.
 */
public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Amount must be less than balance");
        }
        this.balance -= amount;
    }
}
