import java.util.*;
/**
 * Created by gouthamvidyapradhan on 19/05/2017.
 * Accepted
 */
public class MatrixSearch
{
    public static void main(String[] args) throws Exception
    {
        //new MatrixSearch().searchMatrix()
    }

    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b)
    {
        if(a.size() == 0) return 0;
        int M = a.size();
        int N = a.get(0).size();
        int r = 0, c = N - 1;
        while(r < M && c >= 0)
        {
            if(a.get(r).get(c) == b) return 1;
            else if(b < a.get(r).get(c)) --c;
            else if(b > a.get(r).get(c)) r++;
        }
        return 0;
    }
}
