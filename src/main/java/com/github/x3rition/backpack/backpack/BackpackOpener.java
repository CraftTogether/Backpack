package com.github.x3rition.backpack.backpack;

import com.github.x3rition.backpack.Main;
import com.github.x3rition.backpack.backpack.Backpack;
import com.github.x3rition.backpack.backpack.BackpackItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import java.util.Objects;

public class BackpackOpener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getItem() != BackpackItem.backpack){
            return;
        }
        if (Objects.requireNonNull(event.getItem()).getItemMeta().equals(BackpackItem.backpack.getItemMeta())) {
            Player player = event.getPlayer();
            Backpack backpack = Main.getInstance().getBackpackManager().getBackpack(player.getUniqueId());
            event.getPlayer().openInventory(backpack.getInventory());
        }
    }
}