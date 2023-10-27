package lesson_38.hometask;

import java.util.Random;

public class Channel {

    private static final int MAX_BROADCASTS_COUNT = 5;

    private String name; // название канала

    private Broadcast[] broadcasts; // множество передач этого канала

    private int broadcastsCount; // количество телепередач этого канала

    public Channel(String name) {
        this.broadcasts = new Broadcast[MAX_BROADCASTS_COUNT];
        this.name = name;
    }

    public void addBroadcast(Broadcast broadcast) {
        this.broadcasts[broadcastsCount] = broadcast;
        broadcastsCount++;
    }

    public void showProgram() { // случайно показывает какую-то программу
        Random random = new Random();
        int randomBroadcastNumber = random.nextInt(broadcastsCount); // генерируем случайное число от 0 до количества программ в канале

        // выводим название случайной программы
        System.out.println(name + ":" + broadcasts[randomBroadcastNumber].getTitle());
    }
}