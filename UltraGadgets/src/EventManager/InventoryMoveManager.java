package EventManager;

import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import br.com.floodeer.ultragadgets.UltraGadgets;

public class InventoryMoveManager
  implements Listener
{
  static UltraGadgets plugin = UltraGadgets.getMain();
  
  @EventHandler
  public void onPlayerClick(PlayerDropItemEvent e)
  {
    ItemStack i = e.getItemDrop().getItemStack();
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().GadgetItemName)) {
      e.setCancelled(true);
    }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().BombaGadgetName)) {
      e.setCancelled(true);
    }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().FunGunGadgetName)) {
      e.setCancelled(true);
    }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().CookieGadgetName)) {
      e.setCancelled(true);
    }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().StickOfTpGadgetName)) {
      e.setCancelled(true);
    }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().PaintballGunGadgetName)) {
      e.setCancelled(true);
    }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().fogueteGadgetName)) {
      e.setCancelled(true);
    }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().DiscoBallGadgetName)) {
      e.setCancelled(true);
    }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().RailGunGadgetName)) {
      e.setCancelled(true);
    }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().SmokeBombGadgetName)) {
      e.setCancelled(true);
    }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().DiamondPartyGadgetName)) {
      e.setCancelled(true);
    }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().ParaquedasGadgetName)) {
      e.setCancelled(true);
    }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().WitherShooterName)) {
      e.setCancelled(true);
    }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().TrampolimName)) {
      e.setCancelled(true);
    }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().VectorGadgetName)) {
        e.setCancelled(true);
      }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().VampireGadgetName)) {
        e.setCancelled(true);
      }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().CowboyGadgetName)) {
        e.setCancelled(true);
      }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().ExplosiveSheepName)) {
        e.setCancelled(true);
      }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().discoArmorName)) {
        e.setCancelled(true);
      }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().socoGadgetName)) {
        e.setCancelled(true);
      }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().gravidadeGadgetName)) {
        e.setCancelled(true);
      }
    if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().partyPopperGadgetName)) {
        e.setCancelled(true);
      }
    if (plugin.getItem().startsName(i, "�6�lMob Gun")) {
        e.setCancelled(true);
    }
  }
  
  @EventHandler(priority = EventPriority.HIGH)
  public void onClickInv(InventoryClickEvent e)
  {
    if ((e.getWhoClicked() instanceof Player)) 
    {
      ItemStack i = e.getCurrentItem();
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().GadgetItemName)) {
        e.setCancelled(true);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().BombaGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().partyPopperGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().FunGunGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().CookieGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().StickOfTpGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().PaintballGunGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().FireworkPartyGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().fogueteGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().DiscoBallGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().RailGunGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().SmokeBombGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().DiamondPartyGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().ParaquedasGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().WitherShooterName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().TrampolimName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().VectorGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().VampireGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY); 
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().CowboyGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().ExplosiveSheepName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().discoArmorName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().socoGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().isGadgetItem(i, plugin.getMessagesFile().gravidadeGadgetName))
      {
        e.setCancelled(true);
        e.setResult(Result.DENY);
      }
      if (plugin.getItem().startsName(i, "�6�lMob Gun")) {
          e.setCancelled(true);
          e.setResult(Result.DENY); 
        }
      }
    }
  }
