package ru.hse.kdz03.animals;

import ru.hse.kdz03.Cart;
import ru.hse.kdz03.utils.RandomUtils;

/**
 * Класс Animal представляет поведение всех животных
 */
public abstract class Animal implements Runnable {
    private final Cart cart;
    // Случайный коэффициент для расчета координат
    private final double coefficient;
    // Угол в радианах для расчета координат
    private final double angle;

    public Animal(double coefficient, Cart cart, double angle) {
        this.coefficient = coefficient;
        this.cart = cart;
        this.angle = angle;
    }

    /**
     * Изменение координат тележки по формуле
     */
    public void changeCoordinates() {
        double newX = cart.getX() + coefficient * Math.cos(angle);
        double newY = cart.getY() + coefficient * Math.sin(angle);
        cart.setCoordinates(newX, newY);
    }

    /**
     * Реализует работу потоков над сдвигом тележки
     */
    @Override
    public void run() {
        // Данный блок выполняется одновременно только одним потоком
        synchronized (cart) {
            while (true) {
                // Если поток не прерван меняем координаты тележки
                if (!Thread.currentThread().isInterrupted()) {
                    changeCoordinates();
                } else {
                    return;
                }
                try {
                    // Засыпаем на определенное время
                    cart.wait(RandomUtils.getSleepTime());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
