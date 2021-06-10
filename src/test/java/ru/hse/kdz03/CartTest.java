package ru.hse.kdz03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
Cart cart;
Cart cart2;
    @BeforeEach
    void initialization()
    {
        cart = new Cart(2,3);
        cart2 = new Cart(1.45,8.5);
    }
    @DisplayName("Изменение координат тележки")
    @Test
    void setCoordinates() {
        cart.setCoordinates(4,9);
        assertEquals(4,cart.getX());
        assertEquals(9,cart.getY());
        cart2.setCoordinates(3.2,8.9);
        assertEquals(3.2,cart2.getX());
        assertEquals(8.9,cart2.getY());

    }
    @DisplayName("Получение координаты x у тележки")
    @Test
    void getX() {
        assertEquals(2,cart.getX());
        assertEquals(1.45,cart2.getX());
    }
    @DisplayName("Получение координаты y у тележки")
    @Test
    void getY() {
        assertEquals(3,cart.getY());
        assertEquals(8.5,cart2.getY());
    }
    @DisplayName("Получение строкового представления координат тележки")
    @Test
    void testToString() {
        assertEquals("Координаты тележки -> x: 2,00\t|\ty: 3,00",cart.toString());
        assertEquals("Координаты тележки -> x: 1,45\t|\ty: 8,50",cart2.toString());
    }
}