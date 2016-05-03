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

package com.timvisee.dynambi.worker;

import com.timvisee.dynambi.Core;
import jssc.SerialPort;
import jssc.SerialPortException;

public class WorkerThread extends Thread {

    /**
     * Thread name.
     */
    private static final String THREAD_NAME = "Worker thread";

    /**
     * Sleep delay of the thread when it's idling.
     */
    private static final int THREAD_IDLE_SLEEP_DELAY = 1000;

    /**
     * Constructor.
     */
    public WorkerThread() {
        super(() -> {
            // Show a status message
            System.out.println(THREAD_NAME + " started");

            try {
                int i = 0;

                // Keep looping
                while(true) {
                    // Idle the thread if we're not connected
                    if(!Core.getInstance().getConnectionManager().isConnected()) {
                        Thread.sleep(THREAD_IDLE_SLEEP_DELAY);
                        continue;
                    }

                    // Get the connected strip
                    SerialPort strip = Core.getInstance().getConnectionManager().getStrip().getPort();

                    try {

                        // Send the header
                        strip.writeString("oz");

                        strip.writeInt((int) (Math.random() * 127.0));
                        strip.writeInt((int) (Math.random() * 127.0));
                        strip.writeInt((int) (Math.random() * 127.0));

                        strip.writeInt((int) (Math.random() * 127.0));
                        strip.writeInt((int) (Math.random() * 127.0));
                        strip.writeInt((int) (Math.random() * 127.0));

                        strip.writeInt((int) (Math.random() * 127.0));
                        strip.writeInt((int) (Math.random() * 127.0));
                        strip.writeInt((int) (Math.random() * 127.0));

                        strip.writeInt((int) (Math.random() * 127.0));
                        strip.writeInt((int) (Math.random() * 127.0));
                        strip.writeInt((int) (Math.random() * 127.0));

                        // Send the footer
                        strip.writeInt(130);

                        // Sleep for a little
                        Thread.sleep(500);

                    } catch(SerialPortException e) {
                        e.printStackTrace();
                    }
                }

            } catch(InterruptedException e) {
                e.printStackTrace();
            }

        }, THREAD_NAME);
    }
}
