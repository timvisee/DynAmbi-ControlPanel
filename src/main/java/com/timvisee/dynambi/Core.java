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
import com.timvisee.dynambi.connection.StripConnection;

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



        // TODO: Set target name
        // TODO: Option to automatically connect when target becomes available
        // TODO: Connect, safely. Properly disconnect and close the port if the connection is lost




        try {
            // Connect to the LED strip
            System.out.println("Connecting to LED strip at " + Globals.DEFAULT_COM_PORT + "...");
            StripConnection strip = this.connectionManager.connect(Globals.DEFAULT_COM_PORT);

            System.out.println("Connected to LED strip");

        } catch(Exception e) {
            e.printStackTrace();
        }
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
