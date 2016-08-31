package problems.interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 28/08/2016.
 */
public class MaxNegativeSubArray
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12121212);
        list.add(-12121);
        list.add(-12122);
        list.add(-999999999);



        List<Integer> result = maxset(list);
        for (int i : result)
            System.out.print(i + " ");
    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> a)
    {
        int l = a.size(), left = -1, right = -1, tl = -1, tr = -1;
        long max = Long.MIN_VALUE, sum = 0;

        for(int i = 0; i < l; i ++)
        {
            int curr = a.get(i);
            if(curr >= 0)
            {
                if(tr != (i - 1) || tr == -1)
                {
                    tl = i; tr = i;
                    sum = curr;
                }
                else
                {
                    tr++;
                    sum += curr;
                }
            }
            else
            {
                if(tr == i - 1 && tr != -1)
                {
                    if(sum > max)
                    {
                        max = sum;
                        left = tl;
                        right = tr;
                    }
                    else if(sum == max)
                    {
                        if((right - left) < (tr - tl))
                        {
                            left = tl;
                            right = tr;
                        }
                    }
                }
            }
        }

        if(tr == l - 1 && tr != -1)
        {
            if(sum > max)
            {
                max = sum;
                left = tl;
                right = tr;
            }
            else if(sum == max)
            {
                if((right - left) < (tr - tl))
                {
                    left = tl;
                    right = tr;
                }
            }
        }

        if(left == -1 && right == -1)
            return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = left; i <= right; i ++)
            result.add(a.get(i));
        return result;
    }

}
