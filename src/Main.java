import Game.GameData;
import Game.GameWorld;
import Game.Game;
import Player.Player;

public class Main {

    public static void main(String[] args) {

        GameData data = GameData.loadGameDataFromResources("/gamedata.json");
        System.out.println("Locations: " + data.locations.size());

        GameWorld world = new GameWorld(data, "loc_wolf_ford");
        Player player = new Player("Zbinek", 100);

        Game game = new Game(world, player);
        game.run();
    }
}
