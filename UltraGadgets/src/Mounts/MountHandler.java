package Mounts;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.floodeer.gadgets.Main;

public class MountHandler implements Listener {
	
	  static Main plugin = Main.getMain();
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
	      ((Horse)pet.get(paramPlayer.getUniqueId())).remove();
	      pet.remove(paramPlayer.getUniqueId());
	      pet.remove(paramPlayer.getUniqueId());
	    }else{
	      return;
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
		  }
	  }
}
