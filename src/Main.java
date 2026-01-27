import Game.GameData;
import Game.GameWorld;
import Game.Game;
import Items.Item;
import Items.Potion;
import Items.Weapon;
import Locations.Location;
import Player.Player;

public class Main {

    public static void main(String[] args) {

        GameData data = GameData.loadGameDataFromResources("/gamedata.json");
        System.out.println("Locations: " + data.locations.size());

        GameWorld world = new GameWorld(data, "loc_wolf_ford");
        Player player = new Player("Zbinek", 100);


        Location start = world.getCurrentLocation();
        start.addItem(new Potion("Small potion", 20));
        start.addItem(new Weapon("Steel sword", 15));


        Game game = new Game(world, player);
        game.run();
    }
}
