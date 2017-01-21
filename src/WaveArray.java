import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by gouthamvidyapradhan on 31/08/2016.
 */
public class WaveArray
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(100);
        ArrayList<Integer> result = wave(list);
        for (int i : result)
            System.out.print(i + " ");
    }


    public static ArrayList<Integer> wave(ArrayList<Integer> a)
    {
        int l = a.size(), curr, next;
        Collections.sort(a);
        for(int i = 0, j = 1; j < l; i += 2, j += 2)
        {
            curr = a.get(i);
            next = a.get(j);
            if(curr < next)
            {
                a.set(j, curr);
                a.set(i, next);
            }
        }
        return a;
    }

}
