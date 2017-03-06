/**
 * Created by gouthamvidyapradhan on 06/03/2017.
 * Accepted
 */
public class PowerOf2
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new PowerOf2().powerOfTwo("256"));
    }

    private int powerOfTwo(String N)
    {
        if(N.equals("1")) return 0; //this is strange. 2 ^ 0 = 1???

        while(!N.equals("1"))
        {
            if((Integer.parseInt(String.valueOf(N.charAt(N.length() - 1))) % 2) != 0)
                return 0;
            N = divideByTwo(N);
        }
        return 1;
    }

    /**
     * Divide by 2
     * @param d divisor
     * @return quotient
     */
    private String divideByTwo(String d)
    {
        String num = ""; String result = "";
        for(int i = 0, l = d.length(); i < l; i ++)
        {
            num += (('0' - d.charAt(i)) * -1);
            int intVal = Integer.parseInt(num);
            if(intVal >= 2)
            {
                result += (intVal / 2);
                num = String.valueOf(intVal % 2);
            }
            else
            {
                result += 0;
            }
        }
        //remove leading zeros
        for(int i = 0, l = result.length(); i < l; i ++)
        {
            if(result.charAt(i) != '0')
            {
                result = result.substring(i, l);
                return result;
            }
        }
        return "0";
    }
}
