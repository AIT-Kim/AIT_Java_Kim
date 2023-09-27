package lesson_17;

/**
 * 27.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

// Класс "Книга"
public class Book {
    private String title; // Название книги
    private String author; // Автор книги
    private int numberOfPages; // Количество страниц

    public Book(String title, String author, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public String readPage(int pageNumber) {
        // Представим, что этот метод возвращает содержимое страницы
        return "Содержимое страницы " + pageNumber;
    }
}