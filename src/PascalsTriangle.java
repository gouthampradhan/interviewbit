import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 28/08/2016.
 */
public class PascalsTriangle
{
    public static void main(String[] args) throws Exception
    {
        List<Integer> result = getRow(10);
        for (int i : result)
            System.out.print(i + " ");
    }


    public static ArrayList<Integer> getRow(int a)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int[][] M = new int[a + 1][a + 1];
        if(a == 0)
        {
            result.add(1);
        }
        else if(a == 1)
        {
            result.add(1);
            result.add(1);
        }
        else
        {
            M[0][0] = 1;
            M[1][0] = 1;
            M[1][1] = 1;

            for(int k = 2; k <= a; k ++)
            {
                M[k][0] = 1;
                M[k][k] = 1;
                for(int i = 1; i < k; i++)
                {
                    M[k][i] = M[k - 1][i - 1] + M[k - 1][i];
                }
            }
            for(int i = 0; i <= a; i++)
                result.add(M[a][i]);
        }
        return result;
    }

}
