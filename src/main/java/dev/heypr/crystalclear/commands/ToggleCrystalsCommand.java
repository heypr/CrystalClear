package dev.heypr.crystalclear.commands;

import dev.heypr.crystalclear.CrystalClear;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ToggleCrystalsCommand implements CommandExecutor {

    private final CrystalClear plugin;

    public ToggleCrystalsCommand(CrystalClear plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (plugin.isFastCrystalsEnabled) {
            plugin.isFastCrystalsEnabled = false;
            sender.sendMessage("FastCrystals have been disabled.");
        }
        else {
            plugin.isFastCrystalsEnabled = true;
            sender.sendMessage("FastCrystals have been enabled.");
        }
        return true;
    }
}
