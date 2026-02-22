package Command;

import Characters.Enemy;
import Game.GameWorld;
import Locations.Location;
import Player.Player;

/**
 * Command that handles combat between the player and enemies
 * Theres a cyklus that goes on and on until either the enemy or the user is defeated
 * @author Denis Vesely
 */
public class AttackCommand implements Command {

    private final Player player;
    private final GameWorld gameWorld;


    public AttackCommand(Player player, GameWorld gameWorld) {
        this.player = player;
        this.gameWorld = gameWorld;
    }

    /**
     * executes turned based combat in current location
     * if theres no enemy in current location, the command returns a message telling the user theres no one to fight.
     * When the fight is over, the command returns the whole combat log. If player dies the command tells the user hes dead.
     * @return a message with the outcome of the fight or a message that theres no one to fight
     */
    @Override
    public String execute() {
        Location loc = gameWorld.getCurrentLocation();
        Enemy enemy = loc.getEnemy();

        if (enemy == null || !enemy.isAlive()) {
            return "There is no enemy to attack here.";
        }
        while (enemy.isAlive() && player.isAlive()) {
            int dealt = player.attack(enemy);

            String result = "You hit " + enemy.getName() +
                    " for " + dealt + " damage, he now has " + enemy.getHealth() + "HP";

            if (!enemy.isAlive()) {
                return result + " Enemy defeated!";

            }

            player.takeDamage(enemy.getDamage());

            result += " " + enemy.getName() + " hit you for " +
                    enemy.getDamage() + " damage.";
            result += "Your HP: " + player.getHealth();


            if (!player.isAlive()) {
                result += " You died.";
            }

            System.out.println(result);
        } return "";
    }
}
