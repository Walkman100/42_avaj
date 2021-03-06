package wtc.mcarter.avaj.simulator;

import java.util.ArrayList;
import wtc.mcarter.avaj.simulator.vehicles.Flyable;

public class Tower {
    private ArrayList<Flyable> observers;

    public Tower() {
        observers = new ArrayList<>();
    }

    public void register(Flyable flyable) {
        Logger.gL().writeTowerRegistered(flyable.toString());
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        Logger.gL().writeTowerUnregistered(flyable.toString());
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        ArrayList<Flyable> _observers = new ArrayList<>(observers);

        for (Flyable flyable : _observers) {
            flyable.updateConditions();
        }
    }
}
