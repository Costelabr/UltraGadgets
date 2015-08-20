package Mounts;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import Core.UtilParticle;
import Core.UtilParticle.ParticleType;

import com.floodeer.gadgets.UltraGadgets;

public class MountHandler implements Listener {
	
	  static UltraGadgets plugin = UltraGadgets.getMain();
	  public static HashMap<UUID, Horse> pet = new HashMap<>();
	  
	  public static boolean HasPet(Player paramPlayer)
	  {
	    if (pet.containsKey(paramPlayer.getUniqueId())) {
	      return true;
	    }
	    return false;
	  }
	  
	  public static void removePlayerMount(Player paramPlayer)
	  {
	    if (pet.containsKey(paramPlayer.getUniqueId()))
	    {
	      (pet.get(paramPlayer.getUniqueId())).remove();
	      pet.remove(paramPlayer.getUniqueId());
	    }
	  }
	  
	  public static boolean isMountOwner(Player paramPlayer, Horse paramHorse)
	  {
	    Horse localHorse = (Horse)pet.get(paramPlayer.getUniqueId());
	    return (localHorse != null) && (localHorse.equals(paramHorse));
	  }
	  
	  @EventHandler
	  public void OnPlayerQuit(PlayerQuitEvent paramPlayerQuitEvent)
	  {
	    Player paramPlayer = paramPlayerQuitEvent.getPlayer();
	    if (HasPet(paramPlayer)) {
	      removePlayerMount(paramPlayer);
	    }
	  }
	  
	  @EventHandler
	  public void onPlayerDamage(EntityDamageEvent e) {
		  if(e.getEntity() instanceof Horse) {
			  Horse h = (Horse) e.getEntity();
			  if(h.hasMetadata("FrozenHorse")) {
				  e.setCancelled(true);
			  }
			  if(h.hasMetadata("InfernalHorse")) {
				  e.setCancelled(true);
			  }
		  }
	  }
	  
	  @EventHandler
	  public void onEntityMove(PlayerMoveEvent e) {
		  if (e.getTo().getBlockX() == e.getFrom().getBlockX() && e.getTo().getBlockY() == e.getFrom().getBlockY() && e.getTo().getBlockZ() == e.getFrom().getBlockZ()) {
			  return;
		  }
		  
		 Player p = (Player)e.getPlayer();
		 if(p.getLocation().getBlock().getType() == Material.SNOW || p.getLocation().getBlock().getType() == Material.SNOW_BLOCK) {
			new UtilParticle(ParticleType.SNOW_SHOVEL, 0.1F, 3, 0.4F).sendToLocation(p.getLocation());
			new UtilParticle(ParticleType.SNOWBALL, 0.1F, 3, 0.4F).sendToLocation(p.getLocation()); 
			new UtilParticle(ParticleType.CLOUD, 0.1F, 3, 0.4F).sendToLocation(p.getLocation()); 
		 }
	  }
}
