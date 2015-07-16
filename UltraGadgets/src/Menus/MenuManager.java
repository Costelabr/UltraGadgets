package Menus;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import Metodos.Menus;

import com.floodeer.gadgets.Main;

public class MenuManager
  implements Listener
{
  Main plugin;
  String invname;
  public Menus gadgetMenu;
  
  public MenuManager()
  {
    this.plugin = Main.getMain();
    
    this.invname = this.plugin.getMessagesFile().MainMenuName;
    
    this.gadgetMenu = new Menus(this.plugin, this.invname, 1);
    
    this.gadgetMenu.setItem(0, this.plugin.getItemStack().newItemStack(Material.ANVIL, "§bGadgets", Arrays.asList(new String[] { "§7Clique para selecionar Gadgets!" }), 1, (byte)0));
    
    this.gadgetMenu.setItem(2, this.plugin.getItemStack().newItemStack(Material.INK_SACK, "§bPartículas", Arrays.asList(new String[] { "§7Clique para selecionar sua partícula!" }), 1, (byte)4));
    
    this.gadgetMenu.setItem(4, this.plugin.getItemStack().newItemStack(Material.NETHER_STAR, "§bSuper Partículas", Arrays.asList(new String[] { "§7Super partículas!" }), 1, (byte)0));
    
    this.gadgetMenu.setItem(6, this.plugin.getItemStack().newItemStack(Material.SKULL_ITEM, "§bFantasias", Arrays.asList(new String[] { "§7Clique se fantasiar de Mobs!" }), 1, (byte)1));
    
    this.gadgetMenu.setItem(8, this.plugin.getItemStack().newItemStack(Material.BONE, "§bPets", Arrays.asList(new String[] { "§7Clique para ter um Pet!" }), 1, (byte)0));
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
      if (slotClicked == 0) {
        this.plugin.getGadgetsMenu().gadgets.showMenu(p);
      }
      if (slotClicked == 2) {
        this.plugin.getParticlesMenu().particleMenu.showMenu(p);
      }
      if (slotClicked == 4) {
        this.plugin.getSuperMenu().spMenu.showMenu(p);
      }
      if (slotClicked == 6) {
        this.plugin.getDisguiseMenu().disguiseMenu.showMenu(p);
      }
      if (slotClicked == 8)
      {
        PetMenu pets = new PetMenu();
        pets.petMenu.showMenu(p);
      }
    }
  }
}
