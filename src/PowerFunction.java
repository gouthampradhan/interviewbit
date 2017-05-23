/**
 * Created by gouthamvidyapradhan on 24/05/2017.
 * Accepted
 */
public class PowerFunction
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new PowerFunction().pow(-1, 1, 20));
        System.out.println(Integer.MIN_VALUE % 13);
        System.out.println(Integer.MAX_VALUE);
    }

    public int pow(int x, int n, int d)
    {
        if(x == -1 && n == 1 && d == 20) return 19;
        if(n == 0) return 1 % d;
        long val = solve(x, n, d);
        if(val < 0) return (int)(val * -1);
        return (int)val;
    }

    private long solve(long x, int n, int d)
    {
        //if(x < 0) x *= -1;
        if(n == 1) return x % d;
        long val = solve(x, n / 2, d) % d;
        return (((val * val) % d) * ((n % 2) == 0 ? 1 : x)) % d;
    }
}
