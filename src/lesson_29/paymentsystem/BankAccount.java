package lesson_29.paymentsystem;
/**
 * 15.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class BankAccount implements PaymentSystem {
    private double balance;
    private static final double TRANSFER_FEE = 0.02; // 2% комиссия за переводы

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void transferMoney(double amount, PaymentSystem recipient) {
        double totalAmount = amount + amount * TRANSFER_FEE;
        if (totalAmount > balance) {
            System.out.println("Insufficient funds for transfer including fees.");
            return;
        }
        balance -= totalAmount;
        recipient.depositMoney(amount);
        System.out.println("Transferred " + amount + " with fee of " + (amount * TRANSFER_FEE));
    }

    @Override
    public void withdrawMoney(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + ". Remaining balance: " + balance);
    }

    @Override
    public void depositMoney(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ". New balance: " + balance);
    }

    @Override
    public double checkBalance() {
        return balance;
    }
}

