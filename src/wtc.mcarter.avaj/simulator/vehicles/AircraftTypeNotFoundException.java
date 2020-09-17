package wtc.mcarter.avaj.simulator.vehicles;

public class AircraftTypeNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public AircraftTypeNotFoundException(String type) {
        super("Aircraft type \"" + type + "\" not found!");
    }
}
