package models;

import java.util.*;
import models.playerTypes.AllrounderPlayer;
import models.playerTypes.BatsmanPlayer;
import models.playerTypes.BowlerPlayer;
import models.playerTypes.WicketkeeperPlayer;

public class PlayerList {
	static final int MAXPLAYERS = 20;
	static List<Player> list;
	
	public PlayerList() {
        list = new ArrayList<>(MAXPLAYERS);
    }
	
	static List<Player> getAllPlayers() { //TODO : Return only available players
	    List<Player> returnList = new ArrayList<>(); 
	    //Collections.copy(returnList,list);
	    //for(Player p : returnList) {
	    //    if(!p.isAvailable()) returnList.remove(p);
	    //}
		for(Player p : list) {
			if(p.isAvailable()) {
				returnList.add(p);
			}
		}
	    return returnList;
	} 
	
	static void removePlayer(Long id) //Can be improved by converting to list to Map<Long, Player>
	{
		for(Player p: list)
		{
			if(p.id.equals(id) && p.isAvailable()) {
				p.setAvailable(false);
				System.err.println("Player "+id+" is NOT available for selection now");
				break;
			}
		}
	}
	
	static void addPlayer(Long id) //Can be improved by converting to list to Map<Long, Player>
	{
		for(Player p: list)
		{
			if(p.id.equals(id) && !p.isAvailable()) {
				p.setAvailable(true);
				System.err.println("Player "+id+" is now available");
				break;
			}
		}
	}
	
	static Player getPlayerById(Long id) //Can be improved by converting to list to Map<Long, Player>
	{
		Player result = null;
		for(Player p: list)
		{
			if(p.id.equals(id)) {
				result = p;
			}
		}
		return result;
	}
	
    static PlayerList fillData() {
        PlayerList pl = new PlayerList();
        String playerNames[];
        Long playerPrices[];
        String playerTypes[]; //BT, BW, WC, AL

        playerNames = new String[]{"SC Ganguly", "SR Tendulkar", "R Dravid", "MS Dhoni", "A Kumble", "Z Khan", "Virat Kohli", "A Symonds", "G McGrath", "RT Ponting", "AC Gilchrist", "HH Gibbs", "KP Pieterson", "Sakhib Hasan", "Ajantha Mendis", "Shikhar Dhawan", "Brad Hodge", "Umar Gul", "Stephen Fleming", "Nathan Astle"};
        playerPrices = new Long[]{100000L, 200000L, 500000L, 1000000L, 100000L, 200000L, 500000L, 1000000L, 100000L, 200000L, 500000L, 1000000L, 100000L, 200000L, 500000L, 1000000L, 100000L, 200000L, 500000L, 1000000L};
        playerTypes = new String[]{"BT", "BW", "WC", "AL", "BT", "BW", "WC", "AL", "BT", "BW", "WC", "AL", "BT", "BW", "WC", "AL", "BT", "BW", "WC", "AL"};
        char playerTypesChar[] = new char[]{'T', 'L', 'W', 'A', 'T', 'L', 'W', 'A', 'T', 'L', 'W', 'A', 'T', 'L', 'W', 'A', 'T', 'L', 'W', 'A'};
        Player playerTemp = null;
        for (int i = 0; i < playerNames.length; i++) {
            switch (playerTypesChar[i]) {
                case 'T':
                    playerTemp = new BatsmanPlayer(playerNames[i], playerPrices[i]);
					playerTemp.playerType = "Batsman";
                    break;
                case 'L':
                    playerTemp = new BowlerPlayer(playerNames[i], playerPrices[i]);
					playerTemp.playerType = "Bowler";
                    break;
                case 'W':
                    playerTemp = new WicketkeeperPlayer(playerNames[i], playerPrices[i]);
					playerTemp.playerType = "WicketKeeper";
                    break;
                case 'A':
                    playerTemp = new AllrounderPlayer(playerNames[i], playerPrices[i]);
					playerTemp.playerType = "Allrounder";
                    break;
            }
            pl.list.add(playerTemp);
        }
        return pl;
    }
	
	@Deprecated
	public static List<Player> all() { //TODO: Remove this method when Team view is constructed. No direct access to playerList will happen then
		//return new ArrayList<Player>();
		list = new ArrayList<>(MAXPLAYERS);
		fillData();
		return list;
	}
	
}