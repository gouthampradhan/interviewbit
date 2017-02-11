import java.util.StringTokenizer;

/**
 * Created by gouthamvidyapradhan on 11/02/2017.
 * Accepted
 */
public class ValidNumber
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new ValidNumber().isNumber("3."));
    }

    private int isNumber(final String a)
    {
        String num = a.trim();
        if(num.isEmpty()) return 0;
        if(num.charAt(0) == '+' || num.charAt(0) == '-')
            num = num.substring(1, num.length());
        if(num.isEmpty()) return 0;
        if(num.contains("e-"))
        {
            StringTokenizer st = new StringTokenizer(num, "e-");
            if(st.countTokens() < 2 || st.countTokens() > 2)
                return 0;
            String first = st.nextToken();
            String last = st.nextToken();
            if(last.contains(".")) return 0; //second part cannot contain a decimal point
            boolean fValid = first.contains(".") ? isValidDecimal(first) : isValidNumber(first);
            return (fValid && isValidNumber(last))? 1 : 0;
        }
        else if(num.contains("e"))
        {
            StringTokenizer st = new StringTokenizer(num, "e");
            if(st.countTokens() < 2 || st.countTokens() > 2)
                return 0;
            String first = st.nextToken();
            String last = st.nextToken();
            if(last.contains(".")) return 0; //second part cannot contain a decimal point
            boolean fValid = first.contains(".") ? isValidDecimal(first) : isValidNumber(first);
            return (fValid && isValidNumber(last))? 1 : 0;
        }
        else if(num.contains("."))
        {
            StringTokenizer st = new StringTokenizer(num, ".");
            if(st.countTokens() > 2) return 0; //cannot have more than two decimal points
            if(st.countTokens() == 1)
                if(num.endsWith(".")) return 0;
            while(st.hasMoreTokens())
            {
                if(!isValidNumber(st.nextToken())) return 0;
            }
            return 1;
        }
        else
        {
            return isValidNumber(num) ? 1 : 0;
        }
    }

    private boolean isValidDecimal(String s)
    {
        StringTokenizer st = new StringTokenizer(s, ".");
        if(st.countTokens() > 2) return false; //cant have more than 1 decimal points
        if(st.countTokens() == 1)
            if(s.endsWith(".")) return false;
        while(st.hasMoreTokens())
        {
            if(!isValidNumber(st.nextToken())) return false;
        }
        return true;
    }

    private boolean isValidNumber(String num)
    {
        for(int i = 0, l = num.length(); i < l; i ++)
            if('0' - num.charAt(i) < -9 || '0' - num.charAt(i) > 0)
                return false;
        return true;
    }
}
