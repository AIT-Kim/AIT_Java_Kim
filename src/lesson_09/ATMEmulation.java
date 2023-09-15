package lesson_09;
/**
 * 15.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
import java.util.Scanner;

public class ATMEmulation {

    private int balance = 10000;  // начальный баланс в евроцентах (100€)
    private final int[] notes = {50000, 20000, 10000, 5000, 2000, 1000, 500};  // доступные банкноты в евроцентах

    public static void main(String[] args) {
        ATMEmulation atm = new ATMEmulation();
        atm.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Добро пожаловать в банкомат!");
            System.out.println("1. Проверить баланс");
            System.out.println("2. Снять деньги");
            System.out.println("3. Внести деньги");
            System.out.println("4. Выход");
            System.out.print("Выберите операцию: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Введите сумму для снятия в евроцентах (например, 1050 для 10.50€): ");
                    int amount = scanner.nextInt();
                    withdraw(amount);
                    break;
                case 3:
                    System.out.print("Введите сумму для внесения в евроцентах: ");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Спасибо за использование нашего банкомата!");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Ваш текущий баланс: " + balance / 100.0 + "€");
    }

    private void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Недостаточно средств.");
            return;
        }

        if (amount % 5 != 0) {
            System.out.println("Сумма должна быть кратна 5 евроцентам.");
            return;
        }

        System.out.println("Выданные банкноты:");
        for (int note : notes) {
            int notesCount = amount / note;
            if (notesCount > 0) {
                System.out.println(note / 100.0 + "€ - " + notesCount + " шт.");
                amount -= notesCount * note;
            }
        }
        balance -= amount;
    }

    private void deposit(int amount) {
        balance += amount;
        System.out.println("Ваш новый баланс: " + balance / 100.0 + "€");
    }
}