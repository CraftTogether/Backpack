package com.github.x3rition.backpack.backpack;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BackpackItem {
    public static ItemStack backpack;

    public static void init() {
        createBackpack();
    }

    private static void createBackpack() {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("&2Backpack");
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, false);
        backpack = item;
    }
}
