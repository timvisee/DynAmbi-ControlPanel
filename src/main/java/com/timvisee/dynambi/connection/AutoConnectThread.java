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

package com.timvisee.dynambi.connection;

import jssc.SerialPortList;

import java.util.Arrays;

public class AutoConnectThread extends Thread {

    /**
     * Thread name.
     */
    private static final String THREAD_NAME = "Auto connect polling thread";

    /**
     * Sleep delay of the thread in milliseconds.
     */
    private static final int THREAD_SLEEP_DELAY = 1000;

    /**
     * Constructor.
     *
     * @param connectionManager Connection manager instance.
     */
    public AutoConnectThread(final ConnectionManager connectionManager) {
        // Call the super, and create the runnable
        super(() -> {
            try {
                // Flag to define whether whether we've run the loop before
                boolean firstRun = true;

                // Keep polling
                while(true) {
                    // Sleep for a while if this isn't the first run
                    if(!firstRun)
                        Thread.sleep(THREAD_SLEEP_DELAY);
                    else
                        firstRun = false;

                    // Continue if something is already connected, if no port name is given or if auto connection is disabled
                    if(!connectionManager.isAutoConnect() || !connectionManager.hasPortName() || connectionManager.isConnected())
                        continue;

                    // Make sure the given port name is available
                    if(!Arrays.asList(SerialPortList.getPortNames()).contains(connectionManager.getPortName()))
                        continue;

                    try {
                        // Try to connect to the specified port
                        connectionManager.connect();

                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }

            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }, THREAD_NAME);
    }
}
