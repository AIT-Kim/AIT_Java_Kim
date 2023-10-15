package lesson_29.paymentsystem;
/**
 * 15.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class ElectronicWallet implements PaymentSystem {
    private double balance;
    private String owner;

    public ElectronicWallet(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public void transferMoney(double amount, PaymentSystem recipient) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= amount;
        recipient.depositMoney(amount);
        System.out.println("Transferred " + amount + " to " + ((ElectronicWallet) recipient).getOwner());
    }

    @Override
    public void withdrawMoney(double amount) {
        System.out.println("Withdrawal operation not supported for e-wallet.");
    }

    @Override
    public void depositMoney(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " to " + owner + "'s e-wallet. New balance: " + balance);
    }

    @Override
    public double checkBalance() {
        return balance;
    }
}


