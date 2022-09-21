package com.lighty.ifruit.objects;

import com.lighty.ifruit.IFruitPlugin;
import lombok.Getter;

import java.util.HashMap;
import java.util.UUID;

public class Phone {
    @Getter private UUID owner;
    @Getter private int number;
    @Getter private boolean isOn;
    @Getter private SIMProvider provider;

    @Getter private HashMap<Phone, String> contacts;
    @Getter private HashMap<Phone, String> messages;

    public Phone(UUID owner, int number, SIMProvider provider, boolean isOn) {
        this.owner = owner;
        this.number = number;
        this.provider = provider;
        this.isOn = isOn;

        this.contacts = new HashMap<>();
        this.messages = new HashMap<>();
    }

    private void addContact(Phone phone, String name) {
        contacts.put(phone, name);
    }

    private void removeContact(Phone phone) {
        contacts.remove(phone);
    }

    private void call(Phone phone) {
        if (phone.isOn()) {
            IFruitPlugin.getCalls().put(this, phone);
        }
    }

}
