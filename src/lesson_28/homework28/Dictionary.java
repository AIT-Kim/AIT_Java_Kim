package lesson_28.homework28;
/**
 * 13.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private Map<String, String> wordPairs = new HashMap<>();

    public void put(String word, String translation) {
        wordPairs.put(word, translation);
    }

    public String get(String word) {
        return wordPairs.getOrDefault(word, word);
    }

    // Вложенный класс для представления пары слово-перевод
    private static class DictionaryPair {
        String word;
        String translation;

        DictionaryPair(String word, String translation) {
            this.word = word;
            this.translation = translation;
        }
    }

    // Внутренний класс для перевода слов с использованием словаря
    public class Translator {

        public String[] translate(String[] words) {
            String[] translations = new String[words.length];

            for (int i = 0; i < words.length; i++) {
                translations[i] = wordPairs.getOrDefault(words[i], words[i]);
            }

            return translations;
        }
    }

    /**
     Создать класс "Dictionary" - таблица слов и их переводов.

     dictionary.put("Hello", "Привет");
     dictionary.put("Bye", "Пока");

     dictionary.get("Hello"); // Привет

     Вложенный класс - DictionaryPair (содержит исходное слово и перевод)
     Внутренний класс - Translator

     Translator содержит метод String[] translate(String[] words)

     dictionary.put("Hello", "Привет");
     dictionary.put("Bye", "Пока");

     String[] words = {"Hello", "Bye", "Java"};

     translator.translate(words); // {"Привет", "Пока", "Java"}

     Он переводит входной набор слов по КОНКРЕТНОМУ словарю.
     */
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.put("Hello", "Привет");
        dictionary.put("Bye", "Пока");

        Translator translator = dictionary.new Translator();

        String[] words = {"Hello", "Bye", "Java"};
        String[] translations = translator.translate(words);

        for (String translation : translations) {
            System.out.println(translation);
        }
    }
}

