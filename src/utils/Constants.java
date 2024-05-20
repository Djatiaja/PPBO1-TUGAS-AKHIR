package utils;

import javax.swing.plaf.PanelUI;

public class Constants {
    public static class PlayerMovement{
        public static final int UP=0;
        public static final int LEFT=1;
        public static final int DOWN=2;
        public static final int RIGHT=3;
    }

    public static class PlayerConstants{
        public static final int IDLE =0;
        public static final int RUNNING =1;
        public static final int JUMPING = 2;
        public static final int FALLING =3;
        public static final int GROUND =4;
        public static final int HIT =5;
        public static final int ATTACK_1 =6;
        public static final int ATTACK_JUMP_1 =7;
        public static final int ATTACK_JUMP_2 =8;

        public static int GetSpriteAmount(int player_action){
            switch (player_action){
                case IDLE -> {
                    return 5;
                }
                case RUNNING -> {
                    return 6;
                }
                case JUMPING, ATTACK_JUMP_1, ATTACK_1, ATTACK_JUMP_2 -> {
                    return 3;
                }
                case GROUND -> {
                    return 2;
                }
                case HIT -> {
                    return 4;
                }
                default -> {
                    return 1;
                }
            }
        }

    }
}
