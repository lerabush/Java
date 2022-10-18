package example;

import java.util.logging.Logger;

public class MusicStrategyByDate implements MusicStrategy {
    private static final Logger LOGGER = Logger.getLogger(MusicStrategyByDate.class.getName());

    @Override
    public void execute() {
        LOGGER.info("Music playing by the date of adding");
    }

}
