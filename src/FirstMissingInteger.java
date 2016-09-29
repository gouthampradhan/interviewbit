package src;

import java.util.ArrayList;

/**
 * Created by gouthamvidyapradhan on 26/09/2016.
 */
public class FirstMissingInteger
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(5);
        System.out.println(firstMissingPositive(list));
    }

    public static int firstMissingPositive(ArrayList<Integer> a)
    {
        int l = a.size();
        int[] arr = new int[l + 1];
        for(int i : a)
        {
            if(i > 0 && i <= l)
                arr[i] = i;
        }
        if(l > 0)
        {
            for(int i = 1; i <= l; i++)
            {
                if(arr[i] == 0)
                    return i;
            }
        }
        else return 1;

        return l + 1;
    }
}
