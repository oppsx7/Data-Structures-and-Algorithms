package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter password");
        String text = input.nextLine();
        int counter = 0;
        char letter = text.charAt(0);
        List<String> myList = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == letter)
                counter++;
            else {

                myList.add(Integer.toString(counter));
                myList.add(Character.toString(letter));
                letter=text.charAt(i);
                counter = 1;
            }

        }
        myList.add(Integer.toString(counter));
        myList.add(Character.toString(letter));

        for (String obj : myList)
            System.out.print(obj);

    }
}
