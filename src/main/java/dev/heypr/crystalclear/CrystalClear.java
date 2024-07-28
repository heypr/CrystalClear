package dev.heypr.crystalclear;

import dev.heypr.crystalclear.commands.ToggleCrystalsCommand;
import dev.heypr.crystalclear.listeners.CrystalDamageListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CrystalClear extends JavaPlugin implements Listener {

    public boolean isFastCrystalsEnabled = true;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new CrystalDamageListener(this), this);
        getCommand("togglecrystals").setExecutor(new ToggleCrystalsCommand(this));
        getLogger().info("Crystals will now be immediately destroyed.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Crystals will now no longer be immediately destroyed.");
    }
}
