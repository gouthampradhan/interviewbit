import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gouthamvidyapradhan on 26/09/2016.
 * Accepted
 */
public class SetMatrixZeros
{
    private static Set<Integer> row = new HashSet<>();
    private static Set<Integer> col = new HashSet<>();

    /**
     * Main method.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        //Test data
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(0);
        row1.add(0);
        row1.add(0);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(0);
        row2.add(0);
        row2.add(0);

        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(0);
        row3.add(0);
        row3.add(0);

        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add(0);
        row4.add(0);
        row4.add(0);

        ArrayList<Integer> row5 = new ArrayList<>();
        row5.add(0);
        row5.add(0);
        row5.add(0);

        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);
        matrix.add(row4);
        matrix.add(row5);

        setZeroes(matrix);

        for(int i = 0, rl = matrix.size(); i < rl; i++)
        {
            ArrayList<Integer> r = matrix.get(i);
            for(int j = 0, cl = r.size(); j < cl; j++)
            {
                System.out.println(r.get(j) + " ");
            }
            System.out.println();
        }

    }

    /**
     * Set matrix zeros
     * @param a
     */
    public static void setZeroes(ArrayList<ArrayList<Integer>> a)
    {
        for(int i = 0, rl = a.size(); i < rl; i++)
        {
            ArrayList<Integer> r = a.get(i);
            for(int j = 0, cl = r.size(); j < cl; j++)
            {
                if(r.get(j) == 0)
                {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int i = 0, rl = a.size(); i < rl; i++)
        {
            ArrayList<Integer> r = a.get(i);
            for(int j = 0, cl = r.size(); j < cl; j++)
            {
                if(row.contains(i) || col.contains(j))
                    r.set(j, 0);
                else
                    r.set(j, 1);
            }
        }

    }
}
