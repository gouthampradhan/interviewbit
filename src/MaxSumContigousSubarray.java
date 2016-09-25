package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 27/08/2016.
 */
public class MaxSumContigousSubarray
{
    public static void main(String[] args) throws Exception
    {
        List<Integer> list = new ArrayList<>();
        list.add(99981);
        list.add(-1);
        list.add(99982);
        System.out.println(maxSubArray(list));
    }

    public static int maxSubArray(final List<Integer> a)
    {
        int l = a.size();
        if(l == 0) return 0;
        int next = l;
        int[] temp = new int[l + 1];
        Arrays.fill(temp, 0);
        int max = Integer.MIN_VALUE;
        for(int i = l - 1; i >= 0; i--)
        {
            int tmax = Math.max(a.get(i), a.get(i) + temp[next]);
            temp[i] = tmax;
            max = Math.max(max, tmax);
            next--;
        }
        return max;
    }
}
