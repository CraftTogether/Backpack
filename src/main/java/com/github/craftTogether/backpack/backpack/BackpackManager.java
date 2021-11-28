package com.github.craftTogether.backpack.backpack;

import com.github.craftTogether.backpack.Config;
import com.github.craftTogether.backpack.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Stores a backpack for each user.
 */
public class BackpackManager {

    private final Map<UUID, Backpack> map = new HashMap<>();

    public BackpackManager() {
        try {
            final Config config = Plugin.getInstance().getConfiguration();
            Files.lines(config.getFile().toPath())
                    .map(line -> line.split(":", 2)[0])
                    .forEach(key -> {
                        try {
                            if (!key.equals("backpacks")) {
                                Bukkit.getConsoleSender().sendMessage(key);
                                final UUID uuid = UUID.fromString(key);
                                final String backpack = config.getConfig().getString(key);
                                map.put(uuid, new Backpack(uuid, backpack));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Backpack getBackpack(UUID uuid) {
        if (map.containsKey(uuid)) {
            return map.get(uuid);
        } else {
            final Backpack backpack = new Backpack(uuid);
            map.put(uuid, backpack);
            return backpack;
        }
    }

    public void setBackpack(UUID uuid, Backpack backpack) {
        map.put(uuid, backpack);
    }

    public void save() {
        final YamlConfiguration config = Plugin.getInstance().getConfiguration().getConfig();
        final ConfigurationSection backpacks = config.getConfigurationSection("backpacks");
        map.entrySet().forEach(entry -> {
            backpacks.set(entry.getKey().toString(), entry.getValue().toBase64());
        });
    }
}