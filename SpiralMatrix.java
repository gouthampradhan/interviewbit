package problems.interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 26/08/2016.
 * O(N x M) trivial problem but a bit tricky
 */
public class SpiralMatrix
{
    public static void main(String[] args) throws Exception
    {
        List<ArrayList<Integer>> a = new ArrayList<>();
        for(int i = 0; i < 10; i ++)
            a.add(new ArrayList<>());

        int s = 0;
        for(int i = 0; i < 10; i ++)
        {
            for(int j = 0; j < 1; j ++)
                a.get(i).add(s++);
        }
        List<Integer> ret = spiralOrder(a);
        for(int i : ret)
            System.out.println(i);
    }

    /**
     * Generate results
     * @param a
     * @return
     */
    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int c = 0;
        int tr = 0, lc = 0;
        int br = a.size() - 1; //top row
        int rc = a.get(0).size() - 1;

        while(tr <= br && lc <= rc)
        {
            switch (c)
            {
                case 0 :
                    for(int i = lc; i <= rc; i++)
                        result.add(a.get(tr).get(i));
                    tr++;
                    break;

                case 1 :
                    for(int i = tr; i <= br; i++)
                        result.add(a.get(i).get(rc));
                    rc--;
                    break;

                case 2 :
                    for(int i = rc; i >= lc; i--)
                        result.add(a.get(br).get(i));
                    br--;
                    break;

                case 3 :
                    for(int i = br; i >= tr; i--)
                        result.add(a.get(i).get(lc));
                    lc++;
                    break;
            }
            c = (c + 1) % 4;
        }

        // Populate result;
        return result;
    }
}
