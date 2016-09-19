package problems.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 31/08/2016.
 */
public class MaxDistance
{
    static class Element
    {
        int e, i;
        Element(int e, int i)
        {
            this.e = e;
            this.i = i;
        }
    }
    public static void main(String[] args) throws Exception
    {
        List<Integer> list = new ArrayList<>();
        list.add(9999);
        list.add(-9999);
        list.add(9999);
        list.add(-9999);
        list.add(9999);

        int result = maximumGap(list);
        System.out.println(result);
    }

    public static int maximumGap(final List<Integer> a)
    {
        if(a.size() == 0)
            return -1;
        List<Element> list = new ArrayList<>();

        for(int i = 0, l = a.size(); i < l; i++)
            list.add(i, new Element(a.get(i), i));

        Collections.sort(list, (o1, o2) -> Integer.compare(o1.e, o2.e));

        int min = list.get(0).i, prev = list.get(0).i, max = 0;

        for(Element e : list)
        {
            if(e.i < prev)
            {
                min = Math.min(min, e.i);
                prev = e.i;
            }
            else if(e.i > prev)
            {
                max = Math.max(max, e.i - min);
                prev = e.i;
            }
        }

        return max;
    }

}
