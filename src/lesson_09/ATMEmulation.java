package lesson_09;
/**
 * 15.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
import java.util.*;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class ATMEmulation {

    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static Map<Integer, Integer> availableNotes = new HashMap<>() {{
        put(5, 30);
        put(10, 20);
        put(20, 10);
        put(50, 10);
        put(100, 5);
    }};
    private static int balance = 100 + new Random().nextInt(401);

    public static void main(String[] args) {
        setSessionTimer();
        mainMenu();
    }

    private static void mainMenu() {
        resetSessionTimer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в банкомат!");
        System.out.println("Выберите действие:");
        System.out.println("1. Проверить баланс");
        System.out.println("2. Внести деньги");
        System.out.println("3. Снять деньги");
        System.out.println("4. Завершить работу");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                depositMoney();
                break;
            case 3:
                withdrawMoney();
                break;
            case 4:
                System.out.println("Спасибо за использование нашего банкомата!");
                System.exit(0);
                break;
            default:
                System.out.println("Неверный выбор. Попробуйте еще раз.");
                mainMenu();
        }
    }

    private static void checkBalance() {
        resetSessionTimer();
        System.out.println("Ваш баланс: " + balance + " евро");
        mainMenu();
    }

    private static void depositMoney() {
        resetSessionTimer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Внесите деньги. Банкомат принимает купюры номиналом: 5, 10, 20, 50, 100 евро.");
        System.out.println("Когда закончите вносить деньги, введите 0.");

        while (true) {
            int note = scanner.nextInt();
            if (note == 0) break;

            if (availableNotes.containsKey(note)) {
                balance += note;
                int currentCount = availableNotes.get(note);
                availableNotes.put(note, currentCount + 1);
            } else {
                System.out.println("Этот номинал не принимается. Попробуйте другую купюру.");
            }
        }

        System.out.println("Деньги внесены успешно.");
        mainMenu();
    }

    private static void withdrawMoney() {
        resetSessionTimer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Предлагаемые суммы для снятия:");
        System.out.println("1. 50 евро");
        System.out.println("2. 100 евро");
        System.out.println("3. 150 евро");
        System.out.println("4. Введите свою сумму");

        int choice = scanner.nextInt();
        int amount;

        switch (choice) {
            case 1:
                amount = 50;
                break;
            case 2:
                amount = 100;
                break;
            case 3:
                amount = 150;
                break;
            case 4:
                System.out.println("Введите сумму, которую хотите снять:");
                amount = scanner.nextInt();
                break;
            default:
                System.out.println("Неверный выбор. Попробуйте еще раз.");
                withdrawMoney();
                return;
        }

        if (amount > balance) {
            System.out.println("Недостаточно средств на балансе.");
            mainMenu();
            return;
        }

        if (canDispense(amount)) {
            balance -= amount;
            System.out.println("Пожалуйста, заберите ваши деньги.");
        } else {
            System.out.println("Извините, невозможно выдать запрошенную сумму.");
        }

        mainMenu();
    }

    private static boolean canDispense(int amount) {
        Map<Integer, Integer> cloneNotes = new HashMap<>(availableNotes);
        Map<Integer, Integer> dispensedNotes = new HashMap<>();

        List<Integer> keys = new ArrayList<>(cloneNotes.keySet());
        Collections.sort(keys, Collections.reverseOrder());

        for (int note : keys) {
            int neededNotes = amount / note;

            // Берем либо нужное количество купюр, либо половину от доступных, что бы оставить место для меньших купюр
            int actualNotes = Math.min(neededNotes, Math.max(1, cloneNotes.get(note) / 2));

            if (cloneNotes.get(note) < actualNotes) {
                actualNotes = cloneNotes.get(note);
            }

            if (actualNotes > 0) {
                dispensedNotes.put(note, actualNotes);
            }

            amount -= actualNotes * note;
            cloneNotes.put(note, cloneNotes.get(note) - actualNotes);
        }

        if (amount == 0) {
            printDispensedNotes(dispensedNotes);
            availableNotes = cloneNotes;
            return true;
        } else {
            // Если не удалось выдать нужную сумму с учетом условий, пытаемся выдать жадным способом
            return canDispenseGreedy(amount);
        }
    }

    private static boolean canDispenseGreedy(int amount) {
        Map<Integer, Integer> cloneNotes = new HashMap<>(availableNotes);
        Map<Integer, Integer> dispensedNotes = new HashMap<>();

        List<Integer> keys = new ArrayList<>(cloneNotes.keySet());
        Collections.sort(keys, Collections.reverseOrder());

        for (int note : keys) {
            int count = amount / note;

            if (cloneNotes.get(note) < count) {
                count = cloneNotes.get(note);
            }

            if (count > 0) {
                dispensedNotes.put(note, count);
            }

            amount -= count * note;
            cloneNotes.put(note, cloneNotes.get(note) - count);
        }

        if (amount == 0) {
            printDispensedNotes(dispensedNotes);
            availableNotes = cloneNotes;
            return true;
        }

        return false;
    }

    private static void printDispensedNotes(Map<Integer, Integer> dispensedNotes) {
        System.out.println("Вы получите следующие купюры:");
        for (Map.Entry<Integer, Integer> entry : dispensedNotes.entrySet()) {
            System.out.println("Номинал: " + entry.getKey() + " евро - Количество: " + entry.getValue());
        }
    }

    private static void terminateSession() {
        System.out.println("Время сеанса истекло. Пожалуйста, начните заново.");
        System.exit(0);
    }

    private static void setSessionTimer() {
        scheduler.schedule(ATMEmulation::terminateSession, 1, TimeUnit.MINUTES);
    }

    private static void resetSessionTimer() {
        scheduler.shutdownNow();
        scheduler = Executors.newScheduledThreadPool(1);  // Создаем новый экземпляр
        setSessionTimer();
    }
}
