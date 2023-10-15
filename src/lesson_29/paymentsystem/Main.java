package lesson_29.paymentsystem;
/**
 * 15.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Main {
    public static void main(String[] args) {
        BankAccount johnsBank = new BankAccount(5000);
        BankAccount annasBank = new BankAccount(3000);
        ElectronicWallet johnsWallet = new ElectronicWallet("John", 200);
        ElectronicWallet annasWallet = new ElectronicWallet("Anna", 150);

        // John transfers money from his bank account to Anna's e-wallet
        johnsBank.transferMoney(250, annasWallet);

        // Anna checks her e-wallet balance
        System.out.println("Anna's e-wallet balance: " + annasWallet.checkBalance());

        // Anna transfers money from her e-wallet to John's e-wallet
        annasWallet.transferMoney(50, johnsWallet);

        // John checks his e-wallet balance
        System.out.println("John's e-wallet balance: " + johnsWallet.checkBalance());

        // Anna deposits money to her e-wallet from her bank account
        annasBank.transferMoney(400, annasWallet);
    }
}
