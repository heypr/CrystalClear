package dev.heypr.crystalclear.listeners;

import dev.heypr.crystalclear.CrystalClear;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class CrystalDamageListener implements Listener {

    private final CrystalClear plugin;

    public CrystalDamageListener(CrystalClear plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
        if (!plugin.isFastCrystalsEnabled) return;
        if (event.getDamager() instanceof Player player && event.getEntity() instanceof EnderCrystal crystalEntity) {
            removeEntity(player, crystalEntity);
        }
    }

    public void removeEntity(Player player, Entity crystalEntity) {
        ((CraftPlayer) player).getHandle().connection.send(new ClientboundRemoveEntitiesPacket(crystalEntity.getEntityId()));
    }
}
