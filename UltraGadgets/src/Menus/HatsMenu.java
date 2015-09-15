package Menus;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Utils.Deprecated;
import Utils.UtilMenu;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class HatsMenu implements Listener {
	
	UltraGadgets plugin = UltraGadgets.getMain();
	UtilMenu hats = new UtilMenu(plugin, plugin.getMensagensConfig().getString("Hats-Menu").replaceAll("&", "§"), 6);
	UtilMenu hats2page = new UtilMenu(plugin, plugin.getMensagensConfig().getString("Hats-Menu").replaceAll("&", "§") + "(2/3)", 6);
	UtilMenu hats3page = new UtilMenu(plugin, plugin.getMensagensConfig().getString("Hats-Menu").replaceAll("&", "§") + "(3/3)", 6);
	
	private ItemStack setHat(Material material, String nome) {
		ItemStack i = new ItemStack(material, 1, (byte)0);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(nome);
		i.setItemMeta(im);
		return i;
	}

	public void showHatsMenu1Page(Player p) {
		if(p.hasPermission("ug.chapeus.obsidian") || p.hasPermission("ug.chapeus.usar.todos") || p.hasPermission("ug.usar.todos")) {
		hats.setItem(10, setHat(Material.OBSIDIAN, "§aObsidian"));
		}else{
			hats.setItem(10, plugin.getItemStack().noPermissionItem("§7Obsidian"));
		}
		
		if(p.hasPermission("ug.chapeus.wool") || p.hasPermission("ug.chapeus.usar.todos") || p.hasPermission("ug.usar.todos")) {
		hats.setItem(11, setHat(Material.WOOL, "§aLã"));
		}else{
			hats.setItem(11, plugin.getItemStack().noPermissionItem("§7Lã"));
		}
		
		if(p.hasPermission("ug.chapeus.redstone") || p.hasPermission("ug.chapeus.usar.todos") || p.hasPermission("ug.usar.todos")) {
		hats.setItem(12, setHat(Material.REDSTONE_BLOCK, "§aBloco de Redstone"));
		}else{
			hats.setItem(12, plugin.getItemStack().noPermissionItem("§7Bloco de Redstone"));
		}
		
		if(p.hasPermission("ug.chapeus.lapis") || p.hasPermission("ug.chapeus.usar.todos") || p.hasPermission("ug.usar.todos")) {
		hats.setItem(13, setHat(Material.LAPIS_BLOCK, "§aBloco de Lapis"));
		}else{
			hats.setItem(13, plugin.getItemStack().noPermissionItem("§7Bloco de Lapis"));
		}
		
		if(p.hasPermission("ug.chapeus.diamond") || p.hasPermission("ug.chapeus.usar.todos") || p.hasPermission("ug.usar.todos")) {
		hats.setItem(14, setHat(Material.DIAMOND_BLOCK, "§aBloco de Diamante"));
		}else{
			hats.setItem(14, plugin.getItemStack().noPermissionItem("§7Bloco de Diamante"));
		}
		
		if(p.hasPermission("ug.chapeus.iron") || p.hasPermission("ug.chapeus.usar.todos") || p.hasPermission("ug.usar.todos")) {
		hats.setItem(15, setHat(Material.IRON_BLOCK, "§aBloco de Ferro"));
		}else{
			hats.setItem(15, plugin.getItemStack().noPermissionItem("§7Bloco de Ferro"));
		}
		
		if(p.hasPermission("ug.chapeus.gold") || p.hasPermission("ug.chapeus.usar.todos") || p.hasPermission("ug.usar.todos")) {
		hats.setItem(16, setHat(Material.GOLD_BLOCK, "§aBloco de Ouro"));
		}else{
			hats.setItem(16, plugin.getItemStack().noPermissionItem("§7Bloco de Ouro"));
		}
		
		if(p.hasPermission("ug.chapeus.log") || p.hasPermission("ug.chapeus.usar.todos") || p.hasPermission("ug.usar.todos")) {
		hats.setItem(19, setHat(Material.LOG, "§aBloco de Madeira"));
		}else{
			hats.setItem(19, plugin.getItemStack().noPermissionItem("§7Bloco de Madeira"));
		}
		
		if(p.hasPermission("ug.chapeus.nether") || p.hasPermission("ug.chapeus.usar.todos") || p.hasPermission("ug.usar.todos")) {
		hats.setItem(20, setHat(Material.NETHER_BRICK, "§aPedra do Nether"));
		}else{
			hats.setItem(20, plugin.getItemStack().noPermissionItem("§7Pedra do Nether"));
		}
		
		if(p.hasPermission("ug.chapeus.beacon") || p.hasPermission("ug.chapeus.usar.todos") || p.hasPermission("ug.usar.todos")) {
		hats.setItem(21, setHat(Material.BEACON, "§aSinalizador"));
		}else{
			hats.setItem(21, plugin.getItemStack().noPermissionItem("§7Sinalizador"));
		}
		if(p.hasPermission("ug.chapeus.cactus") || p.hasPermission("ug.chapeus.usar.todos") || p.hasPermission("ug.usar.todos")) {
		hats.setItem(22, setHat(Material.CACTUS, "§aCacto"));
		}else{
			hats.setItem(22, plugin.getItemStack().noPermissionItem("§7Cacto"));
		}
		if(p.hasPermission("ug.chapeus.cactus") || p.hasPermission("ug.chapeus.usar.todos") || p.hasPermission("ug.usar.todos")) {
		hats.setItem(23, setHat(Material.CACTUS, "§aCacto"));
		}else{
			hats.setItem(23, plugin.getItemStack().noPermissionItem("§7Cacto"));
		}
		if(p.hasPermission("ug.chapeus.coal") || p.hasPermission("ug.chapeus.usar.todos") || p.hasPermission("ug.usar.todos")) {
		hats.setItem(23, setHat(Material.COAL_BLOCK, "§aCarvão"));
		}else{
			hats.setItem(23, plugin.getItemStack().noPermissionItem("§7Carvão"));
		}
		
		
	    hats.setItem(49, plugin.getItemStack().newItemStack(Material.BARRIER, "§aRemover Hat", 
		Arrays.asList(new String[] {"§7Clique para remover seu chapeu" }), 1, (byte)0));
				    	    
		hats.setItem(50, plugin.getItemStack().setGoArrow());
				    
		hats.setItem(48, plugin.getItemStack().setBackArrow());
	    
	    hats.showMenu(p);
	  }
	
	@EventHandler
	public void onHandlerHatInventory(InventoryClickEvent e) {
		if(e.getWhoClicked() instanceof Player && e.getInventory().getName().equals(plugin.getMensagensConfig().getString("Hats-Menu").replaceAll("&", "§"))) {
		   e.setCancelled(true);
		   Player p = (Player)e.getWhoClicked();
		   int s = e.getSlot();
		   ItemStack item = e.getCurrentItem();
		   Deprecated.updateInventory(p);
		   p.closeInventory();
		 if (s == 10) {
		     if(!p.hasPermission("ug.chapeus.obsidian") & !p.hasPermission("ug.chapeus.usar.todos") & !p.hasPermission("ug.usar.todos")) {
		      p.sendMessage(plugin.getMessagesFile().hatPermission);
	          p.closeInventory();
	          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
		      return;
		     }
		     p.getInventory().setHelmet(item);
		     p.sendMessage(plugin.getMessagesFile().newHat + " Obsidian");
		   }
		 
		 if (s == 11) {
		     if(!p.hasPermission("ug.chapeus.wool") & !p.hasPermission("ug.chapeus.usar.todos") & !p.hasPermission("ug.usar.todos")) {
		      p.sendMessage(plugin.getMessagesFile().hatPermission);
	          p.closeInventory();
	          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
		      return;
		     }
		     p.getInventory().setHelmet(item);
		     p.sendMessage(plugin.getMessagesFile().newHat + " Lã");
		   }
		 
		 if (s == 12) {
		     if(!p.hasPermission("ug.chapeus.redstone") & !p.hasPermission("ug.chapeus.usar.todos") & !p.hasPermission("ug.usar.todos")) {
		      p.sendMessage(plugin.getMessagesFile().hatPermission);
	          p.closeInventory();
	          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
		      return;
		     }
		     p.getInventory().setHelmet(item);
		     p.sendMessage(plugin.getMessagesFile().newHat + " Bloco de Redstone");
		   }
		 
		 if (s == 13) {
		     if(!p.hasPermission("ug.chapeus.lapis") & !p.hasPermission("ug.chapeus.usar.todos") & !p.hasPermission("ug.usar.todos")) {
		      p.sendMessage(plugin.getMessagesFile().hatPermission);
	          p.closeInventory();
	          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
		      return;
		     }
		     p.getInventory().setHelmet(item);
		     p.sendMessage(plugin.getMessagesFile().newHat + " Bloco de Lapis");
		   }
		 
		 if (s == 14) {
		     if(!p.hasPermission("ug.chapeus.diamond") & !p.hasPermission("ug.chapeus.usar.todos") & !p.hasPermission("ug.usar.todos")) {
		      p.sendMessage(plugin.getMessagesFile().hatPermission);
	          p.closeInventory();
	          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
		      return;
		     }
		     p.getInventory().setHelmet(item);
		     p.sendMessage(plugin.getMessagesFile().newHat + " Bloco de Diamante");
		   }
		 
		 if (s == 15) {
		     if(!p.hasPermission("ug.chapeus.iron") & !p.hasPermission("ug.chapeus.usar.todos") & !p.hasPermission("ug.usar.todos")) {
		      p.sendMessage(plugin.getMessagesFile().hatPermission);
	          p.closeInventory();
	          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
		      return;
		     }
		     p.getInventory().setHelmet(item);
		     p.sendMessage(plugin.getMessagesFile().newHat + " Bloco de Ferro");
		   }
		 
		 if (s == 16) {
		     if(!p.hasPermission("ug.chapeus.log") & !p.hasPermission("ug.chapeus.usar.todos") & !p.hasPermission("ug.usar.todos")) {
		      p.sendMessage(plugin.getMessagesFile().hatPermission);
	          p.closeInventory();
	          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
		      return;
		     }
		     p.getInventory().setHelmet(item);
		     p.sendMessage(plugin.getMessagesFile().newHat + " Madeira");
		   }
		 
		 if (s == 19) {
		     if(!p.hasPermission("ug.chapeus.nether") & !p.hasPermission("ug.chapeus.usar.todos") & !p.hasPermission("ug.usar.todos")) {
		      p.sendMessage(plugin.getMessagesFile().hatPermission);
	          p.closeInventory();
	          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
		      return;
		     }
		     p.getInventory().setHelmet(item);
		     p.sendMessage(plugin.getMessagesFile().newHat + " Pedra do Nether");
		   }
		 
		 if (s == 20) {
		     if(!p.hasPermission("ug.chapeus.beacon") & !p.hasPermission("ug.chapeus.usar.todos") & !p.hasPermission("ug.usar.todos")) {
		      p.sendMessage(plugin.getMessagesFile().hatPermission);
	          p.closeInventory();
	          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
		      return;
		     }
		     p.getInventory().setHelmet(item);
		     p.sendMessage(plugin.getMessagesFile().newHat + " Sinalizador");
		   }
		   if(s == 48) {
			   p.closeInventory();
			   plugin.getMenuManager().showMenu(p);
		   }
		   if(s == 50) {
			   p.closeInventory();
			   p.sendMessage("§7§oEm breve!");
		   }
		   if(s == 49) {
			   p.getInventory().setHelmet(null);
			   if(p.getInventory().getHelmet() == null) {
				   p.sendMessage("§cVocê não parece ter Hats para remover!");
				   return;
			   }
			   p.sendMessage("§cVocê removeu seus Hats!");
			   p.closeInventory();
		   }
		}
	}
}
