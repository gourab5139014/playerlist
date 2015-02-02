package testfantasygame.teamType;

import java.util.List;
import models.Player;
import models.TeamType;

public class Team3Bat1Wc1Al3Bowl extends TeamType {

    public Team3Bat1Wc1Al3Bowl() {
        super.setBatsmanLimit(3);
        super.setWicketkeeperLimit(1);
        super.setAllrounderLimit(1);
        super.setBowlerLimit(3);
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
