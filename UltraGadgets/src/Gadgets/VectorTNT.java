package Gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import Utils.UtilCooldown;
import Utils.UtilMath;
import Utils.UtilParticle;
import Utils.UtilParticle.ParticleType;
import Utils.UtilTitles;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class VectorTNT implements Listener {
	
	UltraGadgets plugin = UltraGadgets.getMain();
	public List<Player> toVector = new ArrayList<Player>();
	
	public void launchTNT(Player localPlayer) {
		
		TNTPrimed localTNT = (TNTPrimed) localPlayer.getWorld().spawn(localPlayer.getLocation(), TNTPrimed.class);
		localTNT.setMetadata("localData", new FixedMetadataValue(plugin, null));
		localTNT.setVelocity(localPlayer.getLocation().getDirection().multiply(1.6).normalize());
		localTNT.setIsIncendiary(false);
		localTNT.setFuseTicks(80);
	}
	 
	Map<UUID, Integer> mapOfP = new HashMap<UUID, Integer>();
	@EventHandler
	public void onLocalDataTNTExplode(final EntityExplodeEvent e) {
		if(e.getEntity() instanceof TNTPrimed) {
			
			final TNTPrimed localTNT = (TNTPrimed)e.getEntity();
			if(localTNT.hasMetadata("LocalData2")) {
				e.setCancelled(true);
				e.setYield(0);
				new UtilParticle(ParticleType.SMOKE_NORMAL, 12.70000000149011612D, 8, 12.80000001192092896D).sendToLocation(localTNT.getLocation());
			}
			if(localTNT.hasMetadata("localData")){
				e.setYield(0);
				e.setCancelled(true);
				final Entity[] ent = plugin.getUtilLocation().getNearbyEntities(e.getLocation(), 12);
				for(final Entity entity : ent) {
					if(entity.hasMetadata("NPC")) return;
					if(entity.hasMetadata("ugPets")) return;
					new UtilParticle(ParticleType.SMOKE_NORMAL, 12.80000000149011612D, 4, 12.80000001192092896D).sendToLocation(localTNT.getLocation());
					final BukkitTask t = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
						
						@Override
						public void run() {						
						    TNTPrimed newTNT = e.getEntity().getWorld().spawn(localTNT.getLocation(), TNTPrimed.class);
						    newTNT.setVelocity(new Vector(0.0D, UtilMath.randomRange(0.8, 1.6), 0.0D).add(UtilMath.getRandomCircleVector().multiply(0.5D)));
						    newTNT.setMetadata("LocalData2", new FixedMetadataValue(plugin, null));
							
						}
					}, 0, 6L);
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						
						@Override
						public void run() {
						t.cancel();
							
						}
					}, 4*20L);
				    
					 Vector v = new Vector(0, UtilMath.randomRange(1.3, 2.8), 0);
					 entity.setVelocity(v);
				}
			}
		}
	}
	
	
	@EventHandler
	public void paramPlayerUseVectorTNT(PlayerInteractEvent paramPlayerUseVectorTNTEvent) {
	    Player paramPlayer = paramPlayerUseVectorTNTEvent.getPlayer();
	    Action paramAction = paramPlayerUseVectorTNTEvent.getAction();
	    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
	      return;
	    }
	    ItemStack paramItem = paramPlayer.getItemInHand();
	    if (this.plugin.getUtilBlock().usable(paramPlayerUseVectorTNTEvent.getClickedBlock())) {
	      return;
	    }
	    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().VectorGadgetName)) {
	        if (UtilCooldown.tryCooldown(paramPlayer, "VectorTNT", this.plugin.getConfigFile().vectorTNTCooldown))
	        {
	          launchTNT(paramPlayer);
	        }
	        else{
	          long cooldown = UtilCooldown.getCooldown(paramPlayer, "VectorTNT") / 1000L;
	          plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "VectorTNT", "VectorTNT", cooldown);
	          paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
	          UtilTitles.sendCooldownTitle(paramPlayer, 
	          plugin.getMessagesFile().titleMessage,
	          plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
	          plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
	        }
	     }
	}
	
	@EventHandler
	public void damage(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof TNTPrimed) {
			e.setCancelled(true);
		}
	}
	
}
