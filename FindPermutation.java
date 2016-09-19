package problems.interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by gouthamvidyapradhan on 31/08/2016.
 */
public class FindPermutation
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> list = findPerm("IIIIIIIIIID", 12);
        for (int i : list)
            System.out.print(i + " ");

    }

    public static ArrayList<Integer> findPerm(final String A, int B)
    {
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if(B == 1)
        {
            result.add(1);
            return result;
        }
        list.add(1);
        int lastI = 0;
        for(int i = 0; i < B - 1; i ++)
        {
            char c = A.charAt(i);
            switch (c)
            {
                case 'I':
                        list.add(i + 2);
                        lastI = i + 1;
                        break;

                case 'D':
                        list.add(lastI, i + 2);
                        break;
            }
        }
        result.addAll(list);
        return result;
    }
}
