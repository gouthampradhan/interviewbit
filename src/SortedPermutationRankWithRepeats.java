import java.math.BigInteger;
import java.util.*;

/**
 * Created by gouthamvidyapradhan on 21/01/2017.
 * Accepted
 *
 * Algorithm
 * (Nr of terms < current index) * factorial(String length - current Index)
 * divided by /
 * factorial (count of repeated terms including the current one)
 *
 * example:
 * B            A       N        A        N       A
 * 3 x 5!
 * -------   + 0 +  2 x 3!            1 x 1!
 *                  ------- +  0 +    ------  + 0
 * 3!x2!x1!         2! x 2!           1! x 1!

 Ans = 34 + 1 = 35
 */
public class SortedPermutationRankWithRepeats
{
    private static Map<Character, Integer> charCount = new HashMap<>();
    private static int[] factArr;
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println(findRank("asdfasdfasdf"));
    }

    /**
     * Factorial of a number
     * @param n
     * @return
     */
    private static int factorial(int n)
    {
        if(n == 0) factArr[0] = 1;
        else factArr[n] = ((n * factorial(n - 1)) % 1000003);
        return factArr[n];
    }

    /**
     * Find permutation rank
     * @param a
     * @return
     */
    private static int findRank(String a)
    {
        factArr = new int[a.length() + 1];

        factorial(a.length());

        for(int i = 0, l = a.length(); i < l; i ++)
        {
            if(charCount.containsKey(a.charAt(i)))
                charCount.put(a.charAt(i), charCount.get(a.charAt(i)) + 1);
            else
                charCount.put(a.charAt(i), 1);
        }

        List<Character> sorted = new ArrayList<>();
        sorted.addAll(charCount.keySet());
        Collections.sort(sorted);

        int prefixCount, rank = 1;
        long fact;

        for(int i = 0, l = a.length(); i < l; i ++)
        {
            prefixCount = 0; fact = 1L;
            char currChar = a.charAt(i);
            for(char c : sorted)
            {
                if(c != currChar)
                    prefixCount += charCount.get(c);
                else
                {
                    for(char c1 : sorted)
                        fact = ((fact * factArr[charCount.get(c1)]) %  1000003);
                    charCount.put(c, charCount.get(c) - 1);
                    break;
                }
            }
            int postfixCount = l - (i + 1);
            BigInteger modulus = new BigInteger("1000003");
            BigInteger exponent = new BigInteger("1000001");
            BigInteger factBigIn = new BigInteger(String.valueOf(fact));
            int modExpVal = factBigIn.modPow(exponent, modulus).intValue();
            rank = (int)((rank + (modExpVal * ((long)(prefixCount * factArr[postfixCount]) % 1000003) % 1000003)) % 1000003);
        }
        return rank;
    }
}
