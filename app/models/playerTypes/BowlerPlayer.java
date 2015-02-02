/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.playerTypes;

import models.Player;
import models.playBehaviour.PlayWithBall;

/**
 *
 * @author 157756
 */
public class BowlerPlayer extends Player{

    public BowlerPlayer(String name, Long price) {
        super(name, price);
		playerType = "Bowler";
		
        setPlayBehaviour(new PlayWithBall());
		
        //playBehaviour = new PlayWithBall();
        
    }

    @Override
    public void display() {
        System.out.println("Hello from the Bowler "+super.getName());        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
