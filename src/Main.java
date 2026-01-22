import Game.GameData;
import Game.GameWorld;
import Game.Game;

public class Main {

    public static void main(String[] args) {

        GameData data = GameData.loadGameDataFromResources("/gamedata.json");

        GameWorld world = new GameWorld(data, "loc_wolf_ford");

        Game game = new Game(world);
        game.run();
    }
}
