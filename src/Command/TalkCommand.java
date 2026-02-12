package Command;

import Dialogs.Dialog;
import Locations.Location;
import Game.GameWorld;

import java.util.Scanner;

/**
 * Allows te player to talk with NPCs
 * Checks if theres anyone to talk to
 * By the content of the dialog it finds out if its talking to Jezibaba or anuone else
 * Talking to Jezibaba makes TalkedToJezibab true so the player can move forwartd from the swamps
 * Other dialogs are just normal dialogs, no biggie if you dont talk with them
 * @author Denis Vesely
 */
public class TalkCommand implements Command {

    private final GameWorld gameWorld;
    private final Scanner scanner;

    public TalkCommand(GameWorld gameWorld, Scanner scanner) {
        this.gameWorld = gameWorld;
        this.scanner = scanner;
    }

    /**
     * Executes talk command
     * searches for dialog in the current location, if none fond it informs the user
     * If the dialog has a qeustion is triggers the Jezibaba dialog
     * If its just a normal dialog, it triggers the other dialogs, which you dont have to trigger to progress
     * @return a dialog text or a message sayign theres no one to talk to
     */
    @Override
    public String execute() {
        Location loc = gameWorld.getCurrentLocation();


        Dialog d = null;

        for (Dialog c : gameWorld.getDialogs()) {
            if (c.getLocationId().equals(loc.getId())) {
                d = c;
                break;
            }
        }

        if (d == null) {
            return "No one to talk to.";
        }

        if (d.getQuestion() != null && d.getCorrectAnswer() != null) {
            System.out.println(d.getLinesBefore());
            System.out.println(d.getQuestion());
            System.out.print("> ");

            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase(d.getCorrectAnswer().trim())) {
                System.out.println(d.getSuccessLines());

                if (d.getNpcId().equals("baba_mocalnice")) {
                    gameWorld.setTalkedToJezibaba(true);
                }
            } else {
                System.out.println(d.getFailLines());
            }
            return "";
        }

        if (d.getLines() != null && !d.getLines().isBlank()) {
            return d.getLines();
        }

        return "He got nothing to say";
    }
}
