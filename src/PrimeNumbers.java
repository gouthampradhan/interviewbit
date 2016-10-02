import java.util.*;

/**
 * Created by gouthamvidyapradhan on 02/10/2016.
 * Accepted Sieve of Eratosthenes
 */
public class PrimeNumbers
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        List<Integer> result = sieve(15);
        result.forEach(System.out::println);
    }

    /**
     * Generate primes
     * @param a input integer
     * @return
     */
    public static ArrayList<Integer> sieve(int a)
    {
        ArrayList<Integer> result = new ArrayList<>();

        if(a < 2)
            return result;

        boolean[] primes = new boolean[a + 1];

        for(int i = 2; i <= a; i ++)
            primes[i] = true;

        primes[0] = false;
        primes[1] = false;

        int sqRoot = (int)Math.sqrt(a);

        for(int i = 2; i <= sqRoot; i ++)
        {
            if(primes[i])
                for(int j = 2; (j * i ) <= a; j ++)
                    primes[j * i] = false;
        }

        for (int i = 0; i <= a; i++)
        {
            if(primes[i])
                result.add(i);
        }
        return result;
    }
}
