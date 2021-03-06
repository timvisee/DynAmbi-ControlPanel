/*
 * Copyright (c) Tim Visee 2016. All rights reserved.
 *
 * @author Tim Visee
 * @website http://timvisee.com/
 *
 * Open Source != No Copyright
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * You should have received a copy of The MIT License (MIT) along with this
 * program. If not, see <http://opensource.org/licenses/MIT/>.
 */

package com.timvisee.dynambi;

import com.timvisee.dynambi.connection.ConnectionManager;
import com.timvisee.dynambi.worker.Worker;

public class Core {

    /**
     * Core instance.
     */
    private static Core instance;

    /**
     * Connection manager instance.
     */
    private ConnectionManager connectionManager;

    /**
     * Worker instance.
     */
    private Worker worker;

    /**
     * Get the core instance.
     *
     * @return Core instance.
     */
    public static Core getInstance() {
        return instance;
    }

    /**
     * Initialize.
     */
    public void init() {
        // Set the core instance
        instance = this;

        // Show a status message
        System.out.println("Initializing " + DynAmbi.APP_NAME + "...");

        // Instantiate the connection manager
        System.out.println("Initializing connection manager...");
        this.connectionManager = new ConnectionManager();

        // Set the preferred serial port on the connection manager
        this.connectionManager.setPortName(Globals.DEFAULT_SERIAL_PORT_NAME);

        // Instantiate worker
        System.out.println("Initializing worker...");
        this.worker = new Worker();

        // TODO: Close the serial connection if the connection is lost
    }

    /**
     * Get the connection manager.
     *
     * @return Connection manager.
     */
    public ConnectionManager getConnectionManager() {
        return this.connectionManager;
    }

    /**
     * Get the worker.
     *
     * @return The worker.
     */
    public Worker getWorker() {
        return this.worker;
    }
}
