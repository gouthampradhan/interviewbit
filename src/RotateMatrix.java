package src;

import java.util.ArrayList;

/**
 * Created by gouthamvidyapradhan on 30/08/2016.
 */
public class RotateMatrix
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int e = 1;
        for(int i = 0; i < 1; i++)
            list.add(new ArrayList<>());
        for(int i = 0; i < 1; i++)
        {
            for(int j = 0; j < 1; j++)
                list.get(i).add(e++);
        }
        rotate(list);
        for (ArrayList<Integer> li : list)
        {
            for (int i : li)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public static void rotate(ArrayList<ArrayList<Integer>> a)
    {
        int s = a.size();
        int tr = 0, fc = 0, lc = s - 1, br = s - 1, t1, t2;

        while(tr < br && fc < lc)
        {
            for(int i = fc, j = tr, k = lc, l = br; i < lc; i ++, j ++, k --, l --)
            {
                t1 = a.get(j).get(lc);
                a.get(j).set(lc, a.get(tr).get(i));

                t2 = a.get(br).get(k);
                a.get(br).set(k, t1);

                t1 = a.get(l).get(fc);
                a.get(l).set(fc, t2);

                a.get(tr).set(i, t1);
            }
            tr++; fc++; lc--; br--;
        }

    }
}
