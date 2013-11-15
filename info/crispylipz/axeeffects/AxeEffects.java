package info.crispylipz.axeeffects;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AxeEffects extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        super.onEnable();
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getLogger().info("AxeEffects has been enabled!");
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        final Entity target = event.getEntity();
        final Entity damager = event.getDamager();

        event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK);
        if (damager instanceof LivingEntity) {
            LivingEntity le = (LivingEntity) damager;

            if (le.getEquipment().getItemInHand().getType() == Material.DIAMOND_AXE) {
                target.getWorld().playEffect(target.getLocation(), Effect.POTION_SWIRL, 0);
            }
        }
    }


}