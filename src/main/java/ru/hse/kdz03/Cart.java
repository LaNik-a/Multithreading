package ru.hse.kdz03;

/**
 * Класс представляет координаты тележки и позволяет получить информацию о них
 */
public class Cart {

    private double x;
    private double y;

    public Cart(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Установка координат тележки
     *
     * @param x координата по оси x
     * @param y координата по оси y
     */
    public void setCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Получение координаты
     *
     * @return координата по оси x
     */
    public synchronized double getX() {
        return x;
    }

    /**
     * Получение координаты
     *
     * @return координата по оси y
     */
    public synchronized double getY() {
        return y;
    }

    /**
     * Получение информации о нахождении тележки
     *
     * @return координаты по оси x,y
     */
    @Override
    public String toString() {
        return "Координаты тележки -> x: " + String.format("%.2f", getX())
                + "\t|\ty: " + String.format("%.2f", getY());
    }


}
