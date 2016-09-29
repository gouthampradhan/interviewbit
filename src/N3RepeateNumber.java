package src;

import java.util.*;

/**
 * Created by gouthamvidyapradhan on 27/09/2016.
 */
public class N3RepeateNumber
{
    private static Map<Integer, Integer> map = new HashMap<>();

    /**
     * Main method
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception
    {
        //int[] test = {1000860, 1000860, 1000555, 1000249, 1000860, 1000480, 1000902, 1000740, 1000860, 1000343, 1000253, 1000535, 1000529, 1000540, 1000396, 1000716, 1000860, 1000860, 1000860, 1000991, 1000860, 1000422, 1000600, 1000400, 1000305, 1000860, 1000860, 1000590, 1000509, 1000416, 1000997, 1000860, 1000860, 1000309, 1000567, 1000860, 1000860, 1000860, 1000015, 1000468, 1000860, 1000860, 1000105, 1000860, 1000860, 1000109, 1000066, 1000860, 1000912, 1000598, 1000586, 1000574, 1000801, 1000325, 1000844, 1000633, 1000860, 1000800, 1000958, 1000860, 1000860, 1000649, 1000729, 1000287, 1000949, 1000860, 1000860, 1000860, 1000847, 1000127, 1000860, 1000003, 1000666, 1000969, 1000387, 1000028, 1000860, 1000193, 1000860, 1000812, 1000308, 1000771, 1000350, 1000860, 1000719, 1000048, 1000860, 1000467, 1000194, 1000463, 1000246, 1000930, 1000669, 1000969, 1000860, 1000860, 1000165, 1000280, 1000860, 1000920, 1000166, 1000860, 1000860, 1000577, 1000993, 1000860, 1000834, 1000768, 1000058, 1000144, 1000860, 1000252, 1000860, 1000860, 1000860, 1000395, 1000212, 1000891, 1000314, 1000928, 1000068, 1000230, 1000860, 1000648, 1000044, 1000107, 1000860, 1000188, 1000021, 1000279, 1000915, 1000061, 1000965, 1000860, 1000860, 1000027, 1000860, 1000837, 1000148, 1000605, 1000268, 1000307, 1000860, 1000584, 1000369, 1000433, 1000908, 1000860, 1000293, 1000860, 1000331, 1000860, 1000860, 1000860, 1000860, 1000963, 1000607, 1000395, 1000860, 1000798, 1000501, 1000738, 1000860, 1000645, 1000935, 1000860, 1000860, 1000559, 1000860, 1000860, 1000609, 1000171, 1000471, 1000860, 1000957, 1000471, 1000630, 1000239, 1000591, 1000860, 1000860, 1000554, 1000860, 1000920, 1000915, 1000065, 1000860, 1000739, 1000270, 1000769};
        int[] test = {9,0,1,1,9, 1};
        List<Integer> list = new ArrayList<>();
        for(int i : test)
            list.add(i);

        Map<Integer, Integer> testMap = new HashMap<>();

        for(int i : test)
        {
            if(testMap.containsKey(i))
                testMap.put(i, testMap.get(i) + 1);
            else
                testMap.put(i, 1);
        }
        Iterator<Integer> ite = testMap.keySet().iterator();
        while(ite.hasNext())
        {
            int key = ite.next();
            int value = testMap.get(key);
            if(value > (test.length / 3))
                System.out.println("expected: " + key + " " + value + " size " + test.length);
        }

        System.out.println(repeatedNumber(list));
    }

    public static int repeatedNumber(final List<Integer> a)
    {
        int l = a.size();
        if(l == 0) return -1;
        for(int i = 0; i < l; i ++)
        {
            if(map.containsKey(a.get(i)))
            {
                int count = map.get(a.get(i)) + 1;
                map.put(a.get(i), count);
            }
            else
            {
                if(map.keySet().size() < 2)
                    map.put(a.get(i), 1);
                else
                {
                    Set<Integer> set = map.keySet();
                    int[] k = new int[2];
                    int in = 0;
                    for(int s : set)
                        k[in++] = s;
                    for(int key : k)
                        update(key);
                }
            }
        }

        int hits, result = -1;
        for (int i : map.keySet()) {
            hits = 0;
            for (int e : a) {
                if (e == i)
                    hits++;
            }
            if (hits > (l / 3))
                return i;
        }
        return result;
    }


    private static void update(int key)
    {
        int c1 = map.get(key) - 1;
        if(c1 == 0)
            map.remove(key);
        else map.put(key, c1);
    }

}
