package com.lighty.ifruit;

import com.lighty.ifruit.objects.Phone;
import de.leonhard.storage.Json;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public final class IFruitPlugin extends JavaPlugin {

    @Getter private static IFruitPlugin instance;

    @Getter private static Json phonesJson;
    @Getter private static Json providersJson;

    @Getter private static HashMap<UUID, Phone> phones;
    @Getter private static HashMap<Phone, Phone> calls;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        phonesJson = new Json(new File("/plugins/IFruit/Phones"));
        providersJson = new Json(new File("/plugins/IFruit/SIMProviders"));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
