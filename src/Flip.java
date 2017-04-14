import java.util.ArrayList;

/**
 * Created by gouthamvidyapradhan on 27/08/2016.
 * Accepted
 */
public class Flip
{
    public static void main(String[] args) throws Exception
    {
        //ArrayList<Integer> result = flip("111010011101011101100011101111100000000101101010010101010000101110101111010011101011101100011101111100000000101101010010101010000101110101111010011101011101100011101111100000000101101010010101010000101110101111010011101011101100011101111100000000101101010010101010000101110101111010011101011101100011101111100000000101101010010101010000101110101");
        ArrayList<Integer> result = flip("0111");
        for(int i : result)
            System.out.println(i);
    }

    public static ArrayList<Integer> flip(String A)
    {
        A = A.trim();
        int count = 0;
        int max = Integer.MIN_VALUE;
        int index = 0, tempSIndex = 0, finalSIndex = 0;
        for(int i = 0; i < A.length(); i ++)
        {
            if(A.charAt(i) == '0')
            {
                if(count < 0)
                {
                    tempSIndex = i;
                    count = 1;
                }
                else count++;
                if(count > max)
                {
                    max = count;
                    index = i;
                    finalSIndex = tempSIndex;
                }
            }
            else
            {
                count--;
            }
        }
        if(max == Integer.MIN_VALUE)
            return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(finalSIndex + 1);
        result.add(index + 1);
        return result;
    }
}
