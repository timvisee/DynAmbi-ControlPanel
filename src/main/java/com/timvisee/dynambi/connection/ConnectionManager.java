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

import jssc.SerialPort;
import jssc.SerialPortList;

public class ConnectionManager {

    /**
     * Serial port name to connect to.
     */
    private String portName;

    /**
     * Connected LED strip.
     */
    private StripConnection strip;

    /**
     * Constructor.
     */
    public ConnectionManager() { }

    /**
     * Constructor.
     *
     * @param portName Serial port name.
     */
    public ConnectionManager(String portName) {
        this.portName = portName;
    }

    /**
     * Connect to the strip on the given port.
     *
     * @return Strip connection instance.
     *
     * @throws Exception Throws if an error occurred.
     */
    public StripConnection connect() throws Exception {
        return connect(new SerialPort(this.portName));
    }

    /**
     * Connect to a strip.
     *
     * @param port Serial port to connect to.
     *
     * @return Strip connection instance.
     *
     * @throws Exception Throws if an error occurred.
     */
    public StripConnection connect(SerialPort port) throws Exception {
        // Store the serial port name
        this.portName = port.getPortName();

        // Open the serial port if it hasn't been opened yet
        if(!port.isOpened())
            port.openPort();

        // Set the serial port parameters
        port.setParams(SerialPort.BAUDRATE_115200,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);

        // Create a strip connection instance and set it
        this.strip = new StripConnection(port);

        // Return the connected strip
        return this.strip;
    }

    /**
     * Connect to a strip.
     *
     * @param portName Name of the serial port to connect to.
     *
     * @return Strip connection instance.
     *
     * @throws Exception Throws if an error occurred.
     */
    public StripConnection connect(String portName) throws Exception {
        return connect(new SerialPort(portName));
    }

    /**
     * Get the target port name.
     *
     * @return Serial port name.
     */
    public String getPortName() {
        return this.portName;
    }

    /**
     * Get the instance of the strip if connected.
     *
     * @return Connected LED strip instance, null if the strip isn't connected.
     */
    public StripConnection getStrip() {
        return this.strip;
    }

    /**
     * Check whether any LED strip is connected.
     *
     * @return True if any LED strip is connected, false if not.
     */
    public boolean isConnected() {
        return this.strip != null;
    }

    /**
     * Get a list of serial port names that are connected to this system.
     *
     * @return List of serial port names.
     */
    public static String[] listPorts() {
        return SerialPortList.getPortNames();
    }
}
