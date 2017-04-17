package sample;

/**
 * Created by ChiChaChai on 29/3/2560.
 */
public class Buff {


    public static final String INCREASE_BOMB = SourceDir.AMOUNT_BOMB_ITEM;
    public static final String INCREASE_FAST = SourceDir.FAST_ITEM;
    public static final String POTION_ITEM = SourceDir.POTION_ITEM;
    public static final String SHIELD_ITEM = SourceDir.SHIELD_ITEM;

    public static void increaseVelo(PlayerObj playerObj) {
        playerObj.setRunning_velo(playerObj.getRunning_velo() + 2);
    }

    public static void increaseDistanceBomb(PlayerObj playerObj) {
        playerObj.setDistanceBomb(playerObj.getDistanceBomb() + 1);
    }

    public static void increaseAmountBomb(PlayerObj playerObj) {
        playerObj.setAmountBomb(playerObj.getAmountBomb() + 1);
    }

    public static void kickBomb(PlayerObj playerObj, boolean kickable) {
        playerObj.setCanKickBomb(kickable);
    }

    public static void addBarrier(PlayerObj playerObj) {
        playerObj.setHp(playerObj.getHp() + 1);
        playerObj.syncLife();
    }
}
