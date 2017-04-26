package robot;

import java.util.Scanner;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/8
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        long Q = in.nextLong();
        long min = N;

        long x = 0;
        long doux = 1;
        while (doux<N){
            long newMin = x*Q + (long) Math.ceil(((N + 0.0) /doux));
            if(newMin<min){
                min = newMin;
            }
            x++;
            doux = doux*2;
        }
        long newMin = x*Q + 1;
        if(newMin<min){
            min = newMin;
        }
        System.out.println(min);
    }
}
