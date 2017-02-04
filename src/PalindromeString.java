import java.util.regex.Pattern;

/**
 * Created by gouthamvidyapradhan on 04/02/2017.
 * Accepted
 */
public class PalindromeString
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new PalindromeString().isPalindrome(""));
    }

    public int isPalindrome(String A)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0, l = A.length(); i < l; i ++)
        {
            String s = String.valueOf(A.charAt(i)).toLowerCase();
            if(Pattern.matches("[a-z0-9]", s))
                sb.append(s);
        }
        A = sb.toString();
        if(A.length() == 1 || A.length() == 0) return 1;
        for(int i = 0, j = A.length() - 1, l = A.length(); i < l; i ++, j--)
        {
            if(j <= i) break;
            if(A.charAt(i) != A.charAt(j))
                return 0;
        }
        return 1;
    }
}
