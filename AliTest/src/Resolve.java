import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Resolve {

    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        Stack<Integer> numberStack = new Stack<>();
        String[] spl = expr.split(" ");
        for (String aSpl : spl) {
            if ("".equals(aSpl)) {
                continue;
            }
            if (aSpl.contains("*")){
                if(numberStack.size()<2){
                    return -1;
                }
                int n1 = numberStack.pop();
                int n2 = numberStack.pop();
                numberStack.push(n1 * n2);
            }
            else if(aSpl.contains("^")){
                if(numberStack.size()<1){
                    return -1;
                }
                int n = numberStack.pop();
                numberStack.push(n + 1);

            }
            else if(aSpl.contains("+")){
                if(numberStack.size()<2){
                    return -1;
                }
                int n1 = numberStack.pop();
                int n2 = numberStack.pop();
                numberStack.push(n1 + n2);
            }
            else {
                numberStack.push(Integer.valueOf(aSpl));
                if(numberStack.size() > 16){
                    return -2;
                }
            }
        }
        if(numberStack.size()>0){
            return numberStack.pop();
        }
        return 0;
    }
}