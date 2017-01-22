/**
 * Created by gouthamvidyapradhan on 29/11/2016.
 * Accepted
 */
public class GreatestCommonDivisor
{
    public static void main(String[] args)
    {
        System.out.println(new GreatestCommonDivisor().gcd(6, 9));
    }

    private int gcd(int a , int b)
    {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
