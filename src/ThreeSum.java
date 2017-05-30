import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 30/05/2017.
 * Accepted
 */
public class ThreeSum {
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new ThreeSum().threeSumClosest(Arrays.asList(-1,2,1,-4), 1));
    }

    public int threeSumClosest(List<Integer> a, int target)
    {
        Collections.sort(a);
        int min = Integer.MAX_VALUE, ans = -1;
        for(int i = 0, l = a.size(); i < l - 2; i ++)
        {
            if(i == 0 || ! a.get(i).equals(a.get(i - 1)))
            {
                int j = i + 1, k = l - 1;
                while(k > j)
                {
                    if(j != i + 1 && a.get(j).equals(a.get(j - 1)))
                    {
                        j ++;
                        continue;
                    }
                    int sum = a.get(i) + a.get(j) + a.get(k);
                    if(sum < target) {
                        int diff = Math.abs(sum - target);
                        if(diff < min) {
                            min = diff;
                            ans = sum;
                        }
                        j++;
                    }
                    else if(sum > target) {
                        int diff = Math.abs(sum - target);
                        if(diff < min) {
                            min = diff;
                            ans = sum;
                        }
                        k--;
                    }
                    else{
                        return sum;
                    }
                }
            }
        }
        return ans;
    }
}
