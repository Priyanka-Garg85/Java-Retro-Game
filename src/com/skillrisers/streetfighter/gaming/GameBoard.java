package com.skillrisers.streetfighter.gaming;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

// import com.skillrisers.streetfighter.sprites.Health;
import com.skillrisers.streetfighter.sprites.OpponentPlayer;
import com.skillrisers.streetfighter.sprites.Player;
import com.skillrisers.streetfighter.utils.GameConstants;

public class GameBoard extends JPanel implements GameConstants {
	BufferedImage bgImage;
	private Player player;
	private OpponentPlayer oppPlayer;
	private Timer timer;
	// private Health playerHealth;
	// private Health oppPlayerHealth;
	public GameBoard() throws Exception {
		player = new Player();
		oppPlayer = new OpponentPlayer();
		setFocusable(true);
		loadBackground();
		bindEvents();
		gameLoop();
	}

	private void gameLoop(){
		timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				repaint();
				if(player.getX()>oppPlayer.getX())
				{
					
					// player.flipPlayer();
					// oppPlayer.flipPlayer();
					// repaint();
				}
				player.fall();
				oppPlayer.fall();
				collision();
			}

		} );
		timer.start();
	}

	// public void loadHealth(){
	// 	oppPlayerHealth = new Health(30,Color.GREEN);
	// 	playerHealth = new Health(SCREENWIDTH-600, Color.GREEN);
	// }

	// public void printHealth(Graphics pen){
	// 	oppPlayerHealth.printHealth(pen);
	// 	playerHealth.printHealth(pen);

	// }

	public void flipAll(Graphics pen){
		player.paintFlipPlayer(pen);
		oppPlayer.paintFlipPlayer(pen);
		repaint();
	}


	private boolean isCollide(){
		int xDistance = Math.abs(player.getX()-oppPlayer.getX());
		int yDistance = Math.abs(player.getY()-oppPlayer.getY());
		int maxH= Math.max(player.getH(), oppPlayer.getH());
		int maxW= Math.max(player.getW(), oppPlayer.getW());
		return xDistance <= maxW && yDistance <= maxH;
	}

	private void collision(){
		if(isCollide()){
			if(player.isAttacking()&&oppPlayer.isAttacking()){
				if(player.isAttacking()){

				}
				else if(oppPlayer.isAttacking()){

				}
			}
			System.out.println("Collision!!");
			player.setCollide(true);
			player.setSpeed(0);
		}
		else{
			player.setSpeed(SPEED);
			player.setCollide(false);
		}
	}


	@Override
	public void paintComponent(Graphics pen) {
		//System.out.println("Paint Component...");
		paintBackground(pen);
		player.paintPlayer(pen);
		// oppPlayer.flipPlayer();
		oppPlayer.paintFlipPlayer(pen);
		if(player.getX()>oppPlayer.getX())
		{
			flipAll(pen);
		}

	}
	private void paintBackground(Graphics pen) {
		
		pen.drawImage(bgImage, 0,0,SCREENWIDTH, SCREENHEIGHT, null);
		
		pen.setColor(Color.GREEN);
		pen.fillRect(100, 10, 600,50);
		pen.setColor(Color.GREEN);
		pen.fillRect(900, 10, 600,50);
	}
	
	void bindEvents() {
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// System.out.println("Key Typed : " + e.getKeyCode());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("Key Released : " + e.getKeyCode());
				player.setSpeed(0);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("Key Pressed : " + e.getKeyCode());
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.setCurrentMove(WALK);
					player.setSpeed(-SPEED);
					player.setCollide(false);
					player.move();
					// repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.setCurrentMove(WALK);
					player.setSpeed(SPEED);
					player.move();
					// repaint();
				}
				
				if(e.getKeyCode() == KeyEvent.VK_A) {
					oppPlayer.setCurrentMove(WALK);
					oppPlayer.setSpeed(-SPEED);
					oppPlayer.move();
					// repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_D) {
					oppPlayer.setCurrentMove(WALK);
					oppPlayer.setSpeed(SPEED);
					oppPlayer.move();
					// repaint();
				}
				
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					player.setCurrentMove(JUMP);
					player.jump();
					// repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					player.setCurrentMove(CROUCH);
					player.crouch();
					// repaint();
				}

				if(e.getKeyCode() == KeyEvent.VK_W) {
					player.setCurrentMove(JUMP);
					oppPlayer.jump();
					// repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_S) {
					oppPlayer.setCurrentMove(CROUCH);
					oppPlayer.crouch();
					// repaint();
				}
			}
		});
	}
	
	private void loadBackground() {
		try {
			bgImage = ImageIO.read(GameBoard.class.getResource(BACKGROUND));
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Something went wrong...");
			System.out.println("Failed to load background image...");
			System.exit(0);
		}
	}
}
