package ru.yandex.bank;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class) // указали, что тесты будет запускать раннер Parameterized
public class OwnerDataPrintingTest {

    private final String name;
    private final boolean expectedResult;

    public OwnerDataPrintingTest(String name, boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] dataForTest() {
        return new Object[][] {
                {"Тимоте Шаламе", true}, // в строке только один пробел в середине - true
                {"Тим оте Шаламе", false}, // в строке 2 пробела в середине - false
                {" Тимоте Шаламе", false}, // в строке 2 пробела, один в начале - false
                {"Тимоте Шаламе ", false}, // в строке 2 пробела, один в конце - false
                {"ТимотейШевроле", false}, // в строке нет пробела - false
                {"У О", true}, // в строке 3 символа - true
                {"Ли О", true}, // в строке 4 символа - true
                {"Ли", false}, // в строке 2 символа - false
                {"Боооон Джоооооооови", true}, // в строке 19 символов - true
                {"Боооон Джоооооооовии", false}, // в строке 20 символов - false
        };
    }

    @Test
    @DisplayName("Check client name/surname.")
    @Description("Basic test for checking if it's possible to print the owner's data on a bank card.")
    public void testIfStringCanBePrintedOnCard() {
        Account account = new Account(name);
        Assert.assertEquals(expectedResult, account.checkNameToEmboss());
    }
}
