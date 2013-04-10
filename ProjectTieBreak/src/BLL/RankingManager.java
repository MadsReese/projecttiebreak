package BLL;

import BE.Match;
import BE.Member;
import java.util.List;

/**
 *
 * @author boinq
 */
public class RankingManager 
{
    private static final int WIN_POINTS = 3, LOSS_POINTS = 0, DRAW_POINTS = 1;
    
    public static Member[] rankMembers(List<Member> members, List<Match> matches)
    {
        // Initialize an array for holding the ranked members.
        Member[] ranked = new Member[members.size()];
        // Now put the members in, and shift them around based on the ranking rules;
        boolean done = false;
        int index = 0;
        while (!done)
        {
            for (Member t : members)
            {
                if (ranked[index] == null)
                {
                    ranked[index] = t;
                }
                else
                {
                    ranked[index] = compareMembers(ranked[index], t, matches);
                }
            }
            members.remove(ranked[index++]);
            done = members.isEmpty();
        }
        return ranked;
    }

}
