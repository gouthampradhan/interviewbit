import java.util.HashMap;
import java.util.Map;

/**
 * Created by gouthamvidyapradhan on 13/02/2017.
 * Accepted
 */
public class RomanToInteger
{
    private static Map<Character, Integer> ROMAN = new HashMap<>();

    static
    {
        ROMAN.put('I', 1);
        ROMAN.put('V', 5);
        ROMAN.put('X', 10);
        ROMAN.put('L', 50);
        ROMAN.put('C', 100);
        ROMAN.put('D', 500);
        ROMAN.put('M', 1000);
    }
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new RomanToInteger().romanToInt("MMCDLXXV"));
    }

    private int romanToInt(String a)
    {
        int result = 0; int prev;
        StringBuilder sb = new StringBuilder(a);
        String s = sb.reverse().toString();
        prev = ROMAN.get(s.charAt(0));
        for(int i = 0, l = s.length(); i < l; i ++)
        {
            int curr = ROMAN.get(s.charAt(i));
            if(curr >= prev)
                result += curr;
            else result -= curr;
            prev = curr;
        }
        return result;
    }
}
