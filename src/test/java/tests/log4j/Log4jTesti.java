package tests.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jTesti {
    private static Logger logger=LogManager.getLogger(Log4jTesti.class.getName());

    @Test
    public void testlog4jTesti1() {
        logger.info("Log INFO");
        logger.debug("Log DEBUG");
        logger.error("Log ERROR");
        logger.fatal("Log FATAL");
    }
}
