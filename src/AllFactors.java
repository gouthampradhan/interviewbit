import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 02/10/2016.
 * Accepted
 */
public class AllFactors
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        List<Integer> list = allFactors(8);
        for(int a : list)
            System.out.println(a + " ");
    }

    /**
     * Generate all factors
     * @param a
     * @return
     */
    public static ArrayList<Integer> allFactors(int a)
    {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if(a == 1 || a == 0)
        {
            result.add(a);
            return result;
        }

        int sqRoot = (int)Math.sqrt(a);
        left.add(1);
        right.add(a);
        for(int i = 2; i <= sqRoot; i++)
        {
            if((a % i) == 0)
            {
                if(i == (a / i))
                    left.add(i);
                else
                {
                    left.add(i);
                    right.add(a / i);
                }
            }
        }
        //merge
        result.addAll(left);

        for(int i = right.size() - 1; i >= 0; i--)
            result.add(right.get(i));

        return result;
    }

}
