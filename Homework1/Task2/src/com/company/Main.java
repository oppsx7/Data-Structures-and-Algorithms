package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] < arr[j+1])
                {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int min = input.nextInt();
        int count = input.nextInt();
        int[] array = new int[count];
        int difference;
        int j=1;
        for (int i = 0; i < count; i++) {
            array[i] = input.nextInt();
        }
        bubbleSort(array);

        if(array[0]<min){
            System.out.println("no");
            return;
        }

        for(int i=0;i<array.length;i++){
            while(array[i]<min && j<array.length)
            {
                difference = array[i-j]- min;
                    array[i] += difference;
                    array[i - j] -= difference;
                    j++;
            }

        }

        for(int i=0;i<array.length;i++){
            if(array[i]<min){
                System.out.println("no");
                return;
            }

        }

        System.out.println("yes");







    }
}
