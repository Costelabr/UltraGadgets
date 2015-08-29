package Gadgets;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import Utils.FireworkNMSHandler;
import Utils.UtilCooldown;
import Utils.UtilTitles;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class RailGun extends FireworkNMSHandler
  implements Listener 
{
  UltraGadgets plugin = UltraGadgets.getMain();
  
  class Counter
  {
    private double count = 0.0D;
    
    public Counter() {}
    
    public void up()
    {
      this.count += 0.2D;
    }
    
    public double value()
    {
      return this.count;
    }
  }
  
  
  @EventHandler
  public void paramPlayerUseRailGun(PlayerInteractEvent paramPlayerUseRailGunEvent)
  {
    final Player paramPlayer = paramPlayerUseRailGunEvent.getPlayer();
    Action paramAction = paramPlayerUseRailGunEvent.getAction();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (this.plugin.getUtilBlock().usable(paramPlayerUseRailGunEvent.getClickedBlock())) {
      return;
    }
    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().RailGunGadgetName)) {
      if (UtilCooldown.tryCooldown(paramPlayer, "RailShoot", this.plugin.getConfigFile().RailGunCooldown))
      {
        Location paramLocation = paramPlayer.getEyeLocation();
        
        
        final List<Location> blocks = this.plugin.getUtilLocation().getSphere(paramLocation, 10, 1, true, false, 10);
        final BukkitTask runner = new BukkitRunnable()
        {
          int maxIterations = 2;
          int iterations = 0;
          
          public void run()
          {
            this.iterations = 0;
            while ((!blocks.isEmpty()) && (this.iterations++ < this.maxIterations))
            {
              try
              {
                playFirework((Location)blocks.get(0), FireworkEffect.builder().withColor(Color.BLUE).withColor(Color.LIME).withFade(Color.WHITE).build());
              }
              catch (Exception e)
              {
                e.printStackTrace();
              }
              paramPlayer.getWorld().strikeLightningEffect((Location)blocks.get(0));
              blocks.remove(0);
            }
            if (blocks.isEmpty()) {
              cancel();
            }
          }
        }.runTaskTimer(this.plugin, 0L, 1L);
        
        Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            runner.cancel();
          }
        }, 60L);
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
        {
          public void run() {}
        }, 60L);
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "RailShoot") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Rail Gun", "RailShoot", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
        UtilTitles.sendCooldownTitle(paramPlayer, 
        plugin.getMessagesFile().titleMessage,
        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
      }
    }
  }
}
