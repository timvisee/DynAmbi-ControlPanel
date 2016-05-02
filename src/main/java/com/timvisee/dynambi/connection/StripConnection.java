package com.timvisee.dynambi.connection;

import jssc.SerialPort;

public class StripConnection {

    /**
     * The serial port this LED strip is connected to.
     */
    private final SerialPort port;

    /**
     * Constructor.
     *
     * @param port Serial port, must be opened.
     *
     * @throws Exception Throws if the serial port hasn't been opened yet.
     */
    public StripConnection(SerialPort port) throws Exception {
        // Set the serial port
        this.port = port;

        // Make sure the serial port is opened
        if(!port.isOpened())
            throw new Exception("Serial port hasn't been opened yet!");
    }

    /**
     * Get the serial port.
     *
     * @return Serial port.
     */
    public SerialPort getPort() {
        return this.port;
    }
}
