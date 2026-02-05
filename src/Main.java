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

        System.out.println("Locations: " + data.locations.size());
        System.out.println("Enemies: " + data.enemies.size());
        System.out.println("NPCs: " + data.npcs.size());
        System.out.println("Potions: " + data.potions.size());

        GameWorld world = new GameWorld(data, "loc_wolf_ford");
        Player player = new Player("Zbinek", 100);

        for (Potion p : data.potions) {
            Location loc = world.findLocation(p.getLocationId());
            if (loc != null) {
                loc.addItem(p);
            }
        }

        for (Enemy enemy : data.enemies) {
            Location loc = world.findLocation(enemy.getHomeLocationId());
            if (loc != null) {
                loc.setEnemy(enemy);
            }
        }

        for (Weapon w : data.weapons) {
            String locId = w.getLocationId();
            if (locId == null) {
                continue;
            }
            Location loc = world.findLocation(locId);
            loc.addItem(w);
        }








        Game game = new Game(world, player);
        game.run();
    }


}
