import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static int[] calculateSpan(int[] prices){
        int n = prices.length;
        int[] spans = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            spans[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return spans;
    }

    public static void main(String[] args) {
        int[] prices = {100, 65, 85, 90, 80, 200};
        int[] result = calculateSpan(prices);

        System.out.println(Arrays.toString(result));
    }
}