package lesson_38.hometask;

public class RemoteController { // пуль от телевизора

    private TV tv; // ссылка на телевизор

    public RemoteController(TV tv) {
        this.tv = tv;
    }

    public void on(int channelNumber) { // метод включения канала по номеру
        tv.onChannel(channelNumber);
    }
}