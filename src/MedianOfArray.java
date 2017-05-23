import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 23/05/2017.
 * Accepted
 */
public class MedianOfArray
{
    public static void main(String[] args) throws Exception
    {
    }

    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b)
    {
        if(a.size() > b.size())
            return findMedianSortedArrays(b, a); //ensure always a is the shortest array
        int T = a.size() + b.size(), low = -1, high = -1;
        int median = (T - 1) / 2;
        boolean isOdd = false;
        if((T % 2) != 0)
            isOdd = true;

        int s = 0, e = a.size() - 1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if((median - m - 1) < 0 || a.get(m) >= b.get(median - m - 1)) {
                e = m - 1;
                low = m;
                high = median - m;
            }
            else s = m + 1;
        }

        if(low == -1) {
            if(isOdd) return b.get(median - a.size());
            else return (double)(b.get(median - a.size()) + b.get(median - a.size() + 1)) / 2.0D;
        }
        else {
            if(isOdd) return a.get(low) < b.get(high) ?  a.get(low) : b.get(high);
            else {
                //Always sorts maximum of 4 elements hence works in O(1)
                List<Integer> list = new ArrayList<>();
                list.add(a.get(low));
                if(low + 1 < a.size())
                    list.add(a.get(low + 1));
                list.add(b.get(high));
                if(high + 1 < b.size())
                    list.add(b.get(high + 1));
                Collections.sort(list);
                return (double)(list.get(0) + list.get(1)) / 2.0;
            }
        }
    }

}
