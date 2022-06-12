import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        for(int i=0; i< 6;i++){
            List<Integer> list = getRow(i);
            System.out.println(list);

        }
    }
    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>();
        long val = 1;
        for (int j = 0; j <= rowIndex; j++) {
            res.add((int) val);
            val = val * (rowIndex - j) / (j + 1);
        }
        return res;
    }

}
