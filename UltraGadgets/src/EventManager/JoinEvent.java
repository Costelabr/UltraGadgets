package EventManager;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.floodeer.gadgets.Main;

import Core.ActionBar;
import Gadgets.Tipos;
import Pets.Pets.PetsType;

public class JoinEvent
  implements Listener
{
  Main plugin = Main.getMain();
 
  
  @EventHandler
  public void playerJoin(PlayerJoinEvent e)
  {
    final Player p = e.getPlayer();
    Tipos.setGadget(p, Tipos.NENHUM);
    p.getInventory().setItem(this.plugin.getConfig().getInt("Slot-Gadget-Join-Item"), this.plugin.getItemStack().newItemStack(Material.PISTON_BASE, this.plugin.getMessagesFile().GadgetItemName, 
      Arrays.asList(plugin.getMessagesFile().GadgetItemLore), 1, (byte)0));
   
    Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
    {
      public void run()
      {
          ActionBar.sendActionBar(p, "§6§lGadget §e§: " + Tipos.getPlayerGadget.get(p));
      }
    }, 1L, 1L);
  }
  
  @EventHandler
  public void onPlayerClick(PlayerInteractEvent e)
  {
    if ((e.getAction() != Action.RIGHT_CLICK_AIR) && (e.getAction() != Action.RIGHT_CLICK_AIR)) {
      return;
    }
    Player p = e.getPlayer();
    if (!this.plugin.getItem().isGadgetItem(p.getItemInHand(), this.plugin.getMessagesFile().GadgetItemName)) {
      return;
    }
    p.performCommand("ug gadgets");
  }
  
  @EventHandler
  public void playerLeave(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    Tipos.setGadget(p, Tipos.NENHUM);
    PetsType.removePet(p);
  }
}
