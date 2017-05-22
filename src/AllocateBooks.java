import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 21/05/2017.
 */
public class AllocateBooks
{
    public static void main(String[] args)
    {
        ArrayList<Integer> pages = new ArrayList<>();
        pages.add(12);
        pages.add(34);
        pages.add(67);
        pages.add(90);
        System.out.println(new AllocateBooks().books(pages, 5));
    }

    public int books(ArrayList<Integer> a, int b)
    {
        if(a.size() < b) return -1;
        if(b == 0) b = 1;
        int s = 0, e = Integer.MAX_VALUE, ans = 0;
        while(s <= e)
        {
            int m = s + (e - s) / 2;
            int status = share(a, m, b);
            if(status >= 0)
            {
                e = m - 1;
                ans = m;
            }
            else if (status == -1)
                s = m + 1;
        }
        return ans;
    }

    private int share(List<Integer> pages, int K, int N)
    {
        int sum = 0, count = 1;
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
        if(count == N) return 0;
        else if(count < N) return 1;
        return -1;
    }
}
