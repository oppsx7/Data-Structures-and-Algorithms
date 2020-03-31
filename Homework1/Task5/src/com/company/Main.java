package com.company;

import java.util.Scanner;

public class Main {

    int calculateTimes(int n) {
        int times = 0;
        int[] arrayOfCombinations = new int[63];
        boolean[] arrayOfFlags = new boolean[63];
        int t = 1;
        int d = 1;
        for (int i = 0; i < 60; i++) {
            if (i >= 0 && i < 20)
                arrayOfCombinations[i] = i + 1;
            if (i > 19 && i < 40) {
                arrayOfCombinations[i] = 2 * t;
                t++;
            }
            if (i > 39 && i < 60) {

                arrayOfCombinations[i] = 3 * d;
                d++;
            }
        }
        arrayOfCombinations[60] = 25;
        arrayOfCombinations[61] = 50;
        arrayOfCombinations[62] = 0;

        for (int i = 0; i < 20; i++)
            arrayOfFlags[i] = false;
        for (int i = 20; i < 40; i++)
            arrayOfFlags[i] = true;
        for (int i = 40; i < 60; i++)
            arrayOfFlags[i] = false;
        arrayOfFlags[60] = false;
        arrayOfFlags[61] = true;
        arrayOfFlags[62] = false;


        for (int i = 0; i < 63; i++) {
            if (arrayOfFlags[i] == true && n == arrayOfCombinations[i])
                times++;
            else {
                for (int j = 0; j < 63; j++) {
                    if (arrayOfFlags[j] == true && (n == arrayOfCombinations[i] + arrayOfCombinations[j]))
                        times++;
                    else {
                        for (int k = 0; k < 63; k++) {
                            if (arrayOfFlags[k] == true && (n == arrayOfCombinations[i] + arrayOfCombinations[j] + arrayOfCombinations[k]))
                                times++;
                        }
                    }
                }
            }
        }

        return times;
    }

    public static void main(String[] args) {
        Main a = new Main();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(a.calculateTimes(n));

    }
}
