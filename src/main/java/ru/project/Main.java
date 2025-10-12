package ru.project;

public class Main {
    public static void main(String[] args) {
        Storage memoryStorage = new InMemoryStorage();
        memoryStorage.save("Data in memory");
        System.out.println("InMemoryStorage: " + memoryStorage.retrieve(0));

        Storage fileStorage = new FileStorage();
        fileStorage.save("Data in file");
        System.out.println("FileStorage: " + fileStorage.retrieve(0));

        Storage jdbcStorage = new JDBCStorage(
                "jdbc:mysql://localhost:5432/mydatabase",
                "myuser",
                "mypassword"
        );

        jdbcStorage.save("Hello, world!");
        String data = jdbcStorage.retrieve(1);
        System.out.println("JDBCStorage: " + jdbcStorage.retrieve(0));
    }
}
