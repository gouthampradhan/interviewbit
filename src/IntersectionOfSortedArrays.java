import java.util.*;

/**
 * Created by gouthamvidyapradhan on 27/05/2017.
 * Accepted
 */
public class IntersectionOfSortedArrays
{
    public static void main(String[] args) throws Exception
    {
        List<Integer> list1 = Arrays.asList( 1, 5, 7, 8, 9, 10, 10, 14, 16, 16, 17, 19, 20, 20, 20, 20, 21, 23, 26, 27, 29, 30, 30, 30, 31, 32, 33, 33, 34, 35, 35, 36, 37, 39, 39, 41, 42, 43, 43, 44, 44, 45, 46, 46, 47, 49, 51, 52, 53, 55, 55, 56, 57, 58, 59, 60, 65, 66, 66, 68, 68, 69, 69, 70, 70, 70, 71, 73, 75, 75, 75, 79, 80, 80, 81, 82, 85, 87, 91, 92, 98, 98, 98, 99, 100, 101 );
        List<Integer> list2 = Arrays.asList(4, 7, 10, 10, 15, 17, 19, 20, 24, 27, 27, 30, 31, 35, 40, 41, 42, 46, 48, 49, 50, 51, 54, 57, 62, 62, 63, 66, 67, 68, 69, 70, 71, 73, 74, 78, 80, 81, 92, 94, 99, 101);
        System.out.println(new IntersectionOfSortedArrays().intersection(list1, list2));
    }

    private List<Integer> intersection(List<Integer> a, List<Integer> b)
    {
        ArrayList<Integer> intersection = new ArrayList<>();
        for(int i = 0, j = 0, l1 = a.size(), l2 = b.size(); i < l1 && j < l2;)
        {
            if (a.get(i).equals(b.get(j)))
            {
                intersection.add(a.get(i));
                i++; j++;
            }
            else if(a.get(i) < b.get(j))
                i++;
            else j++;
        }
        return intersection;
    }
}
