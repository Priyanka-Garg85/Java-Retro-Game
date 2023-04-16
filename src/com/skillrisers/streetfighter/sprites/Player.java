package com.skillrisers.streetfighter.sprites;
// import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Player extends CommonPlayer {
	
	private BufferedImage idleImages[] = new BufferedImage[6];
	private BufferedImage walkImages[] = new BufferedImage[6];
	private BufferedImage jumpImages[] = new BufferedImage[6];
	private BufferedImage crouchImages[] = new BufferedImage[2];
	private BufferedImage LAttackImages[] = new BufferedImage[2];
	private BufferedImage hitImages[] = new BufferedImage[2];
	private int force;
	private BufferedImage[] kickImages;
	private BufferedImage[] punchImages; 
	public Player() throws Exception {
		x = 150;
		y = GROUND;
		w = 200;
		h = 300;
		force=0;
		speed = 0;
		playerImg = ImageIO.read(Player.class.getResource(PLAYER_IMAGE));
		loadIdleImages();
		loadWalkImages();
		loadJumpImages();
		loadCrouchImages();
		loadLAttackImages();
		loadHitImages();
		// loadKickImages();
		// loadPunchImages();
	}
	
	private void loadHitImages(){
		hitImages[0] = playerImg.getSubimage(79,404,82,111);
		hitImages[0] = playerImg.getSubimage(78,268,82,111);
		hitImages[1] = playerImg.getSubimage(376,269,59,111);
	}

	private void loadIdleImages() {
		idleImages[0] = playerImg.getSubimage(1,4,75,95);
		idleImages[1] = playerImg.getSubimage(81,4,75,95);
		idleImages[2] = playerImg.getSubimage(168,4,75,95);
		idleImages[3] = playerImg.getSubimage(253,1,75,95);
		idleImages[4] = playerImg.getSubimage(340,1,75,95);
		idleImages[5] = playerImg.getSubimage(1,4,75,95);
	}

	private void loadWalkImages() {
		walkImages[0] = playerImg.getSubimage(1,4,75,95);
		walkImages[1] = playerImg.getSubimage(81,4,75,95);
		walkImages[2] = playerImg.getSubimage(168,4,75,95);
		walkImages[3] = playerImg.getSubimage(253,1,75,95);
		walkImages[4] = playerImg.getSubimage(340,1,75,95);
		walkImages[5] = playerImg.getSubimage(1,4,75,95);
	}

	private void loadJumpImages() {
		jumpImages[0] = playerImg.getSubimage(1,4,75,95);
		jumpImages[1] = playerImg.getSubimage(81,4,75,95);
		jumpImages[2] = playerImg.getSubimage(168,4,75,95);
		jumpImages[3] = playerImg.getSubimage(253,1,75,95);
		jumpImages[4] = playerImg.getSubimage(340,1,75,95);
		jumpImages[5] = playerImg.getSubimage(1,4,75,95);
	}

	private void loadCrouchImages() {
		crouchImages[0] = playerImg.getSubimage(389,536,81,100);
		crouchImages[1] = playerImg.getSubimage(378,536,81,100);
	}
	private void loadLAttackImages() {
		crouchImages[0] = playerImg.getSubimage(277,255,100,117);
		crouchImages[1] = playerImg.getSubimage(169,244,100,129);
	}
	// private void loadKickImages() {
	// 	kickImages[0] = playerImg.getSubimage(56, 1458, 117, 247);
	// 	kickImages[1] = playerImg.getSubimage(247, 1458, 123, 243);
	// 	kickImages[2] = playerImg.getSubimage(428, 1461, 207, 243);
	// 	kickImages[3] = playerImg.getSubimage(247, 1458, 123, 243);
	// 	kickImages[4] = playerImg.getSubimage(56, 1458, 117, 247);
	// }
	
	// private void loadPunchImages() {
	// 	punchImages[0] = playerImg.getSubimage(43, 485, 119, 247);
	// 	punchImages[1] = playerImg.getSubimage(260, 486, 166, 242);
	// 	punchImages[2] = playerImg.getSubimage(478, 490, 115, 242);
	// } 
	public BufferedImage printIdle() {
		isAttacking = false;
		if(imageIndex >= 6) {
			imageIndex = 0;
		}
		BufferedImage img = idleImages[imageIndex];
		imageIndex++;
		return img;
	}

	public BufferedImage printWalk() {
		if(imageIndex >= 6) {
			imageIndex = 0;
			currentMove = WALK;
			isAttacking=false;
		}
		isAttacking=true;
		BufferedImage img = walkImages[imageIndex];
		imageIndex++;
		return img;
	}
	public BufferedImage printKick() {
		if(imageIndex > 4) {
			imageIndex = 0;
			currentMove = IDLE;
			isAttacking = false;
		}
		isAttacking = true;
		BufferedImage img = kickImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	public BufferedImage printPunch() {
		if(imageIndex > 2) {
			imageIndex = 0;
			currentMove = IDLE;
			isAttacking = false;
		}
		isAttacking = true;
		BufferedImage img = punchImages[imageIndex];
		imageIndex++;
		return img;
	}
	public BufferedImage printJump() {
		if(imageIndex >= 6) {
			imageIndex = 0;
			currentMove = JUMP;
		}
		BufferedImage img = jumpImages[imageIndex];
		imageIndex++;
		return img;
	}

	public BufferedImage printCrouch() {
		if(imageIndex >= 2) {
			imageIndex = 0;
			currentMove = CROUCH;
		}
		BufferedImage img = crouchImages[imageIndex];
		imageIndex++;
		return img;
	}
	public void fall() {
		if(y + force > GROUND) {
			return;
		}
		force = force + GRAVITY;
		y = y + force;
	}
	

	public BufferedImage printLAttack() {
		if(imageIndex >= 2) {
			imageIndex = 0;
			currentMove = CROUCH;
		}
		BufferedImage img = LAttackImages[imageIndex];
		imageIndex++;
		return img;
	}

	public BufferedImage printHit() {
		if(imageIndex >= 2) {
			imageIndex = 0;
			currentMove = CROUCH;
		}
		BufferedImage img = hitImages[imageIndex];
		imageIndex++;
		return img;
	}
	@Override
	public BufferedImage defaultImage() {
		if(currentMove == WALK) {
			return printWalk();
		}
		else if(currentMove == KICK) {
			return printKick();
		}
		// else if(currentMove == PUNCH) {
		// 	return printPunch();
		// }
		else {
			return printIdle();
		}
	}
	
}
	