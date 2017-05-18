/**
 * Created by gouthamvidyapradhan on 18/05/2017.
 * Accepted
 */
public class MinimumCharsStringPalindromic
{
    public static void main(String[] args) {
        System.out.println(new MinimumCharsStringPalindromic().solve("aaabbaaabb"));
    }

    public int solve(String A) {
        if(A == null || A.isEmpty()) return 0;
        int i = 0, j = A.length() - 1, pos = A.length();
        while(i < j) {
            if(A.charAt(i) != A.charAt(j)) {
                if(i == 0) {
                    pos = j;
                    j --;
                }
                else {
                    pos = j + 1;
                    i = 0;
                }
            }
            else {
                i ++;
                j --;
            }
        }
        return A.length() - pos;
    }

}
