import java.util.Arrays;

/**
 * Created by gouthamvidyapradhan on 06/02/2017.
 * Accepted
 */
public class StrStr
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new StrStr().strStr("AABAACAADAABAABA", "B"));
    }

    /**
     * KMP algorithm
     * @param T
     * @param P
     * @return
     */
    public int strStr(final String T, final String P)
    {
        if(T == null || T.isEmpty() || P == null || P.isEmpty()) return -1;

        int[] A = new int[P.length()];
        Arrays.fill(A, 0);
        //pre-process
        for(int j = 0, i = 1, l = P.length(); i < l; )
        {
            if(P.charAt(i) == P.charAt(j))
            {
                A[i] = A[j] + 1;
                i++; j++;
            }
            else
            {
                if(j == 0) i++;
                else j = A[j - 1];
            }
        }

        //j : text ; i : pattern
        for(int j = 0, i = 0, jL = T.length(), iL = P.length(); j < jL; )
        {
            if(T.charAt(j) == P.charAt(i))
            {
                if(i == iL - 1)
                {
                    //result.add(j - i);
                    return (j - i);
                    //i = A[i - 1]; //slight variant of this problem in case if we want to return multiple occurrence.
                }
                else
                {
                    i++; j++;
                }
            }
            else
            {
               if(i == 0) j++;
               else i = A[i - 1];
            }
        }
        return -1;
    }
}
