/**
 * Created by gouthamvidyapradhan on 29/11/2016.
 * Accepted
 */
public class LargestCoprimeDivisor
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new LargestCoprimeDivisor().cpFact(30, 12));
    }

    private int cpFact(int A, int B)
    {
        int sqRoot = (int)Math.sqrt(A);
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= sqRoot; i ++)
        {
            if(A % i == 0)
            {
                int q = A / i;
                if(gcd(q, B) == 1)
                {
                    max = Math.max(max, q);
                }
                if(gcd(i, B) == 1)
                {
                    max = Math.max(max, i);
                }
            }
        }
        return max;
    }

    private int gcd(int a , int b)
    {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
