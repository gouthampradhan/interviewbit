import java.util.ArrayList;

/**
 * Created by gouthamvidyapradhan on 28/01/2017.
 * Accepted
 */
public class SingleNumberII
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(1);
        list.add(12);
        list.add(3);
        list.add(12);
        list.add(1);
        list.add(1);
        list.add(1212);
        list.add(3);
        list.add(3);
        System.out.println(new SingleNumberII().singleNumber(list));
    }

    private int singleNumber(ArrayList<Integer> A)
    {
        int result = 0;
        for(int j = 0; j < 32; j ++)
        {
            int count = 0;
            for(int i : A)
                count  += ((i & (1 << j)) > 0 ? 1 : 0);
            count %= 3;
            result  |= (count << j);
        }
        return result;
    }
}
