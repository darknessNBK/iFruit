package com.lighty.ifruit.utils;

import com.lighty.ifruit.objects.Phone;
import com.lighty.ifruit.objects.SIMProvider;
import com.lighty.ifruit.objects.TransceiverStation;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Methods {

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static Player getPhoneOwner(Phone phone) {
        return Bukkit.getPlayer(phone.getOwner());
    }

    public static Phone getPhoneByNumber(int number) {
        for (Phone phone : com.lighty.ifruit.IFruitPlugin.getPhones().values()) {
            if (phone.getNumber() == number) {
                return phone;
            }
        }
        return null;
    }

    public static Phone getPhoneByOwner(Player player) {
        for (Phone phone : com.lighty.ifruit.IFruitPlugin.getPhones().values()) {
            if (phone.getOwner().equals(player.getUniqueId())) {
                return phone;
            }
        }
        return null;
    }

    public static TransceiverStation getNearestTransceiver(SIMProvider provider, Location location) {
        ArrayList<TransceiverStation> transceiverStations = provider.getTransceiverStations();

        TransceiverStation nearestTransceiver = null;
        double nearestDistance = 0;

        for(TransceiverStation transceiverStation : transceiverStations) {
            double distance = transceiverStation.getLocation().distance(location);
            if(nearestTransceiver == null) {
                nearestTransceiver = transceiverStation;
                nearestDistance = distance;
            } else {
                if(distance < nearestDistance) {
                    nearestTransceiver = transceiverStation;
                    nearestDistance = distance;
                }
            }
        }

        return nearestTransceiver;
    }

    public static int scaleDistanceToSignal(double distance) {
        if(distance <= 100) {
            return 5;
        } else if(distance <= 200) {
            return 4;
        } else if(distance <= 300) {
            return 3;
        } else if(distance <= 400) {
            return 2;
        } else if(distance <= 500) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int getSignalStrength(Player player) {
        Phone phone = getPhoneByOwner(player);
        if(phone == null) return 0;
        if(!phone.isOn()) return 0;
        if(phone.getProvider() == null) return 0;

        Location playerLocation = player.getLocation();
        TransceiverStation nearestTransceiver = getNearestTransceiver(phone.getProvider(), playerLocation);

        return scaleDistanceToSignal(playerLocation.distance(nearestTransceiver.getLocation()));
    }


}
