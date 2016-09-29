/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explodinggame.player;

import engine.Input;
import engine.Signal;
import static explodinggame.ExplodingGame.SCALE;
import static explodinggame.ExplodingGame.SPEED;
import graphics.Graphics2D;
import graphics.data.Sprite;
import org.lwjgl.input.Keyboard;
import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import util.Color4;
import util.Vec2;

/**
 *
 * @author grant
 */
public class Player {
    
    public Sprite sprite;
    public Signal<Vec2> pos;
    
    public Player(Sprite sprite, Vec2 pos) {
        
        this.sprite = sprite;
        this.pos = new Signal(pos);
    }
    
    public void init(){
        
        Input.whileKey(Keyboard.KEY_W, true).onEvent(() -> {
            pos.set(pos.get().add(new Vec2(0,1).multiply(SPEED)));
        });
        Input.whileKey(Keyboard.KEY_A, true).onEvent(() -> {
            pos.set(pos.get().add(new Vec2(-1,0).multiply(SPEED)));
        });
        Input.whileKey(Keyboard.KEY_S, true).onEvent(() -> {
            pos.set(pos.get().add(new Vec2(0,-1).multiply(SPEED)));
        });
        Input.whileKey(Keyboard.KEY_D, true).onEvent(() -> {
            pos.set(pos.get().add(new Vec2(1,0).multiply(SPEED)));
        });
    }
    
    public void draw() {
        
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        Graphics2D.drawSprite(sprite.getTexture(), pos.get(), new Vec2(SCALE), 0, Color4.WHITE);
    }
    
}
