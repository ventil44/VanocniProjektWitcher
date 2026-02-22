import Characters.Enemy;
import Game.GameData;
import Game.GameWorld;
import Game.Game;
import Items.Potion;
import Items.Weapon;
import Locations.Location;
import Player.Player;
import Dialogs.Dialog;


public class Main {

    public static void main(String[] args) {

        GameData data = GameData.loadGameDataFromResources("/gamedata.json");
        GameWorld world = new GameWorld(data, "loc_wolf_ford");
        Player player = new Player("Zbinek", 100);
        world.loadWorld();

        Game game = new Game(world, player);
        game.run();
    }


}
