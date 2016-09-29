/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explodinggame;

import engine.Core;
import engine.Input;
import explodinggame.map.Level;
import explodinggame.player.Player;
import graphics.Window2D;
import graphics.data.Sprite;
import org.lwjgl.input.Keyboard;
import util.Color4;
import util.Vec2;

/**
 *
 * @author gvandomelen19
 */
public class ExplodingGame {
    
    public static final int SCALE = 5;
    public static final int SPEED = 5;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Core.init();
        
        Window2D.background = Color4.BLACK;
        
        Level map = new Level(Level.genLevel(50, 50, 0), new Sprite("stone1"), 50, 50);
        Player player = new Player(new Sprite("player1"),Vec2.ZERO);
        
        Window2D.viewPos =  Window2D.LR();
        
        Core.renderLayer(1).onEvent(() -> map.drawBackground());
        Core.renderLayer(99).onEvent(() -> player.draw());
        Core.renderLayer(3).onEvent(() -> map.draw());
        
        Core.run();
    }
    
}
