package Menus;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.Event.Result;
import org.bukkit.event.inventory.InventoryClickEvent;

import Core.UtilMenu;
import Mounts.MountHandler;
import Mounts.Mounts;

import com.floodeer.gadgets.Main;

public class MountMenu implements Listener {
	
	Main plugin = Main.getMain();
	String mountTitle = this.plugin.getMessagesFile().mountMenuName;
	String ativado = this.plugin.getMensagensConfig().getString("Novo-Mount").replaceAll("&", "§");
	public UtilMenu mountMenu = new UtilMenu(this.plugin, this.mountTitle, 6);
	
	
  public void showMountMenu(Player p) {
		    
	if(p.hasPermission("ug.mount.frozen") || p.hasPermission("ug.mount.usar.todos") || p.hasPermission("ug.usar.todos")) {
	this.mountMenu.setItem(12, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§bFrozen", Arrays.asList(new String[] { "§7Por onde passar o lugar ficará gelado!" }), 1, (byte)69));
	}else{
  		this.mountMenu.setItem(12, this.plugin.getItemStack().noPermissionItem("§7Frozen"));
	}
	
	this.mountMenu.setItem(13, this.plugin.getItemStack().setSoonTM());
		   
    this.mountMenu.setItem(14, this.plugin.getItemStack().setSoonTM());
	 
	this.mountMenu.setItem(21, this.plugin.getItemStack().setSoonTM());	    
	
	this.mountMenu.setItem(22, this.plugin.getItemStack().setSoonTM());
		    
    this.mountMenu.setItem(23, this.plugin.getItemStack().setSoonTM());
    
    this.mountMenu.setItem(30, this.plugin.getItemStack().setSoonTM());
    
    this.mountMenu.setItem(31, this.plugin.getItemStack().setSoonTM());
    
    this.mountMenu.setItem(32, this.plugin.getItemStack().setSoonTM());
    
    this.mountMenu.setItem(39, this.plugin.getItemStack().setBackArrow());
    
    this.mountMenu.setItem(40, this.plugin.getItemStack().newItemStack(Material.WOOL, "§aRemover Montaria", Arrays.asList(new String[] { "§7Clique para remover seu mount" }), 1, (byte)14));
    
    this.mountMenu.setItem(41, this.plugin.getItemStack().setGoArrow());
    
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
	     if(slotClicked == 39) {
	    	 p.sendMessage("§7§oEm breve!");
	     }
	     if(slotClicked == 41) {
	    	 plugin.getMenuManager().showMenu(p);
	     }
	     if(slotClicked == 40) {
	    	 if(MountHandler.HasPet(p)) {
	    	 MountHandler.removePlayerMount(p);
	    	 }
	     }
	     if(slotClicked == 12) {
	    	 Mounts.summonMount(p, Mounts.FROZEN);
	    	 p.sendMessage(this.ativado + ChatColor.AQUA + " Frozen"); 
	     }
	  }
  }
}
