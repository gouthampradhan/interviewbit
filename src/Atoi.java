/**
 * Created by gouthamvidyapradhan on 11/02/2017.
 * Accepted
 */
public class Atoi
{
    public static void main(String[] args) throws Exception
    {

        System.out.println(new Atoi().atoi("  7"));
        System.out.println(Integer.MAX_VALUE);
    }

    private int atoi(final String a)
    {
        String num = a.trim();
        boolean negative = false;
        int i = 0, temp;
        long result = 0L;
        if(num.charAt(0) == '-')
        {
            negative = true;
            i = 1;
        }
        else if(num.charAt(0) == '+')
        {
            i = 1;
        }
        temp = ('0' - num.charAt(i)) * -1;
        if(temp > 9 || temp < 0) return (int)result;
        result += temp;
        i++;
        for(int l = num.length(); i < l; i ++)
        {
            temp = (('0' - num.charAt(i)) * -1);
            if(temp > 9 || temp < 0)
            {
                return (negative) ? (int)(result * -1) : (int)result;
            }
            result *= 10;
            result += temp;
            if(negative)
            {
                if(result * -1 < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
            else if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return (negative) ? (int)(result * -1) : (int)result;
    }
}
