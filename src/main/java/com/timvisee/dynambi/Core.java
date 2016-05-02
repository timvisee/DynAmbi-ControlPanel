package com.timvisee.dynambi;

import com.timvisee.dynambi.connection.ConnectionManager;

public class Core {

    /**
     * Connection manager instance.
     */
    private ConnectionManager connectionManager = new ConnectionManager();

    /**
     * Initialize.
     */
    public void init() {
        // Show a status message
        System.out.println("Initializing " + DynAmbi.APP_NAME + "...");
    }

    /**
     * Get the connection manager.
     *
     * @return Connection manager.
     */
    public ConnectionManager getConnectionManager() {
        return this.connectionManager;
    }
}
