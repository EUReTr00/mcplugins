package co.uk.retr00.mcplugins.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ServerHelpGUI implements CommandExecutor {

    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String @NotNull [] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            Inventory gui = Bukkit.createInventory(null, 27, Component.text("Help GUI"));
            gui.setItem(13, new ItemStack(Material.GRASS_BLOCK));

            player.openInventory(gui);

        }

        return true;
    }

}
