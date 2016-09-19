package problems.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 26/08/2016.
 * Simple addition of 1.
 * O(N)
 */
public class AddOne
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(9);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(9);
        List<Integer> ret = plusOne(list);
        for (int i : ret)
            System.out.println(i);
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> a)
    {
        int[] in = new int[a.size()];
        int s = 0;
        for(int i : a)
            in[s++] = i;

        int c = 1;
        int[] b = new int[in.length + 1];
        Arrays.fill(b, -1);
        for(int i = in.length - 1; i >= 0; i --)
        {
            int tem = in[i] + c;
            c = tem / 10;
            b[i + 1] = tem % 10;
        }
        if(c == 1)
            b[0] = 1;

        int start = 0;
        for(int i = 0, l = b.length; i < l; i++)
        {
            if(b[i] == 0 || b[i] == -1)
                start++;
            else
                break;
        }

        b = Arrays.copyOfRange(b, start, b.length);

        ArrayList<Integer> result = new ArrayList<>();
        for(int i :  b)
            result.add(i);

        return result;
    }
}
