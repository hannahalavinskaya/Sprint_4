package ru.yandex.bank;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (this.name.startsWith(" ")) {
            return false;
        } else if (this.name.endsWith(" ")) {
            return false;
        } else if (!this.name.contains(" ")) {
            return false;
        } else if (this.name.substring(this.name.indexOf(" ") + 1).contains(" ")) {
            return false;
        } else if (this.name.length() < 3) {
            return false;
        } else if (this.name.length() > 19) {
            return false;
        } else {
            return true;
        }
    }
}
