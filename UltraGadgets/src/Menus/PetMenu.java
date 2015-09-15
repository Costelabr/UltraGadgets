package Menus;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.Sound;
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
     petMenu.setItem(10, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aGalinha", null, 1, (byte)93));
      }else{
		petMenu.setItem(10, plugin.getItemStack().noPermissionItem("§7Galinha"));
	  }        
    
	 if(p.hasPermission("ug.pets.vaca") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    petMenu.setItem(11, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aVaca", null, 1, (byte)92));
     }else{
		petMenu.setItem(11, plugin.getItemStack().noPermissionItem("§7Vaca"));
	 } 
	 
	 if(p.hasPermission("ug.pets.coelho") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    petMenu.setItem(12, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aCoelho", null, 1, (byte)101));
     }else{
		petMenu.setItem(12, plugin.getItemStack().noPermissionItem("§7Coelho"));
	 } 
	 
	 if(p.hasPermission("ug.pets.lobo") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    petMenu.setItem(13, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aLobo", null, 1, (byte)95));
     }else{
		petMenu.setItem(13, plugin.getItemStack().noPermissionItem("§7Lobo"));
	 } 
	 
	 if(p.hasPermission("ug.pets.porco") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    petMenu.setItem(14, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aPorco", null, 1, (byte)90));
     }else{
		petMenu.setItem(14, plugin.getItemStack().noPermissionItem("§7Porco"));
	 } 
	 
	 if(p.hasPermission("ug.pets.creeper") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
		petMenu.setItem(15, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aCreeper", null, 1, (byte)50));
	}else{
		petMenu.setItem(15, plugin.getItemStack().noPermissionItem("§7Creeper"));
	} 
    
	 if(p.hasPermission("ug.pets.ovelha") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
			petMenu.setItem(16, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aOvelha", null, 1, (byte)91));
	   }else{
		petMenu.setItem(16, plugin.getItemStack().noPermissionItem("§7Ovelha"));
	} 
    
	 if(p.hasPermission("ug.pets.zombie") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
		petMenu.setItem(19, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aZombie", null, 1, (byte)54));
	}else{
		petMenu.setItem(19, plugin.getItemStack().noPermissionItem("§7Zombie"));
	} 
	 if(p.hasPermission("ug.pets.villager") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
		petMenu.setItem(20, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aVillager", Arrays.asList(new String[] { "§7Pet Villager" }), 1, (byte)120));
	}else{
		petMenu.setItem(20, plugin.getItemStack().noPermissionItem("§7Villager"));
	} 
	 if(p.hasPermission("ug.pets.enderman") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
		petMenu.setItem(21, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§aEnderman", null, 1, (byte)58));
	}else{
		petMenu.setItem(21, plugin.getItemStack().noPermissionItem("§7Enderman"));
	} 
    
    
    petMenu.setItem(48, plugin.getItemStack().setBackArrow());
    
    petMenu.setItem(49, plugin.getItemStack().newItemStack(Material.BARRIER, "§aRemover Pet", Arrays.asList(new String[] { "§7Clique para remover seu Pet" }), 1, (byte)14));
    
    petMenu.setItem(50, plugin.getItemStack().setGoArrow());
    
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
      if (slotClicked == 10) {
    	 if(!p.hasPermission("ug.pets.galinha") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().petspermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		 return;
    	 }
    	 if(PetsType.HasPet(p)) {
    		 p.sendMessage("Você já tem um pet!");
    		 return;
    	 }
    	 
        PetsType.setPet(p, PetsType.GALINHA);
        p.closeInventory();
      }
      if (slotClicked == 11) {
     	 if(!p.hasPermission("ug.pets.vaca") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().petspermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		 return;
    	 }
    	 if(PetsType.HasPet(p)) {
    		 PetsType.removePet(p);
    	 }
       PetsType.setPet(p, PetsType.VACA);
       p.closeInventory();
      }
      if (slotClicked == 12) {
     	 if(!p.hasPermission("ug.pets.coelho") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().petspermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		 return;
    	 }
    	 if(PetsType.HasPet(p)) {
    		 PetsType.removePet(p);
    	 }
          PetsType.setPet(p, PetsType.COELHO);
          p.closeInventory();
         }
      if (slotClicked == 13) {
     	 if(!p.hasPermission("ug.pets.lobo") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().petspermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		 return;
    	 }
    	 if(PetsType.HasPet(p)) {
    		 PetsType.removePet(p);
    	 }
          PetsType.setPet(p, PetsType.WOLF);
          p.closeInventory();
         }
      
      if (slotClicked == 14) {
      	 if(!p.hasPermission("ug.pets.porco") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
     		 p.sendMessage(plugin.getMessagesFile().petspermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
     		 return;
     	 }
    	 if(PetsType.HasPet(p)) {
    		 PetsType.removePet(p);
    	 }
           PetsType.setPet(p, PetsType.PORCO);
           p.closeInventory();
          }
      if (slotClicked == 15) {
       	 if(!p.hasPermission("ug.pets.creeper") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
      		 p.sendMessage(plugin.getMessagesFile().petspermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
      		 return;
      	 }
    	 if(PetsType.HasPet(p)) {
    		 PetsType.removePet(p);
    	 }
            PetsType.setPet(p, PetsType.CREEPER);
            p.closeInventory();
        }
      
      if (slotClicked == 16) {
        	 if(!p.hasPermission("ug.pets.ovelha") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
       		 p.sendMessage(plugin.getMessagesFile().petspermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
       		 return;
       	 }
        	if(PetsType.HasPet(p)) {
        	PetsType.removePet(p);
        }
             PetsType.setPet(p, PetsType.SHEEP);
             p.closeInventory();
       }
      
      if (slotClicked == 19) {
     	 if(!p.hasPermission("ug.pets.zombie") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().petspermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		 return;
    	 }
    	 if(PetsType.HasPet(p)) {
    		 PetsType.removePet(p);
    	 }
          PetsType.setPet(p, PetsType.ZOMBIE);
          p.closeInventory();
    }
      if (slotClicked == 20) {
      	 if(!p.hasPermission("ug.pets.villager") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
     		 p.sendMessage(plugin.getMessagesFile().petspermission);
 		     p.closeInventory();
 		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
     		 return;
     	 }
     	 if(PetsType.HasPet(p)) {
     		 PetsType.removePet(p);
     	 }
           PetsType.setPet(p, PetsType.VILLAGER);
           p.closeInventory();
     }
      if (slotClicked == 21) {
       	 if(!p.hasPermission("ug.pets.enderman") && !p.hasPermission("ug.pets.usar.todos") && !p.hasPermission("ug.usar.todos")) {
      		 p.sendMessage(plugin.getMessagesFile().petspermission);
  		     p.closeInventory();
  		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
      		 return;
      	 }
      	 if(PetsType.HasPet(p)) {
      		 PetsType.removePet(p);
      	 }
            PetsType.setPet(p, PetsType.ENDERMAN);
            p.closeInventory();
      }
       
       
      if (slotClicked == 49) {
    	if(!PetsType.HasPet(p)) {
    		p.sendMessage("§cVocê não tem nenhum pet para remover.");
    		p.closeInventory();
    		return;
    	}
        PetManager.infernal.remove(PetsType.booleanCreeper.get(p.getUniqueId()));
        PetManager.explosivo.remove(PetsType.booleanCreeper.get(p.getUniqueId()));
        PetsType.removePet(p);
        PetsType.setPet(p, PetsType.NENHUM);
        p.closeInventory();
      }
      if (slotClicked == 50)
      {
        p.sendMessage("§7§oEm breve!");
        p.closeInventory();
      }
      if(e.getCurrentItem().getType() == Material.PAPER) {
    	  new PetManager().showManagerMenu(p);
      }
      if (slotClicked == 48)
      {
        p.closeInventory();     
        plugin.getMenuManager().gadgetMenu.showMenu(p);
      }
    }
  }
}
