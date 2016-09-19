package problems.interviewbit;

import java.util.ArrayList;

/**
 * Created by gouthamvidyapradhan on 27/08/2016.
 */
public class Flip
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> result = flip("111010011101011101100011101111100000000101101010010101010000101110101111010011101011101100011101111100000000101101010010101010000101110101111010011101011101100011101111100000000101101010010101010000101110101111010011101011101100011101111100000000101101010010101010000101110101111010011101011101100011101111100000000101101010010101010000101110101");
        for(int i : result)
            System.out.println(i);
    }

    public static ArrayList<Integer> flip(String A)
    {
        A = A.trim();
        int l = A.length();

        int[] count = new int[l + 1];

        if(!A.contains("0"))
            return new ArrayList<>();

        int next = l, lPos = 0, rPos = 0, max = Integer.MIN_VALUE;

        count[l] = -2;

        for(int i = l - 1; i >= 0; i --)
        {
            char c = A.charAt(i);
            switch (c)
            {
                case '0':
                         count[i] = Math.max(1, count[next--] + 1);
                         if(count[i] >= max)
                         {
                             max = count[i];
                             lPos = i;
                         }
                         break;

                case '1':
                         count[i] = Math.max(-1, count[next--] - 1);
                         if(count[i] >= max)
                         {
                             max = count[i];
                             lPos = i;
                         }
                         break;
            }
        }

        if(count[lPos] == 1)
            rPos = lPos;
        else
        {
            for(int i = lPos; i < l; i ++)
            {
                if(count[i] == 1)
                    rPos = i;
                else if(count[i] == 0)
                    break;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(lPos + 1);
        result.add(rPos + 1);
        return result;
    }

}
