import Game.GameData;
import Game.GameWorld;
import Game.Game;
import Player.Player;

public class Main {

    public static void main(String[] args) {

        GameData data = GameData.loadGameDataFromResources("/gamedata.json");
        System.out.println("Locations: " + data.locations.size());
        Player p = new Player("Pepa", 100, 100);

        GameWorld world = new GameWorld(data, "loc_wolf_ford");


        Game game = new Game(world, p);
        game.run();
    }
}
