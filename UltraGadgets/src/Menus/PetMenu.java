package Menus;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import Metodos.Menus;
import Pets.Pets.PetsType;

import com.floodeer.gadgets.Main;

public class PetMenu
  implements Listener
{
  Main plugin;
  String invname;
  public Menus petMenu;
  
  public PetMenu()
  {
    this.plugin = Main.getMain();
    this.invname = this.plugin.getMessagesFile().PetsMenuName;
    this.petMenu = new Menus(this.plugin, this.invname, 6);
    
    this.petMenu.setItem(12, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aGalinha", Arrays.asList(new String[] { "§7Pet Galinha" }), 1, (byte)93));
    
    this.petMenu.setItem(13, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aVaca", Arrays.asList(new String[] { "§7Pet Vaca" }), 1, (byte)92));
    
    this.petMenu.setItem(14, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aCoelho", Arrays.asList(new String[] { "§7Pet Coelho" }), 1, (byte)101));
    
    this.petMenu.setItem(21, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aLobo", Arrays.asList(new String[] { "§7Pet Lobo" }), 1, (byte)95));
    
    this.petMenu.setItem(22, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aOvelha", Arrays.asList(new String[] { "§7Pet Ovelha" }), 1, (byte)91));
    
    this.petMenu.setItem(23, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aPorco", Arrays.asList(new String[] { "§7Pet Porco" }), 1, (byte)90));
    
    this.petMenu.setItem(30, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aCavalo", Arrays.asList(new String[] { "§7Cavalo" }), 1, (byte)100));
    
    this.petMenu.setItem(31, this.plugin.getItemStack().setSoonTM());
    
    this.petMenu.setItem(32, this.plugin.getItemStack().setSoonTM());
    
    this.petMenu.setItem(39, this.plugin.getItemStack().setBackArrow());
    
    this.petMenu.setItem(40, this.plugin.getItemStack().newItemStack(Material.WOOL, "§aRemover Pet", Arrays.asList(new String[] { "§7Clique para remover seu Pet" }), 1, (byte)14));
    
    this.petMenu.setItem(41, this.plugin.getItemStack().setGoArrow());
  }
  
  @EventHandler
  public void paramHandlePetMenus(InventoryClickEvent e)
  {
    if ((e.getInventory().getName().equalsIgnoreCase(this.invname)) && ((e.getWhoClicked() instanceof Player)))
    {
      int slotClicked = e.getSlot();
      Player p = (Player)e.getWhoClicked();
      e.setCancelled(true);
      e.setResult(Result.DENY);
      p.closeInventory();
      if (slotClicked == 12) {
        PetsType.setPet(p, PetsType.GALINHA);
      }
      if (slotClicked == 13) {
       PetsType.setPet(p, PetsType.VACA);
      }
      if (slotClicked == 14) {
          PetsType.setPet(p, PetsType.COELHO);
         }
      if (slotClicked == 40) {
        PetsType.removePet(p);
      }
      if (slotClicked == 39)
      {
        p.closeInventory();
        plugin.getMenuManager().gadgetMenu.showMenu(p);
      }
    }
  }
}
