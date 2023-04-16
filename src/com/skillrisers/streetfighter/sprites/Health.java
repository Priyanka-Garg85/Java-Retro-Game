package com.skillrisers.streetfighter.sprites;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Health extends CommonPlayer{
    String playerName;
	public Health(int x, String playerName) {
		this.x = x;
		y = 20;
		w = MAX_HEALTH;
		h = 50;
        health=MAX_HEALTH;
		// this.color = color;
        this.playerName= playerName;
	}
    public void setHealth(){
        health= health - (int)(MAX_HEALTH*0.10);
    }

	@Override
	public BufferedImage defaultImage() {
	
		return null;
	}
	
	public void printHealth(Graphics pen) {
        pen.setColor(Color.RED);
		pen.fillRect(x, y, w, h);
		pen.setColor(Color.GREEN);
		pen.fillRect(x, y, health, h);
        pen.setColor(Color.WHITE);
        pen.setFont(new Font("times", Font.BOLD, 50));
        pen.drawString(playerName, x, y+h+50);
	}

    @Override
    public BufferedImage printIdle() {
        throw new UnsupportedOperationException("Unimplemented method 'printIdle'");
    }

    @Override
    public BufferedImage printWalk() {
       
        throw new UnsupportedOperationException("Unimplemented method 'printWalk'");
    }

    @Override
    public BufferedImage printJump() {
     
        throw new UnsupportedOperationException("Unimplemented method 'printJump'");
    }

    @Override
    public BufferedImage printCrouch() {
    
        throw new UnsupportedOperationException("Unimplemented method 'printCrouch'");
    }

    @Override
    public BufferedImage printLAttack() {
     
        throw new UnsupportedOperationException("Unimplemented method 'printLAttack'");
    }

    @Override
    public BufferedImage printHit() {
    
        throw new UnsupportedOperationException("Unimplemented method 'printHit'");
    }
   
    // @Override
    // public BufferedImage flipPlayer() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'flipPlayer'");
    // }
}