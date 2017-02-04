import java.util.StringTokenizer;

/**
 * Created by gouthamvidyapradhan on 04/02/2017.
 * Accepted
 */
public class ReverseTheString
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new ReverseTheString().reverseWords("the sky is blue"));
    }

    public String reverseWords(String a)
    {
        String reversed = reverse(a.trim());
        char[] charA = reversed.toCharArray();
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean space = false;
        for(int i = 0, l = charA.length; i < l; i ++)
        {
            if(charA[i] != ' ')
            {
                if(space)
                {
                    result.append(reverse(temp.toString()));
                    result.append(' ');
                    temp = new StringBuilder();
                    space = false;
                }
                temp.append(charA[i]);
            }
            else
            {
                space = true;
            }
        }
        result.append(reverse(temp.toString()));
        return result.toString();
    }

    private String reverse(String s)
    {
        char[] charA = s.toCharArray();
        for(int i = 0, j = charA.length - 1; i < j; i ++, j--)
        {
            char temp = charA[j];
            charA[j] = charA[i];
            charA[i] = temp;
        }
        return String.valueOf(charA);
    }
}
