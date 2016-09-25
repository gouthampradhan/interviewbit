package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 29/08/2016.
 */
public class SprialOrderMatrixII
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<ArrayList<Integer>> result = generateMatrix(1000);
        for (ArrayList<Integer> list : result)
        {
            for (int i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> generateMatrix(int a)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(a == 0)
            return result;
        for(int i = 0; i < a; i ++)
        {
            ArrayList<Integer> column = new ArrayList<>();
            for(int j = 0; j < a; j ++)
                column.add(0);
            result.add(i, column);
        }

        int c = 0;
        int tr = 0, lc = 0;
        int br = a - 1; //top row
        int rc = a - 1;

        int e = 1;

        while(tr <= br && lc <= rc)
        {
            switch (c)
            {
                case 0 :
                    for(int i = lc; i <= rc; i++)
                        result.get(tr).set(i, e++);
                        //result.add(a.get(tr).get(i));
                    tr++;
                    break;

                case 1 :
                    for(int i = tr; i <= br; i++)
                        result.get(i).set(rc, e++);
                        //result.add(a.get(i).get(rc));
                    rc--;
                    break;

                case 2 :
                    for(int i = rc; i >= lc; i--)
                        result.get(br).set(i, e++);
                        //result.add(a.get(br).get(i));
                    br--;
                    break;

                case 3 :
                    for(int i = br; i >= tr; i--)
                        result.get(i).set(lc, e++);
                        //result.add(a.get(i).get(lc));
                    lc++;
                    break;
            }
            c = (c + 1) % 4;
        }

        // Populate result;
        return result;
    }

}
