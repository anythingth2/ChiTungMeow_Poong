package sample;

/**
 * Created by ChiChaChai on 30/3/2560.
 */
public interface SourceDir {

    String[] CAT_UP = {"sprite\\Character\\Cat\\Up\\CatUp_01.png", "sprite\\Character\\Cat\\Up\\CatUp_02.png", "sprite\\Character\\Cat\\Up\\CatUp_03.png", "sprite\\Character\\Cat\\Up\\CatUp_04.png"};
    String[] CAT_DOWN = {"sprite\\Character\\Cat\\Down\\CatDown_01.png", "sprite\\Character\\Cat\\Down\\CatDown_02.png", "sprite\\Character\\Cat\\Down\\CatDown_03.png", "sprite\\Character\\Cat\\Down\\CatDown_04.png"};
    String[] CAT_RIGHT = {"sprite\\Character\\Cat\\Right\\CatRight_01.png", "sprite\\Character\\Cat\\Right\\CatRight_02.png", "sprite\\Character\\Cat\\Right\\CatRight_03.png", "sprite\\Character\\Cat\\Right\\CatRight_04.png"};
    String[] CAT_LEFT = {"sprite\\Character\\Cat\\Left\\CatLeft_01.png", "sprite\\Character\\Cat\\Left\\CatLeft_02.png", "sprite\\Character\\Cat\\Left\\CatLeft_03.png", "sprite\\Character\\Cat\\Left\\CatLeft_04.png"};

    String[] DOG_UP = {"sprite\\Character\\Dog\\Up\\DogUp_01.png", "sprite\\Character\\Dog\\Up\\DogUp_02.png", "sprite\\Character\\Dog\\Up\\DogUp_03.png"};
    String[] DOG_DOWN = {"sprite\\Character\\Dog\\Down\\DogDown_01.png", "sprite\\Character\\Dog\\Down\\DogDown_02.png", "sprite\\Character\\Dog\\Down\\DogDown_03.png"};
    String[] DOG_RIGHT = {"sprite\\Character\\Dog\\Right\\DogRight_01.png", "sprite\\Character\\Dog\\Right\\DogRight_02.png", "sprite\\Character\\Dog\\Right\\DogRight_03.png"};
    String[] DOG_LEFT = {"sprite\\Character\\Dog\\Left\\DogLeft_01.png", "sprite\\Character\\Dog\\Left\\DogLeft_02.png", "sprite\\Character\\Dog\\Left\\DogLeft_03.png"};

    String[] PORING_UP = {"sprite\\Character\\Poring\\Up\\PoringUp_01.png", "sprite\\Character\\Poring\\Up\\PoringUp_02.png", "sprite\\Character\\Poring\\Up\\PoringUp_03.png", "sprite\\Character\\Poring\\Up\\PoringUp_04.png", "sprite\\Character\\Poring\\Up\\PoringUp_05.png", "sprite\\Character\\Poring\\Up\\PoringUp_06.png"};
    String[] PORING_DOWN = {"sprite\\Character\\Poring\\Down\\PoringDown_01.png", "sprite\\Character\\Poring\\Down\\PoringDown_02.png", "sprite\\Character\\Poring\\Down\\PoringDown_03.png", "sprite\\Character\\Poring\\Down\\PoringDown_04.png", "sprite\\Character\\Poring\\Down\\PoringDown_05.png", "sprite\\Character\\Poring\\Down\\PoringDown_06.png"};
    String[] PORING_RIGHT = {"sprite\\Character\\Poring\\Right\\PoringRight_01.png", "sprite\\Character\\Poring\\Right\\PoringRight_02.png", "sprite\\Character\\Poring\\Right\\PoringRight_03.png", "sprite\\Character\\Poring\\Right\\PoringRight_04.png", "sprite\\Character\\Poring\\Right\\PoringRight_05.png", "sprite\\Character\\Poring\\Right\\PoringRight_06.png"};
    String[] PORING_LEFT = {"sprite\\Character\\Poring\\Left\\PoringLeft_01.png", "sprite\\Character\\Poring\\Left\\PoringLeft_02.png", "sprite\\Character\\Poring\\Left\\PoringLeft_03.png", "sprite\\Character\\Poring\\Left\\PoringLeft_04.png", "sprite\\Character\\Poring\\Left\\PoringLeft_05.png", "sprite\\Character\\Poring\\Left\\PoringLeft_06.png"};

    String[] RABBIT_UP = {"sprite\\Character\\Rabbit\\Up\\RabbitUp_01.png", "sprite\\Character\\Rabbit\\Up\\RabbitUp_02.png", "sprite\\Character\\Rabbit\\Up\\RabbitUp_03.png", "sprite\\Character\\Rabbit\\Up\\RabbitUp_04.png", "sprite\\Character\\Rabbit\\Up\\RabbitUp_05.png", "sprite\\Character\\Rabbit\\Up\\RabbitUp_06.png"};
    String[] RABBIT_DOWN = {"sprite\\Character\\Rabbit\\Down\\RabbitDown_01.png", "sprite\\Character\\Rabbit\\Down\\RabbitDown_02.png", "sprite\\Character\\Rabbit\\Down\\RabbitDown_03.png", "sprite\\Character\\Rabbit\\Down\\RabbitDown_04.png", "sprite\\Character\\Rabbit\\Down\\RabbitDown_05.png", "sprite\\Character\\Rabbit\\Down\\RabbitDown_06.png"};
    String[] RABBIT_RIGHT = {"sprite\\Character\\Rabbit\\Right\\RabbitRight_01.png", "sprite\\Character\\Rabbit\\Right\\RabbitRight_02.png", "sprite\\Character\\Rabbit\\Right\\RabbitRight_03.png", "sprite\\Character\\Rabbit\\Right\\RabbitRight_04.png", "sprite\\Character\\Rabbit\\Right\\RabbitRight_05.png", "sprite\\Character\\Rabbit\\Right\\RabbitRight_06.png"};
    String[] RABBIT_LEFT = {"sprite\\Character\\Rabbit\\Left\\RabbitLeft_01.png", "sprite\\Character\\Rabbit\\Left\\RabbitLeft_02.png", "sprite\\Character\\Rabbit\\Left\\RabbitLeft_03.png", "sprite\\Character\\Rabbit\\Left\\RabbitLeft_04.png", "sprite\\Character\\Rabbit\\Left\\RabbitLeft_05.png", "sprite\\Character\\Rabbit\\Left\\RabbitLeft_06.png"};

    String[] Kitty = {"sprite\\Loading\\Kitty\\Kitty_01.png", "sprite\\Loading\\Kitty\\Kitty_02.png", "sprite\\Loading\\Kitty\\Kitty_03.png", "sprite\\Loading\\Kitty\\Kitty_04.png", "sprite\\Loading\\Kitty\\Kitty_05.png", "sprite\\Loading\\Kitty\\Kitty_06.png", "sprite\\Loading\\Kitty\\Kitty_07.png", "sprite\\Loading\\Kitty\\Kitty_08.png", "sprite\\Loading\\Kitty\\Kitty_09.png", "sprite\\Loading\\Kitty\\Kitty_10.png", "sprite\\Loading\\Kitty\\Kitty_11.png"};


    String CAT = "CAT";
    String DOG = "DOG";
    String RABBIT = "RABBIT";
    String PORING = "PORING";
    String[] CHAR_TYPE = {CAT, RABBIT, PORING, DOG};
    String RED = "red.png";
    String BLUE = "blue.png";
    String MENU_DIR = "UI\\Menu\\";


    String BG = MENU_DIR + "BG.png";
    String EMPTY_BG = MENU_DIR + "emptyBG.png";
    String START_BUT = MENU_DIR + "start.png";
    String HOWTO_BUT = MENU_DIR + "howto.png";
    String HOWTO_BG = "UI\\How to\\BgHowTo.png";
    String CHARACTER_SELECT_BG = "UI\\SelectCharacter\\BgCharacter.png";
    String NEXT_BUT = "UI\\SelectCharacter\\Next(SelectCharacter).png";
    String PREVIOUS_BUT = "UI\\SelectCharacter\\previous(SelectCharacter).png";
    String EXIT_BUT = MENU_DIR + "exit.png";
    String CREDIT_BUT = MENU_DIR + "credit.png";
    String CREDIT_BG = "UI\\Credit\\Credit.png";
    String LOADING_BG = "UI\\Loading\\Loading.png";
    String HOME_BUT = "UI\\How to\\Home.png";

    String AMOUNT_BOMB_ITEM = "sprite\\Item\\AmountBomb.png";
    String FAST_ITEM = "sprite\\Item\\Fast.png";
    String POTION_ITEM = "sprite\\Item\\potion.png";
    String SHIELD_ITEM = "sprite\\Item\\Shield.png";
    String[] ALL_ITEM = {AMOUNT_BOMB_ITEM, FAST_ITEM, POTION_ITEM, SHIELD_ITEM};

    String BOMB_OBJ = "sprite\\bomb\\bomb1.png";
    String[] BOOM_EFF = {"sprite\\bomb\\Boom\\bomb_01.png", "sprite\\bomb\\Boom\\bomb_02.png", "sprite\\bomb\\Boom\\bomb_03.png", "sprite\\bomb\\Boom\\bomb_04.png", "sprite\\bomb\\Boom\\bomb_05.png", "sprite\\bomb\\Boom\\bomb_06.png"};

    String BGM = "out\\production\\ChiTungMeow_Poong\\sound\\bgm.mp3";
    String BOOM_SOUND_EFF = "out\\production\\ChiTungMeow_Poong\\sound\\boomSoundEff.mp3";
    String DEPLOY_BOMB_SOUND_EFF = "out\\production\\ChiTungMeow_Poong\\sound\\deployBombSoundEff.mp3";

    String GROUND_SPRING = "sprite\\Obj\\Ground\\Spring.png";
    String GROUND1 = "sprite\\Obj\\Ground\\Ground.png";

    String ROCK = "sprite\\Obj\\Rock\\GreenRock.png";
    String BUSH = "sprite\\Obj\\Bush\\Bush1.png";

    String BIG_SAKURA1 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_01.png";
    String BIG_SAKURA2 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_02.png";
    String BIG_SAKURA3 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_03.png";
    String BIG_SAKURA4 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_04.png";
    String BIG_SAKURA5 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_05.png";
    String BIG_SAKURA6 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_06.png";
    String BIG_SAKURA7 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_07.png";
    String BIG_SAKURA8 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_08.png";
    String BIG_SAKURA9 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_09.png";
    String BIG_SAKURA10 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_10.png";
    String BIG_SAKURA11 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_11.png";
    String BIG_SAKURA12 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_12.png";
    String BIG_SAKURA13 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_13.png";
    String BIG_SAKURA14 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_14.png";
    String BIG_SAKURA15 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_15.png";
    String BIG_SAKURA16 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_16.png";
    String BIG_SAKURA17 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_17.png";
    String BIG_SAKURA18 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_18.png";
    String BIG_SAKURA19 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_19.png";
    String BIG_SAKURA20 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_20.png";
    String BIG_SAKURA21 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_21.png";
    String BIG_SAKURA22 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_22.png";
    String BIG_SAKURA23 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_23.png";
    String BIG_SAKURA24 = "sprite\\Obj\\Tree\\SakuraTree\\SakuraTree_24.png";


    String SAKURA1 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_01.png";
    String SAKURA2 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_02.png";
    String SAKURA3 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_03.png";
    String SAKURA4 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_04.png";
    String SAKURA5 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_05.png";
    String SAKURA6 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_06.png";
    String SAKURA7 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_07.png";
    String SAKURA8 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_08.png";
    String SAKURA9 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_09.png";
    String SAKURA10 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_10.png";
    String SAKURA11 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_11.png";
    String SAKURA12 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_12.png";
    String SAKURA13 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_13.png";
    String SAKURA14 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_14.png";
    String SAKURA15 = "sprite\\Obj\\Tree\\SakuraTree2\\SakuraTree2_15.png";


    String FLOWER1 = "sprite\\Obj\\Flower\\Flower.png";
    String FLOWER2 = "sprite\\Obj\\Flower\\Flower2.png";
    String FLOWER3 = "sprite\\Obj\\Flower\\Flower3.png";

    String CHAIRUP = "sprite\\Obj\\Building\\ChairUp\\ChairUp.png";
    String LAMP1 = "sprite\\Obj\\Building\\Lamp\\Lamp_01.png";
    String LAMP2 = "sprite\\Obj\\Building\\Lamp\\Lamp_02.png";

    String WALL_BD = "sprite\\Obj\\Wall\\Buttom\\ButtomWallD.png";
    String WALL_BL = "sprite\\Obj\\Wall\\Buttom\\ButtomWallL.png";
    String WALL_BU = "sprite\\Obj\\Wall\\Buttom\\ButtomWallU.png";
    String WALL_BR = "sprite\\Obj\\Wall\\Buttom\\ButtomWallR.png";

    String WALL_LD = "sprite\\Obj\\Wall\\Cornor\\WallLD.png";
    String WALL_LU = "sprite\\Obj\\Wall\\Cornor\\WallLU.png";
    String WALL_RD = "sprite\\Obj\\Wall\\Cornor\\WallRD.png";
    String WALL_RU = "sprite\\Obj\\Wall\\Cornor\\WallRU.png";

    String WALL_HD = "sprite\\Obj\\Wall\\Head\\HeadWallD.png";
    String WALL_HL = "sprite\\Obj\\Wall\\Head\\HeadWallL.png";
    String WALL_HR = "sprite\\Obj\\Wall\\Head\\HeadWallR.png";
    String WALL_HU = "sprite\\Obj\\Wall\\Head\\HeadWallU.png";

    String WALL_MD = "sprite\\Obj\\Wall\\Middle\\MiddleWallD.png";
    String WALL_ML = "sprite\\Obj\\Wall\\Middle\\MiddleWallL.png";
    String WALL_MR = "sprite\\Obj\\Wall\\Middle\\MiddleWallR.png";
    String WALL_MU = "sprite\\Obj\\Wall\\Middle\\MiddleWallU.png";


    String STATUS_BG = "UI\\status\\play.png";
    String LIFE = "UI\\status\\Life.png";

    String WIN = "sprite\\GUI\\Win.png";
    String LOSE = "sprite\\GUI\\Lose.png";

}
