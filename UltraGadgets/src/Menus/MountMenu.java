package Menus;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.Event.Result;
import org.bukkit.event.inventory.InventoryClickEvent;

import Mounts.MountHandler;
import Mounts.Mounts;
import Utils.UtilMenu;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class MountMenu implements Listener {
	
	UltraGadgets plugin = UltraGadgets.getMain();
	String mountTitle = plugin.getMessagesFile().mountMenuName;
	String ativado = plugin.getMensagensConfig().getString("Novo-Mount").replaceAll("&", "§");
	public UtilMenu mountMenu = new UtilMenu(plugin, mountTitle, 6);
	
  public void showMountMenu(Player p) {
		    
	if(p.hasPermission("ug.mount.frozen") || p.hasPermission("ug.mount.usar.todos") || p.hasPermission("ug.usar.todos")) {
	mountMenu.setItem(10, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§bFrozen", Arrays.asList(new String[] { "§7Por onde passar o lugar ficará gelado!" }), 1, (byte)69));
	}else{
  		mountMenu.setItem(10, plugin.getItemStack().noPermissionItem("§7Frozen"));
	}
	
	if(p.hasPermission("ug.mount.infernal") || p.hasPermission("ug.mount.usar.todos") || p.hasPermission("ug.usar.todos")) {
	mountMenu.setItem(11, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§bInfernal", Arrays.asList(new String[] { "§7Um rastro infernal por onde passar." }), 1, (byte)61));
	}else{
  		mountMenu.setItem(11, plugin.getItemStack().noPermissionItem("§7Infernal"));
	}
    
    mountMenu.setItem(50, plugin.getItemStack().setBackArrow());
    
    mountMenu.setItem(49, plugin.getItemStack().newItemStack(Material.BARRIER, "§aRemover Montaria", Arrays.asList(new String[] { "§7Clique para remover seu mount" }), 1, (byte)14));
    
    mountMenu.setItem(48, plugin.getItemStack().setGoArrow());
    
    mountMenu.showMenu(p);
  }
  
  @EventHandler
  public void handlerInventory(InventoryClickEvent e) {
	  if(e.getWhoClicked() instanceof Player && e.getInventory().getName().equalsIgnoreCase(mountTitle)) {
		 int slotClicked = e.getSlot();
	     Player p = (Player)e.getWhoClicked();
	     e.setCancelled(true);
	     e.setResult(Result.DENY);
	     p.closeInventory();
	     if(slotClicked == 48) {
	    	 p.closeInventory();
	    	 plugin.getMenuManager().showMenu(p);
	     }
	     if(slotClicked == 50) {	    	 
	    	 p.sendMessage("§7§oEm breve!");
	     }
	     if(slotClicked == 49) {
	    	 if(MountHandler.HasPet(p)) {
	    	 MountHandler.removePlayerMount(p);
	    	 p.sendMessage("§cVocê removeu sua Montaria.");
	    	 }else{
	    		 p.sendMessage("§cVocê não tem nenhum Mount para remover!");
	    	 }
	     }
	     if(slotClicked == 10) { 
	    	 if(!p.hasPermission("ug.mount.frozen") & !p.hasPermission("ug.mount.usar.todos") & !p.hasPermission("ug.usar.todos")) {
		     p.sendMessage(plugin.getMessagesFile().petspermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
		    return;
		    }
	    	 if(MountHandler.HasPet(p)) {
	    	 MountHandler.removePlayerMount(p);
	    	 }
	    	 Mounts.summonMount(p, Mounts.FROZEN);
	    	 p.sendMessage(ativado + ChatColor.AQUA + " Frozen"); 
	     }
	     if(slotClicked == 11) {
	    	 if(!p.hasPermission("ug.mount.infernal") & !p.hasPermission("ug.mount.usar.todos") & !p.hasPermission("ug.usar.todos")) {
				p.sendMessage(plugin.getMessagesFile().petspermission);
			    p.closeInventory();
			    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
				return;
			}
	    	 if(MountHandler.HasPet(p)) {
	    	 MountHandler.removePlayerMount(p);
	    	 }
	    	 Mounts.summonMount(p, Mounts.INFERNO);
	    	 p.sendMessage(ativado + ChatColor.AQUA + " Infernal"); 
	     }
	  }
  }
}
