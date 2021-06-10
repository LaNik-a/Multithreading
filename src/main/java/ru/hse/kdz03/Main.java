package ru.hse.kdz03;

import ru.hse.kdz03.animals.Crayfish;
import ru.hse.kdz03.animals.Pike;
import ru.hse.kdz03.animals.Swan;
import ru.hse.kdz03.utils.RandomUtils;

import javax.swing.Timer;
import java.util.Scanner;

public class Main {
    private static final int TOTAL_MILLISECONDS = 25000;
    private static final int INFO_USER_MILLISECONDS = 2000;
    private static Scanner sc;

    public static void main(String[] args) {
        int coordinateX = 0;
        int coordinateY = 0;
        try {
            coordinateX = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Число для x неккоректно, поэтому x = 0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Первого аргумента не было введено, поэтому x = 0");
        }
        try {
            coordinateY = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Число для y неккоректно, поэтому y = 0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Второго аргумента не было введено, поэтому y = 0");
        }
        double coefficientPike;
        double coefficientSwan;
        double coefficientCrayfish;
        System.out.println("\nХотите сами ввести коэффициенты для существ?" +
                "\nЕсли хотите, напишите \"Да\"");
        sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.toLowerCase().equals("да")) {
            coefficientPike = getNum(1, 10,
                    "Введите коэффициент для щуки на промежутке [1;10)");
            coefficientSwan = getNum(1, 10,
                    "Введите коэффициент для лебедя на промежутке [1;10)");
            coefficientCrayfish = getNum(1, 10,
                    "Введите коэффициент для рака на промежутке [1;10)");
        } else {
            coefficientPike = RandomUtils.getCoefficient();
            coefficientSwan = RandomUtils.getCoefficient();
            coefficientCrayfish = RandomUtils.getCoefficient();
        }

        Cart cart = new Cart(coordinateX, coordinateY);
        System.out.println("Начальные " + cart.toString().toLowerCase() + "\n");
        Thread thrCrayfish = new Thread(new Crayfish(coefficientCrayfish, cart));
        Thread thrSwan = new Thread(new Swan(coefficientSwan, cart));
        Thread thrPike = new Thread(new Pike(coefficientPike, cart));
        Timer timerInfo = new Timer(INFO_USER_MILLISECONDS, null);
        timerInfo.addActionListener(e -> System.out.println(cart.toString()));
        Timer timer = new Timer(TOTAL_MILLISECONDS, null);
        timer.addActionListener(e -> {
            thrCrayfish.interrupt();
            thrPike.interrupt();
            thrSwan.interrupt();
            System.out.println("\nУ существ окончательно закончились силы ;(\n");
            System.out.println("Итоговые " + cart.toString().toLowerCase());
        });

        timerInfo.start();
        timer.start();
        thrCrayfish.start();
        thrPike.start();
        thrSwan.start();
    }

    /**
     * Получение числа от пользователя в заданном отрезке
     *
     * @param leftBorder  левый конец отрезка
     * @param rightBorder правый конец отрезка
     * @param inputStr    подсказка пользователю
     * @return число от пользователя
     */
    public static double getNum(int leftBorder, int rightBorder, String inputStr) {
        sc = new Scanner(System.in);
        String str;
        double number = -1;
        do {
            System.out.println(inputStr);
            str = sc.nextLine();
            if (isNumber(str)) {
                number = Double.parseDouble(str);
            }
        } while (!isNumber(str) || number < leftBorder || number >= rightBorder);

        return number;
    }

    /**
     * Проверка на возможность преобразовать в число
     *
     * @param s строка
     * @return можно/нельзя
     */
    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }


}
