package Menus;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import Pets.PetManager;
import Pets.Pets.PetsType;
import Utils.UtilMenu;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class PetMenu
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
  public String invname = plugin.getMessagesFile().PetsMenuName; 
  public UtilMenu petMenu = new UtilMenu(plugin, invname, 6);
  
  public void showPetMenu(Player p) {
   
   if(PetsType.HasPet(p)) {
	petMenu.setItem(4, plugin.getItemStack().newItemStack(Material.PAPER, "§aPet Manager", Arrays.asList(new String[] { "§7Gerenciar seu pet atual" }), 1, (byte)0));
	}else{
		petMenu.setItem(4, new ItemStack(Material.AIR));
	}
		 
	 if(p.hasPermission("ug.pets.galinha") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
     petMenu.setItem(12, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aGalinha", Arrays.asList(new String[] { "§7Pet Galinha" }), 1, (byte)93));
      }else{
		petMenu.setItem(12, plugin.getItemStack().noPermissionItem("§7Galinha"));
	  }        
    
	 if(p.hasPermission("ug.pets.vaca") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    petMenu.setItem(13, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aVaca", Arrays.asList(new String[] { "§7Pet Vaca" }), 1, (byte)92));
     }else{
		petMenu.setItem(13, plugin.getItemStack().noPermissionItem("§7Vaca"));
	 } 
	 
	 if(p.hasPermission("ug.pets.coelho") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    petMenu.setItem(14, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aCoelho", Arrays.asList(new String[] { "§7Pet Coelho" }), 1, (byte)101));
     }else{
		petMenu.setItem(14, plugin.getItemStack().noPermissionItem("§7Coelho"));
	 } 
	 
	 if(p.hasPermission("ug.pets.lobo") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    petMenu.setItem(21, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aLobo", Arrays.asList(new String[] { "§7Pet Lobo" }), 1, (byte)95));
     }else{
		petMenu.setItem(21, plugin.getItemStack().noPermissionItem("§7Lobo"));
	 } 
	 
	 if(p.hasPermission("ug.pets.porco") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    petMenu.setItem(22, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aPorco", Arrays.asList(new String[] { "§7Pet Porco" }), 1, (byte)90));
     }else{
		petMenu.setItem(22, plugin.getItemStack().noPermissionItem("§7Porco"));
	 } 
	 
	 if(p.hasPermission("ug.pets.slime") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
		petMenu.setItem(23, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aSlime", Arrays.asList(new String[] { "§7Pet Slime" }), 1, (byte)55));
	}else{
		petMenu.setItem(23, plugin.getItemStack().noPermissionItem("§7Slime"));
	} 
    
	 if(p.hasPermission("ug.pets.ovelha") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
			petMenu.setItem(30, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aOvelha", Arrays.asList(new String[] { "§7Pet Ovelha" }), 1, (byte)91));
	   }else{
		petMenu.setItem(30, plugin.getItemStack().noPermissionItem("§7Ovelha"));
	} 
    
    petMenu.setItem(31, plugin.getItemStack().setSoonTM());
    
    petMenu.setItem(32, plugin.getItemStack().setSoonTM());
    
    petMenu.setItem(39, plugin.getItemStack().setBackArrow());
    
    petMenu.setItem(40, plugin.getItemStack().newItemStack(Material.BARRIER, "§aRemover Pet", Arrays.asList(new String[] { "§7Clique para remover seu Pet" }), 1, (byte)14));
    
    petMenu.setItem(41, plugin.getItemStack().setGoArrow());
    
    petMenu.showMenu(p);
  }
  
  @EventHandler
  public void paramHandlePetMenus(InventoryClickEvent e)
  {
    if ((e.getInventory().getName().equalsIgnoreCase(invname)) && ((e.getWhoClicked() instanceof Player)) && (e.getClick() == ClickType.LEFT))
    {
      int slotClicked = e.getSlot();
      Player p = (Player)e.getWhoClicked();
      e.setCancelled(true);
      e.setResult(Result.DENY);
      p.closeInventory();
      if (slotClicked == 12) {
    	 if(!p.hasPermission("ug.pets.galinha") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().petspermission);
    		 return;
    	 }
    	 if(PetsType.HasPet(p)) {
    		 p.sendMessage("Você já tem um pet!");
    		 return;
    	 }
    	 
        PetsType.setPet(p, PetsType.GALINHA);
      }
      if (slotClicked == 13) {
     	 if(!p.hasPermission("ug.pets.vaca") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().petspermission);
    		 return;
    	 }
    	 if(PetsType.HasPet(p)) {
    		 p.sendMessage("Você já tem um pet!");
    		 return;
    	 }
       PetsType.setPet(p, PetsType.VACA);
      }
      if (slotClicked == 14) {
     	 if(!p.hasPermission("ug.pets.coelho") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().petspermission);
    		 return;
    	 }
    	 if(PetsType.HasPet(p)) {
    		 p.sendMessage("Você já tem um pet!");
    		 return;
    	 }
          PetsType.setPet(p, PetsType.COELHO);
         }
      if (slotClicked == 21) {
     	 if(!p.hasPermission("ug.pets.lobo") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().petspermission);
    		 return;
    	 }
    	 if(PetsType.HasPet(p)) {
    		 p.sendMessage("Você já tem um pet!");
    		 return;
    	 }
          PetsType.setPet(p, PetsType.WOLF);
         }
      
      if (slotClicked == 22) {
      	 if(!p.hasPermission("ug.pets.porco") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
     		 p.sendMessage(plugin.getMessagesFile().petspermission);
     		 return;
     	 }
    	 if(PetsType.HasPet(p)) {
    		 p.sendMessage("Você já tem um pet!");
    		 return;
    	 }
           PetsType.setPet(p, PetsType.PORCO);
          }
      if (slotClicked == 23) {
       	 if(!p.hasPermission("ug.pets.slime") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
      		 p.sendMessage(plugin.getMessagesFile().petspermission);
      		 return;
      	 }
      	 if(PetsType.HasPet(p)) {
      		 p.sendMessage("Você já tem um pet!");
      		 return;
      	 }
            PetsType.setPet(p, PetsType.SLIME);
        }
      
      if (slotClicked == 30) {
        	 if(!p.hasPermission("ug.pets.ovelha") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
       		 p.sendMessage(plugin.getMessagesFile().petspermission);
       		 return;
       	 }
       	 if(PetsType.HasPet(p)) {
       		 p.sendMessage("Você já tem um pet!");
       		 return;
       	 }
             PetsType.setPet(p, PetsType.SHEEP);
         }
      
      if (slotClicked == 40) {
    	if(!PetsType.HasPet(p)) {
    		p.sendMessage("§cVocê não tem nenhum pet para remover.");
    		p.closeInventory();
    		return;
    	}
        PetsType.removePet(p);
        PetsType.setPet(p, PetsType.NENHUM);
      }
      if (slotClicked == 41)
      {
        p.sendMessage("§7§oEm breve!");
        p.closeInventory();
      }
      if(e.getCurrentItem().getType() == Material.PAPER) {
    	  new PetManager().showManagerMenu(p);
      }
      if (slotClicked == 39)
      {
        p.closeInventory();     
        plugin.getMenuManager().gadgetMenu.showMenu(p);
      }
    }
  }
}
