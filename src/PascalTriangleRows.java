package src;

import java.util.ArrayList;

/**
 * Created by gouthamvidyapradhan on 28/08/2016.
 */
public class PascalTriangleRows
{
    public static void main(String[] args) throws Exception
    {

        ArrayList<ArrayList<Integer>> result = generate(4);
        for (ArrayList<Integer> list : result)
        {
            for (int i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> generate(int a)
    {
        if(a == 0)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 0; i < a; i ++)
            result.add(new ArrayList<>());

        if(a == 1)
        {
            result.get(0).add(1);
        }
        else if(a == 2)
        {
            result.get(0).add(1);
            result.get(1).add(1);
            result.get(1).add(1);
        }
        else
        {
            result.get(0).add(1);
            result.get(1).add(1);
            result.get(1).add(1);

            for(int k = 2; k < a; k ++)
            {
                ArrayList<Integer> row = result.get(k);
                for(int i = 0; i <= k; i ++)
                    row.add(0);

                result.get(k).set(0, 1);
                result.get(k).set(k, 1);
                for(int i = 1; i < k; i++)
                {
                    result.get(k).set(i, result.get(k - 1).get(i - 1) + result.get(k - 1).get(i));
                }
            }
        }
        return result;

    }

}
