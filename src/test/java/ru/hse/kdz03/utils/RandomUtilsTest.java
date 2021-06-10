package ru.hse.kdz03.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomUtilsTest {

    @DisplayName("Получение случайного коэффициента")
    @Test
    void getCoefficient() {
        boolean[] boolExpected = {true, true, true, true, true};
        boolean[] boolActual = new boolean[5];
        for (int i = 0; i < 5; i++) {
            double res = RandomUtils.getCoefficient();
            boolActual[i] = res >= 1 && res < 10;
        }
        assertArrayEquals(boolExpected, boolActual);

        boolean[] boolExpected2 = {false, false, false, false, false};
        boolean[] boolActual2 = new boolean[5];
        for (int i = 0; i < 5; i++) {
            double res = RandomUtils.getCoefficient();
            boolActual2[i] = res < 1 || res >= 10;
        }
        assertArrayEquals(boolExpected2, boolActual2);
    }
    @DisplayName("Получение случайного времени сна")
    @Test
    void getSleepTime() {
        boolean[] boolExpected = {true, true, true, true, true};
        boolean[] boolActual = new boolean[5];
        for (int i = 0; i < 5; i++) {
            double res = RandomUtils.getSleepTime();
            boolActual[i] = res >= 1000 && res < 5000;
        }
        assertArrayEquals(boolExpected, boolActual);
        boolean[] boolExpected2 = {false, false, false, false, false};
        boolean[] boolActual2 = new boolean[5];
        for (int i = 0; i < 5; i++) {
            double res = RandomUtils.getSleepTime();
            boolActual2[i] = res < 1000 || res >= 5000;
        }
        assertArrayEquals(boolExpected2, boolActual2);
    }
}