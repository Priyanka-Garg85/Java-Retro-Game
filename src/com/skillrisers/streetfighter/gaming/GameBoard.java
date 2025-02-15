package com.skillrisers.streetfighter.gaming;

import java.awt.Color;
import java.awt.Font;
// import java.awt.Color;
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

import com.skillrisers.streetfighter.sprites.Health;
import com.skillrisers.streetfighter.sprites.OpponentPlayer;
import com.skillrisers.streetfighter.sprites.Player;
import com.skillrisers.streetfighter.sprites.PowerEffect;
import com.skillrisers.streetfighter.utils.GameConstants;

public class GameBoard extends JPanel implements GameConstants {
	BufferedImage bgImage;
	private Player player;
	private OpponentPlayer oppPlayer;
	private Timer timer;
	private boolean isGameOver;
	private Health playerHealth;
	private Health oppPlayerHealth;
	private int bg_x= -500;
	private int bg_w= SCREENWIDTH- 2*bg_x;
	public GameBoard() throws Exception {
		player = new Player();
		oppPlayer = new OpponentPlayer();
		setFocusable(true);
		loadBackground();
		bindEvents();
		loadHealth();
		gameLoop();
	}

	private void gameLoop(){
		timer = new Timer(200, new ActionListener() {
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

	public void loadHealth(){
		playerHealth = new Health(70,"RYU");
		oppPlayerHealth = new Health(SCREENWIDTH-670, "KEN");
	}

	public void printHealth(Graphics pen){
		oppPlayerHealth.printHealth(pen);
		playerHealth.printHealth(pen);

	}
	
	// public void flipAll(Graphics pen){
	// 	player.paintFlipPlayer(pen);
	// 	oppPlayer.paintFlipPlayer(pen);
	// 	repaint();
	// }


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
			}
			else if(player.isAttacking()){
					// oppPlayer.prinHitImages();
				oppPlayer.setCurrentMove(HIT);
				oppPlayerHealth.setHealth();
				oppPlayer.setAttacking(false);
				}
			else if(!player.isAttacking()){
				oppPlayer.setCurrentMove(IDLE);
			}
			else if(oppPlayer.isAttacking()){


				}
			
			if(playerHealth.getHealth()<=0|| oppPlayerHealth.getHealth()<=0){
				isGameOver=true;

			}
			
			// System.out.println("Collision Detected!!");
			player.setCollide(true);
			player.setSpeed(0);
		}

		else{
			player.setSpeed(SPEED);
			// System.out.println("No Collision...");
			player.setCollide(false);
			oppPlayer.setCollide(false);
		}
	}
	private void printGameOver(Graphics pen){
		pen.setColor(Color.WHITE);
		pen.setFont(new Font("times",Font.BOLD,80));
		pen.drawString("Game Over!!", SCREENWIDTH/2 -160, SCREENHEIGHT/2-100);

	}


	@Override
	public void paintComponent(Graphics pen) {
		//System.out.println("Paint Component...");
		paintBackground(pen);
		player.paintPlayer(pen);
		oppPlayer.paintPlayer(pen);
		printHealth(pen);
		printPower(pen);
		// flipAll(pen);
		// oppPlayer.flipPlayer();
		// oppPlayer.paintFlipPlayer(pen);
		if(player.getX()>oppPlayer.getX())
		{
			flipAll(pen);
		}
		if (isGameOver){
			printGameOver(pen);
			timer.stop();
		}

	}
	private void flipAll(Graphics pen) {
		// player.flipPlayer();
		// player.paintFlipPlayer(pen);
		// oppPlayer.flipPlayer();
		// oppPlayer.paintFlipPlayer(pen);
		// repaint();
		
	}
	private void movebg(int speed){
		bg_x=bg_x+speed;
	}

	private void paintBackground(Graphics pen) {
		
		
		pen.drawImage(bgImage, bg_x,0,bg_w, SCREENHEIGHT, null);
		
		// pen.setColor(Color.GREEN);
		// pen.fillRect(100, 10, 600,50);
		// pen.setColor(Color.GREEN);
		// pen.fillRect(900, 10, 600,50);
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
				player.setCurrentMove(IDLE);
				oppPlayer.setCurrentMove(IDLE);
				player.setAttacking(false);
				oppPlayer.setAttacking(false);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("Key Pressed : " + e.getKeyCode());
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					
					player.setSpeed(-SPEED/2);
					player.move();
					player.setCollide(false);
					player.setCurrentMove(WALK);
					oppPlayer.setSpeed(SPEED/2);
					oppPlayer.move();
					oppPlayer.setCollide(false);
					movebg(SPEED/2);
					player.setAttacking(false);
					oppPlayer.setAttacking(false);
					// repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					
					player.setSpeed(SPEED/2);
					player.move();
					player.setCollide(false);
					player.setCurrentMove(WALK);
					oppPlayer.setSpeed(-SPEED/2);
					oppPlayer.move();
					oppPlayer.setCollide(false);
					movebg(-SPEED/2);
					// repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_K) {
					player.setCurrentMove(KICK);
					player.setAttacking(true);
				}
				else if(e.getKeyCode() == KeyEvent.VK_P) {
					player.setCurrentMove(POWER);
					player.showPower();
					
				}
				// else if(e.getKeyCode() == KeyEvent.VK_P) {
				// 	player.setCurrentMove(PUNCH);
				// 	player.setAttacking(true);
				// }
				else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					player.jump();
				}
				// 	oppPlayer.jump();
				// 	player.setCurrentMove(JUMP);
				// 	repaint();
				// 	oppPlayer.setCurrentMove(JUMP);
				// 	repaint();
				// }
				
				if(e.getKeyCode() == KeyEvent.VK_A) {
		
					player.setSpeed(SPEED/2);
					player.move();
					player.setCollide(false);
					oppPlayer.setCurrentMove(WALK);
					oppPlayer.setSpeed(-SPEED/2);
					oppPlayer.move();
					oppPlayer.setCollide(false);
					movebg(SPEED/2);
					// repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_D) {
					
					player.setSpeed(-SPEED/2);
					player.move();
					player.setCollide(false);
					oppPlayer.setCurrentMove(WALK);
					oppPlayer.setSpeed(SPEED/2);
					oppPlayer.move();
					oppPlayer.setCollide(false);
					movebg(-SPEED/2);
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

	private void printPower(Graphics pen){
		for(PowerEffect power : player.getPowers()){
			power.printPower(pen);
		}
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
