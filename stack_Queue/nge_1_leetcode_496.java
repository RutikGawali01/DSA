
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class nge_1_leetcode_496 {
   //
    public static int[] nge_1(int[] num1, int[] num2) {
    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();

    for (int i = num2.length - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() <= num2[i]) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            map.put(num2[i], -1);
        } else {
            map.put(num2[i], stack.peek());
        }
        stack.push(num2[i]);
    }

    int[] ans = new int[num1.length];
    for (int i = 0; i < num1.length; i++) {
        ans[i] = map.get(num1[i]);
    }

    return ans;
}
    public static void main(String[] args) {
        
    }
}
