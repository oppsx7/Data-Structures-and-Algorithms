package com.company;

import java.util.Scanner;

import static java.lang.StrictMath.abs;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        int position;
        int result;
        int maxResult=0;
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = input.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                position=abs(j-i);
                if(array[i]<array[j]){
                    result=position*array[i];

                }
                else{
                    result = position*array[j];
                }

                if(result>maxResult){
                    maxResult=result;
                }


            }
        }

        System.out.println(maxResult);
    }
}
