package lesson_20;

/**
 * 02.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SecureMessage {
    // хранения содержания сообщения и ключа шифрования
    private String messageContent;
    private SecretKeySpec encryptionKey;

    public SecureMessage(String key) {
        try {
            byte[] keyBytes = key.getBytes("UTF-8");
            encryptionKey = new SecretKeySpec(keyBytes, "AES");
            this.messageContent = "";
        } catch (Exception e) {
            throw new RuntimeException("Ошибка инициализации ключа: " + e.getMessage());
        }
    }

    // Зашифровать сообщение
    public void encryptMessage() {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, encryptionKey);
            byte[] encryptedBytes = cipher.doFinal(messageContent.getBytes("UTF-8"));
            messageContent = Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка шифрования сообщения: " + e.getMessage());
        }
    }

    // Расшифровать сообщение
    public void decryptMessage() {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, encryptionKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(messageContent));
            messageContent = new String(decryptedBytes, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException("Ошибка расшифровки сообщения: " + e.getMessage());
        }
    }

    // Установить сообщение
    public void setMessage(String message) {
        this.messageContent = message;
    }

    // Получить сообщение
    public String getMessage() {
        return this.messageContent;
    }

    public static void main(String[] args) {
        SecureMessage secureMsg = new SecureMessage("1234567812345678");  // AES ключ должен быть 16 символов
        secureMsg.setMessage("Это секретное сообщение!");
        System.out.println("Оригинальное сообщение: " + secureMsg.getMessage());

        secureMsg.encryptMessage();
        System.out.println("Зашифрованное сообщение: " + secureMsg.getMessage());

        secureMsg.decryptMessage();
        System.out.println("Расшифрованное сообщение: " + secureMsg.getMessage());
    }
}

