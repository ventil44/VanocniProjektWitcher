package Items;


/**
 * Abstract class representing items
 * Abstract because z toho dedi potion a weapon
 * @author Denis Vesely
 */
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
