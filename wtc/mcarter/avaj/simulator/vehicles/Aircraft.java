package wtc.mcarter.avaj.simulator.vehicles;

import wtc.mcarter.avaj.simulator.Logger;
import wtc.mcarter.avaj.simulator.WeatherTower;
import wtc.mcarter.avaj.weather.Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        idCounter++;
        return idCounter;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "#" + name + "(" + id + ")";
    }

    public void writeLandingMessage() {
        Logger.gL().writeMessage(this.toString() + " landing at Y:" + coordinates.getLongitude() + " X:"
                + coordinates.getLatitude() + " Z:" + coordinates.getHeight() + ".");
    }

    public void writeStatusMessage(WeatherTower weatherTower) {
        Logger.gL().writeAircraftMessage(this.toString(), "Status update: experiencing " + weatherTower._getWeather(coordinates).name() + ".");
    }
}
