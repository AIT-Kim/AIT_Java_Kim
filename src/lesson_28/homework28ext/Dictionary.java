package lesson_28.homework28ext;
/**
 * 13.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private final Map<String, DictionaryPair> dictionary = new HashMap<>();

    public void put(String word, Map<Language, String> translations) {
        dictionary.put(word, new DictionaryPair(word, translations));
    }

    public String get(String word, Language language) {
        DictionaryPair pair = dictionary.get(word);
        if (pair == null) {
            return null;
        }
        return pair.getTranslation(language);
    }

    public class Translator {
        public String[] translate(String[] words, Language targetLanguage) {
            String[] translations = new String[words.length];

            for (int i = 0; i < words.length; i++) {
                String translation = get(words[i], targetLanguage);
                translations[i] = translation != null ? translation : words[i];
            }

            return translations;
        }
    }

    public static class DictionaryPair {
        private final String word;
        private final Map<Language, String> translations;

        public DictionaryPair(String word, Map<Language, String> translations) {
            this.word = word;
            this.translations = translations;
        }

        public String getTranslation(Language language) {
            return translations.get(language);
        }
    }

    public enum Language {
        ENGLISH,
        RUSSIAN,
        SPANISH,
        FRENCH,
        GERMAN,
        // можно добавлять другие языки по мере необходимости
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Map<Language, String> helloTranslations = new HashMap<>();
        helloTranslations.put(Language.RUSSIAN, "Привет");
        helloTranslations.put(Language.SPANISH, "Hola");
        helloTranslations.put(Language.FRENCH, "Bonjour");
        helloTranslations.put(Language.GERMAN, "Hallo");

        dictionary.put("Hello", helloTranslations);

        Translator translator = dictionary.new Translator();
        String[] words = {"Hello", "Bye", "Java"};
        String[] translatedWords = translator.translate(words, Language.RUSSIAN);

        for (String word : translatedWords) {
            System.out.println(word);
        }
    }
}

