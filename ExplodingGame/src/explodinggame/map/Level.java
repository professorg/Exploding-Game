/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package explodinggame.map;

import static explodinggame.ExplodingGame.SCALE;
import graphics.Graphics2D;
import graphics.data.Sprite;
import java.util.Random;
import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import util.Color4;
import util.Util;
import util.Vec2;

/**
 *
 * @author grant
 */
public class Level {

    public Tile[][] tiles;
    public Sprite background;
    public int width;
    public int height;

    public Level(Tile[][] tiles, Sprite background, int width, int height) {

        this.tiles = tiles;
        this.background = background;
        this.width = width;
        this.height = height;
    }

    public static Tile[][] genLevel(int x, int y, int seed) {

        Tile[][] out = new Tile[x][y];
        Random r = new Random(seed);

        for (int j = 0; j < x; j++) {

            for (int k = 0; k < y; k++) {

                out[j][k] = r.nextDouble() < 0.2 ? new Tile(new Sprite("tile1"), 1.0f) : null;
            }
        }
        return out;
    }

    public void draw() {

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        Util.forRange(0, width, 0, height, (x, y) -> {

            if (tiles[x][y] != null) {

                Graphics2D.drawSprite(tiles[x][y].sprite.getTexture(),
                        new Vec2(
                                tiles[x][y].sprite.getTexture().getImageWidth() * x
                                - tiles[x][y].sprite.getTexture().getImageWidth() * 3 / 2,
                                -tiles[x][y].sprite.getTexture().getImageWidth() * y
                                - tiles[x][y].sprite.getTexture().getImageHeight() * 3 / 2).multiply(SCALE),
                        new Vec2(SCALE), 0, Color4.WHITE);
            }
        });
    }

    public void drawBackground() {
        
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        Util.forRange(0, width, 0, height, (x, y) -> {
            
            Graphics2D.drawSprite(background.getTexture(),
                    new Vec2(
                            background.getTexture().getImageWidth() * x
                            - background.getTexture().getImageWidth() * 3 / 2,
                            -background.getTexture().getImageWidth() * y
                            - background.getTexture().getImageHeight() * 3 / 2).multiply(SCALE),
                    new Vec2(SCALE), 0, Color4.WHITE);
        });
    }

}
