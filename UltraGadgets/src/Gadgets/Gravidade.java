package Gadgets;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;

import br.com.floodeer.ultragadgets.UltraGadgets;
import Update.SchedulerEvent;
import Update.SchedulerType;
import Utils.UtilCooldown;
import Utils.UtilGravity;
import Utils.UtilParticle;
import Utils.UtilTitles;

public class Gravidade implements Listener {
	
	List<Block> block = new ArrayList<Block>();
	UltraGadgets plugin = UltraGadgets.getMain();
	
	public void buildGravidade(final Player p) {
		Location l = p.getLocation();
		final Block b = l.add(0,1,0).getBlock();
		if(b.getType() == Material.AIR) {
			b.setType(Material.SLIME_BLOCK);
			b.getRelative(BlockFace.UP).setType(Material.IRON_FENCE);
			b.getRelative(BlockFace.DOWN).setType(Material.IRON_FENCE);
			block.add(b);
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				
				@Override
				public void run() {
					p.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, b.getType());
					p.getWorld().playEffect(b.getRelative(BlockFace.UP).getLocation(), Effect.STEP_SOUND, b.getType());
					p.getWorld().playEffect(b.getRelative(BlockFace.DOWN).getLocation(), Effect.STEP_SOUND, b.getType());
					b.setType(Material.AIR);
					b.getRelative(BlockFace.UP).setType(Material.AIR);
					b.getRelative(BlockFace.DOWN).setType(Material.AIR);
					block.remove(b);
					UtilGravity.inGravity.clear();
				}
			}, 25*20L);
		}
	}
	
	@EventHandler
	public void update(SchedulerEvent e) {
		if(e.getType() == SchedulerType.TICK) {
				for(Block b : block) {
				new UtilParticle(UtilParticle.ParticleType.SPELL, 3.80000000074505806D, 1, 3.80000001192092896D).sendToLocation(b.getLocation());
			    new UtilParticle(UtilParticle.ParticleType.REDSTONE, 0.60000001192092896D, 2, 0.60000001192092896D).sendToLocation(b.getLocation());
				  for(Entity ent : plugin.getUtilLocation().getNearbyEntities(b.getLocation(), 12)) {
					  if(ent instanceof Player) {
						  Player pent = (Player)ent;
						  UtilGravity.inGravity.add(pent);
						  double distance = pent.getLocation().distance(b.getLocation());
						  if(distance > 13) {
							  UtilGravity.inGravity.remove(pent);
						    }
					   }
				   }
				}
			}
		}
	
	@EventHandler
	public void paramPlayerUseGravidade(PlayerInteractEvent paramPlayerUseGravidadeEvent) {
		
	    Player paramPlayer = paramPlayerUseGravidadeEvent.getPlayer();
	    Action paramAction = paramPlayerUseGravidadeEvent.getAction();
	    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
	      return;
	    }
	    ItemStack paramItem = paramPlayer.getItemInHand();
	    if (this.plugin.getUtilBlock().usable(paramPlayerUseGravidadeEvent.getClickedBlock())) {
	      return;
	    }
	    if (this.plugin.getItem().isGadgetItem(paramItem, plugin.getMessagesFile().gravidadeGadgetName)) {
	       if (UtilCooldown.tryCooldown(paramPlayer, "Gravidade", plugin.getConfigFile().gravidadeCooldown)) {
	        buildGravidade(paramPlayer);
	   }else{
	         long cooldown = UtilCooldown.getCooldown(paramPlayer, "Gravidade") / 1000L;
	         plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Gravidade", "Gravidade", cooldown);
	         paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
	         UtilTitles.sendCooldownTitle(paramPlayer, 
	         plugin.getMessagesFile().titleMessage,
	         plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
	         plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
	      }
	   }
	}
	
	@EventHandler
	public void quitGravidade(PlayerQuitEvent e) {
		if(UtilGravity.inGravity.contains(e.getPlayer())) {
			UtilGravity.inGravity.remove(e.getPlayer());
		}
	}
	
	@EventHandler
	public void teleportGravidade(PlayerTeleportEvent e) {
		if(UtilGravity.inGravity.contains(e.getPlayer())) {
			UtilGravity.inGravity.remove(e.getPlayer());
		}
	}
	
	@EventHandler
	public void changeGravity(PlayerChangedWorldEvent e) {
		if(UtilGravity.inGravity.contains(e.getPlayer())) {
			UtilGravity.inGravity.remove(e.getPlayer());
		}
	}
}
