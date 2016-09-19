package problems.interviewbit;

import java.util.ArrayList;

/**
 * Created by gouthamvidyapradhan on 29/08/2016.
 */
public class AntiDiagonals
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 100; i ++)
        {
            list.add(new ArrayList<>());
        }
        int a = 1;
        for(int i = 0; i < 100; i ++)
        {
            for(int j = 0; j < 100; j ++)
            {
                list.get(i).add(a++);
            }
        }
        ArrayList<ArrayList<Integer>> result = diagonal(list);
        for (ArrayList<Integer> r : result)
        {
            for (int i : r)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a)
    {
        int l = a.size();
        if(l == 0) return new ArrayList<>();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for(int i = 0; i < l * 2 - 1; i++)
            matrix.add(new ArrayList<>());

        for(int i = 0, mr = 0; i < l; i++, mr++)
        {
            int r = 0;
            for(int c = i; c >=0; c--)
            {
                matrix.get(mr).add(a.get(r).get(c));
                r++;
            }
        }

        for(int i = 1, mr = l; i < l; i++, mr++)
        {
            int c = l - 1;
            for(int r = i; r < l; r++)
            {
                matrix.get(mr).add(a.get(r).get(c));
                c--;
            }
        }

        return matrix;
    }

}
