import java.util.ArrayList;

/**
 * Created by gouthamvidyapradhan on 04/02/2017.
 * Accepted
 */
public class LongestCommonPrefix
{
    private static ArrayList<String> strArr = new ArrayList<>();

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("asdf");
        list.add(" ");
        //list.add("asdfasdfadsf");
        //list.add("asdfasdfasdf");
        //list.add("geezer");
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(list));
    }


    /**
     * Bruteforce O(N X M)
     * @param A
     * @return
     */
    private String lcp(ArrayList<String> A)
    {
        if(A.size() == 1)
           return A.get(0);
        for(int i = 1, l = A.size(); i < l; i ++)
        {
            String current = A.get(i);
            String prev = A.get(i - 1);
            int sL = (current.length() < prev.length()) ? current.length() : prev.length();
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j < sL; j++)
            {
                if(prev.charAt(j) == current.charAt(j))
                    temp.append(prev.charAt(j));
                else break;
            }
            if(temp.length() == 0)
                return " ";
            A.set(i, temp.toString());
        }
        return A.get(A.size() - 1);

    }

    /**
     * O(M log N)
     * @param A
     * @return
     */
    public String longestCommonPrefix(ArrayList<String> A)
    {
        if(A.size() == 1)
            return A.get(0);
        strArr.clear();
        strArr.addAll(A);
        return partition(0, A.size() - 1);
    }

    /**
     * Partition
     * @param s start index
     * @param e end index
     * @return String
     */
    private String partition(int s, int e)
    {
        if(s == e)
        {
            return strArr.get(s);
        }
        else
        {
            int l = (e - s);
            int m = l / 2;
            String left = partition(s, s + m);
            String right = partition(s + m + 1, e);
            return commonPrefix(left, right);
        }
    }

    /**
     * Longest common prefix
     * @param s1 String one
     * @param s2 String two
     * @return common prefix
     */
    private String commonPrefix(String s1, String s2)
    {
        int sL = (s1.length() < s2.length()) ? s1.length() : s2.length();
        StringBuilder temp = new StringBuilder();
        for(int j = 0; j < sL; j++)
        {
            if(s1.charAt(j) == s2.charAt(j))
                temp.append(s1.charAt(j));
            else break;
        }
        return temp.toString();
    }
}
