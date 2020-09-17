package wtc.mcarter.avaj.simulator.vehicles;

import wtc.mcarter.avaj.weather.Coordinates;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws AircraftTypeNotFoundException {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        switch (type) {
            case "JetPlane":
                return new JetPlane(name, coordinates);
            case "Helicopter":
                return new Helicopter(name, coordinates);
            case "Balloon":
            case "Baloon":
                return new Balloon(name, coordinates);
            default:
                throw new AircraftTypeNotFoundException(type);
        }
    }
}
