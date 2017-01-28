import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by gouthamvidyapradhan on 28/01/2017.
 * Accepted
 */
public class DifferentBitsSumPairwise
{
    private static int[] sum0 = new int[32];
    private static int[] sum1 = new int[32];
    private static final int CONST = 1000000007;
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(47);
        list.add(60);
        list.add(23);
        list.add(88);
        list.add(5);
        System.out.println(new DifferentBitsSumPairwise().cntBits(list));
    }

    private int cntBits(ArrayList<Integer> A)
    {
        int n = A.size();
        long result = 0L;
        for(int j = 0; j < 32; j ++)
        {
            long count = 0L;
            for(int i : A)
            {
                if((i & (1 << j)) > 0)
                    count++;
            }
            count = (count * (n - count)) % CONST;
            result = (result + count) % CONST;
        }
        return (int)((result * 2) % CONST);
    }
}
