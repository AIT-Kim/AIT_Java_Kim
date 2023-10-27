package lesson_38.hometask;

public class Main {
    public static void main(String[] args) {
        Channel bbc = new Channel("BBC");
        Channel cnn = new Channel("CNN");

        Broadcast animals = new Broadcast("Animals");
        Broadcast religion = new Broadcast("Religion");
        Broadcast worldNews = new Broadcast("World News");

        Broadcast nationalNews = new Broadcast("National News");
        Broadcast music = new Broadcast("Music");
        Broadcast sport = new Broadcast("Sport");

        bbc.addBroadcast(animals);
        bbc.addBroadcast(religion);
        bbc.addBroadcast(worldNews);

        cnn.addBroadcast(nationalNews);
        cnn.addBroadcast(music);
        cnn.addBroadcast(sport);

        TV tv = new TV();

        tv.addChannel(bbc);
        tv.addChannel(cnn);

        RemoteController remoteController = new RemoteController(tv);

        remoteController.on(0);
        remoteController.on(1);
    }
}