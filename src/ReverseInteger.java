/**
 * Created by gouthamvidyapradhan on 26/11/2016.
 * Accepted
 */
public class ReverseInteger
{
    public static void main(String[] args)
    {
        int a = -1146467285;
        //int a = 5827646411;
        System.out.println(new ReverseInteger().reverse(a));
    }

    private int reverse(int a)
    {
        boolean isNeg = (a < 0);
        int reminder = a;
        long result = 0;

        if(isNeg) reminder *= -1;

        while(reminder > 0)
        {
            result = (result * 10) + (reminder % 10);
            reminder = reminder / 10;
        }

        result =  isNeg ? (result * -1) : result;
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;

        return (int)result;
    }

}
