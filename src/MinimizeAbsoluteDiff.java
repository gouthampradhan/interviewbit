import java.util.Arrays;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 25/05/2017.
 * Accepted
 */
public class MinimizeAbsoluteDiff
{
    private int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception
    {
        List<Integer> a = Arrays.asList(1, 4, 10);
        List<Integer> b = Arrays.asList(-121, -18, 0);
        List<Integer> c = Arrays.asList(-18);
        System.out.println(new MinimizeAbsoluteDiff().minimize(a, b, c));
    }

    public int minimize(List<Integer> A, List<Integer> B, List<Integer> C)
    {
        int aL = A.size(), bL = B.size(), cL = C.size();
        int i = 0, j = 0, k = 0;
        while(i < aL && j < bL && k < cL)
        {
            min = Math.min(min, getDiff(i, j, k, A, B, C));
            if(min == 0) return 0;
            int status = getMinIndex(i, j, k, A, B, C);
            if(status == 0)
                i++;
            else if(status == 1)
                j++;
            else k++;
        }
        return min;
    }

    private int getDiff(int i, int j, int k, List<Integer> a, List<Integer> b, List<Integer> c)
    {
        int f = Math.abs(a.get(i) - b.get(j));
        int s = Math.abs(b.get(j) - c.get(k));
        int t = Math.abs(c.get(k) - a.get(i));
        return Math.max(Math.max(f, s), t);
    }

    private int getMinIndex(int i, int j, int k, List<Integer> a, List<Integer> b, List<Integer> c)
    {
        return a.get(i) <= b.get(j) ? (a.get(i) <= c.get(k)) ? 0 : 2 : (b.get(j) <= c.get(k)) ? 1 : 2;
    }
}
