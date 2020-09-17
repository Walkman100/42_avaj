package wtc.mcarter.avaj.simulator;

public class Logger {
    private static Logger logger;
    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }

        return logger;
    }

    public void close() {
        //
    }
}
