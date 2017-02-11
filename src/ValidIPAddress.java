import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by gouthamvidyapradhan on 11/02/2017.
 * Accepted
 */
public class ValidIPAddress
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> result = new ValidIPAddress().restoreIpAddresses("10233");
        result.forEach(System.out::println);
    }

    private ArrayList<String> restoreIpAddresses(String s)
    {
        int l = s.length();
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < 3 && i < l - 3; i ++)
        {
            String one = s.substring(0, i + 1);
            if(one.length() > 1 && one.startsWith("0"))
                continue;
            for(int j = i + 1; j < (j + 3) && j < l - 2 && (j - i <= 3); j ++)
            {
                String two = s.substring(i + 1, j + 1);
                if(two.length() > 1 && two.startsWith("0"))
                    continue;
                for(int k = j + 1; k < (k + 3) && (k < l - 1) && (k - j <= 3); k ++)
                {
                    String three = s.substring(j + 1, k + 1);
                    if(three.length() > 1 && three.startsWith("0"))
                        continue;
                    String four = s.substring(k + 1, l);
                    if(four.length() > 1 && four.startsWith("0"))
                        continue;
                    int I = Integer.parseInt(one);
                    int II = Integer.parseInt(two);
                    int III = Integer.parseInt(three);
                    int IV = Integer.parseInt(four);
                    if(I >= 0 && I <= 255 && II >= 0 && II <= 255 && III >= 0 && III <= 255 && IV >= 0 && IV <= 255)
                    {
                        StringBuilder sb = new StringBuilder();
                        result.add(sb.append(I).append(".").append(II).append(".").append(III).append(".").append(IV).toString());
                    }
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
