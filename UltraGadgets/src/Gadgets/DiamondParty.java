package Gadgets;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
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
import org.bukkit.util.Vector;

import Utils.FireworkNMSHandler;
import Utils.UtilCooldown;
import Utils.UtilTitles;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class DiamondParty extends FireworkNMSHandler
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
  
  private void startParty(final Player p) {
	  
    final Vector direction = Vector.getRandom();
    direction.setX(direction.getX() - 0.5D);
    direction.setY(0.6F);
    direction.setZ(direction.getZ() - 0.5D);
    final BukkitTask ftask = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable()
    {
      public void run()
      {
        try
        {
          ItemStack paramDiamond = new ItemStack(Material.DIAMOND);
          final Item paramItemDrop = p.getWorld().dropItem(p.getEyeLocation().add(0.0D, 0.0D, 0.0D), paramDiamond);
          paramItemDrop.setVelocity(direction);
          paramItemDrop.setPickupDelay(Integer.MAX_VALUE);
          Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
          {
            public void run()
            {
              paramItemDrop.remove();
            }
          }, 36L);
          playFirework(p.getLocation().add(0.0D, 2.8D, 0.0D), 
            FireworkEffect.builder()
            .withColor(Color.BLUE)
            .withColor(Color.AQUA)
            .withColor(Color.WHITE)
            .withFade(Color.WHITE)
            .with(FireworkEffect.Type.BURST)
            .build());
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    }, 1L, 5L);
    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
    {
      public void run()
      {
        ftask.cancel();
      }
    }, 240L);
  }
  
  @EventHandler
  public void paramPlayerUseDiamondParty(PlayerInteractEvent paramPlayerUseDiamondPartyEvent)
  {
    Player paramPlayer = paramPlayerUseDiamondPartyEvent.getPlayer();
    Action paramAction = paramPlayerUseDiamondPartyEvent.getAction();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (plugin.getUtilBlock().usable(paramPlayerUseDiamondPartyEvent.getClickedBlock())) {
      return;
    }
    if (plugin.getItem().isGadgetItem(paramItem, plugin.getMessagesFile().DiamondPartyGadgetName)) {
      if (UtilCooldown.tryCooldown(paramPlayer, "DiamondParty", plugin.getConfigFile().DiamondPartyCooldown))
      {
        startParty(paramPlayer);
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "DiamondParty") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Diamond Party", "DiamondParty", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
        UtilTitles.sendCooldownTitle(paramPlayer, 
        plugin.getMessagesFile().titleMessage,
        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
      }
    }
  }
}