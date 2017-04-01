package sample;

/**
 * Created by ChiChaChai on 29/3/2560.
 */
public class Buff {

    public void increaseVelo(PlayerObj playerObj) {
        playerObj.setRunning_velo(playerObj.getRunning_velo() + 1);
    }

    public void increaseDistanceBomb(PlayerObj playerObj) {
        playerObj.setDistanceBomb(playerObj.getRunning_velo() + 1);
    }

    public void increaseAmountBomb(PlayerObj playerObj) {
        playerObj.setAmountBomb(playerObj.getAmountBomb() + 1);
    }

    public void kickBomb(PlayerObj playerObj, boolean kickable) {
        playerObj.setCanKickBomb(kickable);
    }

    public void addBarrier(PlayerObj playerObj) {
        playerObj.setHp(playerObj.getHp() + 1);
    }
}
