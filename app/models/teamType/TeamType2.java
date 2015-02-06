package models.teamType;

import java.util.List;
import models.Player;
import models.TeamType;

public class TeamType2 extends TeamType {

        public TeamType2() {
            super.setBatsmanLimit(4);
        super.setWicketkeeperLimit(1);
        super.setAllrounderLimit(1);
        super.setBowlerLimit(2);
		System.err.println("Team Type = 4BT 1WC 1AL 2BW");
    }
    
    public boolean isValidAddition(Player p,List<Player> list) {
       return super.isValidAddition(p, list);
    }

    public boolean isValidRemoval(Player p,List<Player> list) {
        return super.isValidRemoval(p, list);
    }
}
