package testfantasygame.teamType;

import java.util.List;
import models.Player;
import models.TeamType;

public class Team4Bat1Wc1Al2Bowl extends TeamType {

        public Team4Bat1Wc1Al2Bowl() {
            super.setBatsmanLimit(4);
        super.setWicketkeeperLimit(1);
        super.setAllrounderLimit(1);
        super.setBowlerLimit(2);
    }
    
    public boolean isValidAddition(Player p,List<Player> list) {
       return super.isValidAddition(p, list);
    }

    public boolean isValidRemoval(Player p,List<Player> list) {
        return super.isValidRemoval(p, list);
    }
}
