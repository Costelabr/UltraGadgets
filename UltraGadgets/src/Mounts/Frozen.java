package Mounts;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.floodeer.gadgets.Main;

public class Frozen implements Listener {
	
	Main plugin = Main.getMain();
	
	
	@EventHandler
	public void onFrozenMove(PlayerMoveEvent e) {
		if(e.getPlayer().isInsideVehicle()) {
			Player paramPlayer = e.getPlayer();
		    Entity paramEntity= paramPlayer.getVehicle();
		    if(paramEntity.getType() == null) return;
		    if(paramEntity.getType() == EntityType.HORSE) {
		    if(paramEntity.hasMetadata("FrozenHorse")) {
		    int i = 78;
		    int j = 0;
		    for (Block localBlock1 : plugin.getUtilBlock().getInRadius(MountHandler.pet.get(paramPlayer.getUniqueId()).getLocation(), 3.5D, true).keySet()) {
		    if ((paramPlayer.getLocation().getBlock().getType() != Material.WATER) && 
		     (paramPlayer.getLocation().getBlock().getType() != Material.STATIONARY_WATER) && 
		      (paramPlayer.getLocation().getBlock().getType() != Material.CHEST) && 
		       (paramPlayer.getLocation().getBlock().getType() != Material.SKULL) && 
		         (paramPlayer.getLocation().getBlock().getType() != Material.SNOW) && 
		          (paramPlayer.getLocation().getBlock().getType() != Material.SNOW_BLOCK)) {
		           if (plugin.getUtilBlock().solid(localBlock1)) {
		           if (!plugin.getUtilBlock().blockToRestore.contains(localBlock1)) {
		             Block localBlock2 = plugin.getUtilBlock().getHighest(localBlock1.getWorld(), localBlock1.getLocation().getBlockX(), localBlock1.getLocation().getBlockZ());
		              if (!plugin.getUtilBlock().blockToRestore.contains(localBlock2)) {
		                 Location localLocation = localBlock2.getLocation().add(0.0D, j, 0.0D);
		                  plugin.getUtilBlock().setBlockToRestore(localLocation.getBlock(), i, (byte)0, 4L, true, true, false);
		                }
		              }
		            }
		          } 
		        }
		     }
		  }
	   }
	}
}
