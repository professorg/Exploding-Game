/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explodinggame.player;

import static explodinggame.ExplodingGame.SCALE;
import graphics.Graphics2D;
import graphics.Window2D;
import graphics.data.Sprite;
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
    public Vec2 pos;
    
    public Player(Sprite sprite, Vec2 pos) {
        
        this.sprite = sprite;
        this.pos = pos;
    }
    
    public void draw() {
        
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        Graphics2D.drawSprite(sprite.getTexture(), pos, new Vec2(SCALE), 0, Color4.WHITE);
    }
    
}
