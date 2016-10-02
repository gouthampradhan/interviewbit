/**
 * Created by gouthamvidyapradhan on 02/10/2016.
 * Accepted
 */
public class VerifyPrime
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(isPrime(49));
    }

    /**
     * Check if the element is prime
     * @param a input element
     * @return integer
     */
    public static int isPrime(int a)
    {
        if(a == 1 || a == 0)
            return 0;

        int sqRoot = (int)Math.sqrt(a);

        for(int i = 2; i <= sqRoot; i++)
        {
            if((a % i) == 0)
                return 0;
        }

        return 1;
    }

}
