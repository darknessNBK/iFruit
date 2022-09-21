package com.lighty.ifruit.objects;

import lombok.Getter;
import org.bukkit.Location;

public class TransceiverStation {
    @Getter Location location;
    @Getter private SIMProvider provider;
    @Getter private int signalStrength;

    public TransceiverStation(Location location, SIMProvider provider, int signalStrength) {
        this.location = location;
        this.provider = provider;
        this.signalStrength = signalStrength;
    }
}
