package cn.ecook.base.base;

/**
 * @author mcjs001
 */
public class BaseConfig {
    public static boolean DEBUG = true;

    private BaseConfig() {
    }

    public static void init(boolean debug) {
        DEBUG = debug;
    }
}
