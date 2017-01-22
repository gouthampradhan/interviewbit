import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by gouthamvidyapradhan on 01/09/2016.
 * Accepted
 */
public class MergeOverlappingIntervals
{
    static class Interval
    {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) throws Exception
    {
        ArrayList<Interval> test = new ArrayList<>();
        test.add(new Interval(-1, 1));
        test.add(new Interval(3, 4));
        test.add(new Interval(2, 4));
        test.add(new Interval(0, 3));
        test.add(new Interval(5, 7));
        test.add(new Interval(7, 8));
        test.add(new Interval(8, 11));
        test.add(new Interval(9, 11));
        test.add(new Interval(16, 17));
        test.add(new Interval(13, 15));
        test.add(new Interval(12, 16));
        test.add(new Interval(12, 14));
        test.add(new Interval(888, 982));
        test.add(new Interval(-888, 888));
        test.add(new Interval(888, 982));
        test.add(new Interval(889, 982));
        test.add(new Interval(982, 982));
        test.add(new Interval(889, 981));
        test.add(new Interval(889, 983));

        ArrayList<Interval> result = merge(test);
        for(Interval i : result)
            System.out.println(i.start + " " + i.end);
    }

    private static ArrayList<Interval> merge(ArrayList<Interval> intervals)
    {
        Collections.sort(intervals, (o1, o2) -> Integer.compare(o1.start, o2.start));

        ArrayList<Interval> result = new ArrayList<>();

        int low = intervals.get(0).start;
        int high = intervals.get(0).end;
        for(int i = 1, l = intervals.size(); i < l; i++)
        {
            Interval in = intervals.get(i);
            if(in.start >= low && in.start <= high && in.end > high)
                high = in.end;
            else if(in.start > high)
            {
                result.add(new Interval(low, high));
                low = in.start;
                high = in.end;
            }
        }
        result.add(new Interval(low, high));
        return result;
    }
}
