package ru.yandex.bank;

public class Praktikum {

    public static void main(String[] args) {
        String name = "Vasia Pupkin";
        Account account = new Account(name);
        if (!account.checkNameToEmboss()){
            System.out.println("Данные не соответствуют условиям! Проверьте требования!");
        }
    }
}

