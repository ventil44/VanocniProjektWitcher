package Command;

import Dialogs.Dialog;
import Locations.Location;
import Game.GameWorld;

import java.util.Scanner;

public class TalkCommand implements Command {

    private final GameWorld gameWorld;
    private final Scanner scanner;

    public TalkCommand(GameWorld gameWorld, Scanner scanner) {
        this.gameWorld = gameWorld;
        this.scanner = scanner;
    }

    @Override
    public String execute() {
        Location loc = gameWorld.getCurrentLocation();


        Dialog d = null;

        for (Dialog candidate : gameWorld.getDialogs()) {
            if (candidate.getLocationId().equals(loc.getId())) {
                d = candidate;
                break;
            }
        }

        if (d == null) {
            return "Není tu nikdo, s kým by se dalo mluvit.";
        }

        if (d.getQuestion() != null && d.getCorrectAnswer() != null) {
            if (d.getLinesBefore() != null) System.out.println(d.getLinesBefore());
            System.out.println(d.getQuestion());
            System.out.print("> ");

            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase(d.getCorrectAnswer().trim())) {
                if (d.getSuccessLines() != null) System.out.println(d.getSuccessLines());

                if (d.getNpcId().equals("baba_mocalnice")) {
                    gameWorld.setTalkedToJezibaba(true);
                }
            } else {
                if (d.getFailLines() != null) System.out.println(d.getFailLines());
            }
            return "";
        }

        if (d.getLines() != null && !d.getLines().isBlank()) {
            return d.getLines();
        }

        return "Tato postava nemá co říct.";
    }
}
