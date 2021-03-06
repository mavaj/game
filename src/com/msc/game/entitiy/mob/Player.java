package com.msc.game.entitiy.mob;

import com.msc.game.Graphics.Screen;
import com.msc.game.Graphics.Sprite;
import com.msc.game.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite;
    private int anim = 0;
    private boolean walking = false;

    public Player(Keyboard input) {
        this.input = input;
        this.sprite = sprite.player_forward;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
        this.sprite = sprite.player_forward;
    }

    public void update() {
        int xa = 0, ya = 0;

        if (anim < 7500) {
            anim++;
        } else {
            anim = 0;
        }

        if (input.up) {
            ya--;
        }
        if (input.down) {
            ya++;
        }
        if (input.left) {
            xa--;
        }
        if (input.right) {
            xa++;
        }

        if (xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }
    }

    public void render(Screen screen) {
        if (dir == 0) {
            sprite = Sprite.player_forward;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = sprite.player_forward_1;
                } else {
                    sprite = sprite.player_forward_2;
                }
            }
        }
        if (dir == 1) {
            sprite = Sprite.player_right;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = sprite.player_right_1;
                } else {
                    sprite = sprite.player_right_2;
                }
            }
        }
        if (dir == 2) {
            sprite = Sprite.player_back;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = sprite.player_back_1;
                } else {
                    sprite = sprite.player_back_2;
                }
            }
        }
        if (dir == 3) {
            sprite = Sprite.player_left;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = sprite.player_left_1;
                } else {
                    sprite = sprite.player_left_2;
                }
            }
        }
        screen.renderPlayer(x - 16, y - 16, sprite);
    }

}
