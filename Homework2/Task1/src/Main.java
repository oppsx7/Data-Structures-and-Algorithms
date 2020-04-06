import java.util.Scanner;

public class Main {

    public static void countingSort(char[] array) {
        int maxNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNumber) {
                maxNumber = array[i];
            }
        }
        int[] countingArray = new int[maxNumber + 1];
        for (int i = 0; i < maxNumber+1; i++) {
            countingArray[i] = 0;
        }
        for (int i = 0; i < array.length; i++) {
            countingArray[array[i]]++;
        }
        int sortedIndex = 0;
        for (int i = 0; i < array.length; i++) {
            while (countingArray[sortedIndex] == 0) {
                sortedIndex++;
            }
            array[i] = (char)(sortedIndex+97);
            countingArray[sortedIndex]--;
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        char[] array = input.next().toCharArray();
        char[] array1 = input.next().toCharArray();
        if (array.length != array1.length || array.length > n || array1.length>n) {
            System.out.println("no");
            return;
        }
        countingSort(array);
        countingSort(array1);
        for (int i = 0; i < n; i++) {
            if (array[i] != array1[i]){
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
}
