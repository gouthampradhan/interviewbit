package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 27/08/2016.
 */
public class RepeatAndMissingNumber
{
    public static void main(String[] args) throws Exception
    {
        List<Integer> list = new ArrayList<>();
        //for(int i = 0; i <= 9999999; i ++)
        //    list.add(i + 1);
        //list.set(100, 99);
        list.add(19);
        list.add(20);
        list.add(1);
        list.add(1);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(18);
        list.add(3);
        list.add(7);
        list.add(17);
        list.add(16);
        list.add(15);
        list.add(14);
        list.add(13);
        list.add(12);
        list.add(11);
        list.add(10);
        list.add(9);
        list.add(8);
        List<Integer> ret = repeatedNumber(list);
        for (int i : ret)
            System.out.println(i);
    }

    public static ArrayList <Integer> repeatedNumber(final List<Integer> a)
    {
        long sum = 0L;
        int l = a.size(), duplicate = 0, missing;
        boolean[] check = new boolean[l + 1];
        for(int e : a)
        {
            sum += e;
            if(!check[e])
                check[e] = true;
            else
                duplicate = e;
        }
        sum -= duplicate;
        //sum of upto n terms
        long sumNTerms = ((long)l * (2 + (l - 1))) / 2;
        missing = (int)(sumNTerms - sum);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(duplicate);
        res.add(missing);
        return res;
    }

}
