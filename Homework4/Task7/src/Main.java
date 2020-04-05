import java.util.Arrays;

public class Main {

    int[] formTeams(int[] array, int k) {

        int[] tempArray = new int[array.length];
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++)
            tempArray[i] = array[i];
        Arrays.sort(array);
        int max = array[array.length - 1];
        int j = 0;
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            if (i == max && flag) {
                result[i] = 1;
                for (int j = 0; j < k; j++) {
                    result[i - k + j] = 1;
                }
                flag = false;
            } else if (i == max && !flag) {
                result[i] = 2;
                for (int j = 0; j < k; j++) {
                    result[i - k + j] = 2;
                }
                flag = true;
            }
            
        }

        return result;
    }

    public static void main(String[] args) {
    }
}
