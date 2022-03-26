package standardEdition.exception;

import java.util.logging.Logger;

/**
 * @Author: jiegege
 * @Date: 2022/3/20 5:09 PM
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class logger {

    //private static final LogUtil

    private static final Logger LOGGER = Logger.getLogger("adapter");

    public static void main(String[] args) {
        LOGGER.info("fe");
    }
}
