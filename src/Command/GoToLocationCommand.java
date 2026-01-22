package Command;

import Game.GameWorld;
import Locations.Location;
import Player.Player;

import java.util.List;
import java.util.Scanner;

public class GoToLocationCommand implements Command {

    private GameWorld gameWorld;
    private Scanner scanner;

    public GoToLocationCommand(GameWorld gameWorld, Scanner scanner) {
        this.gameWorld = gameWorld;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        Location current = gameWorld.getCurrentLocation();
        List<String> connections = current.getConnectedLocations();

        if (connections.isEmpty()) {
            System.out.println("There are no locations to go to.");
            return;
        }

        System.out.println("Where do you want to go?");
        for (int i = 0; i < connections.size(); i++) {
            Location loc = gameWorld.findLocation(connections.get(i));
            System.out.println((i + 1) + ") " + loc.getName());
        }

        System.out.print("> ");
        int choice;

        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        if (choice < 1 || choice > connections.size()) {
            System.out.println("This location does not exist.");
            return;
        }

        Location newLocation = gameWorld.findLocation(connections.get(choice - 1));
        gameWorld.setCurrentLocation(newLocation);

        System.out.println("You moved to: " + newLocation.getName());
        System.out.println(newLocation.getDescription());
    }
}

