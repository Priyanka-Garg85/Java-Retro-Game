package com.skillrisers.streetfighter.sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.skillrisers.streetfighter.utils.GameConstants;

import com.skillrisers.streetfighter.utils.GameConstants;

public class Health extends CommonPlayer implements GameConstants{
	Color color;
	public Health(int x, Color color) {
		this.x = x;
		y = 20;
		w = MAX_HEALTH;
		h = 50;
        health=MAX_HEALTH;
		this.color = color;
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
		pen.fillRect(x, y, health, h);
		pen.setColor(color);
		pen.fillRect(x, y, health, h);
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