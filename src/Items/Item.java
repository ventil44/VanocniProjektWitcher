package Items;

import Player.Player;

public abstract class Item {

    private String name;
    private String id;
    private String locationId;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getId() {
        return id;
    }

}
