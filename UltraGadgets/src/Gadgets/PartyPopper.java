package Gadgets;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import Utils.UtilCooldown;
import Utils.UtilMath;
import Utils.UtilTitles;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class PartyPopper implements Listener {
	
	UltraGadgets plugin = UltraGadgets.getMain();
	Map<Player, Integer> popper = new HashMap<Player, Integer>();
	
	public void startPopper(final Player p) {
		
	  p.playSound(p.getLocation(), Sound.CAT_MEOW, 2F, 10F);
	  int sc = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
		
	 @Override
	   public void run() {
	   final Item i = p.getWorld().dropItem(p.getLocation().add(0.0D, 1.59700000596046448D, 0.0D), plugin.getItemStack().create(Material.WOOL, (byte)UtilMath.random.nextInt(15)));
	   i.setPickupDelay(Integer.MAX_VALUE);
	   i.setVelocity(new Vector(0.0D, 0.5D, 0.0D).add(UtilMath.getRandomCircleVector().multiply(0.1D)));
	   i.getWorld().playSound(i.getLocation(), Sound.CHICKEN_EGG_POP, 0.2F, 1.0F);
	   Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
		
		@Override
		public void run() {
			i.remove();
		}
	  }, 1*20L);
	 }
	}, 0, 2L).getTaskId();
	 popper.put(p, sc);
	 Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
		
		@Override
		public void run() {
			cancelPopper(p);
		}
	}, 25*20L);
  }
	
	public void cancelPopper(Player p) {
		if(popper.containsKey(p)) {
		Bukkit.getScheduler().cancelTask(popper.get(p));
		popper.remove(p);
		}
	}
	
	  @EventHandler
	  public void paramPlayerUseParty(PlayerInteractEvent paramPlayerUsePartyEvent)
	  {
	    Player paramPlayer = paramPlayerUsePartyEvent.getPlayer();
	    Action paramAction = paramPlayerUsePartyEvent.getAction();
	    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
	      return;
	    }
	    ItemStack paramItem = paramPlayer.getItemInHand();
	    if (plugin.getUtilBlock().usable(paramPlayerUsePartyEvent.getClickedBlock())) {
	      return;
	    }
	    if(plugin.getItem().isGadgetItem(paramItem, plugin.getMessagesFile().partyPopperGadgetName)) {
	     if (UtilCooldown.tryCooldown(paramPlayer, "PartyPopper", plugin.getConfigFile().partyPopperCooldown)) {
	    	startPopper(paramPlayer);
	      }
	      else
	      {
	        long cooldown = UtilCooldown.getCooldown(paramPlayer, "PartyPopper") / 1000L;
	        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "PartyPopper", "PartyPopper", cooldown);
	        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
	        UtilTitles.sendCooldownTitle(paramPlayer, 
	        plugin.getMessagesFile().titleMessage,
	        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
	        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
	      }
	    }
	  }
}
