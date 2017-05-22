/**
 * Created by gouthamvidyapradhan on 22/05/2017.
 * Accepted
 */
public class SquareRootOfInteger {
    public int sqrt(int x)
    {
        int s = 0, e = x;
        long ans = 0L;
        while(s <= e)
        {
            long m = s + (e - s) / 2;
            long prod = m * m;
            if(prod <= x)
            {
                s = (int)(m + 1);
                ans = m;
            }
            else e = (int)m - 1;
        }
        return (int)ans;
    }
}
