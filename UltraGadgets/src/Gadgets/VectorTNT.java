package Gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import org.bukkit.util.Vector;

import Core.Util18;
import Core.UtilCooldown;
import Core.UtilMath;

import com.floodeer.gadgets.Main;

public class VectorTNT implements Listener {
	
	Main plugin = Main.getMain();
	public List<Player> toVector = new ArrayList<Player>();
	
	public void launchTNT(Player localPlayer) {
		
		TNTPrimed localTNT = (TNTPrimed) localPlayer.getWorld().spawn(localPlayer.getLocation(), TNTPrimed.class);
		localTNT.setMetadata("localData", new FixedMetadataValue(plugin, null));
		localTNT.setVelocity(localPlayer.getLocation().getDirection().multiply(1));
		localTNT.setIsIncendiary(false);
		localTNT.setFuseTicks(80);
	}
	
	Map<UUID, Integer> mapOfP = new HashMap<UUID, Integer>();
	@EventHandler
	public void onLocalDataTNTExplode(EntityExplodeEvent e) {
		if(e.getEntity() instanceof TNTPrimed) {
			
			TNTPrimed localTNT = (TNTPrimed)e.getEntity();
			if(localTNT.hasMetadata("localData")) {
				e.setYield(0);
				e.setCancelled(true);
				final Entity[] ent = plugin.getUtilLocation().getNearbyEntities(e.getLocation(), 12);
				for(final Entity entity : ent) {
					if(entity.hasMetadata("NPC")) return;
					if(entity.hasMetadata("PET")) return;		
					 Vector v = new Vector(UtilMath.random.nextInt(5),  UtilMath.random.nextInt(2), UtilMath.random.nextInt(5));
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
	          Util18.sendTitle(paramPlayer, 
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
