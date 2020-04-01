import java.util.*;

public class Main {
    public void countingSort(int[] array) {
        int maxNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNumber) {
                maxNumber = array[i];
            }
        }
        int[] countingArray = new int[maxNumber + 1];
        for (int i = 0; i < maxNumber + 1; i++) {
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
            array[i] = sortedIndex;
            countingArray[sortedIndex]--;
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        int counter = 0;
        int[] array = new int[n];
        for (int j = 0; j < array.length; j++) {
            array[j] = input.nextInt();
        }
        Main a = new Main();
        a.countingSort(array);
        String tryed = null;
        List<String> al =
                new ArrayList<String>(Arrays.asList(tryed));

        List<Integer> list =  new ArrayList<Integer>();
        for(Integer inty :array )
            list.add(inty);
        Integer tempInt = array[n - 1];
        for (int i = 0; i < n; i++) {

        }

        System.out.println(counter);


    }
}
