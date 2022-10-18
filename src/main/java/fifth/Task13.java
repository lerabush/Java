package fifth;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.ConsoleHandler;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task13 {
    private static final String[] badWords = {"sex", "drag", "c++"};
    private static final Logger logger = getCustomLogger();

    private static Logger getCustomLogger() {
        Logger logger = Logger.getLogger("corejava.chapter5.lab13");
        logger.setFilter(createCustomFilter());
        return logger;
    }

    private static Filter createCustomFilter() {
        return record -> {
            String message = record.getMessage().toLowerCase();
            for (String badWord : badWords) {
                if (message.contains(badWord)) return false;
            }
            return true;
        };
    }

    public static void main(String[] args) {
        logger.log(Level.INFO, "Hello World");
        logger.log(Level.INFO, "sex");
        logger.log(Level.INFO, "World");
        logger.log(Level.INFO, "sosexy");
        logger.log(Level.INFO, "C++");
        logger.log(Level.INFO, "C/C++");
    }

}
