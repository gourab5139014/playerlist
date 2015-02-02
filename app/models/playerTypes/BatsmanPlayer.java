/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.playerTypes;
import models.PlayBehaviour;
import models.Player;
import models.playBehaviour.PlayWithBat;

/**
 *
 * @author 157756
 */
public class BatsmanPlayer extends Player {

    /*public BatsmanPlayer(String name, Long price) {
     playBehaviour = new PlayWithBat();
     }*/
    public BatsmanPlayer(String name, Long price) {
        super(name, price);
		playerType = "Batsman";
		
        setPlayBehaviour(new PlayWithBat());
		
//        playBehaviour = new PlayWithBat();
    }

    @Override
    public void display() {
        System.out.println("Hello from the Batsman "+super.getName());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
