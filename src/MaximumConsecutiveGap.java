import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 27/09/2016.
 */
public class MaximumConsecutiveGap
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(maximumGap(list));
    }

    public static int maximumGap(final List<Integer> a)
    {
        int l = a.size();
        if(l < 2) return 0;
        Collections.sort(a);
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < l; i ++)
            max = Math.max(max, a.get(i) - a.get(i - 1));
        return max;
    }
}
