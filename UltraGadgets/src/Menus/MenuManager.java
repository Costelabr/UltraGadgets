package Menus;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import Utils.UtilMenu;
import Utils.Ward;
import Utils.WardrobeUtils;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class MenuManager
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();;
  String invname = plugin.getMessagesFile().MainMenuName;
  public UtilMenu gadgetMenu = new UtilMenu(plugin, invname, 5);
  WardrobeUtils w;
  
  public void showMenu(Player p) {
    
	gadgetMenu.setItem(4, plugin.getItemStack().newItemStack(Material.SADDLE, "§bMontarias", Arrays.asList(new String[] { "§7Clique para selecionar sua Montaria!" }), 1, (byte)0));
    
    gadgetMenu.setItem(11, plugin.getItemStack().newItemStack(Material.INK_SACK, "§bPartículas", Arrays.asList(new String[] { "§7Clique para selecionar sua partícula!" }), 1, (byte)4));
   
    gadgetMenu.setItem(15, plugin.getItemStack().newItemStack(Material.NETHER_STAR, "§bSuper Partículas", Arrays.asList(new String[] { "§7Super partículas!" }), 1, (byte)0));
    
    gadgetMenu.setItem(19, plugin.getItemStack().newItemStack(Material.WORKBENCH, "§bConstruir Gadget", Arrays.asList(new String[] { "§7Com as opções disponíveis, você pode montar seu", "§7próprio gadget!" }), 1, (byte)0)); 
  
    gadgetMenu.setItem(22, plugin.getItemStack().newItemStack(Material.PISTON_BASE, "§bGadgets", Arrays.asList(new String[] { "§7Clique para selecionar seu Gadget!" }), 1, (byte)0));
    
    gadgetMenu.setItem(25, plugin.getItemStack().newItemStack(Material.DIAMOND_HELMET, "§bChapéus", Arrays.asList(new String[] { "§7Clique para selecionar seu chapéu!" }), 1, (byte)0));
    
    gadgetMenu.setItem(29, plugin.getItemStack().newItemStack(Material.SKULL_ITEM, "§bFantasias", Arrays.asList(new String[] { "§7Clique se fantasiar de Mobs!" }), 1, (byte)1));
    
    gadgetMenu.setItem(33, plugin.getItemStack().newItemStack(Material.IRON_CHESTPLATE, "§bGuarda-Roupa", Arrays.asList(new String[] { "§7Clique para selecionar sua armadura!" }), 1, (byte)0));
    
    gadgetMenu.setItem(40, plugin.getItemStack().newItemStack(Material.BONE, "§bPets", Arrays.asList(new String[] { "§7Clique para ter um Pet!" }), 1, (byte)0));
    
    gadgetMenu.showMenu(p);
  }
  
  @EventHandler
  public void onPlayerClickInGadgetInventory(InventoryClickEvent e)
  {
    if ((e.getInventory().getName().equalsIgnoreCase(invname)) && ((e.getWhoClicked() instanceof Player)))
    {
      Player p = (Player)e.getWhoClicked();
      int slotClicked = e.getSlot();
      e.setCancelled(true);
      e.setResult(Result.DENY);
      if (slotClicked == 4) {
        plugin.getMountsMenu().showMountMenu(p);
      }
      if (slotClicked == 11) {
        plugin.getParticlesMenu().showParticlesMenu(p);
      }
      if (slotClicked == 15) {
        plugin.getSuperMenu().showSuperMenu(p);
      }
      if (slotClicked == 19) {
          p.sendMessage("§c§oEm breve!");
          p.closeInventory();
       }
      if (slotClicked == 25) {
          p.closeInventory();
          plugin.getHatsMenu().showHatsMenu1Page(p);
        }
      if (slotClicked == 22) {
          plugin.getGadgetsMenu().showGadgetsPage1(p);
        }
      if (slotClicked == 29) {
        plugin.getDisguiseMenu().showDisguiseMenu(p);
      }
      if (slotClicked == 33) {
    	   if(p.hasPermission("ug.wadrobe.usar") || (p.hasPermission("ug.usar.todos"))) {
    	   new Ward(p, plugin);
    	   }else{
    		   p.sendMessage(ChatColor.RED + "Você não tem permissão.");
    	   }
        }
      if (slotClicked == 40) {
          plugin.getPetsMenu().showPetMenu(p);
        }
    }
  }
}
