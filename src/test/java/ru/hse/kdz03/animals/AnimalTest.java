package ru.hse.kdz03.animals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import ru.hse.kdz03.Cart;

import javax.swing.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    Cart cart;
    Animal crayfish;
    Animal pike;
    Animal swan;

    @BeforeEach
    void initialization() {
        cart = new Cart(2, 3);
        crayfish = new Crayfish(2, cart);
        pike = new Pike(3, cart);
        swan = new Swan(4, cart);
    }

    @DisplayName("Поменять координаты, использую формулу")
    @org.junit.jupiter.api.Test
    void changeCoordinates() {
        crayfish.changeCoordinates();
        assertEquals(0, Math.round(cart.getX()));
        assertEquals(3, Math.round(cart.getY()));
        pike.changeCoordinates();
        assertEquals(2, Math.round(cart.getX()));
        assertEquals(0, Math.round(cart.getY()));
        swan.changeCoordinates();
        assertEquals(4, Math.round(cart.getX()));
        assertEquals(4, Math.round(cart.getY()));

    }

    @DisplayName("Работа потоков над сдвигом тележки")
    @org.junit.jupiter.api.Test
    void run()  {
        Thread thrCrayfish = new Thread(crayfish);
        Thread thrPike = new Thread(pike);
        Thread thrSwan = new Thread(swan);
        Thread thrTest = new Thread(swan);
        thrCrayfish.start();
        thrPike.start();
        thrSwan.start();
        // Для теста на то что все потоки которые надо запустились
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        boolean containsThrCrayfish = map.containsKey(thrCrayfish);
        boolean containsThrPike = map.containsKey(thrPike);
        boolean containsThrSwan = map.containsKey(thrSwan);
        boolean containsThrTest = map.containsKey(thrTest);
        assertTrue(containsThrCrayfish);
        assertTrue(containsThrPike);
        assertTrue(containsThrSwan);
        assertFalse(containsThrTest);
        String stateThrCrayfish = String.valueOf(thrCrayfish.getState());
        thrCrayfish.interrupt();
        assertEquals("TIMED_WAITING", stateThrCrayfish);
        String stateFinalThrCrayfish = String.valueOf(thrCrayfish.getState());
        assertEquals("TERMINATED", stateFinalThrCrayfish);
        thrSwan.interrupt();
        thrPike.interrupt();
        Cart cart2 = new Cart(4, 4);
        Animal crayfish2 = new Crayfish(5, cart2);
        Thread thrTest2 = new Thread(crayfish2);
        Timer timer = new Timer(999, null);
        timer.addActionListener(e -> {
            thrTest2.interrupt();
            assertEquals(-1, cart2.getX());
            assertEquals(4, cart2.getY());
        });
        timer.start();
        thrTest2.start();

    }
}