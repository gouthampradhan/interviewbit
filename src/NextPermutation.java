package src;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by gouthamvidyapradhan on 29/08/2016.
 */
public class NextPermutation
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(20);
        list.add(20);
        list.add(20);
        list.add(20);
        list.add(20);
        list.add(20);
        list.add(20);
        nextPermutation(list);
    }


    public static void nextPermutation(ArrayList<Integer> a)
    {
        int len = a.size();
        int r = 0, l = -1, next = len - 1, d, min = Integer.MAX_VALUE, rEle = 0;
        for(int i = len - 2; i >=0; i--)
        {
            if(a.get(i) < a.get(next))
            {
                l = i;
                rEle = a.get(i);
                break;
            }
            next--;
        }
        if(l == -1)
        {
            //already last permutation given
            Collections.reverse(a);
        }
        else
        {
            for(int i = l + 1; i < len; i ++)
            {
                if(a.get(i) > rEle)
                {
                    d = a.get(i) - rEle;
                    if(d <= min)
                    {
                        r = i; //right ele
                        min = d;
                    }
                }
            }

            //swap
            int temp = a.get(l);
            a.set(l, a.get(r));
            a.set(r, temp);

            for(int i = l + 1, j = len - 1; (i < len && i < j); i ++, j --)
            {
                int temp1 = a.get(i);
                a.set(i, a.get(j));
                a.set(j, temp1);
            }
        }

        for (int i : a)
            System.out.print(i + " ");
    }
}
