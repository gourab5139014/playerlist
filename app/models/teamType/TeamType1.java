package models.teamType;

import java.util.List;
import models.Player;
import models.TeamType;

public class TeamType1 extends TeamType {

    public TeamType1() {
        super.setBatsmanLimit(3);
        super.setWicketkeeperLimit(1);
        super.setAllrounderLimit(2);
        super.setBowlerLimit(2);
		System.err.println("Team Type = 3BT 1WC 2AL 2BW");
    }

    @Override
    public boolean isValidAddition(Player p, List<Player> list) {
        return super.isValidAddition(p, list);
    }
    
    @Override
    public boolean isValidRemoval(Player p, List<Player> list) {
       return super.isValidRemoval(p, list);
    }
}
