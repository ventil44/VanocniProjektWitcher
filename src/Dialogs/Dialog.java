package Dialogs;

import java.util.ArrayList;

/**
 * Represents dialogs
 * @author Denis Vesely
 */
public class Dialog {

    private String id;
    private String npcId;
    private String locationId;

    private String lines;

    private String linesBefore;
    private String question;
    private String correctAnswer;
    private String successLines;
    private String failLines;

    public String getId() { return id; }
    public String getNpcId() { return npcId; }
    public String getLocationId() { return locationId; }

    public String getLines() { return lines; }

    public String getLinesBefore() { return linesBefore; }
    public String getQuestion() { return question; }
    public String getCorrectAnswer() { return correctAnswer; }
    public String getSuccessLines() { return successLines; }
    public String getFailLines() { return failLines; }

}
