package lesson_51.persons;

public class EmailValidateException extends Exception{
    /*
    getMessage() - возвращает строку с коротким описанием исключения
    getCause() - возвращает исключение, которое вызвало текущее исключение
    toString() - Строковое представление исключения
    printStackTrace() - выводит трассировку исключения
     */

    public EmailValidateException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Email validate exception | " +  super.getMessage();
    }
}