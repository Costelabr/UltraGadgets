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
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import Core.Util18;
import Core.UtilCooldown;

import com.floodeer.gadgets.UltraGadgets;

public class CookieKookie
  implements Listener
{
  Map<String, Item> Kookies = new HashMap<>();
  Map<Player, BukkitTask> cooking = new HashMap<>();
  UltraGadgets plugin = UltraGadgets.getMain();
  
  public double randomRange(double paramDouble1, double paramDouble2)
  {
    return Math.random() < 0.5D ? (1.0D - Math.random()) * (paramDouble2 - paramDouble1) + paramDouble1 : Math.random() * (paramDouble2 - paramDouble1) + paramDouble1;
  }
  
  public void paramSummonKookies(final Player p)
  {
    final Vector direction = new Vector(randomRange(-0.10000000149011612D, 0.10000000149011612D), 0.5D, randomRange(-0.10000000149011612D, 0.10000000149011612D));
    
    final BukkitTask tasker = Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
    {
      public void run()
      {
        final Item drop = p.getWorld().dropItemNaturally(p.getLocation().add(0.0D, 1.8D, 0.0D), new ItemStack(Material.COOKIE));
        final Item drop2 = p.getWorld().dropItemNaturally(p.getLocation().add(0.0D, 1.8D, 0.0D), new ItemStack(Material.COOKIE));
        final Item drop3 = p.getWorld().dropItemNaturally(p.getLocation().add(0.0D, 1.8D, 0.0D), new ItemStack(Material.COOKIE));
        
        drop.setMetadata("KookiesForU", new FixedMetadataValue(CookieKookie.this.plugin, "Coolkies"));
        drop.setVelocity(direction);
        drop.setPickupDelay(1000);
        
        drop2.setMetadata("KookiesForU2", new FixedMetadataValue(CookieKookie.this.plugin, "Coolkies"));
        drop2.setVelocity(direction);
        drop2.setPickupDelay(1000);
        
        drop3.setMetadata("KookiesForU3", new FixedMetadataValue(CookieKookie.this.plugin, "Coolkies"));
        drop3.setVelocity(direction);
        drop3.setPickupDelay(1000);
        
        p.getWorld().playSound(drop.getLocation(), Sound.ITEM_PICKUP, 2.0F, 15.0F);
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(CookieKookie.this.plugin, new Runnable()
        {
          public void run()
          {
            drop.remove();
            drop2.remove();
            drop3.remove();
          }
        }, 20L);
        CookieKookie.this.Kookies.put("Kookie1", drop);
        CookieKookie.this.Kookies.put("Kookie2", drop2);
        CookieKookie.this.Kookies.put("Kookie3", drop3);
        if (drop.isOnGround()) {
          drop.remove();
        }
        if (drop2.isOnGround()) {
          drop.remove();
        }
        if (drop3.isOnGround()) {
          drop.remove();
        }
      }
    }, 0L, 2L);
    this.cooking.put(p, tasker);
    
    Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
    {
      public void run()
      {
        tasker.cancel();
      }
    }, 320L);
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
    if (this.plugin.getUtilBlock().usable(paramPlayerUseKookies.getClickedBlock())) {
      return;
    }
    
    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().CookieGadgetName)) {
      if (UtilCooldown.tryCooldown(paramPlayer, "Cookies", this.plugin.getConfigFile().CookieCooldown))
      {
        paramSummonKookies(paramPlayer);
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "Cookies") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Cookies Party", "Cookies", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
        Util18.sendTitle(paramPlayer, 
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
    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().CookieGadgetName))
    {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void playerLeftWithCookies(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    if (this.cooking.containsKey(p))
    {
      ((BukkitTask)this.cooking.get(p)).cancel();
      ((Item)this.Kookies.get("Kookie1")).remove();
      ((Item)this.Kookies.get("Kookie2")).remove();
      ((Item)this.Kookies.get("Kookie3")).remove();
      this.Kookies.clear();
      this.cooking.remove(p);
    }
  }
}
