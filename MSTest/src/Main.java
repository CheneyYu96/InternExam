import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/8
 */
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        List<Long> rows = new ArrayList<>();
        List<Long> columes = new ArrayList<>();
        int total = in.nextInt();
        for (int i = 0; i < total; i++){
            rows.add(in.nextLong());
            columes.add(in.nextLong());
        }
        int result = 0;
        for(int i = 0 ; i < total; i++){
            long ax = rows.get(i);
            long ay = columes.get(i);

            for(int j = i + 1; j < total; j++){
                long bx = rows.get(j);
                long by = columes.get(j);
                long mx = ax - bx;
                long my = ay - by;
                if(ax==bx || ay==by|| mx==my || mx == -my){
                    result++;
                }
            }
        }

        System.out.println(result);
    }

}
