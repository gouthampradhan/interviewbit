import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 27/08/2016.
 */
public class MinStepsInInfiniteGrid
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> X = new ArrayList<>();
        ArrayList<Integer> Y = new ArrayList<>();
        X.add(-172);
        X.add(-8172);
        X.add(-888);
        X.add(-918);
        X.add(-918);

        Y.add(122);
        Y.add(1212);
        Y.add(1212);
        Y.add(1224);
        Y.add(4345);
        System.out.println(coverPoints(X, Y));
    }

    public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y)
    {
        int l = X.size();
        if(l == 0 || l == 1) return 0;
        int next = 1, distance = 0;
        for(int i = 0; i < l && next < l; i ++)
        {
            int t1 = Math.abs(X.get(i) - X.get(next));
            int t2 = Math.abs(Y.get(i) - Y.get(next));
            if(t1 < t2)
                distance += t1 + (t2 - t1);
            else if(t2 < t1)
                distance += t2 + (t1 - t2);
            else
                distance += t1;
            next++;
        }
        return distance;
    }
}
