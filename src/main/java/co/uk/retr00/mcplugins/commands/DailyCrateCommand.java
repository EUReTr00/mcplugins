package co.uk.retr00.mcplugins.commands;

import co.uk.retr00.mcplugins.builders.ItemBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public class DailyCrateCommand implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("daily")){

            if (!player.hasPermission("command.daily")) {
                player.sendMessage(MiniMessage.miniMessage().deserialize("<#ff0000>You do not have access to that command."));
                return true;
            }

            int chance = 10;
            if (player.hasPermission("command.daily.boost")) {chance = 5;}

            int number = ThreadLocalRandom.current().nextInt(chance+1);

            player.sendMessage("test.");

        }

        return true;
    }


}
