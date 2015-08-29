package Gadgets;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Utils.UtilCooldown;
import Utils.UtilTitles;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class Movire
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
  ArrayList<Player> paramIsFireN = new ArrayList<Player>();
  
  @EventHandler
  public void paramPlayerActiveMovire(PlayerInteractEvent paramPlayerActiveFireMove)
  {
    final Player paramPlayer = paramPlayerActiveFireMove.getPlayer();
    Action paramAction = paramPlayerActiveFireMove.getAction();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (this.plugin.getUtilBlock().usable(paramPlayerActiveFireMove.getClickedBlock())) {
      return;
    }
    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().MovireGadgetName)) {
      if (UtilCooldown.tryCooldown(paramPlayer, "FIRE", this.plugin.getConfigFile().MovireCooldown))
      {
        this.paramIsFireN.add(paramPlayer);
        paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 240, 1));
        Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
        {
          public void run()
          {
            Movire.this.paramIsFireN.remove(paramPlayer);
            paramPlayer.setFireTicks(0);
          }
        }, 240L);
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "FIRE") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Movire", "FIRE", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
        UtilTitles.sendCooldownTitle(paramPlayer, 
        plugin.getMessagesFile().titleMessage,
        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
      }
    }
  }
  
  @SuppressWarnings("deprecation")
@EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
  public void paramPlayerMove(PlayerMoveEvent paramEvent)
  {
    Player paramPlayer = paramEvent.getPlayer();
    if (this.paramIsFireN.contains(paramPlayer))
    {
      Block b = paramEvent.getTo().getBlock();
      if ((b.getType() != Material.WATER) && 
 		     (b.getType() != Material.STATIONARY_WATER) && 
 		      (b.getType() != Material.CHEST) && 
 		       (b.getType() != Material.SKULL) && 
 		         (b.getType() != Material.SNOW) && 
 		          (b.getType() != Material.CLAY_BRICK)) {
 	  plugin.getUtilBlock().setBlockToRestore(b, Material.FIRE.getId(), (byte)0, 4L, true, false, false);
      }
    }
  }
  
  @EventHandler
  public void paramPlayerDamageByFire(EntityDamageEvent paramEventDamage)
  {
    if ((paramEventDamage.getEntity() instanceof Player)) {
      if (((paramEventDamage.getCause() == EntityDamageEvent.DamageCause.FIRE ? 1 : 0) | (paramEventDamage.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK ? 1 : 0)) != 0)
      {
        Player paramPlayer = (Player)paramEventDamage.getEntity();
        if (this.paramIsFireN.contains(paramPlayer)) {
          paramEventDamage.setCancelled(true);
        }
      }
    }
  }
}
