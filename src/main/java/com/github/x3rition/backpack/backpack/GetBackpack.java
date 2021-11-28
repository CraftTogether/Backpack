package com.github.x3rition.backpack.backpack;

import com.github.x3rition.backpack.backpack.BackpackItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetBackpack implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (command.getName().equalsIgnoreCase("backpack")) {
            Player player = (Player) sender;
            player.getInventory().addItem(BackpackItem.backpack);
        }
        return true;
    }
}
