package lesson_08;
/**
 * 14.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

import java.util.Scanner;

/**
 Этот код просит пользователя ввести код валюты, а затем выводит полное название валюты.
 В примере учитываются пять распространенных европейских валют.
 */
public class CurrencyDecoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите код валюты (поддерживаются: EUR, GBP, CHF, SEK, NOK): ");
        String currencyCode = scanner.nextLine().toUpperCase();

        switch (currencyCode) {
            case "EUR":
                System.out.println("Евро");
                break;
            case "GBP":
                System.out.println("Британский фунт стерлингов");
                break;
            case "CHF":
                System.out.println("Швейцарский франк");
                break;
            case "SEK":
                System.out.println("Шведская крона");
                break;
            case "NOK":
                System.out.println("Норвежская крона");
                break;
            default:
                System.out.println("Неизвестный код валюты");
        }
    }
}





