import java.util.ArrayList;

/**
 * Created by gouthamvidyapradhan on 22/05/2017.
 * Accepted
 */
public class SortedInsertPosition
{
    public static void main(String[] args) throws Exception
    {

    }

    public int searchInsert(ArrayList<Integer> a, int b)
    {
        int pos = a.size();
        int s = 0, e = a.size() - 1;
        while(s <= e)
        {
            int m = s + (e - s) / 2;
            if(a.get(m) >= b)
            {
                pos = m;
                e = m - 1;
            }
            else s = m + 1;
        }
        return pos;
    }

}
