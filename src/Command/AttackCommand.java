package Command;

import Characters.Enemy;
import Game.GameWorld;
import Locations.Location;
import Player.Player;

public class AttackCommand implements Command {

    private final Player player;
    private final GameWorld gameWorld;


    public AttackCommand(Player player, GameWorld gameWorld) {
        this.player = player;
        this.gameWorld = gameWorld;
    }

    @Override
    public String execute() {
        Location loc = gameWorld.getCurrentLocation();
        Enemy enemy = loc.getEnemy();

        if (enemy == null || !enemy.isAlive()) {
            return "There is no enemy to attack here.";
        }
        while(enemy.isAlive()) {
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
                result += "You died.";
            }

            System.out.println(result);
        } return "";
    }
}
