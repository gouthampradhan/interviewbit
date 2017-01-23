/**
 * Created by gouthamvidyapradhan on 23/01/2017.
 * Accepted
 */
public class TrailingZerosInFactorial
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(trailingZeros(1000082829));
    }

    private static int trailingZeros(int n)
    {
        int count = 0;
        for(long i = 5L; (n / i) > 0; i*=5)
        {
            count += (n / i);
        }
        return count;
    }
}
