/**
 * Created by gouthamvidyapradhan on 04/02/2017.
 * Accepted
 */
public class CountAndSay
{
    private static final String NUM = "123456789";
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new CountAndSay().countAndSay(50));
    }

    public String countAndSay(int n)
    {
        String result = "1";
        if(n == 1) return result;
        result = "11";
        if(n == 2) return result;
        int count;
        StringBuilder temp = new StringBuilder();
        for(int k = 3; k <= n; k ++)
        {
            int i = 1, j = i - 1;
            count = 1;
            for(int l = result.length(); i < l; i ++, j++)
            {
                if(result.charAt(j) == result.charAt(i))
                    count++;
                else
                {
                    temp.append(count).append(NUM.indexOf(result.charAt(j)) + 1);
                    count = 1;
                }
            }
            temp.append(count).append(NUM.indexOf(result.charAt(j)) + 1);
            result = temp.toString();
            temp = new StringBuilder();
        }
        return result;
    }
}
