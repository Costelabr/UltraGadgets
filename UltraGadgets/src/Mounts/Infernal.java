package Mounts;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import Utils.UtilParticle;
import Utils.UtilParticle.ParticleType;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class Infernal implements Listener {
	
	UltraGadgets plugin = UltraGadgets.getMain();
	
	public int random(Integer[] integers) {
		Random rand = new Random();
		return integers[rand.nextInt(integers.length)];
	}
	
	@EventHandler
	public void onInfernalMove(PlayerMoveEvent e) {
		if(e.getPlayer().isInsideVehicle()) {
			Player paramPlayer = e.getPlayer();
		    Entity paramEntity = paramPlayer.getVehicle();
		    if(paramEntity.getType() == null) return;
		    if(paramEntity.getType() == EntityType.HORSE) {
		    if(paramEntity.hasMetadata("InfernalHorse")) {
		    new UtilParticle(ParticleType.FLAME, 0.10000000149011612D, 4, 0.30000001192092896D).sendToLocation(paramEntity.getLocation());
		    int i = 159;
		    int ie = random(new Integer[] { 1,4,14});
		    if(!plugin.getConfigFile().useMountBlockEffect) {
		    	return;
		    }
		    for (Block localBlock1 : plugin.getUtilBlock().getInRadius(MountHandler.pet.get(paramPlayer.getUniqueId()).getLocation(), 3.5D, true).keySet()) {
		    if ((paramPlayer.getLocation().getBlock().getType() != Material.WATER) && 
		     (paramPlayer.getLocation().getBlock().getType() != Material.STATIONARY_WATER) && 
		      (paramPlayer.getLocation().getBlock().getType() != Material.CHEST) && 
		       (paramPlayer.getLocation().getBlock().getType() != Material.SKULL) && 
		         (paramPlayer.getLocation().getBlock().getType() != Material.SNOW) && 
		          (paramPlayer.getLocation().getBlock().getType() != Material.CLAY_BRICK)) {
		           if (plugin.getUtilBlock().solid(localBlock1)) {
		           if (!plugin.getUtilBlock().blockToRestore.contains(localBlock1)) {
		             Block localBlock2 = plugin.getUtilBlock().getHighest(localBlock1.getWorld(), localBlock1.getLocation().getBlockX(), localBlock1.getLocation().getBlockZ());
		              if (!plugin.getUtilBlock().blockToRestore.contains(localBlock2)) {
		                 Location localLocation = localBlock2.getLocation();
		                 byte b = (byte)ie;
		                  plugin.getUtilBlock().setBlockToRestore(localLocation.subtract(0, 1, 0).getBlock(), i, b, 4L, true, false, false);
		                }
		              }
		            }
		          } 
		        }
		     }
		  }
	   }
	}
	
	@EventHandler
	public void onEntityMove(PlayerMoveEvent e) {
		Block b = e.getTo().getBlock();
		if((b.getType() == Material.CLAY)) {
			if(plugin.getUtilBlock().blockToRestore.contains(b)) {
			new UtilParticle(ParticleType.FLAME, 0.10000000149011612D, 4, 0.30000001192092896D).sendToLocation(e.getPlayer().getLocation());
			}
		}
	}
}
