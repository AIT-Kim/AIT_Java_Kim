package lesson_29.paymentsystem;
/**
 * 15.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public interface PaymentSystem {
    void transferMoney(double amount, PaymentSystem recipient);
    void withdrawMoney(double amount);
    void depositMoney(double amount);
    double checkBalance();
}