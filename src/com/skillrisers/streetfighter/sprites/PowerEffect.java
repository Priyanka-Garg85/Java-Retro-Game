package com.skillrisers.streetfighter.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PowerEffect extends CommonPlayer{
    public PowerEffect(int x,int y, BufferedImage img){
        this.playerImg=img;
        this.x=x;
        this.y=y-100;
        w=50;
        h=50;
        speed=100;
    }
    @Override
    public BufferedImage defaultImage(){
        return playerImg.getSubimage(297,262,16,12);
        
    }
    public void printPower(Graphics pen){
        pen.drawImage(defaultImage(),x,y,w,h, null);
        move();
    }

    @Override
    public BufferedImage printIdle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printIdle'");
    }
    @Override
    public BufferedImage printWalk() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printWalk'");
    }
    @Override
    public BufferedImage printJump() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printJump'");
    }
    @Override
    public BufferedImage printCrouch() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printCrouch'");
    }
    @Override
    public BufferedImage printLAttack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printLAttack'");
    }
    @Override
    public BufferedImage printHit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printHit'");
    }
}
