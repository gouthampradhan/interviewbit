package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 31/08/2016.
 */
public class HotelBookingsPossible
{
    static class Hotel
    {
        int date;
        boolean isArrive;
        Hotel(int date, boolean isArrive)
        {
            this.date = date;
            this.isArrive = isArrive;
        }
    }

    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> arrive = new ArrayList<>();
        ArrayList<Integer> depart = new ArrayList<>();
        /*arrive.add(9);
        arrive.add(47);
        arrive.add(17);
        arrive.add(39);
        arrive.add(35);
        arrive.add(35);
        arrive.add(20);
        arrive.add(18);
        arrive.add(15);
        arrive.add(34);
        arrive.add(11);
        arrive.add(2);
        arrive.add(45);
        arrive.add(46);
        arrive.add(15);
        arrive.add(33);
        arrive.add(47);
        arrive.add(47);
        arrive.add(10);
        arrive.add(11);
        arrive.add(27);

        depart.add(32);
        depart.add(82);
        depart.add(39);
        depart.add(86);
        depart.add(81);
        depart.add(58);
        depart.add(64);
        depart.add(53);
        depart.add(40);
        depart.add(76);
        depart.add(40);
        depart.add(46);
        depart.add(63);
        depart.add(88);
        depart.add(56);
        depart.add(52);
        depart.add(50);
        depart.add(72);
        depart.add(22);
        depart.add(19);
        depart.add(38);
*/
        arrive.add(1);
        arrive.add(2);
        arrive.add(3);
        arrive.add(4);

        depart.add(2);
        depart.add(3);
        depart.add(4);
        depart.add(5);

        boolean status = hotel(arrive, depart, 0);
        System.out.println(status);
    }


    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K)
    {
        int l = arrive.size(), ol = 0;
        List<Hotel> list = new ArrayList<>();

        for (int i : arrive)
            list.add(new Hotel(i, true));

        for (int i : depart)
            list.add(new Hotel(i, false));

        Collections.sort(list, (o1, o2) ->
        {
            if(o1.date == o2.date)
            {
                if(!o1.isArrive)
                    return -1;
                else return 1;
            }
            return Integer.compare(o1.date, o2.date);
        });

        for (Hotel h : list)
        {
            if(h.isArrive)
                ol++;
            else
                ol--;
            if(ol > K)
                return false;
        }

        return true;
    }
}
