package testfantasygame.teamType;

import java.util.List;
import models.Player;
import models.TeamType;

public class Team3Bat1Wc2Al2Bowl extends TeamType {

    public Team3Bat1Wc2Al2Bowl() {
        super.setBatsmanLimit(3);
        super.setWicketkeeperLimit(1);
        super.setAllrounderLimit(2);
        super.setBowlerLimit(2);
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
