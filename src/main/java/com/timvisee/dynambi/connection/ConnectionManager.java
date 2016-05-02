package com.timvisee.dynambi.connection;

import jssc.SerialPort;
import jssc.SerialPortList;

public class ConnectionManager {

    /**
     * Connected LED strip.
     */
    private StripConnection strip;

    /**
     * Constructor.
     */
    public ConnectionManager() { }

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
     * Get the connected LED strip.
     *
     * @return Connected LED strip.
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
    public String[] listPorts() {
        return SerialPortList.getPortNames();
    }
}
