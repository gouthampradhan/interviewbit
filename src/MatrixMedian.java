import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 20/05/2017.
 * Accepted
 */
public class MatrixMedian
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<ArrayList<Integer>> test = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1); row1.add(3); row1.add(5);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(2); row2.add(6); row2.add(9);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(3); row3.add(6); row3.add(9);

        test.add(row1);
        test.add(row2);
        test.add(row3);
        System.out.println(new MatrixMedian().findMedian(test));
    }

    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int mIndex = (A.size() * A.get(0).size()) / 2;
        int s = 0, e = Integer.MAX_VALUE, m, median = -1;
        while(s <= e) {
            m = s + (e - s) / 2;
            int lessThan = findIndex(A, m);
            if(lessThan >= mIndex + 1) {
                median = m;
                e = m - 1;
            }
            else s = m + 1;
        }
        return median;
    }

    private int findIndex(ArrayList<ArrayList<Integer>> A, int target){
        int sum = 0;
        for(int currRow = 0, l = A.size(); currRow < l; currRow ++) {
            int pos = -1;
            List<Integer> list = A.get(currRow);
            int s = 0, e = list.size() - 1, m;
            while(s <= e) {
                m = s + (e - s) / 2;
                int ele = list.get(m);
                if(ele <= target) {
                    pos = m;
                    s = m + 1;
                }
                else if(ele > target){
                    e = m - 1;
                }
            }
            sum += (pos + 1);
        }
        return sum;
    }
}
