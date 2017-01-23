import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 24/01/2017.
 * Accepted
 */
public class RearrangeArray
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(0);
        list.add(1);
        list.add(2);
        arrange(list);
        list.forEach(n -> System.out.print(n + " "));
    }

    public static void arrange(ArrayList<Integer> a)
    {
        int l = a.size();

        for(int i = 0; i < l; i ++)
            a.set(i, a.get(i) + (a.get(a.get(i)) % l) * l);

        for(int i = 0; i < l; i ++)
            a.set(i, (a.get(i) / l));
    }
}
