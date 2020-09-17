package wtc.mcarter.avaj.simulator;

import java.util.ArrayList;

import wtc.mcarter.avaj.simulator.vehicles.Flyable;

public class Tower {
    private ArrayList<Flyable> observers;

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        //
    }
}
