import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 21/05/2017.
 * Accepted
 */
public class PaintersPartitionProblem
{
    private long min = Long.MAX_VALUE;
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1000000);
        list.add(1000000);
        list.add(1000000);
        list.add(1000000);
        list.add(1000000);
        System.out.println(new PaintersPartitionProblem().paint(5, 1000000, list));
    }

    public int paint(int a, int b, ArrayList<Integer> c)
    {
        int s = 0, e = Integer.MAX_VALUE;
        long ans = -1L;
        while(s <= e)
        {
            int m = s + (e - s) / 2;
            int status = share(c, m, a, b);
            if(status == 0)
            {
                e = m - 1;
                ans = m;
            }
            else if (status == -1)
                s = m + 1;
        }
        return (int)((ans * (b % 10000003)) % 10000003);
    }

    private int share(List<Integer> pages, int K, int N, int T)
    {
        long sum = 0, count = 1;
        for(int p : pages)
        {
            if(p > K) return -1;
            sum += p;
            if(sum > K)
            {
                sum = p;
                count ++;
            }
        }
        return count <= N ? 0 : -1;
    }

}
