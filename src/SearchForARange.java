import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 22/05/2017.
 * Accepted
 */
public class SearchForARange
{
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int low = findIndex(a, b, true);
        int high = findIndex(a, b, false);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(low);
        result.add(high);
        return result;
    }

    /**
     * Find index
     * @param nums nums array
     * @param target target
     * @param isLowerIndex true if target is to find lower index, false otherwise
     * @return index
     */
    private int findIndex(List<Integer> nums, int target, boolean isLowerIndex){
        int result = -1;
        int s = 0, e = nums.size() - 1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(nums.get(m) == target) {
                result = m;
                if(isLowerIndex) e = m - 1; //if searching for the lower index then search the lower bound,
                    // else search the upper bound
                else s = m + 1;
            }
            else if(nums.get(m) < target){
                s = m + 1;
            }
            else e = m - 1;
        }
        return result;
    }

}
