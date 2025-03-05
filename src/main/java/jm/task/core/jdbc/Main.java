package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // Создание таблицы User(ов)
        userService.createUsersTable();
        System.out.println("Таблица users создана.");

        // Добавление 4 User(ов) в таблицу
        userService.saveUser("Ivan", "Ivanov", (byte) 25);
        System.out.println("User с именем Ivan добавлен в базу данных");

        userService.saveUser("Petr", "Petrov", (byte) 30);
        System.out.println("User с именем Petr добавлен в базу данных");

        userService.saveUser("Maria", "Sidorova", (byte) 28);
        System.out.println("User с именем Maria добавлен в базу данных");

        userService.saveUser("Anna", "Kuznetsova", (byte) 22);
        System.out.println("User с именем Anna добавлен в базу данных");

        // Получение всех User из базы и вывод в консоль
        System.out.println("Список всех пользователей:");
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        // Очистка таблицы User(ов)
        userService.cleanUsersTable();
        System.out.println("Таблица users очищена.");

        // Удаление таблицы
        userService.dropUsersTable();
        System.out.println("Таблица users удалена.");
    }
}