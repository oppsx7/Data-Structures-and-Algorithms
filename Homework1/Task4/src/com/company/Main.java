package com.company;

import java.util.Scanner;

public class Main {

    public boolean canWeMakeSocks(int n,int m){
        if(m<1){
            return false;
        }
        if((m>n && m==n+1) || (m>1 && m<n && (n-m)%2==1)){
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        Main a = new Main();
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int[] array = new int[T * 2];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        for (int i = 0; i < array.length - 1; i += 2) {
            if(a.canWeMakeSocks(array[i],array[i+1])==true)
                System.out.println("yes");

            else
                System.out.println("no");
        }
    }

}

