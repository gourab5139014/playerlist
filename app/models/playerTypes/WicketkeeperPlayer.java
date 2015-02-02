/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.playerTypes;

import models.Player;
import models.playBehaviour.PlayWithWicket;

/**
 *
 * @author 157756
 */
public class WicketkeeperPlayer extends Player {

    public WicketkeeperPlayer(String name, Long price) {
        super(name, price);
		playerType = "Wicketkeeper";
		
        setPlayBehaviour(new PlayWithWicket());
		
//        playBehaviour = new PlayWithWicket();
    }

    @Override
    public void display() {
       System.out.println("Hello from the WicketKeeper "+super.getName());
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
