package com.msc.game.Graphics;

public class Sprite {

    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;

    public static Sprite grass = new Sprite(16, 0, 4, SpriteSheet.tiles);
    public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
    public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
    public static Sprite voidSprite = new Sprite(16, 0x1B87E0);

    public static Sprite player_forward = new Sprite(32, 0, 5, SpriteSheet.tiles);
    public static Sprite player_forward_1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
    public static Sprite player_forward_2 = new Sprite(32, 0, 7, SpriteSheet.tiles);

    public static Sprite player_back = new Sprite(32, 2, 5, SpriteSheet.tiles);
    public static Sprite player_back_1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
    public static Sprite player_back_2 = new Sprite(32, 2, 7, SpriteSheet.tiles);

    public static Sprite player_left = new Sprite(32, 3, 5, SpriteSheet.tiles);
    public static Sprite player_left_1 = new Sprite(32, 3, 6, SpriteSheet.tiles);
    public static Sprite player_left_2 = new Sprite(32, 3, 7, SpriteSheet.tiles);

    public static Sprite player_right = new Sprite(32, 1, 5, SpriteSheet.tiles);
    public static Sprite player_right_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
    public static Sprite player_right_2 = new Sprite(32, 1, 7, SpriteSheet.tiles);

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        this.SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * this.SIZE;
        this.y = y * this.SIZE;
        this.sheet = sheet;
        load();
    }

    public Sprite(int size, int colour) {
        this.SIZE = size;
        this.pixels = new int[this.SIZE * this.SIZE];
        setColour(colour);
    }

    private void setColour(int colour) {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = colour;
        }
    }

    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }
}
