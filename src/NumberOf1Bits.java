/**
 * Created by gouthamvidyapradhan on 24/01/2017.
 * Accepted
 */
public class NumberOf1Bits
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new NumberOf1Bits().numerOfOneBits(Long.MAX_VALUE));
    }

    private int numerOfOneBits(long n)
    {
        long i = 1L;
        int count = 0;
        for(int j = 0; j < 63; j++)
        {
            if((n & i) > 0)
                count++;
            i <<= 1;
        }
        return count;
    }

}
