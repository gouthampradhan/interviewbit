import java.util.ArrayList;

/**
 * Created by gouthamvidyapradhan on 07/06/2017.
 * Accepted
 */
public class MergeTwoSortedListsII
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(1);
        a.add(5);
        a.add(8);
        b.add(6);
        b.add(9);
        new MergeTwoSortedListsII().merge(a, b);
        System.out.println(a);
    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int i =0, j = 0;
        for(int l1 = a.size(), l2 = b.size(); i < l1 && j < l2;) {
            if(a.get(i) < b.get(j)) {
                result.add(a.get(i));
                i++;
            }
            else if(b.get(j) < a.get(i)) {
                result.add(b.get(j));
                j++;
            }
            else {
                result.add(a.get(i));
                result.add(a.get(i));
                i++;
                j++;
            }
        }
        if(i < a.size()) {
            result.addAll(a.subList(i, a.size()));
        }
        if(j < b.size()) {
            result.addAll(b.subList(j, b.size()));
        }
        a.clear();
        a.addAll(result);
    }


}
