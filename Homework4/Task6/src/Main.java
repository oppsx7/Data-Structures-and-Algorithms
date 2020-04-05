import java.util.*;

public class Main {

    static int checkBestPosition(int[] array) {
        Stack<Integer> stack =  new Stack<>();
        int maxPosition = 0;
        int currentStackSize =0;
        for(int i=array.length-1;i>=0;i--){
            if(stack.empty())
                stack.push(array[i]);
            else if(stack.peek()>array[i]) {
                stack.push(array[i]);
            }

            else {
                while(!stack.isEmpty() && stack.peek()<=array[i])
                    stack.pop();
                stack.push(array[i]);
            }

            if(stack.size()>=currentStackSize) {
                currentStackSize = stack.size();
                maxPosition = i;
            }
        }


        return maxPosition;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++)
            array[i] = input.nextInt();

        System.out.println(checkBestPosition(array));
    }
}
