package lesson_21;
/**
 * 04.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class BankApp {
    public static void main(String[] args) {
        BankAccount firstAccount = new BankAccount(4856810939019L, "USD", "Ivan Petrov", "SwedBank");

        System.out.println(firstAccount.toString());
        System.out.println(firstAccount.displayInfo());

        BankAccount secondAccount = new BankAccount(4856845639019L, "EUR", "Ivan Petrov", "SwedBank");

        System.out.println(secondAccount.toString());

        BankAccount thirdAccount = new BankAccount(4856878939019L, "USD", "John Smith", "SwedBank");
        System.out.println(thirdAccount.toString());
    }
}