package org.example.app.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    private BonusService bonusService;

    @BeforeEach
    void setUp() {
         bonusService = new BonusService();
    }

    @Test
    @DisplayName("Тест додатку при введенні негативного значення")
    void testGetRes_negativeSales() {
        double sales = -500;
        String expectedResult = "Negative balance";
        String actualResult = bonusService.getRes(sales);
        assertNotEquals(expectedResult, actualResult,
                "Додаток повинен вивести значення Incorrect value!");
    }

    @Test
    @DisplayName("Тест додатку на правильність розрахування бонусу")
    void testCalcBonus_positiveSales() {
        double sales = 500;
        double expectedResult = 50;
        double actualResult = bonusService.calcBonus(sales);
        assertEquals(expectedResult, actualResult,
                "Додаток повинен розраховувати бонус за формулою 10% від sales");
    }

    @AfterEach
    void tearDown() {
        bonusService = null;
    }
}