package lesson_04;

/**
 * InputOutput
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */


public class Main6 {
    public static void main(String[] args) {
        int x = 10;
        int y = 5;
        String text = "Result: " + x + y;
        // int y = 10 + 5 + 1 = 15 + 1 = 16
        // Программа видит строку `Result`, далее к этой строке прибавляется число x
        // мы помним правило, что все, что соединяется со строкой - становится строкой, поэтому получим строку "Result: 10"
        // далее, к этой строке прибавляется число y, по тому же правилу получаем "Result: 105"

        System.out.println(text);
    }
}