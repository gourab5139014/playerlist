/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.playerTypes;

import models.Player;
import models.playBehaviour.PlayWithEverything;

/**
 *
 * @author 157756
 */
public class AllrounderPlayer extends Player{

    public AllrounderPlayer(String name, Long price) {
        super(name, price);
		playerType = "All-rounder";
		
        setPlayBehaviour(new PlayWithEverything());
		
    }

    @Override
    public void display() {
        System.out.println("Hello from all-rounder "+super.getName());
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
