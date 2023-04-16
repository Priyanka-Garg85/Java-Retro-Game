package com.skillrisers.streetfighter.sprites;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

// import com.skillrisers.streetfighter.utils.GameConstants;

public class OpponentPlayer extends CommonPlayer{
	
	private BufferedImage idleImages[] = new BufferedImage[6];
	private BufferedImage walkImages[] = new BufferedImage[6];
	private BufferedImage jumpImages[] = new BufferedImage[6];
	private BufferedImage crouchImages[] = new BufferedImage[2];
	private BufferedImage hitImages[] = new BufferedImage[3];

	public OpponentPlayer() throws Exception {
		x = SCREENWIDTH - 350;
		y = GROUND;
		w = 200;
		h = 300;
		force=0;
		speed = 0;
		playerImg = ImageIO.read(Player.class.getResource(OPPONENT_IMAGE));
		loadIdleImages();
		loadWalkImages();
		loadJumpImages();
		loadCrouchImages();
		loadHitImages();
	}
	private void loadHitImages(){
		hitImages[0] = playerImg.getSubimage(428,396,116,107);
		hitImages[0] = playerImg.getSubimage(421,395,116,107);
		hitImages[1] = playerImg.getSubimage(425,395,116,107);
	}
	@Override
	public BufferedImage defaultImage() {
		//X = 47 Y = 242 Width = 110 Height = 245
		//return playerImg.getSubimage(47, 242, 110, 245);
		if(currentMove == HIT) {
			return printHitImages();
		}
		else {
			return printIdle();
		}}
	private void loadIdleImages() {
		idleImages[0] = playerImg.getSubimage(12, 0, 85, 118);
		idleImages[1] = playerImg.getSubimage(103, 0, 85, 118);
		idleImages[2] = playerImg.getSubimage(206, 0, 85, 118);
		idleImages[3] = playerImg.getSubimage(304, 0, 85, 118);
		idleImages[4] = playerImg.getSubimage(405, 0, 85, 118);
		idleImages[5] = playerImg.getSubimage(506, 0, 85, 118);
	}

	private void loadWalkImages() {
		walkImages[0] = playerImg.getSubimage(12, 0, 85, 118);
		walkImages[1] = playerImg.getSubimage(103, 0, 85, 118);
		walkImages[2] = playerImg.getSubimage(206, 0, 85, 118);
		walkImages[3] = playerImg.getSubimage(304, 0, 85, 118);
		walkImages[4] = playerImg.getSubimage(405, 0, 85, 118);
		walkImages[5] = playerImg.getSubimage(506, 0, 85, 118);
	}

	private void loadJumpImages() {
		jumpImages[0] = playerImg.getSubimage(12, 0, 85, 118);
		jumpImages[1] = playerImg.getSubimage(103, 0, 85, 118);
		jumpImages[2] = playerImg.getSubimage(206, 0, 85, 118);
		jumpImages[3] = playerImg.getSubimage(304, 0, 85, 118);
		jumpImages[4] = playerImg.getSubimage(405, 0, 85, 118);
		jumpImages[5] = playerImg.getSubimage(506, 0, 85, 118);
	}

	private void loadCrouchImages() {
		crouchImages[0] = playerImg.getSubimage(3,281,116,107);
		crouchImages[1] = playerImg.getSubimage(1,258,116,136);
		
	}
	// private void loadLAttackImages() {
	// 	crouchImages[0] = playerImg.getSubimage(10,295,68,84);
	// 	crouchImages[1] = playerImg.getSubimage(157,295,68,84);
	// }
	public BufferedImage printHitImages() {
		if(imageIndex >=3) {
			imageIndex = 0;
			currentMove = IDLE;
		}
		BufferedImage img = hitImages[imageIndex];
		imageIndex++;
		return img;
	}

	public BufferedImage printIdle() {
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
			currentMove = IDLE;
		}
		BufferedImage img = walkImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	public BufferedImage printJump() {
		if(imageIndex >= 6) {
			imageIndex = 0;
			currentMove = IDLE;
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
