package co.uk.retr00.mcplugins.commands;

import co.uk.retr00.mcplugins.builders.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public class FreeXpCommand implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String @NotNull [] args) {

        if (command.getName().equalsIgnoreCase("freexp")){

            if (sender instanceof Player player) {

                int number = ThreadLocalRandom.current().nextInt(10);

                Inventory gui = Bukkit.createInventory(null, 27, Component.text("Help GUI"));

                gui.setItem(11,
                        new ItemBuilder(Material.DIAMOND)
                                .name("<#ff0000>Test")
                                .build()
                );
            }
        }

        return true;
    }

}
