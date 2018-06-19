package mx.irving;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }

    static public int solution(String S) {
        // write your code in Java SE 8
        if (S == null || S.isEmpty()) {
            return -1;
        }
        String[] operations = S.split(" ");
        List<String> stack = new ArrayList<String>();
        for (String operation : operations) {
            switch (operation) {
                case "DUP":
                    if (stack.isEmpty()) {
                        return -1;
                    }
                    stack.add(stack.get(stack.size() -1));
                    break;
                case "POP" :
                    if (stack.isEmpty()) {
                        return -1;
                    }
                    stack.remove(stack.size() -1);
                    break;
                case "+" :
                    if (stack.size() < 2) {
                        return -1;
                    }
                    String right  = stack.remove(stack.size() -1);
                    String left  = stack.remove(stack.size() -1);
                    stack.add("" + Integer.parseInt(right) + Integer.parseInt(left));
                    break;
                case "-" :
                    if (stack.size() < 2) {
                        return -1;
                    }
                    String rightM  = stack.remove(stack.size() -1);
                    String leftM  = stack.remove(stack.size() -1);
                    int result = Integer.parseInt(rightM) - Integer.parseInt(leftM);
                    stack.add("" + result);
                    break;
                default:
                    stack.add(operation);
            }
        }
        return Integer.parseInt(stack.get(stack.size() -1));
    }
}
