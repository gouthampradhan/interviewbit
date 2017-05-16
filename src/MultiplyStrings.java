/**
 * Created by gouthamvidyapradhan on 16/02/2017.
 * Accepted
 */
public class MultiplyStrings
{
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) throws Exception
    {
            System.out.println(new MultiplyStrings().multiply("99999","99999"));
    }

    private String multiply(String num1, String num2)
    {
        if(num1 == null || num2 == null) return "0";
        int A[][] = new int[num1.length()][num2.length() + 1];
        //123x234
        int k = 0;
        for(int i = num1.length() - 1; i >= 0; i --)
        {
            int m1 = ('0' - num1.charAt(i)) * -1;
            int carry = 0;
            int l = num2.length();
            for(int j = num2.length() - 1; j >= 0; j --)
            {
                int p = ((('0' - num2.charAt(j)) * -1) * m1) + carry;
                int r = p % 10;
                A[k][l--] = r;
                carry = p / 10;
            }
            A[k][l] = carry;
            k++;
        }

        int carry = 0;
        StringBuilder result = new StringBuilder();
        for(int x = num2.length(); x >= 0; x--)
        {
            int sum = 0;
            for(int i = 0, j = x, l1 = num1.length() - 1, l2 = num2.length(); i <= l1 && j <= l2; i++, j++)
                sum += A[i][j];
            result.append((sum + carry) % 10);
            carry = (sum + carry) / 10;
        }
        for(int x = 1, l = num1.length(); x < l; x++)
        {
            int sum = 0;
            for(int i = x, j = 0, l1 = num1.length() - 1, l2 = num2.length(); i <= l1 && j <= l2; i++, j++)
                sum += A[i][j];
            result.append((sum + carry) % 10);
            carry = (sum + carry) / 10;
        }
        result.append(carry);
        String product = result.reverse().toString();
        for(int i = 0, l = product.length(); i < l; i ++)
        {
            if(product.charAt(i) != '0')
                return product.substring(i, l);
        }
        return "0";
    }
}
