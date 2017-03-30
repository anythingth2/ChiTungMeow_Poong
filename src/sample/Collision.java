package sample;

/**
 * Created by ChiChaChai on 30/3/2560.
 */
public class Collision {


    public static boolean isOverlapWithMap(PlayerObj playerObj, SaveMap saveMap) {
        double playerX = playerObj.getX();
        double playerY = playerObj.getY();
        double playerWidth = playerObj.getCharacterCore().getFitWidth();
        double playerHeight = playerObj.getCharacterCore().getFitHeight();

        double mapWidth = saveMap.getWidthEachSprite();
        double mapHeight = saveMap.getHeightEachSprite();
        for (int i = 0; i < saveMap.getHeightBlock(); i++)
            for (int j = 0; j < saveMap.getWidthBlock(); j++)
                if (playerX < saveMap.getMapObjX(i, j) + mapWidth
                        && playerX + playerWidth > saveMap.getMapObjX(i, j)
                        && playerY < saveMap.getMapObjY(i, j) + mapHeight
                        && playerY + playerHeight > saveMap.getMapObjY(i, j))
                    return true;

        return false;
    }
}
