package entities;


import utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utils.Constants.PlayerConstants.*;

public class Player extends Entity{

    private BufferedImage[][] animations;
    private int aniTick = 0, aniIdx = 0, aniSpeed = 10; //Animation stuff
    private int playerAction = IDLE; //Refer to Constants; Action of the player
    private boolean left, up, right, down; //Direction
    private boolean moving = false, attacking = false; //Actions
    private float playerSpeed = 2.0f;

    public Player(float x, float y, int width, int height) {
        super(x, y);
        loadAnimation();
    }

    public void update(){
        updatePos();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g){
        g.drawImage(animations[playerAction][aniIdx],(int)x,(int)y, 128,80 ,null);
    }

    private void updateAnimationTick() {
        this.aniTick++;
        if(this.aniTick >= this.aniSpeed){
            this.aniTick = 0;
            this.aniIdx++;
            if(this.aniIdx >= GetSpriteAmount(playerAction)){
                this.aniIdx = 0;
                attacking = false;
            }
        }
    }

    private void setAnimation() {

        int startAni = playerAction;
        if(moving){
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }

        if(attacking){
            playerAction = ATTACK_1;
        }

        if(startAni != playerAction){
            resetAniTick();
        }
    }

    private void resetAniTick() {
        aniTick = 0;
        aniIdx = 0;
    }

    private void updatePos() {
        moving = false;

        if(left && !right){
            x -= playerSpeed;
            moving = true;
        } else if (right && !left){
            x += playerSpeed;
            moving = true;
        }

        if(up && !down){
            y -= playerSpeed;
            moving = true;
        } else if (down && !up){
            y += playerSpeed;
            moving = true;
        }
    }

    private void loadAnimation() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);

        animations = new BufferedImage[9][6];
        for(int col = 0; col < animations.length; col++){
            for(int row = 0; row < animations[col].length; row++){
                animations[col][row] = img.getSubimage(row * 64, col * 40, 64, 40);
            }
        }

    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void resetDirBooleans() {
        left = false;
        up = false;
        right = false;
        down = false;
    }

    public void setAttacking(boolean attacking){
        this.attacking = attacking;

    }
}
