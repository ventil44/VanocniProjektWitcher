package Command;

import Characters.Enemy;
import Game.GameWorld;
import Locations.Location;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Command that moves the player fro0m current location to one thats connected
 *
 * The command prints out a list of connected locations, the user can choose where to go.
 * Also in some locations the user has to do some things before hes able to move forward to another location
 * @author Denis Vesely
 */
public class GoToLocationCommand implements Command {

    private final GameWorld gameWorld;
    private final Scanner scanner;

    public GoToLocationCommand(GameWorld gameWorld, Scanner scanner) {
        this.gameWorld = gameWorld;
        this.scanner = scanner;
    }

    /**
     * Executes the command to move the player to a connected location.
     * If the input is invalid it informs the user about it.
     * @return a message describing the result of the travel
     */
    @Override
    public String execute() {
        Location current = gameWorld.getCurrentLocation();
        ArrayList<String> connections = current.getConnectedLocations();

        if (current.getId().equals("loc_forest_of_shadows")) {

            Enemy nekker = gameWorld.findEnemy("nekker");

            if (nekker != null && nekker.isAlive()) {
                return "You have to defeat the Nekker first!";
            }
        }

        if (current.getId().equals("loc_swamp")) {
            if (!gameWorld.hasTalkedToJezibaba()) {
                return "Talk to the Jezibaba first!";
            }
        }

        if (connections.isEmpty()) {
            return "There are no locations to go to.";
        }

        System.out.println("Where do you want to go?");
        for (int i = 0; i < connections.size(); i++) {
            Location loc = gameWorld.findLocation(connections.get(i));
            System.out.println((i + 1) + " - " + loc.getName());
        }

        System.out.print("> ");
        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            return "Invalid inpt";
        }

        if (choice < 1 || choice > connections.size()) {
            return "This location does not exist.";
        }

        Location newLocation = gameWorld.findLocation(connections.get(choice - 1));
        gameWorld.setCurrentLocation(newLocation);

        return "You moved to: " + newLocation.getName() + "\n" +
                newLocation.getDescription();
    }
}

