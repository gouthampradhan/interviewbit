/**
 * Created by gouthamvidyapradhan on 11/02/2017.
 * Accepted
 */
public class AddBinaryStrings
{
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println(new AddBinaryStrings().addBinary("1111110101010101010", "1111010101010101010101010101010101"));
    }

    private String addBinary(String s1, String s2)
    {
        String first, second;
        if(s1.length() >= s2.length())
        {
            first = s1;
            second = s2;
        }
        else
        {
            first = s2;
            second = s1;
        }
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for(int i = first.length() - 1, j = second.length() - 1; i >= 0; i--, j--)
        {
            int one = ('0' - first.charAt(i)) * -1;
            int two = 0;
            if(j >= 0)
            {
                two = ('0' - second.charAt(j)) * -1;
            }
            result.append((one + two + carry) % 2);
            carry = (one + two + carry) / 2;
        }
        if(carry > 0)
            result.append(carry);
        return result.reverse().toString();
    }
}
