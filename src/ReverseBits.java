/**
 * Created by gouthamvidyapradhan on 25/01/2017.
 * Accepted
 */
public class ReverseBits
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new ReverseBits().reverseBits(0));
    }

    /**
     * Reverse bits
     * @param n
     * @return
     */
    private long reverseBits(long n)
    {
        long result = 0L, j = 1L;
        for(int i = 31; i >= 0; i --)
        {
            if((n & j) > 0)
                result |= ((long)1 << i);
            j <<= 1;
        }
        return result;
    }
}
