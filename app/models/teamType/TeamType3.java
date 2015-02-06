package models.teamType;

import java.util.List;
import models.Player;
import models.TeamType;

public class TeamType3 extends TeamType {

    public TeamType3() {
        super.setBatsmanLimit(3);
        super.setWicketkeeperLimit(1);
        super.setAllrounderLimit(1);
        super.setBowlerLimit(3);
		System.err.println("Team Type = 3BT 1WC 1AL 3BW");
    }
    
    
    @Override
    public boolean isValidAddition(Player p,List<Player> list) {
       return super.isValidAddition(p, list);
    }

    @Override
    public boolean isValidRemoval(Player p,List<Player> list) {
        return super.isValidRemoval(p, list);
    }
    
}
