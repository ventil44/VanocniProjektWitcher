package Game;

import Locations.Location;
import java.util.ArrayList;
import Player.Player;

public class GameWorld {

    private ArrayList<Location> locations;
    private Location currentLocation;

    public GameWorld(GameData data, String startLocationId) {
        this.locations = data.locations;
        this.currentLocation = findLocation(startLocationId);

    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    /**
     * Finds a specific location by its identifier.
     * @param id the identifier of the location to be found
     * @return the matching location
     */
    public Location findLocation(String id) {
        for (Location l : locations) {
            if (l.getId().equals(id)){
                return l;
            }
        }
        throw new IllegalArgumentException("Location not found: " + id);
    }




}


