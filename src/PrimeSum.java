import java.util.*;

/**
 * Created by gouthamvidyapradhan on 02/10/2016.
 * Accepted
 */
public class PrimeSum
{
    private static Set<Integer> set = new TreeSet<>(); //maintain a sorted set
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) throws Exception
    {
        List<Integer> result = primesum(16777214);
        result.forEach(System.out::println);
    }

    /**
     * Calculate sum of primes (Goldbach’s conjecture)
     * @param a integer
     * @return pair
     */
    public static ArrayList<Integer> primesum(int a)
    {
        ArrayList<Integer> result = new ArrayList<>();

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
                set.add(i);
        }

        for(int ele : set)
        {
            if (set.contains(a - ele))
            {
                result.add(ele);
                result.add(a - ele);
                break;
            }
        }
        return result;
    }

}
