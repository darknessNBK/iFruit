package com.lighty.ifruit.objects;

import lombok.Getter;

import java.util.ArrayList;

public class SIMProvider {
    @Getter private String name;
    @Getter private ArrayList<TransceiverStation> transceiverStations;

    public SIMProvider(String name) {
        this.name = name;
        this.transceiverStations = new ArrayList<>();
    }
}
