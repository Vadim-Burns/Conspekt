package oop;

import java.util.UUID;

class DatabaseConnection {
    // По умолчанию он указывает на null
    private static DatabaseConnection databaseConnection;

    private final String uuid;

    // Конструктор должен быть private, чтобы его нельзя было вызвыть из вне(нормальными способами)
    private DatabaseConnection() {
        this.uuid = UUID.randomUUID().toString();
        System.out.println("Creating new database connection " + this.uuid);
    }

    public static DatabaseConnection getInstance() {
        // Если такого объекта еще нет, то создаем. Иначе просто возвращаем
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }

        return databaseConnection;
    }

    @Override
    public String toString() {
        return "DatabaseConnection{" +
                "uuid='" + uuid + '\'' +
                '}';
    }

    public void print() {
        System.out.println(this);
    }
}

public class Singleton {
    public static void main(String[] args) {
        // Создаем новый, так как такого еще нет
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.print();

        // Просто получаем старый
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        db2.print();
    }
}
