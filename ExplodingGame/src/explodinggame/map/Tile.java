/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explodinggame.map;

import graphics.data.Sprite;

/**
 *
 * @author grant
 */
public class Tile {
    
    Sprite sprite;
    float resistence;
    
    public Tile(Sprite s, float r) {
        
        this.sprite = s;
        this.resistence = r;
    }
    
}
