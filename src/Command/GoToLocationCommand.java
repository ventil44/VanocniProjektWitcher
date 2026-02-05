package Command;

import Characters.Enemy;
import Game.GameWorld;
import Locations.Location;

import java.util.ArrayList;
import java.util.Scanner;

public class GoToLocationCommand implements Command {

    private final GameWorld gameWorld;
    private final Scanner scanner;

    public GoToLocationCommand(GameWorld gameWorld, Scanner scanner) {
        this.gameWorld = gameWorld;
        this.scanner = scanner;
    }

    /**
     * Executes the command to move the player to a connected location.
     * Gets current location, if there are no connect, prints a message and exits
     * Displays a list of location the player can go to, player chooses by numbers
     * If the input is not a number or isnt within the range, prints a message and exits
     * If the input is valid, player moves the location they chose, prints its name and description
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

        if (connections.isEmpty()) {
            System.out.println("There are no locations to go to.");
            return "";
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
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return "";
        }

        if (choice < 1 || choice > connections.size()) {
            System.out.println("This location does not exist.");
            return "";
        }

        Location newLocation = gameWorld.findLocation(connections.get(choice - 1));
        gameWorld.setCurrentLocation(newLocation);

        return "You moved to: " + newLocation.getName() + "\n" +
                newLocation.getDescription();
    }
}

