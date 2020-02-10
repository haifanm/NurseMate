package com.example.haifa.nursemate;

public interface QRDataListener {
    /**
     * On detected.
     *
     * @param data
     *     the data
     */
    // Called from not main thread. Be careful
    void onDetected(final String data);
}
