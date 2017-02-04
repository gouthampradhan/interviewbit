import java.util.StringTokenizer;

/**
 * Created by gouthamvidyapradhan on 04/02/2017.
 * Accepted
 */
public class LengthOfLastWord
{
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("d"));
    }

    public int lengthOfLastWord(final String A)
    {
        if(A.trim().length() == 0) return 0;
        //StringTokenizer st = new StringTokenizer(A, " ");
        char[] charA = A.trim().toCharArray();
        int count = 0;
        for(int i = charA.length - 1; i >= 0; i --)
        {
            if(charA[i] != ' ')
                count++;
            else break;
        }
        return count;
    }
}
