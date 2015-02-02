package models;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Player {
    public String name;
    public Long id; //unique id for every player
    Long price;
    public PlayBehaviour playBehaviour;
    public String playerType;
	boolean isAvailable; //use this to mark if a player is already assigned to a team
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);
	
    public Player(String name, Long price)
    {
        this.name = name;
        this.price = price;
        this.id = Long.valueOf(ID_GENERATOR.getAndIncrement());
        this.isAvailable = true;
    }
	public Player(Player p)
	{
		this.name = p.name;
        this.price = p.price;
        this.id = p.id;
        this.isAvailable = p.isAvailable;
		this.playerType = p.playerType;
	}
	
    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
    public Long getPrice() {
        return price;
    }
	public String getPlayerType()
	{
		return playerType;
	}
    public void performPlay(){
        playBehaviour.performPlay();
    }
    
    public void setPlayBehaviour(PlayBehaviour pb){
        playBehaviour = pb;
    }
    
    public String toString()
    {
        return "No. "+ id + " : " + name + " @ Rs. " + price;    
    }
    
    public boolean isAvailable() {
        return this.isAvailable;
    }
    
    public void setAvailable(boolean value) {
        this.isAvailable = value;
    }
    public abstract void display();
}
