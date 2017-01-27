/**
 * Created by gouthamvidyapradhan on 27/01/2017.
 * Accepted. Caution with integer overflow
 */
public class DivideIntegers
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new DivideIntegers().divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor)
    {
        long x = dividend, y = divisor;
        int xSin = (x < 0) ? -1 : 1;
        int ySin = (y < 0) ? -1 : 1;
        if(x < 0) x *= -1;
        if(y < 0) y *= -1;
        long result = 0L;
        int power = 32;
        long yPow = (y << 32);
        while(x >= y)
        {
            while(yPow > x)
            {
                yPow >>= 1;
                power--;
            }
            result += (1L << power); //important to consider long value 1L
            x -= yPow;
        }
        if((xSin == -1 && ySin != -1) || (ySin == -1 && xSin != -1))
            result = result * -1;
        return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? Integer.MAX_VALUE : (int)result;
    }
}
