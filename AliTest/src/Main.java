import java.util.Scanner;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/26
 */
public class Main {
    public static boolean check(String target, String pattern){
        int index = 0;
        int storeIndex = 0;
        int regIndex = 0;
        boolean isInReg = false;
        for(int i = 0 ;i < pattern.length();i++){
            char patternChar = pattern.charAt(i);
            if(patternChar=='*'){
                if(i==pattern.length()-1){
                    return true;
                }
                regIndex = i;
                char endChar;
                while((endChar=pattern.charAt(i))=='*'){
                    i++;
                    if(i>=pattern.length()){
                        return true;
                    }
                }

                isInReg = true;
                if(endChar=='?'){
                    index++;
                }
                else {
                    while (target.charAt(index) != endChar) {
                        index++;
                        if (index >= target.length()) {
                            return false;
                        }
                    }
                }
                storeIndex = index;
            }
            else if(patternChar=='?'){
                index ++;
            }
            else {
                if(target.charAt(index)!=patternChar){
                    /*
                    need to check if the related part of * is right
                     */
                    if(!isInReg) {
                        return false;
                    }
                    else {
                        index = storeIndex + 1;
                        i = regIndex - 1;
                    }
                }
                else {
                    index++;
                }
            }
        }
        return index <= target.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        String pattern = scanner.nextLine();
        if(target != null && !target.isEmpty() && pattern != null && !pattern.isEmpty() ) {
            System.out.println(check(target,pattern)?1:0);
        }
    }
}
