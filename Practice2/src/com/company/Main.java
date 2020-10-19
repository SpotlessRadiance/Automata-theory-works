package com.company;

import java.util.*;

public class Main {
    // Поиск числа учитывая его знак

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int START = 0;
        final int SIGN = 1;
        final int NUMBER = 2;

        List<Character> digits = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
        List<Character> starts = Arrays.asList('1','2','3','4','5','6','7','8','9');
        List<Character> signs = Arrays.asList('-', '+');
        Set<Integer> endStates = Collections.singleton(NUMBER);
        StateMachine sm = new StateMachine(START, endStates);

        sm.add(START, digits, NUMBER);
       sm.add(NUMBER, digits, NUMBER);

       sm.add(START, signs, SIGN);
       sm.add(SIGN, starts, NUMBER);

       System.out.println("Введите строку");
        String line = in.nextLine();
        sm.findAll(line);
    }
}
