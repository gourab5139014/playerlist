package models;

import java.util.List;
import models.playerTypes.AllrounderPlayer;
import models.playerTypes.BatsmanPlayer;
import models.playerTypes.BowlerPlayer;
import models.playerTypes.WicketkeeperPlayer;
import models.Player;
import models.PlayerList;

public abstract class TeamType {

    int batsmanLimit = 0;
    int wicketkeeperLimit = 0;
    int allrounderLimit = 0;
    int bowlerLimit = 0;
	
    public boolean isValidAddition(Player p, List<Player> list) {
        int batsmanCount = 0;
        int wicketkeeperCount = 0;
        int allrounderCount = 0;
        int bowlerCount = 0;
        //Traverse list to get current count
        for (Player pl : list) {
            if (pl instanceof BatsmanPlayer) {
                batsmanCount++;
            } else if (pl instanceof BowlerPlayer) {
                bowlerCount++;
            } else if (pl instanceof WicketkeeperPlayer) {
                wicketkeeperCount++;
            } else if (pl instanceof AllrounderPlayer) {
                allrounderCount++;
            }
        }

        //add Player p to corresponding count
        if (p instanceof BatsmanPlayer) {
            batsmanCount++;
        } else if (p instanceof BowlerPlayer) {
            bowlerCount++;
        } else if (p instanceof WicketkeeperPlayer) {
            wicketkeeperCount++;
        } else if (p instanceof AllrounderPlayer) {
            allrounderCount++;
        }
        //Check validity
        boolean batsmanDecision = batsmanCount >= 0 && batsmanCount <= getBatsmanLimit();
        boolean bowlerDecision = bowlerCount >= 0 && bowlerCount <= getBowlerLimit();
        boolean wicketkeeperDecision = wicketkeeperCount >= 0 && wicketkeeperCount <= getWicketkeeperLimit();
        boolean allrounderDecision = allrounderCount >= 0 && allrounderCount <= getAllrounderLimit();
        //return (batsmanCount <= getBatsmanLimit() && bowlerCount <= getBowlerLimit() && wicketkeeperCount <= getWicketkeeperLimit() && allrounderCount <= getAllrounderLimit());
		if(batsmanDecision && bowlerDecision && wicketkeeperDecision && allrounderDecision) System.err.println("Addition valid");
		else System.err.println("Addition NOT valid");
        return (batsmanDecision && bowlerDecision && wicketkeeperDecision && allrounderDecision);

    }

    public boolean isValidRemoval(Player p, List<Player> list){
                int batsmanCount = 0;
        int wicketkeeperCount = 0;
        int allrounderCount = 0;
        int bowlerCount = 0;
        //Traverse list to get current count
        for (Player pl : list) {
            if (pl instanceof BatsmanPlayer) {
                batsmanCount++;
            } else if (pl instanceof BowlerPlayer) {
                bowlerCount++;
            } else if (pl instanceof WicketkeeperPlayer) {
                wicketkeeperCount++;
            } else if (pl instanceof AllrounderPlayer) {
                allrounderCount++;
            }
        }

        //add Player p to corresponding count
        if (p instanceof BatsmanPlayer) {
            batsmanCount--;
        } else if (p instanceof BowlerPlayer) {
            bowlerCount--;
        } else if (p instanceof WicketkeeperPlayer) {
            wicketkeeperCount--;
        } else if (p instanceof AllrounderPlayer) {
            allrounderCount--;
        }
        //Check validity
        boolean batsmanDecision = batsmanCount >= 0 && batsmanCount <= getBatsmanLimit();
        boolean bowlerDecision = bowlerCount >= 0 && bowlerCount <= getBowlerLimit();
        boolean wicketkeeperDecision = wicketkeeperCount >= 0 && wicketkeeperCount <= getWicketkeeperLimit();
        boolean allrounderDecision = allrounderCount >= 0 && allrounderCount <= getAllrounderLimit();
		if(batsmanDecision && bowlerDecision && wicketkeeperDecision && allrounderDecision) System.err.println("Removal valid");
		else System.err.println("Removal NOT valid");
        return (batsmanDecision && bowlerDecision && wicketkeeperDecision && allrounderDecision);
    }

    public int getBatsmanLimit() {
        return batsmanLimit;
    }

    public int getWicketkeeperLimit() {
        return wicketkeeperLimit;
    }

    public int getAllrounderLimit() {
        return allrounderLimit;
    }

    public int getBowlerLimit() {
        return bowlerLimit;
    }

    public void setBatsmanLimit(int batsmanLimit) {
        this.batsmanLimit = batsmanLimit;
    }

    public void setWicketkeeperLimit(int wicketkeeperLimit) {
        this.wicketkeeperLimit = wicketkeeperLimit;
    }

    public void setAllrounderLimit(int allrounderLimit) {
        this.allrounderLimit = allrounderLimit;
    }

    public void setBowlerLimit(int bowlerLimit) {
        this.bowlerLimit = bowlerLimit;
    }
}
