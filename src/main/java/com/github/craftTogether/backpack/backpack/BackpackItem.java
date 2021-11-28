package com.github.craftTogether.backpack.backpack;

import com.github.craftTogether.backpack.Plugin;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class BackpackItem {

    public static ItemStack backpack;
    private static final NamespacedKey namespacedKey = new NamespacedKey(Plugin.getInstance(), "backpack");

    public static void createItem() {
        final ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(PlainTextComponentSerializer.plainText().deserialize(ChatColor.GRAY + "Backpack"));
        itemStack.setItemMeta(itemMeta);
        backpack = itemStack;
    }

    public static ShapedRecipe getRecipe() {
        final ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, backpack);
        shapedRecipe.shape("AAA", "ABA", "AAA");
        shapedRecipe.setIngredient('A', Material.LEATHER);
        shapedRecipe.setIngredient('B', Material.ENDER_CHEST);

        return shapedRecipe;
    }

}
