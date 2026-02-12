package Command;

import Items.Weapon;
import Locations.Location;
import Player.Player;
import Game.GameWorld;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Handles a quest a in specific location
 * Once the quest is completed it cannot be done again
 * @author Denis Vesely
 */
public class QuestCommand implements Command {

    private GameWorld gameWorld;
    private Scanner scanner = new Scanner(System.in);
    private Player player;
    private boolean isCompleted = false;

    public QuestCommand(GameWorld gameWorld, Scanner scanner, Player player) {
        this.gameWorld = gameWorld;
        this.scanner = scanner;
        this.player = player;
    }

    /**
     * Executes quest command
     * If the quest is not done, the user has to solve a math problem, if they get it right, they get a sword as a reward
     * If they get it wrong they can activate the quest ocne again
     *
     * @return a message describing the result of the quest attempt
     */
    @Override
    public String execute(){
        if(!isCompleted) {
            Location loc = gameWorld.getCurrentLocation();
            if (gameWorld.findLocation("loc_wolf_ford") != loc) {
                return "No quest in this location.";
            } else {
                System.out.println("Hey witcher i need your help with my math homework. Solve this problem and i will give u my best sword.");
                System.out.println("2x+4=10. Whats ur answer?");
                System.out.print("> ");
                int answer;
                try {
                    answer = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    return "Invalid input.";
                }
                if (answer == 3) {
                    System.out.println("You got it!");
                    Weapon reward = gameWorld.findWeapon("old_witchers_sword");
                    player.takeItem(reward);
                    player.equipWeapon(reward);
                    isCompleted = true;

                    return "You received a sword!";
                } else {
                    return "Wrong, no sword for u, try again.";
                }
            }
        }

        return "You already did this quest.";
}
}
