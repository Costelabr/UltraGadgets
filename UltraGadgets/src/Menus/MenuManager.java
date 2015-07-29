package Menus;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import Core.UtilMenu;
import Core.WardrobeUtils;

import com.floodeer.gadgets.Main;

public class MenuManager
  implements Listener
{
  Main plugin = Main.getMain();;
  String invname = this.plugin.getMessagesFile().MainMenuName;
  public UtilMenu gadgetMenu = new UtilMenu(plugin, invname, 5);
  WardrobeUtils w;
  
  public void showMenu(Player p) {
    
	this.gadgetMenu.setItem(4, plugin.getItemStack().newItemStack(Material.SADDLE, "§bMontarias", Arrays.asList(new String[] { "§7Clique para selecionar sua Montaria!" }), 1, (byte)0));
    
    this.gadgetMenu.setItem(11, this.plugin.getItemStack().newItemStack(Material.INK_SACK, "§bPartículas", Arrays.asList(new String[] { "§7Clique para selecionar sua partícula!" }), 1, (byte)4));
   
    this.gadgetMenu.setItem(15, this.plugin.getItemStack().newItemStack(Material.NETHER_STAR, "§bSuper Partículas", Arrays.asList(new String[] { "§7Super partículas!" }), 1, (byte)0));
    
    this.gadgetMenu.setItem(22, plugin.getItemStack().newItemStack(Material.PISTON_BASE, "§bGadgets", Arrays.asList(new String[] { "§7Clique para selecionar Gadgets!" }), 1, (byte)0));
    
    this.gadgetMenu.setItem(29, this.plugin.getItemStack().newItemStack(Material.SKULL_ITEM, "§bFantasias", Arrays.asList(new String[] { "§7Clique se fantasiar de Mobs!" }), 1, (byte)1));
    
    this.gadgetMenu.setItem(33, this.plugin.getItemStack().newItemStack(Material.IRON_CHESTPLATE, "§bGuarda-Roupa", Arrays.asList(new String[] { "§7Clique para selecionar sua armadura!" }), 1, (byte)0));
    
    this.gadgetMenu.setItem(40, this.plugin.getItemStack().newItemStack(Material.BONE, "§bPets", Arrays.asList(new String[] { "§7Clique para ter um Pet!" }), 1, (byte)0));
    
    gadgetMenu.showMenu(p);
  }
  
  @EventHandler
  public void onPlayerClickInGadgetInventory(InventoryClickEvent e)
  {
    if ((e.getInventory().getName().equalsIgnoreCase(this.invname)) && ((e.getWhoClicked() instanceof Player)))
    {
      Player p = (Player)e.getWhoClicked();
      int slotClicked = e.getSlot();
      e.setCancelled(true);
      e.setResult(Result.DENY);
      if (slotClicked == 4) {
        plugin.getMountsMenu().showMountMenu(p);
      }
      if (slotClicked == 11) {
        this.plugin.getParticlesMenu().showParticlesMenu(p);
      }
      if (slotClicked == 15) {
        this.plugin.getSuperMenu().showSuperMenu(p);
      }
      if (slotClicked == 22) {
          this.plugin.getGadgetsMenu().showGadgetsPage1(p);
        }
      if (slotClicked == 29) {
        this.plugin.getDisguiseMenu().showDisguiseMenu(p);
      }
      if (slotClicked == 33) {
    	   if(p.hasPermission("ug.wadrobe.usar") || (p.hasPermission("ug.usar.todos"))) {
    	   w = new WardrobeUtils(this.plugin, p);
    	   }else{
    		   p.sendMessage(ChatColor.RED + "Você não tem permissão.");
    	   }
        }
      if (slotClicked == 40) {
          this.plugin.getPetsMenu().showPetMenu(p);
        }
    }
  }
}
