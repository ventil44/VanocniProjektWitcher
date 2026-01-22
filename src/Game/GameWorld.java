package Game;

import Locations.Location;
import java.util.ArrayList;

public class GameWorld {

    private ArrayList<Location> locations;
    private Location currentLocation;

    public GameWorld(GameData data, String startLocationId) {
        this.locations = data.locations;
        this.currentLocation = data.findLocation(startLocationId);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public Location findLocation(String id) {
        for (Location l : locations) {
            if (l.getId().equals(id)) {
                return l;
            }
        }
        throw new IllegalArgumentException("Location not found: " + id);
    }
}


