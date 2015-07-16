package Gadgets;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;

import Util.UtilCooldown;
import Util.UtilFireworks;
import Util.UtilMath;

import com.floodeer.gadgets.Main;

public class WitherShooter
  implements Listener
{
  Main plugin = Main.getMain();
  
  private void summonFirework(Location loc)
  {
    UtilFireworks fe = new UtilFireworks();
    try
    {
      fe.playFirework(loc.getWorld(), loc, 
        FireworkEffect.builder()
        .withColor(Color.BLACK)
        .withColor(Color.WHITE)
        .with(FireworkEffect.Type.BALL_LARGE)
        .build());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  @EventHandler
  public void Activate(PlayerInteractEvent paramPlayerInteractEvent)
  {
    final Player localPlayer1 = paramPlayerInteractEvent.getPlayer();
    if ((paramPlayerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR) && (paramPlayerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    if (this.plugin.getUtilBlock().usable(paramPlayerInteractEvent.getClickedBlock())) {
      return;
    }
    if (!this.plugin.getItem().isGadgetItem(localPlayer1.getItemInHand(), this.plugin.getMessagesFile().WitherShooterName)) {
      return;
    }
    if (UtilCooldown.tryCooldown(localPlayer1, "Wither", this.plugin.getConfigFile().WitherShootCooldown))
    {
      localPlayer1.getWorld().playSound(localPlayer1.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
      for (Entity localEntity : localPlayer1.getNearbyEntities(5.0D, 5.0D, 5.0D)) {
        if ((localEntity instanceof Player))
        {
          Player localPlayer2 = (Player)localEntity;
          localPlayer2.playSound(localPlayer2.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
        }
      }
      final int i = Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
      {
        public void run()
        {
          final WitherSkull localWitherSkull = (WitherSkull)localPlayer1.launchProjectile(WitherSkull.class);
          localWitherSkull.setShooter(localPlayer1);
          localWitherSkull.setVelocity(UtilMath.getRandomVector());
          localWitherSkull.setMetadata("WITHERCATAPULT", new FixedMetadataValue(WitherShooter.this.plugin, ""));
          localWitherSkull.setBounce(true);
          Bukkit.getScheduler().runTaskLater(WitherShooter.this.plugin, new Runnable()
          {
            public void run()
            {
              WitherShooter.this.summonFirework(localWitherSkull.getLocation());
              localWitherSkull.remove();
            }
          }, 13L);
        }
      }, 10L, 8L).getTaskId();
      Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
      {
        public void run()
        {
          Bukkit.getScheduler().cancelTask(i);
        }
      }, 120L);
    }
    else
    {
      long cooldown = UtilCooldown.getCooldown(localPlayer1, "Wither") / 1000L;
      plugin.getMessagesFile().sendCooldownMessage(localPlayer1, "Wither Shoot", "Wither", cooldown);
      localPlayer1.playSound(localPlayer1.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
    }
  }
  
  @EventHandler
  public void onEntityExplode(EntityExplodeEvent paramEntityExplodeEvent)
  {
    if (paramEntityExplodeEvent.getEntity().hasMetadata("WITHERCATAPULT"))
    {
      summonFirework(paramEntityExplodeEvent.getLocation());
      paramEntityExplodeEvent.setCancelled(true);
    }
  }
  
  public static double arrondi(double paramDouble, int paramInt)
  {
    return (int)(paramDouble * Math.pow(10.0D, paramInt) + 0.5D) / Math.pow(10.0D, paramInt);
  }
}