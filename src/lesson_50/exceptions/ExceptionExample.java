package lesson_50.exceptions;

import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionExample {
    public static void main(String[] args) {

        int[] array = {1, 2, 4};

        String str = null;

        String string = "1F";
        int integer;

        try {
            integer = Integer.parseInt(string); // java.lang.NumberFormatException
            System.out.println("Try end");

        } catch (NumberFormatException exception) {
            exception.printStackTrace();
            integer = 0;

        } finally {

            System.out.println("Блок finally");
        }

        System.out.println("integer: " + integer);
        System.out.println("Продолжение выполнения программы");

        String url = getUrlString();

        System.out.println("Пытаемся открыть страницу: " + url);

        String url2 = null;
        try {
            url2 = getUrlString2();
        } catch (MalformedURLException e) {
            System.out.println("Неверный формат адреса");
            System.out.println(e.toString());
        }

        System.out.println("Пытаемся открыть страницу 2: " + url2);


    }

    public static String getUrlString(){

        URL myUrl = null;
        String defaultUrlStr = "https://google.com";

        try {
            myUrl = new URL(defaultUrlStr);
            myUrl = new URL("htps://example.com");
        } catch (MalformedURLException exception) {
            System.out.println("Неверный формат URL " + exception.getMessage());
        }
        return myUrl.toString();
    }

    public static String getUrlString2() throws MalformedURLException {

        URL myUrl = null;
        String defaultUrlStr = "https://google.com";


        myUrl = new URL(defaultUrlStr);
        myUrl = new URL("htts://example.com");

        return myUrl.toString();
    }
}