package ru.hse.kdz03.utils;

import java.util.Random;

/**
 * Класс RandomUtils представляет статические методы для случайной генерации
 */
public final class RandomUtils {
    static Random rand = new Random();

    /**
     * Получение случайного коэффициента в промежутке [1;10)
     *
     * @return сгенерированный коэффициент
     */
    public static double getCoefficient() {
        return rand.nextDouble() * 9 + 1;
    }

    /**
     * Получение случайной длительности сна в промежутке [1000;5000)
     *
     * @return время на сон
     */
    public static long getSleepTime() {
        return (long) (rand.nextDouble() * 4000 + 1000);
    }
}
