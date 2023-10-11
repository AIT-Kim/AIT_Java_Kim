package lesson_25.computer_and_components;
/**
 * 10.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
// Класс компьютера
public class Computer {
    private Processor processor;
    private Memory memory;
    private Storage storage;

    public Computer(Processor processor, Memory memory, Storage storage) {
        this.processor = processor;
        this.memory = memory;
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Компьютер:\n" +
                "Процессор - " + processor + "\n" +
                "Память - " + memory + "\n" +
                "Накопитель - " + storage;
    }


}