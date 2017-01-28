import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 28/01/2017.
 * Accepted
 */
public class SingleNumber
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
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(8);
        list.add(8);
        list.add(100);
        System.out.println(new SingleNumber().singleNumber(list));
    }

    private int singleNumber(ArrayList<Integer> A)
    {
        int number = 0;
        for(int i : A)
            number = number ^ i;
        return number;
    }
}
