import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 27/09/2016.
 */
public class FindDuplicateInArray
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
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);
        System.out.println(repeatedNumber(list));
    }

    public static int repeatedNumber(final List<Integer> a)
    {
        int[] arr = new int[a.size() + 1];
        for (int i : a)
        {
            if(arr[i] == 0)
                arr[i] = i;
            else return i;
        }
        return -1;
    }

}
