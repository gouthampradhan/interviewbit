import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 30/05/2017.
 * Accepted
 */
public class CountingTriangles
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(new CountingTriangles().nTriang(Arrays.asList(1, 1, 1, 2, 2)));
    }

    private int nTriang(List<Integer> list)
    {
        Collections.sort(list);
        int l = list.size();
        int cnt = 0;
        for(int i = 0; i < l - 2; i ++)
        {
            for(int j = i + 1; j < l - 1; j ++)
            {
                int k = search(list, j + 1, list.get(i) + list.get(j));
                if(k != -1)
                    cnt = ((cnt % 1000000007) + ((k - j) % 1000000007))  %  1000000007;
            }
        }
        return cnt;
    }

    private int search(List<Integer> list, int i, int target)
    {
        int s = i, e = list.size() - 1, m, ans = -1;
        while(s <= e){
            m = s + (e - s) / 2;
            if(list.get(m) < target){
                ans = m;
                s = m + 1;
            }
            else e = m - 1;
        }
        return ans;
    }
}
