package wtc.mcarter.avaj.simulator;

public class Logger {
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

    public void close() {
        //
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
        System.out.println(message);
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
