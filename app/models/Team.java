package models;

import java.util.*;
import models.Player;
import models.PlayerList;
import models.TeamType;
import models.teamType.*;

public class Team {
	static final Long startingMoney = 10000000L;
    String teamName;
    String userName;
     //TODO: Team Configuration Object
     List<Player> players = new ArrayList<Player>();
     PlayerList playerSource;
     Long allocatedMoney = startingMoney;
     Long remainingMoney = allocatedMoney;
     //TODO: Team Configuration Checker Method
     static boolean firstLoad = true;
     boolean isEditable = false;
	 TeamType tt;
	 
	 public Team() {
		System.err.println("Team default constructor called!");
	 }
     
	 public void setTeamType(int index) {
		switch(index) {
			case 1: tt = new TeamType1();
					break;
			case 2: tt = new TeamType2();
					break;
			case 3: tt = new TeamType3();
		}
	}
	
	 public boolean isEditable()
	 {
		return isEditable;
	 }
	 
	 public void setTeamName(String value)
	 {
			teamName = value;
	 }
	 
	 public void setUserName(String value)
	 {
			userName = value;
	 }
	 public String getTeamName()
	 {
			return teamName;
	 }
	 
	 public String getUserName()
	 {
			return userName;
	 }
	 
	 
	 public void setEditable(boolean value)
	 {
			isEditable = value;
	 }
	 public Long getAllocatedMoney(){
		return allocatedMoney;
	 }
	 public Long getRemainingMoney() {
		return remainingMoney;
	 }
	 //@Deprecated
     public List<Player> getPlayers() {
         //if(firstLoad) playerSource.fillData();
         return players;
     }
     
	 public int getTeamSize() {
		return players.size();
	 }
	 
	 public Player getPlayerById(Long id) { // TODO: What happens when no player matches id ?
		Player p = null;
		for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) {
			p = iterator.next();
			if (p != null && p.id.equals(id)) break;
		}
		return p;
	 }
	 
     public List<Player> getAvailablePlayers() {
         if(firstLoad) {
             System.err.println("This is the first load");
             playerSource = PlayerList.fillData();
             firstLoad=false;
         }
         System.err.println("\nMODEL : Displaying available players..");
         return playerSource.getAllPlayers();
     }
     
	 public void reset(){
		playerSource = PlayerList.fillData();
		players.clear();
		isEditable = false;
        firstLoad=false;
		setTeamType(1);
	 }
	 
     public String addPlayer(Long id){
        //String result = "";
		System.err.println("MODEL : Attempting to add Player "+id+" into Team");
		//Mark player as unavaileble in PlayerList
		playerSource.removePlayer(id);
		//Add to team players
		Player newTeamPlayer = playerSource.getPlayerById(id);
		if(newTeamPlayer.price > remainingMoney) {
			playerSource.addPlayer(id);
			return new String("Insufficient Funds");
		}
		if(!tt.isValidAddition(newTeamPlayer,players)) {
			playerSource.addPlayer(id);
			return new String("Invalid player addition. Not according to team type");
		}
		
		players.add(newTeamPlayer);
		//Hit addPlayerPrice
		addPlayerPrice(newTeamPlayer.price);
		return null;
     }
     
     public String deletePlayer(Long id) {
		Long priceToBeReversed = 0L;
        //Remove player from team player list
		for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) {
			Player p = iterator.next();
			if (p != null && p.id.equals(id)) {
				System.err.println("MODEL : Attempting to delete Player "+id+" from Team");
				priceToBeReversed = p.price;
				iterator.remove();
				break;
			}
		}
		//reverse price of player
		reversePlayerPrice(priceToBeReversed);
		
		//mark as available in player inventory
		playerSource.addPlayer(id);
		return null;
     }
     
     private String addPlayerPrice(Long price) { //TODO: Check > 0 and raise exception
         if(price > remainingMoney) return new String("Insufficient Funds");
		 remainingMoney-=price;
		 return null;
     }
     
     private void reversePlayerPrice(Long price) { //TODO: Check <= allocatedMoney and raise exception
        remainingMoney+=price;
     }
}