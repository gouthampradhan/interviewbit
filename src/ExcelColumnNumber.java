/**
 * Created by gouthamvidyapradhan on 27/11/2016.
 */
public class ExcelColumnNumber
{
    private static final String CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new ExcelColumnNumber().titleToNumber("AAAAA"));
    }


    private int titleToNumber(String a)
    {
        StringBuilder sb = new StringBuilder(a.trim());
        String _a = sb.reverse().toString();
        int result = 0;
        for(int i = 0, l = a.length(); i < l; i ++)
        {
            char c = _a.charAt(i);
            int pos = CHAR.indexOf(c);
            result += (pos + 1) * (long)(Math.pow(26, i));
        }
        return result;
    }
}
