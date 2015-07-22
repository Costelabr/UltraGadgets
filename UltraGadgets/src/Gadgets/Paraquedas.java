package Gadgets;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityUnleashEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

import Util.ParticleEffect;
import Util.Util18;
import Util.UtilCooldown;
import Util.UtilMath;

import com.floodeer.gadgets.Main;
import com.floodeer.gadgets.UpdateEvent;

public class Paraquedas
  implements Listener
{
  Main plugin = Main.getMain();
  final ArrayList<Player> localArrayList = new ArrayList<>();
  
  @EventHandler
  public void paramUseParaquedas(PlayerInteractEvent paramPlayerInteractEvent)
  {
    final Player paramPlayer = paramPlayerInteractEvent.getPlayer();
    if ((paramPlayerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR) && 
      (paramPlayerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    if (this.plugin.getUtilBlock().usable(paramPlayerInteractEvent.getClickedBlock())) {
      return;
    }
    if (!this.plugin.getItem().isGadgetItem(paramPlayer.getItemInHand(), this.plugin.getMessagesFile().ParaquedasGadgetName)) {
      return;
    }
    paramPlayerInteractEvent.setCancelled(true);
    if (UtilCooldown.tryCooldown(paramPlayer, "Galinha", this.plugin.getConfigFile().ParaquedasCooldown))
    {
      this.localArrayList.add(paramPlayer);
      for (Entity localEntity : paramPlayer.getWorld().getEntities()) {
        if ((localEntity instanceof Chicken))
        {
          Chicken paramChicken = (Chicken)localEntity;
          if ((paramChicken.isLeashed()) && 
            (paramChicken.getLeashHolder() == paramPlayer) && 
            (paramChicken.isValid()))
          {
            ParticleEffect.SMOKE_NORMAL.display(0.0F, 0.0F, 0.0F, 0.0F, 0, 
              paramChicken.getLocation(), 10.0D);
            paramChicken.remove();
          }
        }
      }
      if (paramPlayer
        .getWorld()
        .getBlockAt(
        paramPlayer.getLocation().add(0.0D, 53.0D, 0.0D))
        .getType() == Material.AIR) {
        if (paramPlayer
          .getWorld()
          .getBlockAt(
          paramPlayer.getLocation().add(0.0D, 54.0D, 
          0.0D)).getType() == Material.AIR) {
          if (paramPlayer
            .getWorld()
            .getBlockAt(
            paramPlayer.getLocation().add(0.0D, 55.0D, 
            0.0D)).getType() == Material.AIR) {
            if (paramPlayer
              .getWorld()
              .getBlockAt(
              paramPlayer.getLocation().add(0.0D, 55.0D, 
              0.0D)).getType() == Material.AIR) {
              if (paramPlayer
                .getWorld()
                .getBlockAt(
                paramPlayer.getLocation().add(0.0D, 54.0D, 
                0.0D)).getType() == Material.AIR) {
                if (paramPlayer
                  .getWorld()
                  .getBlockAt(
                  paramPlayer.getLocation().add(1.0D, 53.0D, 
                  0.0D)).getType() == Material.AIR) {
                  if (paramPlayer
                    .getWorld()
                    .getBlockAt(
                    paramPlayer.getLocation().add(-1.0D, 53.0D, 
                    0.0D)).getType() == Material.AIR) {
                    if (paramPlayer
                      .getWorld()
                      .getBlockAt(
                      paramPlayer.getLocation().add(0.0D, 53.0D, 
                      1.0D)).getType() == Material.AIR) {
                      if (paramPlayer
                        .getWorld()
                        .getBlockAt(
                        paramPlayer.getLocation().add(0.0D, 53.0D, 
                        -1.0D)).getType() == Material.AIR) {
                        if (paramPlayer
                          .getWorld()
                          .getBlockAt(
                          paramPlayer.getLocation().add(0.0D, 52.0D, 
                          0.0D)).getType() == Material.AIR) {
                          if (paramPlayer
                            .getWorld()
                            .getBlockAt(
                            paramPlayer.getLocation().add(0.0D, 56.0D, 
                            0.0D)).getType() == Material.AIR) {
                            if (paramPlayer
                              .getWorld()
                              .getBlockAt(
                              paramPlayer.getLocation().add(0.0D, 57.0D, 
                              0.0D)).getType() == Material.AIR) {
                              if (paramPlayer
                                .getWorld()
                                .getBlockAt(
                                paramPlayer.getLocation().add(0.0D, 58.0D, 
                                0.0D)).getType() == Material.AIR)
                              {
                                paramPlayer.setFallDistance(0.0F);
                                paramPlayer.teleport(paramPlayer.getLocation().add(0.0D, 55.0D, 
                                  0.0D));
                                paramPlayer.setFallDistance(0.0F);
                                for (int i = 0; i <= 10; i++)
                                {
                                  final Chicken localChicken1 = (Chicken)paramPlayer
                                    .getWorld().spawnEntity(
                                    paramPlayer.getLocation()
                                    .add(randomRangeFloat(-1.7F, 1.7F), 
                                    0.0D, 
                                    randomRangeFloat(-1.7F, 
                                    1.7F)), 
                                    EntityType.CHICKEN);
                                  localChicken1.setLeashHolder(paramPlayer);
                                  setMetadata(localChicken1, "PARACHUTE", 
                                    paramPlayer.getName(), this.plugin);
                                  Bukkit.getScheduler().runTaskLater(this.plugin, 
                                    new Runnable()
                                    {
                                      public void run()
                                      {
                                        if (localChicken1.isValid())
                                        {
                                          localChicken1.remove();
                                          ParticleEffect.SMOKE_NORMAL.display(0.0F, 
                                            0.0F, 0.0F, 0.0F, 0, 
                                            localChicken1.getLocation(), 10.0D);
                                        }
                                      }
                                    }, 250L);
                                }
                                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
                                {
                                  public void run()
                                  {
                                    Iterator<Entity> localIterator = paramPlayer.getWorld().getEntities().iterator();
                                    while (localIterator.hasNext())
                                    {
                                      Entity localEntity = (Entity)localIterator.next();
                                      if ((localEntity instanceof Chicken))
                                      {
                                        Chicken localChicken = (Chicken)localEntity;
                                        if ((localChicken.isLeashed()) && 
                                          (localChicken.getLeashHolder() == paramPlayer)) {
                                          localChicken.remove();
                                        }
                                      }
                                    }
                                  }
                                }, 230L);
                                Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, 
                                  new Runnable()
                                  {
                                    public void run()
                                    {
                                      Paraquedas.this.localArrayList.remove(paramPlayer);
                                    }
                                  }, 360L);
                                return;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      paramPlayer.sendMessage("§cN§o h§ espa§o!");
    }
    else
    {
      long cooldown = UtilCooldown.getCooldown(paramPlayer, "Galinha") / 1000L;
      plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Paraquedas", "Galinha", cooldown);
      paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
      Util18.sendTitle(paramPlayer, 
      plugin.getMessagesFile().titleMessage,
      plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
      plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
    }
  }
  
  public void setMetadata(Entity paramEntity, String paramString, Object paramObject, Main paramCore)
  {
    paramEntity.setMetadata(paramString, new FixedMetadataValue(paramCore, 
      paramObject));
  }
  
  @EventHandler
  public void onUnleash(EntityUnleashEvent paramEntityUnleashEvent)
  {
    if (paramEntityUnleashEvent.getEntity().hasMetadata("PARACHUTE"))
    {
      Chicken localChicken = (Chicken)paramEntityUnleashEvent
        .getEntity();
      localChicken.setLeashHolder(null);
      ParticleEffect.SMOKE_NORMAL.display(0.0F, 0.0F, 0.0F, 0.0F, 0, 
        localChicken.getLocation(), 10.0D);
      paramEntityUnleashEvent.getEntity().remove();
    }
  }
  
  @EventHandler
  public void onQuit(PlayerQuitEvent paramPlayerQuitEvent)
  {
    Player paramPlayer = paramPlayerQuitEvent.getPlayer();
    for (Entity localEntity : paramPlayer.getWorld().getEntities()) {
      if ((localEntity instanceof Chicken))
      {
        Chicken localChicken = (Chicken)localEntity;
        if ((localChicken.isLeashed()) && 
          (localChicken.getLeashHolder() == paramPlayer) && 
          (localChicken.hasMetadata("PARACHUTE")))
        {
          ParticleEffect.SMOKE_NORMAL.display(0.0F, 0.0F, 0.0F, 0.0F, 0, 
            localChicken.getLocation(), 10.0D);
          localChicken.remove();
        }
      }
    }
  }
  
  @EventHandler
  public void onUpdate(UpdateEvent paramUpdateEvent)
  {
    for(Player paramPlayer : Bukkit.getOnlinePlayers()) {
    {
      for(Entity localEntity : paramPlayer.getWorld().getEntities()) {
      if (((localEntity instanceof Chicken)) && 
        (localEntity.hasMetadata("PARACHUTE")))
      {
        Chicken localChicken = (Chicken)localEntity;
        if ((localChicken.isLeashed()) && 
          (localChicken.getLeashHolder() == paramPlayer) && 
          (paramPlayer
          .getWorld()
          .getBlockAt(
          paramPlayer.getLocation().add(0.0D, 
          -1.0D, 0.0D)).getType() != Material.AIR)) {
          localChicken.remove();
        }
      }
    }
   }
  }
  }
  
  @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
  public void damage(EntityDamageEvent paramEntityDamageEvent)
  {
    if (((paramEntityDamageEvent.getEntity() instanceof Chicken)) && 
      (paramEntityDamageEvent.getEntity().hasMetadata("PARACHUTE"))) {
      paramEntityDamageEvent.setCancelled(true);
    }
  }
  
  @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
  public void damageFall(EntityDamageEvent e)
  {
    if (((e.getEntity() instanceof Player)) && (e.getCause() == EntityDamageEvent.DamageCause.FALL))
    {
      Player paramPlayer = (Player)e.getEntity();
      if (this.localArrayList.contains(paramPlayer)) {
        e.setCancelled(true);
      }
    }
  }
  
  @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
  public void eventMove(PlayerMoveEvent paramPlayerMoveEvent)
  {
    Player localPlayer = paramPlayerMoveEvent.getPlayer();
    if ((localPlayer.getFallDistance() > 0.0F) && 
      (localPlayer.getVelocity().getY() < -0.1000000014901161D)) {
      for (Entity localEntity : localPlayer.getNearbyEntities(20.0D, 
        20.0D, 40.0D)) {
        if ((localEntity instanceof Chicken))
        {
          Chicken localChicken = (Chicken)localEntity;
          if ((localChicken.isLeashed()) && 
            (localChicken.getLeashHolder() == localPlayer)) {
            if (localChicken.getLocation().getY() > localPlayer.getLocation().getY() + 2.0D)
            {
              localPlayer.setVelocity(localPlayer
                .getVelocity().add(
                new Vector(0.0D, 0.01D, 0.0D)));
              localPlayer.setFallDistance(0.0F);
              if (localPlayer.getVelocity().getY() > -0.1000000014901161D) {
                localPlayer.setVelocity(localPlayer
                  .getVelocity().setY(-0.1F));
              }
            }
          }
        }
      }
    }
  }
  
  public static int randInt(int paramInt1, int paramInt2)
  {
    int i = UtilMath.random.nextInt(paramInt2 - paramInt1 + 1) + paramInt1;
    return i;
  }
  
  public static double arrondi(double paramDouble, int paramInt)
  {
    return (int)(paramDouble * Math.pow(10.0D, paramInt) + 0.5D) / 
      Math.pow(10.0D, paramInt);
  }
  
  public static double randomRange(double paramDouble1, double paramDouble2)
  {
    return Math.random() < 0.5D ? (1.0D - Math.random()) * (
      paramDouble2 - paramDouble1) + paramDouble1 : Math.random() * (
      paramDouble2 - paramDouble1) + paramDouble1;
  }
  
  public static float randomRangeFloat(float paramFloat1, float paramFloat2)
  {
    return (float)(Math.random() < 0.5D ? (1.0D - Math.random()) * (
      paramFloat2 - paramFloat1) + paramFloat1 : Math.random() * (
      paramFloat2 - paramFloat1) + paramFloat1);
  }
  
  public static int randomRangeInt(int paramInt1, int paramInt2)
  {
    return (int)(Math.random() < 0.5D ? (1.0D - Math.random()) * (
      paramInt2 - paramInt1) + paramInt1 : Math.random() * (
      paramInt2 - paramInt1) + paramInt1);
  }
}
