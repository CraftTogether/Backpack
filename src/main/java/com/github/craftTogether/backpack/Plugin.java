package com.github.craftTogether.backpack;

import com.github.craftTogether.backpack.backpack.BackpackEventListener;
import com.github.craftTogether.backpack.backpack.BackpackItem;
import com.github.craftTogether.backpack.backpack.BackpackManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    private static Plugin INSTANCE;
    private Config config;
    private BackpackManager backpackManager;
    private ShapedRecipe backpack;

    public static Plugin getInstance() {
        return INSTANCE;
    }

    public Config getConfiguration() {
        return config;
    }

    public BackpackManager getBackpackManager() {
        return backpackManager;
    }

    @Override
    public void onEnable() {
        INSTANCE = this;
        config = new Config();
        backpackManager = new BackpackManager();

        BackpackItem.createItem();
        Bukkit.addRecipe(BackpackItem.getRecipe()); // Register recipe
        Bukkit.getPluginManager().registerEvents(new BackpackEventListener(), this);

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Backpack Plugin active");
    }


    @Override
    public void onDisable() {
        backpackManager.save();
        config.save();
    }
}
