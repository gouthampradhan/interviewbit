/**
 * Created by gouthamvidyapradhan on 26/11/2016.
 * Accepted
 */
public class PowerOfTwoIntegers
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(new PowerOfTwoIntegers().isPower(1));

    }

    public boolean isPower(int a)
    {
        if(a == 1) return true;
        int sqRt = (int)Math.sqrt(a);
        for(int i = 2; i <= sqRt; i++)
        {
            long result = i;
            while(result < a)
                result *= i;

            if(result == a)
                return true;
        }
        return false;
    }
}
