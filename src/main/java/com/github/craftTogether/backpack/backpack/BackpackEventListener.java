package com.github.craftTogether.backpack.backpack;

import com.github.craftTogether.backpack.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class BackpackEventListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getItem() == null) return;
        if (!event.getItem().equals(BackpackItem.backpack)) return;
        final Player player = event.getPlayer();
        final Backpack backpack = Plugin.getInstance().getBackpackManager().getBackpack(player.getUniqueId());
        player.openInventory(backpack.getInventory());
    }
}