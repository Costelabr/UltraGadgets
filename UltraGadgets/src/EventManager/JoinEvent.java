package EventManager;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import br.com.floodeer.ultragadgets.UltraGadgets;
import Pets.Pets.PetsType;
import Gadgets.Tipos;
import Utils.ActionBar;

public class JoinEvent
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
  public static Map<Player, Integer> run = new HashMap<Player, Integer>();
 
  
  @EventHandler
  public void playerJoin(PlayerJoinEvent e)
  {
    final Player p = e.getPlayer();
    Tipos.setGadget(p, Tipos.NENHUM);
    p.getInventory().setItem(this.plugin.getConfig().getInt("Slot-Gadget-Join-Item"), this.plugin.getItemStack().newItemStack(Material.PISTON_BASE, this.plugin.getMessagesFile().GadgetItemName, Arrays.asList(plugin.getMessagesFile().GadgetItemLore), 1, (byte)0));
    if(plugin.getConfig().getBoolean("Usar-ActionBar")) {
    int t = Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
    {
      public void run()
      {
          ActionBar.sendActionBar(p, "�6�lGadget �e�: " + Tipos.getPlayerGadget.get(p));
      }
    }, 1L, 1L).getTaskId();
    run.put(p, t);
  }
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
