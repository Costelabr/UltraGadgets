package Gadgets;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import Utils.UtilCooldown;
import Utils.UtilTitles;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class Foguete implements Listener {
	
  UltraGadgets plugin = UltraGadgets.getMain();
  private  HashMap<Player, Long> _active = new HashMap<>();
  HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap<>();
  public  HashMap<Player, Location> stationnaire = new HashMap<>();
  public  HashMap<Player, Entity> effect = new HashMap<>();
  public  HashMap<Player, Entity> arrowToRemove = new HashMap<>();
  public  HashMap<Player, ArrayList<Entity>> fallingblocktoremove = new HashMap<>();
  
  public  boolean isInRocket(Player paramPlayer)
  {
    if ((stationnaire.containsKey(paramPlayer)) || (effect.containsKey(paramPlayer)) || (arrowToRemove.containsKey(paramPlayer)) || (fallingblocktoremove.containsKey(paramPlayer))) {
      return true;
    }
    return false;
  }
  
  @EventHandler
  public void ghostDamage(EntityDamageEvent paramEntityDamageEvent)
  {
    Entity localEntity = paramEntityDamageEvent.getEntity();
    if ((localEntity instanceof FallingBlock)) {
      if (localEntity.hasMetadata("ugBlockse")) {
        paramEntityDamageEvent.setCancelled(true);
      }
    }
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void EntityChangeBlockEvent(EntityChangeBlockEvent paramEntityChangeBlockEvent)
  {
    Entity localEntity = paramEntityChangeBlockEvent.getEntity();
    if ((localEntity instanceof FallingBlock)) {
      if (localEntity.hasMetadata("ugBlockse")) {
        paramEntityChangeBlockEvent.setCancelled(true);
      }
    }
  }
  
  public void constructFirework(final Player paramPlayer, Location paramLocation) {
      
      Block localBlock1 = new Location(paramPlayer.getWorld(), paramLocation.getX() + 1.0D, paramLocation.getY(), paramLocation.getZ()).getBlock();
      Block localBlock2 = new Location(paramPlayer.getWorld(), paramLocation.getX(), paramLocation.getY(), paramLocation.getZ() + 1.0D).getBlock();
      Block localBlock3 = new Location(paramPlayer.getWorld(), paramLocation.getX() - 1.0D, paramLocation.getY(), paramLocation.getZ()).getBlock();
      Block localBlock4 = new Location(paramPlayer.getWorld(), paramLocation.getX(), paramLocation.getY(), paramLocation.getZ() - 1.0D).getBlock();
      Block localBlock5 = new Location(paramPlayer.getWorld(), paramLocation.getX() + 1.0D, paramLocation.getY() + 1.0D, paramLocation.getZ()).getBlock();
      Block localBlock6 = new Location(paramPlayer.getWorld(), paramLocation.getX(), paramLocation.getY() + 1.0D, paramLocation.getZ() + 1.0D).getBlock();
      Block localBlock7 = new Location(paramPlayer.getWorld(), paramLocation.getX() - 1.0D, paramLocation.getY() + 1.0D, paramLocation.getZ()).getBlock();
      Block localBlock8 = new Location(paramPlayer.getWorld(), paramLocation.getX(), paramLocation.getY() + 1.0D, paramLocation.getZ() - 1.0D).getBlock();
      Block localBlock9 = new Location(paramPlayer.getWorld(), paramLocation.getX(), paramLocation.getY() + 1.0D, paramLocation.getZ()).getBlock();
      Block localBlock10 = new Location(paramPlayer.getWorld(), paramLocation.getX(), paramLocation.getY() + 2.0D, paramLocation.getZ()).getBlock();
      Block localBlock11 = new Location(paramPlayer.getWorld(), paramLocation.getX(), paramLocation.getY() + 3.0D, paramLocation.getZ()).getBlock();
      if ((localBlock1.isEmpty()) && 
        (localBlock2.isEmpty()) && 
        (localBlock3.isEmpty()) && 
        (localBlock4.isEmpty()) && 
        (localBlock5.isEmpty()) && 
        (localBlock6.isEmpty()) && 
        (localBlock7.isEmpty()) && 
        (localBlock8.isEmpty()) && 
        (localBlock9.isEmpty()) && 
        (localBlock10.isEmpty()) && 
        (localBlock11.isEmpty())) {
        
        _active.put(paramPlayer, Long.valueOf(System.currentTimeMillis()));
        
        stationnaire.put(paramPlayer, paramLocation);
        
        plugin.getUtilBlock().setBlockToRestore(localBlock1, 85, (byte)0, 10L, false, false, true);
        
        plugin.getUtilBlock().setBlockToRestore(localBlock2, 85, (byte)0, 10L, false, false, true);
        
        plugin.getUtilBlock().setBlockToRestore(localBlock3, 85, (byte)0, 10L, false, false, true);
        
        plugin.getUtilBlock().setBlockToRestore(localBlock4, 85, (byte)0, 10L, false, false, true);
        
        plugin.getUtilBlock().setBlockToRestore(localBlock5, 85, (byte)0, 10L, false, false, true);
        
        plugin.getUtilBlock().setBlockToRestore(localBlock6, 85, (byte)0, 10L, false, false, true);
        
        plugin.getUtilBlock().setBlockToRestore(localBlock7, 85, (byte)0, 10L, false, false, true);
        
        plugin.getUtilBlock().setBlockToRestore(localBlock8, 85, (byte)0, 10L, false, false, true);
        
        plugin.getUtilBlock().setBlockToRestore(localBlock9, 42, (byte)0, 10L, false, false, true);
        
        plugin.getUtilBlock().setBlockToRestore(localBlock10, 42, (byte)0, 10L, false, false, true);
        
        plugin.getUtilBlock().setBlockToRestore(localBlock11, 76, (byte)0, 9L, false, false, true);
        
        final Arrow localArrow = (Arrow)paramPlayer.getWorld().spawnEntity(localBlock11.getLocation().add(0.5D, 1.0D, 0.5D), EntityType.ARROW);
        localArrow.setPassenger(paramPlayer);
        arrowToRemove.put(paramPlayer, localArrow);
        
        Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable()
        {
          public void run()
          {
            {
              localArrow.remove();
              arrowToRemove.remove(localArrow);
              playFirework(paramPlayer);
            }
          }
        }, 200L);
      }
      else
      {
        paramPlayer.sendMessage("Area Pequena!");
      }
    }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void invInteract(InventoryClickEvent paramInventoryClickEvent)
  {
    Player localPlayer = (Player)paramInventoryClickEvent.getWhoClicked();
    if (isInRocket(localPlayer))
    {
      paramInventoryClickEvent.setCancelled(true);
      paramInventoryClickEvent.getWhoClicked().getOpenInventory().close();
    }
  }
  
  @EventHandler(priority=EventPriority.HIGH)
  public void OnplayerInteract(PlayerInteractEvent paramPlayerInteractEvent)
  {
    if (isInRocket(paramPlayerInteractEvent.getPlayer())) {
      paramPlayerInteractEvent.setCancelled(true);
    }
  }
  
  @SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
  public  void playFirework(final Player paramPlayer) {
      fallingblocktoremove.put(paramPlayer, new ArrayList());
      
      Location localLocation1 = (Location)stationnaire.get(paramPlayer);
      
      Location localLocation2 = new Location(paramPlayer.getWorld(), localLocation1.getX() + 1.0D, localLocation1.getY() + 1.0D, localLocation1.getZ());
      Location localLocation3 = new Location(paramPlayer.getWorld(), localLocation1.getX(), localLocation1.getY() + 1.0D, localLocation1.getZ() + 1.0D);
      Location localLocation4 = new Location(paramPlayer.getWorld(), localLocation1.getX() - 1.0D, localLocation1.getY() + 1.0D, localLocation1.getZ());
      Location localLocation5 = new Location(paramPlayer.getWorld(), localLocation1.getX(), localLocation1.getY() + 1.0D, localLocation1.getZ() - 1.0D);
      
      Location localLocation6 = new Location(paramPlayer.getWorld(), localLocation1.getX() + 1.0D, localLocation1.getY(), localLocation1.getZ());
      Location localLocation7 = new Location(paramPlayer.getWorld(), localLocation1.getX(), localLocation1.getY(), localLocation1.getZ() + 1.0D);
      Location localLocation8 = new Location(paramPlayer.getWorld(), localLocation1.getX() - 1.0D, localLocation1.getY(), localLocation1.getZ());
      Location localLocation9 = new Location(paramPlayer.getWorld(), localLocation1.getX(), localLocation1.getY(), localLocation1.getZ() - 1.0D);
      Location localLocation10 = new Location(paramPlayer.getWorld(), localLocation1.getX() + 1.0D, localLocation1.getY() + 1.0D, localLocation1.getZ());
      Location localLocation11 = new Location(paramPlayer.getWorld(), localLocation1.getX(), localLocation1.getY() + 1.0D, localLocation1.getZ() + 1.0D);
      Location localLocation12 = new Location(paramPlayer.getWorld(), localLocation1.getX() - 1.0D, localLocation1.getY() + 1.0D, localLocation1.getZ());
      Location localLocation13 = new Location(paramPlayer.getWorld(), localLocation1.getX(), localLocation1.getY() + 1.0D, localLocation1.getZ() - 1.0D);
      Location localLocation14 = new Location(paramPlayer.getWorld(), localLocation1.getX(), localLocation1.getY() + 1.0D, localLocation1.getZ());
      Location localLocation15 = new Location(paramPlayer.getWorld(), localLocation1.getX(), localLocation1.getY() + 2.0D, localLocation1.getZ());
      
      final FallingBlock f1 = paramPlayer.getWorld().spawnFallingBlock(localLocation2, Material.FENCE, (byte)0);
      f1.setVelocity(new Vector(0, 7, 0));
      final FallingBlock f2 = paramPlayer.getWorld().spawnFallingBlock(localLocation3, Material.FENCE, (byte)0);
      f2.setVelocity(new Vector(0, 7, 0));
      final FallingBlock f3 = paramPlayer.getWorld().spawnFallingBlock(localLocation4, Material.FENCE, (byte)0);
      f3.setVelocity(new Vector(0, 7, 0));
      final FallingBlock f4 = paramPlayer.getWorld().spawnFallingBlock(localLocation5, Material.FENCE, (byte)0);
      f4.setVelocity(new Vector(0, 7, 0));
      
      final FallingBlock f5 = paramPlayer.getWorld().spawnFallingBlock(localLocation6, Material.FENCE, (byte)0);
      f5.setVelocity(new Vector(0, 7, 0));
      final FallingBlock f6 = paramPlayer.getWorld().spawnFallingBlock(localLocation7, Material.FENCE, (byte)0);
      f6.setVelocity(new Vector(0, 7, 0));
      final FallingBlock f7 = paramPlayer.getWorld().spawnFallingBlock(localLocation8, Material.FENCE, (byte)0);
      f7.setVelocity(new Vector(0, 7, 0));
      final FallingBlock f8 = paramPlayer.getWorld().spawnFallingBlock(localLocation9, Material.FENCE, (byte)0);
      f8.setVelocity(new Vector(0, 7, 0));
      final FallingBlock f9 = paramPlayer.getWorld().spawnFallingBlock(localLocation10, Material.FENCE, (byte)0);
      f9.setVelocity(new Vector(0, 7, 0));
      final FallingBlock f10 = paramPlayer.getWorld().spawnFallingBlock(localLocation11, Material.FENCE, (byte)0);
      f10.setVelocity(new Vector(0, 7, 0));
      final FallingBlock f11 = paramPlayer.getWorld().spawnFallingBlock(localLocation12, Material.FENCE, (byte)0);
      f11.setVelocity(new Vector(0, 7, 0));
      final FallingBlock f12 = paramPlayer.getWorld().spawnFallingBlock(localLocation13, Material.FENCE, (byte)0);
      f12.setVelocity(new Vector(0, 7, 0));
      final FallingBlock f13 = paramPlayer.getWorld().spawnFallingBlock(localLocation14, Material.IRON_BLOCK, (byte)0);
      f13.setVelocity(new Vector(0, 7, 0));
      effect.put(paramPlayer, f13);
      final FallingBlock f14 = paramPlayer.getWorld().spawnFallingBlock(localLocation15, Material.IRON_BLOCK, (byte)0);
      f14.setVelocity(new Vector(0, 7, 0));
      
      ((ArrayList)fallingblocktoremove.get(paramPlayer)).add(f1);
      ((ArrayList)fallingblocktoremove.get(paramPlayer)).add(f2);
      ((ArrayList)fallingblocktoremove.get(paramPlayer)).add(f3);
      ((ArrayList)fallingblocktoremove.get(paramPlayer)).add(f4);
      ((ArrayList)fallingblocktoremove.get(paramPlayer)).add(f5);
      ((ArrayList)fallingblocktoremove.get(paramPlayer)).add(f6);
      ((ArrayList)fallingblocktoremove.get(paramPlayer)).add(f7);
      ((ArrayList)fallingblocktoremove.get(paramPlayer)).add(f8);
      ((ArrayList)fallingblocktoremove.get(paramPlayer)).add(f9);
      ((ArrayList)fallingblocktoremove.get(paramPlayer)).add(f10);
      ((ArrayList)fallingblocktoremove.get(paramPlayer)).add(f11);
      ((ArrayList)fallingblocktoremove.get(paramPlayer)).add(f12);
      ((ArrayList)fallingblocktoremove.get(paramPlayer)).add(f13);
      ((ArrayList)fallingblocktoremove.get(paramPlayer)).add(f14);
      
      f1.setDropItem(false);
      f2.setDropItem(false);
      f3.setDropItem(false);
      f4.setDropItem(false);
      f5.setDropItem(false);
      f6.setDropItem(false);
      f7.setDropItem(false);
      f8.setDropItem(false);
      f9.setDropItem(false);
      f10.setDropItem(false);
      f11.setDropItem(false);
      f12.setDropItem(false);
      f13.setDropItem(false);
      f14.setDropItem(false);
      
      f1.setMetadata("ugBlockse", new FixedMetadataValue(
        plugin, "ugBlockse"));
      f2.setMetadata("ugBlockse", new FixedMetadataValue(
        plugin, "ugBlockse"));
      f3.setMetadata("ugBlockse", new FixedMetadataValue(
        plugin, "ugBlockse"));
      f4.setMetadata("ugBlockse", new FixedMetadataValue(
        plugin, "ugBlockse"));
      
      f5.setMetadata("ugBlockse", new FixedMetadataValue(
        plugin, "ugBlockse"));
      f6.setMetadata("ugBlockse", new FixedMetadataValue(
        plugin, "ugBlockse"));
      f7.setMetadata("ugBlockse", new FixedMetadataValue(
        plugin, "ugBlockse"));
      f8.setMetadata("ugBlockse", new FixedMetadataValue(
        plugin, "ugBlockse"));
      f9.setMetadata("ugBlockse", new FixedMetadataValue(
        plugin, "ugBlockse"));
      f10.setMetadata("ugBlockse", new FixedMetadataValue(
        plugin, "ugBlockse"));
      f11.setMetadata("ugBlockse", new FixedMetadataValue(
        plugin, "ugBlockse"));
      f12.setMetadata("ugBlockse", new FixedMetadataValue(
        plugin, "ugBlockse"));
      f13.setMetadata("ugBlockse", new FixedMetadataValue(
        plugin, "ugBlockse"));
      f14.setMetadata("ugBlockse", new FixedMetadataValue(
        plugin, "ugBlockse"));
      
      stationnaire.remove(paramPlayer);
      if ((paramPlayer.isValid()) || (stationnaire.containsKey(paramPlayer))) {
        f14.setPassenger(paramPlayer);
      }
      Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable(){
        public void run() {
       
          f5.remove();
          f6.remove();
          f7.remove();
          f8.remove();
          f1.remove();
          f2.remove();
          f3.remove();
          f4.remove();
          
          f9.remove();
          f10.remove();
          f11.remove();
          f12.remove();
          f13.remove();
          f14.remove();
          if ((stationnaire.containsKey(paramPlayer)) || 
        		  (effect.containsKey(paramPlayer)) ||
        		  (arrowToRemove.containsKey(paramPlayer)) || 
        		  (fallingblocktoremove.containsKey(paramPlayer))) {
              stationnaire.remove(paramPlayer);
              effect.remove(paramPlayer);
              arrowToRemove.remove(paramPlayer);
              fallingblocktoremove.remove(paramPlayer);
          }
        }
      }, 160L);
    }
  
  @EventHandler
  public void paramPlayerActiveFirework(PlayerInteractEvent paramPlayerActiveFogueteEvent)
  {
    final Player paramPlayer = paramPlayerActiveFogueteEvent.getPlayer();
    Action paramAction = paramPlayerActiveFogueteEvent.getAction();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (this.plugin.getUtilBlock().usable(paramPlayerActiveFogueteEvent.getClickedBlock())) {
      return;
    }
    if (this.plugin.getItem().isGadgetItem(paramItem, plugin.getMessagesFile().fogueteGadgetName)) {
      if (UtilCooldown.tryCooldown(paramPlayer, "Foguete", plugin.getConfigFile().fogueteCooldown))
      {
        constructFirework(paramPlayer, paramPlayer.getLocation());
      }else{
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "Foguete") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Foguete", "Foguete", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
        UtilTitles.sendCooldownTitle(paramPlayer, 
        plugin.getMessagesFile().titleMessage,
        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
      }
    }
  }
}
