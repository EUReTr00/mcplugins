package co.uk.retr00.mcplugins.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public class ServerHelpGUI implements CommandExecutor, Listener {

    private ItemStack itemBuilder(Material material, Boolean glow, String name, String... loreLines) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return item;

        meta.displayName(MiniMessage.miniMessage().deserialize(name));
        if (glow) {
            meta.addEnchant(Enchantment.UNBREAKING, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        if (loreLines != null && loreLines.length > 0) {
            meta.lore(
                    java.util.Arrays.stream(loreLines)
                            .map(line -> MiniMessage.miniMessage().deserialize(line))
                            .toList()
            );
        }

        item.setItemMeta(meta);
        return item;
    }

    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String @NotNull [] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            Inventory gui = Bukkit.createInventory(null, 27, Component.text("Help GUI"));


            gui.setItem(11, itemBuilder(
                    Material.DIAMOND,true,"<blue><b>Free Diamond","<white>Click for free diamond.","<white>Or... not."
            ));

            player.openInventory(gui);

        }

        return true;

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().title().equals(Component.text("Help GUI"))) {
            return;
        }

        if (event.getRawSlot() == 11) {
            Player player = (Player) event.getWhoClicked();

            if (player.hasPermission("permisison.luck")) {
                int number = ThreadLocalRandom.current().nextInt(5);

                if (number == 4) {
                    player.sendMessage("You got lucky!");
                    player.give(ItemStack.of(Material.DIAMOND, 5));
                } else {
                    player.sendMessage("Unlucky, try again soon.");
                    player.giveExp(10);
                }
            } else {
                player.sendMessage("You don't have access to this command.");
            }

            event.setCancelled(true);

        }
    }

}
