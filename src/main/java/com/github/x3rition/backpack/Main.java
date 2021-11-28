package com.github.x3rition.backpack;

import com.github.x3rition.backpack.backpack.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    private static Main instance;
    private Config config;
    private BackpackManager backpackManager;
    private ShapedRecipe backpack;


    @Override
    public void onLoad() {
        instance = this;
        config = new Config();
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.addRecipe(getBackpackCraft());

        BackpackItem.init();

        Objects.requireNonNull(getCommand("backpack")).setExecutor(new GetBackpack());

        backpackManager = new BackpackManager();
        PluginManager manager = Bukkit.getPluginManager();

        manager.registerEvents(new BackpackOpener(), this);

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + " Backpack Plugin active");
    }

    public ShapedRecipe getBackpackCraft() {
        ItemStack itemStack = new ItemStack(Material.CLOCK);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(ChatColor.BLUE + "Backpack");
        itemMeta.addEnchant(Enchantment.LURE, 1, false);

        NamespacedKey namespacedKey = new NamespacedKey(this, "backpack");
        ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, itemStack);

        shapedRecipe.shape("ABA", "BCB", "ABA");
        shapedRecipe.setIngredient('A', Material.CHEST);
        shapedRecipe.setIngredient('B', Material.LEATHER);
        shapedRecipe.setIngredient('C', Material.ENDER_PEARL);

        return shapedRecipe;
    }

    @Override
    public void onDisable() {

        backpackManager.save();
        config.save();

    }


    public static Main getInstance() {
        return instance;
    }

    public Config getConfiguration() {
        return config;
    }

    public BackpackManager getBackpackManager() {
        return backpackManager;
    }
}
