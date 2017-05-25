import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 25/05/2017.
 * Accepted
 */
public class RotatedSortedArraySearch
{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(new RotatedSortedArraySearch().search(list, 5));
    }
    public int search(final List<Integer> a, int b)
    {
        if(a.size() == 0) return -1;
        if(a.size() == 1)
        {
            return (a.get(0) == b) ? 0 : -1;
        }
        int low = 0, high = a.size() - 1;
        while(low < high)
        {
            int mid = (low + high) / 2;
            if(a.get(mid) == b)
                return mid;
            if((a.get(mid) <= a.get(low)) && (b > a.get(mid) && b <= a.get(high)) ||
                    (a.get(low) <= a.get(mid) && (b < a.get(low) || b > a.get(mid))))
                low = mid + 1;
            else high = mid - 1;
        }
        return (a.get(low) == b) ? low : -1;
    }
}
