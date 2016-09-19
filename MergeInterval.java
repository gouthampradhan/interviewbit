package problems.interviewbit;

import java.util.ArrayList;

/**
 * Created by gouthamvidyapradhan on 01/09/2016.
 */
public class MergeInterval
{
    static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) throws Exception
    {
        Interval i = new Interval();
        i.start = 16;
        i.end = 18;

        ArrayList<Interval> list = new ArrayList<>();
        Interval i1 = new Interval();
        i1.start = 1;
        i1.end = 2;

        Interval i2 = new Interval();
        i2.start = 3;
        i2.end = 5;

        Interval i3 = new Interval();
        i3.start = 6;
        i3.end = 7;

        Interval i4 = new Interval();
        i4.start = 8;
        i4.end = 10;

        Interval i5 = new Interval();
        i5.start = 12;
        i5.end = 16;

        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        list.add(i5);

        ArrayList<Interval> result = insert(list, i);
        for (Interval in : result)
        {
            System.out.println(in.start + " " + in.end);
        }
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval)
    {
        Interval merged = null;
        ArrayList<Interval> result = new ArrayList<>();
        if(intervals.isEmpty())
        {
            result.add(newInterval);
            return result;
        }
        for (Interval i : intervals)
        {
            if((newInterval != null) && ((newInterval.start >= i.start && newInterval.start <= i.end)
                    || (i.start >= newInterval.start && i.start <= newInterval.end)))
            {
                Interval m1 = new Interval();
                m1.start = (i.start < newInterval.start) ? i.start : newInterval.start;
                m1.end = (i.end > newInterval.end) ? i.end : newInterval.end;
                merged = m1;
                newInterval = null;
            }
            else if((merged != null) && (i.start >= merged.start && i.start <= merged.end))
            {
                Interval m1 = new Interval();
                m1.start = merged.start;
                m1.end = (merged.end > i.end) ? merged.end : i.end;
                merged = m1;
            }
            else
            {
                if(merged != null)
                {
                    result.add(merged);
                    merged = null;
                }
                result.add(i);
            }
        }
        if(merged != null)
            result.add(merged);

        //Interval first = intervals.get(0);
        //Interval last = intervals.get(intervals.size() - 1);
        boolean done = false;
        if(newInterval != null)
        {
            for (int i = 0, l = intervals.size(); i < l; i++)
            {
                Interval e = intervals.get(i);
                if(newInterval.start <= e.start && newInterval.end <= e.start)
                {
                    result.add(i, newInterval);
                    done = true;
                    break;
                }
            }
            if(!done)
                result.add(newInterval);
        }
        return result;
    }


}
