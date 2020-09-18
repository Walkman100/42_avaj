package wtc.mcarter.avaj.simulator;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
// #region static
    private static Logger logger;
    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }

        return logger;
    }

    public static Logger gL() {
        return getLogger();
    }
// #endregion

    private FileWriter fileWriter;

    public Logger() {
        try {
            fileWriter = new FileWriter("simulation.txt");
        } catch (IOException e) {
            writeLine("Couldn't create file 'simulation.txt' in the current directory!");
            System.exit(1);
        }
    }

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            writeLine("There was an error closing the log file!");
        }
    }

//#region Base
    /**
     * Writes a string to the standard output, followed by a newline
     */
    public void writeLine(String line) {
        System.out.println(line);
    }

    /**
     * Writes a message to the log file
     */
    public void writeMessage(String message) {
        try {
            fileWriter.write(message);
            fileWriter.write(System.lineSeparator());
        } catch (IOException e) {
            writeLine("Error writing to log file:");
            e.printStackTrace();
        }
    }
//#endregion

//#region aircraft/tower specific

    /**
     * Writes an aircraft log message to the log file
     */
    public void writeAircraftMessage(String aircraftDispName, String message) {
        writeMessage(aircraftDispName + ": " + message);
    }

    /**
     * Writes a tower message to the log file
     */
    public void writeTowerMessage(String message) {
        writeMessage("Tower says: " + message);
    }

    public void writeTowerRegistered(String aircraftDispName) {
        writeTowerMessage(aircraftDispName + " registered to weather tower.");
    }

    public void writeTowerUnregistered(String aircraftDispName) {
        writeTowerMessage(aircraftDispName + " unregistered from weather tower.");
    }
//#endregion
}
