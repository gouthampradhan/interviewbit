/**
 * Created by gouthamvidyapradhan on 27/11/2016.
 * Accepted
 */
public class ExcelColumnTitle
{
    private static final String CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) throws Exception
    {
        System.out.println(new ExcelColumnTitle().convertToTitle(65251));
    }

    public String convertToTitle(int a)
    {
        int r;
        StringBuilder sb = new StringBuilder("");
        while(a > 0)
        {
            a = a - 1;
            r = a % 26;
            a = a / 26;
            sb.append(CHAR.charAt(r));
        }
        return sb.reverse().toString();
    }

}
