package com.timvisee.dynambi;

public class DynAmbi {

    /**
     * Application name.
     */
    public static final String APP_NAME = "DynAmbi Control Panel";

    /**
     * Application version name.
     */
    public static final String APP_VERSION_NAME = "0.1";

    /**
     * Application version code.
     */
    public static final int APP_VERSION_CODE = 1;

    /**
     * Get the full application name string, including the version number.
     *
     * @return Application name string.
     */
    public static String getNameFull() {
        return APP_NAME + " v" + APP_VERSION_NAME;
    }

    /**
     * Main method, called on start.
     *
     * @param args Start up arguments.
     */
    public static void main(String[] args) {
        // Print the application name and version
        System.out.println(getNameFull());

	    // Initialize the core
        Core core = new Core();
        core.init();
    }
}
