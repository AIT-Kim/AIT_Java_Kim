package lesson_38.layers.repositories;

import lesson_38.layers.models.User;
public class UsersRepository {

    private static final int MAX_USERS_COUNT = 10; // максимальное количество пользователей

    private User[] users; // хранилище пользователей

    private int usersCount; // сколько у нас уже есть пользователей

    public UsersRepository() {
        this.users = new User[MAX_USERS_COUNT]; // выделяем место для 10 пользователей
    }

    public void save(User user) { // сохраняем пользователя
        this.users[usersCount] = user; // добавляем его в массив
        this.usersCount++; // увеличиваем количество текущих пользователей
    }

    /**
     * Метод для проверки существования пользователя по email-у
     * @param email email, по которому мы ищем пользователя
     * @return <code>true</code> - если пользователь найден, <code>false</code> - в противном случае
     */
    public boolean isExistsByEmail(String email) {
        for (int i = 0; i < usersCount; i++) { // запускаем цикл, который пробегает по всем добавленным пользователям
            if (users[i].getEmail().equals(email)) { // берем пользователя под индексом i, и проверяем,
                // совпадает ли его email с тем, который мы подали на вход

                // если совпало - возвращаем true
                return true;
            }
        }
        // если ни разу не совпало - false
        return false;
    }

    /**
     * Метод, возвращающий всех пользователей из хранилища
     * @return массив пользователей
     */
    public User[] findAll() {
        // важно вернуть не исходный массив, а его копию, чтобы исходный нельзя было повредить

        User[] copy = new User[usersCount]; // размер копии соответствует количеству пользователей в нашей системе

        for (int i = 0; i < usersCount; i++) {
            copy[i] = users[i]; // копируем i-ый объект из users в массив copy
        }

        return copy;
    }
}