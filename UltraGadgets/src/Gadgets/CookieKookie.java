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
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import Utils.UtilCooldown;
import Utils.UtilMath;
import Utils.UtilTitles;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class CookieKookie
  implements Listener
{
  Map<Player, Integer> cooking = new HashMap<>();
  UltraGadgets plugin = UltraGadgets.getMain();
  
  public double randomRange(double paramDouble1, double paramDouble2)
  {
    return Math.random() < 0.5D ? (1.0D - Math.random()) * (paramDouble2 - paramDouble1) + paramDouble1 : Math.random() * (paramDouble2 - paramDouble1) + paramDouble1;
  }
  
	public void startCookies(final Player p) {
		
		  p.playSound(p.getLocation(), Sound.CAT_MEOW, 2F, 10F);
		  int cookings = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
			
		 @Override
		   public void run() {
		   final Item i = p.getWorld().dropItem(p.getLocation().add(0.0D, 1.59700000596046448D, 0.0D), plugin.getItemStack().create(Material.COOKIE, (byte)0));
		   i.setPickupDelay(Integer.MAX_VALUE);
		   i.setVelocity(new Vector(0.0D, 0.5D, 0.0D).add(UtilMath.getRandomCircleVector().multiply(0.1D)));
		   Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			@Override
			public void run() {
				i.remove();
			}
		  }, 1*20L);
		 }
		}, 0, 2L).getTaskId();
		 cooking.put(p, cookings);
		 Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
			
			@Override
			public void run() {
				stopCooking(p);
			}
		}, 25*20L);
	  }
	
  public void stopCooking(final Player p) {
	 if (cooking.containsKey(p)) {
	  Bukkit.getScheduler().cancelTask(cooking.get(p));
	  cooking.remove(p);
	 }
  }
  
  @EventHandler
  public void paramUseKookie(PlayerInteractEvent paramPlayerUseKookies)
  {
    Player paramPlayer = paramPlayerUseKookies.getPlayer();
    Action paramAction = paramPlayerUseKookies.getAction();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (plugin.getUtilBlock().usable(paramPlayerUseKookies.getClickedBlock())) {
      return;
    }
    
    if (plugin.getItem().isGadgetItem(paramItem, plugin.getMessagesFile().CookieGadgetName)) {
      if (UtilCooldown.tryCooldown(paramPlayer, "Cookies", plugin.getConfigFile().CookieCooldown))
      {
        startCookies(paramPlayer);
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "Cookies") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Cookies Party", "Cookies", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
        UtilTitles.sendCooldownTitle(paramPlayer, 
        plugin.getMessagesFile().titleMessage,
        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
      }
    }
  }
  
  @EventHandler
  public void playerEatCookie(PlayerItemConsumeEvent e)
  {
    Player paramPlayer = e.getPlayer();
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (plugin.getItem().isGadgetItem(paramItem, plugin.getMessagesFile().CookieGadgetName))
    {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void playerLeftWithCookies(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    if (cooking.containsKey(p)) {
      stopCooking(p);
      cooking.remove(p);
    }
  }
}
