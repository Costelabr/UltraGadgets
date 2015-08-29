package EventManager;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

import Menus.DisguiseMenu;
import Update.SchedulerEvent;
import Update.SchedulerType;
import Utils.FireworkNMSHandler;
import Utils.ParticleEffect;
import Utils.UtilCooldown;
import Utils.UtilParticle;
import Utils.UtilVelocity;
import Utils.UtilParticle.ParticleType;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class DisguisesEvent extends FireworkNMSHandler implements Listener{
	 
	UltraGadgets plugin = UltraGadgets.getMain();
	
	@EventHandler
	public void onPlayerClick(PlayerInteractEvent e) {
		if(e.getAction() != Action.LEFT_CLICK_AIR) {
			return;
		}
		Player p = (Player)e.getPlayer();
		if(!plugin.getDisguiseMenu().hasDisguise(p)) return;
		if(DisguiseMenu.disguiseType.get(p.getUniqueId()) == "Enderman" && 
		p.hasPermission("enderman.teleport")) {
			 
		 Location l = plugin.getUtilLocation().getTargetBlock(p, 50);
		 if(l.getBlock().getType() != Material.AIR) {
			 p.teleport(l.add(0, 1, 0));
			 p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
		 }
	   }
		if(DisguiseMenu.disguiseType.get(p.getUniqueId()) == "WitherSkeleton") {
			if(UtilCooldown.tryCooldown(p, "WSkull", 2000)) {
			WitherSkull w = p.launchProjectile(WitherSkull.class);
			w.setMetadata("SkullLaunch", new FixedMetadataValue(plugin, null));
			w.setIsIncendiary(false);
		}else{
			p.sendMessage(plugin.getMessagesFile().otherCooldown);
		}
	 }
	
	}
	
	@EventHandler
	public void toggle(PlayerToggleSneakEvent e) {
		Player p = (Player)e.getPlayer();
		if(!p.isSneaking()) {
		if(DisguiseMenu.disguiseType.get(p.getUniqueId()) == "Creeper") {
			if(UtilCooldown.tryCooldown(p, "Creeper", 5000)) {
			ParticleEffect.EXPLOSION_HUGE.display(0, 0, 0, 1, 150, p.getLocation(), 50.0D);
            p.playSound(p.getLocation(), Sound.EXPLODE, 5, 1);
			  for (Entity entity : p.getNearbyEntities(8, 2, 8)) {
			         if (entity instanceof Player) {
			             final Player nearbyPlayer = (Player)entity;
			             nearbyPlayer.setVelocity(p.getLocation().getDirection().multiply(0.3).add(new Vector(0.0, 1.2, 0.0)));
			             nearbyPlayer.playSound(p.getLocation(), Sound.EXPLODE, 5, 1);

			         }
			     }
			}else{
				p.sendMessage(plugin.getMessagesFile().otherCooldown);
		}
	  }
   }
}
	
	@EventHandler
	public void update(SchedulerEvent e) {
	  if(e.getType() == SchedulerType.TICK) {
		for(Player player : Bukkit.getOnlinePlayers()) {
			if(DisguiseMenu.disguiseType.get(player.getUniqueId()) == "Blaze") {
			  if (player.isSneaking()) {
			      player.leaveVehicle();
			        player.eject(); 
			          new UtilParticle(ParticleType.FLAME, 0.05000000074505806D, 2, 0.30000001192092896D).sendToLocation(player.getLocation().add(0.0D, 0.5D, 0.0D));
			           new UtilParticle(ParticleType.SMOKE_LARGE, 0.05000000074505806D, 2, 0.30000001192092896D).sendToLocation(player.getLocation().add(0.0D, 0.20000000298023224D, 0.0D));
			            UtilVelocity.velocity(player, 0.8D, 0.1D, 1.0D, true);
			            player.setAllowFlight(true);
			   }
		  }
	  }
	}
} 
	
	@EventHandler
	public void explode(final EntityExplodeEvent e) {
		if(e.getEntity() instanceof WitherSkull) {
			if(e.getEntity().hasMetadata("SkullLaunch")) {
				e.setCancelled(true);
				 try {
					playFirework(e.getEntity().getLocation(), FireworkEffect.builder().withColor(Color.BLACK).withColor(Color.WHITE).build());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	@EventHandler
	public void damage(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof WitherSkull) {
			if(e.getDamager().hasMetadata("SkullLaunch")) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void updateFly(PlayerToggleFlightEvent e) {
		if(DisguiseMenu.disguiseType.get(e.getPlayer()) == "Blaze") {
			e.setCancelled(true);
		}
	}
}
