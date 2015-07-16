package Gadgets;

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
import org.bukkit.scheduler.BukkitTask;

import Util.ParticleEffect;
import Util.UtilCooldown;
import Util.UtilLag;
import Util.UtilMath;

import com.floodeer.gadgets.Main;

public class SmokeBomb
  implements Listener
{
  Main plugin = Main.getMain();
  
  @EventHandler
  public void paramPlayerUseSmoke(PlayerInteractEvent paramPlayerUseSmoke)
  {
    Player paramPlayer = paramPlayerUseSmoke.getPlayer();
    Action paramAction = paramPlayerUseSmoke.getAction();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (this.plugin.getUtilBlock().usable(paramPlayerUseSmoke.getClickedBlock())) {
      return;
    }
    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().SmokeBombGadgetName)) {
      if (UtilCooldown.tryCooldown(paramPlayer, "SmokeBomb", this.plugin.getConfigFile().SmokeBombCooldown))
      {
        ItemStack paramBomba = new ItemStack(Material.COAL);
        final Item paramItemDrop = paramPlayer.getWorld().dropItem(paramPlayer.getEyeLocation().add(0.0D, 0.0D, 0.0D), paramBomba);
        paramItemDrop.setVelocity(paramPlayer.getEyeLocation().getDirection().multiply(0.8D).normalize());
        paramItemDrop.setPickupDelay(Integer.MAX_VALUE);
        Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
        {
          public void run()
          {
            final BukkitTask paramSmokeRepeatingController = Bukkit.getScheduler().runTaskTimer(SmokeBomb.this.plugin, new Runnable()
            {
              public void run()
              {
                paramItemDrop.getWorld().playSound(paramItemDrop.getLocation(), Sound.FIZZ, 3.0F, 1.0F);
                if (UtilLag.ServerisLag()) {
                  ParticleEffect.EXPLOSION_HUGE.display(0.0F, 0.0F, 0.0F, 5.0F, UtilMath.random.nextInt(50), paramItemDrop.getLocation(), 35.0D);
                } else {
                  ParticleEffect.EXPLOSION_HUGE.display(UtilMath.random.nextInt(3), UtilMath.random.nextInt(3), UtilMath.random.nextInt(3), 5.0F, 180, paramItemDrop.getLocation(), 35.0D);
                }
              }
            }, 1L, 8L);
            
            Bukkit.getScheduler().scheduleSyncDelayedTask(SmokeBomb.this.plugin, new Runnable()
            {
              public void run()
              {
                paramItemDrop.remove();
                paramSmokeRepeatingController.cancel();
              }
            }, 100L);
          }
        }, 100L);
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "SmokeBomb") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Smoke Bomb", "SmokeBomb", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
      }
    }
  }
}
