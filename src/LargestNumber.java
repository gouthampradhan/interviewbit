package src;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 29/08/2016.
 */
public class LargestNumber
{
    public static void main(String[] args) throws Exception
    {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(30);
        list.add(34);
        list.add(5);
        list.add(9);
        largestNumber(list);
    }

    public static String largestNumber(final List<Integer> a)
    {
        Collections.sort(a, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                if(Long.parseLong(o1.toString() + o2.toString()) > Long.parseLong(o2.toString() + o1.toString()))
                    return -1;
                else return 1;
            }
        });

        StringBuilder result = new StringBuilder();
        int sum = 0;
        for (int i : a)
        {
            result.append(i);
            sum += i;
        }
        return (sum == 0)? "0" : result.toString();
    }

}
