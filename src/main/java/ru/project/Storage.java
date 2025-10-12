package ru.project;

public interface Storage {
    void save(String data);
    String retrieve(int id);
}
