import java.util.*;

/**
 * Created by gouthamvidyapradhan on 18/05/2017.
 * Accepted
 */

public class JustifiedText
{

    public static void main(String[] args)
    {

    }

    public ArrayList<String> fullJustify(ArrayList<String> a, int b)
    {
        if(a.isEmpty()) return new ArrayList<>();
        int wCount = 0, charCount = 0;
        List<String> line = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0, l = a.size(); i < l; i++)
        {
            String next = a.get(i);
            if( (b - (charCount + wCount)) >= next.length())
            {
                line.add(next);
                charCount += next.length();
                wCount++;
            }
            else
            {
                //justify and add to list
                sb.append(line.get(0));
                StringBuilder space = new StringBuilder();
                if(line.size() > 1)
                {
                    int spaceCount = (b - charCount) / (wCount - 1);
                    int remaining = (b - charCount) % (wCount - 1);

                    for(int j = 0; j < spaceCount; j++)
                        space.append(' ');

                    for(int k = 1, kl = line.size(); k < kl; k++)
                    {
                        sb.append(space);
                        if(remaining > 0)
                        {
                            sb.append(' ');
                            --remaining;
                        }
                        sb.append(line.get(k));
                    }
                }
                else
                {
                    int balance = b - (charCount + (wCount - 1));
                    for(int j = 0; j < balance; j ++)
                        sb.append(' ');
                }
                result.add(sb.toString());
                sb = new StringBuilder();
                line.clear();
                line.add(next);
                charCount = next.length();
                wCount = 1;
            }
        }
        if(!line.isEmpty())
        {
            sb.append(line.get(0));
            for(int i = 1, l = line.size(); i < l; i++)
            {
                sb.append(' ');
                sb.append(line.get(i));
            }
        }
        int balance = b - (charCount + (wCount - 1));
        for(int i = 0; i < balance; i ++)
            sb.append(' ');
        result.add(sb.toString());
        return result;
    }
}
