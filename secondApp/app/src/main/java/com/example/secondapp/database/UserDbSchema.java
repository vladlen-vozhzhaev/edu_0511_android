package com.example.secondapp.database;

public class UserDbSchema { // Класс для описания структуры БД
    public static class UserTable{ // Класс для таблицы users
        public static final String NAME = "users"; // Название таблицы в БД
        public  static  final class Cols{ // Класс для колонок таблицы
            public static final String UUID = "uuid";
            public static final String FIRSTNAME = "firstname";
            public static final String LASTNAME = "lastname";
            public static final String PHONE = "phone";
        }
    }
}