import java.util.Arrays;

/**
 * Created by gouthamvidyapradhan on 21/01/2017.
 * Accepted
 */
public class SortedPermutationRank
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        String str = "zyxwvutsrqponmlkjihgfedcba";
        System.out.println(rank(str));
    }

    /**
     * Factorial of a number
     * @param n
     * @return
     */
    private static int factorial(int n)
    {
        if(n == 0) return 1;
        else return ((n * factorial(n - 1)) % 1000003);
    }

    /**
     * Check rank
     * @param a
     * @return
     */
    private static int rank(String a)
    {
        char[] input = a.toCharArray();
        Arrays.sort(input);
        boolean[] index = new boolean[input.length];
        int rank = 0;
        for(int i = 0, l = a.length(); i < l; i ++)
        {
            char c = a.charAt(i);
            int lowerChars = 0;
            for(int j = 0; j < l; j ++)
            {
                if(input[j] != c)
                {
                   if(!index[j])
                       lowerChars++;
                }
                else
                {
                    index[j] = true; //mark this taken
                    break;
                }
            }
            int balance = l - (i + 1);
            rank = (rank + (((((balance == 0) ? 0 : factorial(balance)) * lowerChars)) % 1000003)) % 1000003;
        }
        return (rank + 1) % 1000003;
    }
}
