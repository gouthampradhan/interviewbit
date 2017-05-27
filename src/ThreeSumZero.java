import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 27/05/2017.
 * Accepted
 */
public class ThreeSumZero
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {

    }

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(a.size() < 3) return result;
        Collections.sort(a);
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
                    if(sum == 0)
                    {
                        ArrayList<Integer> newList = new ArrayList<>();
                        newList.add(a.get(i));
                        newList.add(a.get(j));
                        newList.add(a.get(k));
                        result.add(newList);
                        k--; j++;
                    }
                    else if(sum > 0) k--;
                    else j++;
                }
            }
        }
        return result;

    }

}
