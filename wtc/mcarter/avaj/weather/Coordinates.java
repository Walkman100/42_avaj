package wtc.mcarter.avaj.weather;

import static java.lang.Math.*;

public class Coordinates {
    private int _longitude;
    private int _latitude;
    private int _height;

    public Coordinates(int longitude, int latitude, int height) {
        _longitude = max(longitude, 0);
        _latitude = max(latitude, 0);
        _height = min(max(height, 0), 100);
    }

    public int getLongitude() {
        return _longitude;
    }

    public int getLatitude() {
        return _latitude;
    }

    public int getHeight() {
        return _height;
    }
}
