/**
 * Created by gouthamvidyapradhan on 02/10/2016.
 * Accepted.
 */
public class PalindromeInteger
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(isPalindrome(11));
    }

    public static boolean isPalindrome(int a)
    {
        if(a < 0) return false;

        String str1 = String.valueOf(a);
        int len = str1.length();

        int i = 0, j = str1.length() - 1;
        do
        {
            if(!(str1.charAt(i++) == str1.charAt(j--)))
                return false;

        } while(i < len && i < j);
        return true;
    }

}
