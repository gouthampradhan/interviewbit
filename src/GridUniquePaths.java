/**
 * Created by gouthamvidyapradhan on 24/01/2017.
 * Accepted
 */
public class GridUniquePaths
{
    private static int[][] A;
    private static int[] R = {0, 1};
    private static int[] C = {1, 0};
    private static int N, M;
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        N = 100; M = 1;
        System.out.println(new GridUniquePaths().uniquePaths(N, M));
    }

    public int uniquePaths(int a, int b)
    {
        N = a; M = b;
        A = new int[a][b];
        A[a-1][b-1] = 1;
        return dp(0, 0);
    }

    private int dp(int n, int m)
    {
        if(A[n][m] != 0) return A[n][m];
        for(int i = 0; i < 2; i ++)
        {
            int newR = n + R[i];
            int newC = m + C[i];
            if(newR >= N || newC >= M)
                continue;
            A[n][m] += dp(newR, newC);
        }
        return A[n][m];
    }
}
