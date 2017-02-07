import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by gouthamvidyapradhan on 07/02/2017.
 * Accepted
 */
public class CompareVersionNumbers
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new CompareVersionNumbers().compareVersion("5.0.1.1.1.0.0.1.1", "5.0.1.1.1.0.0.1"));
    }

    public int compareVersion(String S1, String S2)
    {
        StringTokenizer v1St = new StringTokenizer(S1, ".");
        StringTokenizer v2St = new StringTokenizer(S2, ".");
        int v1Count = v1St.countTokens();
        int v2Count = v2St.countTokens();
        if(v1Count < v2Count)
        {
            for(int i = 0; i < v1Count; i ++)
            {
                BigInteger v1 = new BigInteger(v1St.nextToken());
                BigInteger v2 = new BigInteger(v2St.nextToken());
                if(!v1.equals(v2))
                {
                    return v1.compareTo(v2);
                }
            }
            while(v2St.hasMoreTokens())
            {
                if(! new BigInteger(v2St.nextToken()).equals(BigInteger.ZERO)) return -1;
            }
        }
        else if(v2Count < v1Count)
        {
            for(int i = 0; i < v2Count; i ++)
            {
                BigInteger v1 = new BigInteger(v1St.nextToken());
                BigInteger v2 = new BigInteger(v2St.nextToken());
                if(!v1.equals(v2))
                {
                    return v1.compareTo(v2);
                }
            }
            while(v1St.hasMoreTokens())
            {
                if(! new BigInteger(v1St.nextToken()).equals(BigInteger.ZERO)) return 1;
            }
        }
        else
        {
            for(int i = 0; i < v1Count; i ++)
            {
                BigInteger v1 = new BigInteger(v1St.nextToken());
                BigInteger v2 = new BigInteger(v2St.nextToken());
                if(! v1.equals(v2))
                    return v1.compareTo(v2);
            }
        }
        return 0;
    }
}
