package Menus;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import Core.UtilDisguise.DisguiseType;
import Core.*;
import com.floodeer.gadgets.Main;

public class DisguiseMenu
  implements Listener
{
  Main plugin = Main.getMain();;
  String invname =  this.plugin.getMessagesFile().DisguiseMenuName;;
  String trans = this.plugin.getMessagesFile().newDisguise;
  public UtilMenu disguiseMenu = new UtilMenu(this.plugin, this.invname, 6);
  
  public void showDisguiseMenu(Player p) {
    
  	if(p.hasPermission("ug.disguise.zumbi") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.disguiseMenu.setItem(12, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Zombie", Arrays.asList(new String[] { "§7Clique para virar um Zumbi" }), 1, (byte)54));
  	}else{
  		this.disguiseMenu.setItem(12, this.plugin.getItemStack().noPermissionItem("§7Zombie"));
  	}
    
	if(p.hasPermission("ug.disguise.esqueleto") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.disguiseMenu.setItem(13, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Skeleton", Arrays.asList(new String[] { "§7Clique para virar um Esqueleto" }), 1, (byte)5));
  	}else{
  		this.disguiseMenu.setItem(13, this.plugin.getItemStack().noPermissionItem("§7Esqueleto"));
  	}  
    
	if(p.hasPermission("ug.disguise.aranha") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.disguiseMenu.setItem(14, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Spider", Arrays.asList(new String[] { "§7Clique para virar uma Aranha" }), 1, (byte)52));
  	}else{
  		this.disguiseMenu.setItem(14, this.plugin.getItemStack().noPermissionItem("§7Aranha"));
  	}  
    
	if(p.hasPermission("ug.disguise.bruxa") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.disguiseMenu.setItem(21, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Witch", Arrays.asList(new String[] { "§7Clique para virar uma Bruxa" }), 1, (byte)66));
  	}else{
  		this.disguiseMenu.setItem(21, this.plugin.getItemStack().noPermissionItem("§7Bruxa"));
  	}
    
	if(p.hasPermission("ug.disguise.pigzumbi") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.disguiseMenu.setItem(22, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Zombie Pigman", Arrays.asList(new String[] { "§7Clique para virar um Porco Zumbi" }), 1, (byte)57));
  	}else{
  		this.disguiseMenu.setItem(22, this.plugin.getItemStack().noPermissionItem("§7Zombie Pigman"));
  	}
    
    this.disguiseMenu.setItem(23, this.plugin.getItemStack().setSoonTM());
    
    this.disguiseMenu.setItem(30, this.plugin.getItemStack().setSoonTM());
    
    this.disguiseMenu.setItem(31, this.plugin.getItemStack().setSoonTM());
    
    this.disguiseMenu.setItem(32, this.plugin.getItemStack().setSoonTM());
    
    this.disguiseMenu.setItem(40, this.plugin.getItemStack().newItemStack(Material.WOOL, "§cRemover Fantasia", Arrays.asList(new String[] { "§7Clique para voltar a ser um Player!" }), 1, (byte)14));
    
    this.disguiseMenu.setItem(39, this.plugin.getItemStack().setBackArrow());
    
    this.disguiseMenu.setItem(41, this.plugin.getItemStack().setGoArrow());
    
    this.disguiseMenu.showMenu(p);
  }
  
  @EventHandler
  public void onPlayerClickInGadgetInventory(InventoryClickEvent e)
  {
    if ((e.getInventory().getName().equalsIgnoreCase(this.invname)) && ((e.getWhoClicked() instanceof Player)))
    {
      int slotClicked = e.getSlot();
      Player p = (Player)e.getWhoClicked();
      e.setCancelled(true);
      e.setResult(Result.DENY);
      p.closeInventory();
      UtilDisguise zamb = new UtilDisguise(DisguiseType.ZOMBIE, p.getName());
      UtilDisguise skelly = new Core.UtilDisguise(DisguiseType.SKELETON, p.getName());
      UtilDisguise spider = new UtilDisguise(DisguiseType.SPIDER, p.getName());
      UtilDisguise w = new UtilDisguise(DisguiseType.WITCH, p.getName());
      UtilDisguise zpig = new UtilDisguise(DisguiseType.ZOMBIEPIG, p.getName());
      if (slotClicked == 12)
      {
      	if(!p.hasPermission("ug.disguise.zumbi") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        zamb.disguiseToAll();
        p.sendMessage(this.trans + "§c§lZumbi");
      }
      if (slotClicked == 13)
      {
    	if(!p.hasPermission("ug.disguise.esqueleto") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        skelly.disguiseToAll();
        p.sendMessage(this.trans + "§c§lEsqueleto");
      }
      if (slotClicked == 14)
      {
      	if(!p.hasPermission("ug.disguise.aranha") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        spider.disguiseToAll();
        p.sendMessage(this.trans + "§c§lAranha");
      }
      if (slotClicked == 21)
      {
      	if(!p.hasPermission("ug.disguise.bruxa") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        w.disguiseToAll();
        p.sendMessage(this.trans + "§c§lBruxa");
      }
      if (slotClicked == 22)
      {
      	if(!p.hasPermission("ug.disguise.pigzumbi") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        zpig.disguiseToAll();
        p.sendMessage(this.trans + "§c§lPorco Zumbi");
      }
      if (slotClicked == 39)
      {
        p.closeInventory();
        this.plugin.getMenuManager().gadgetMenu.showMenu(p);
      }
      if (slotClicked == 40)
      {
      	if(!p.hasPermission("ug.disguise.remover") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        skelly.removeDisguise();
        spider.removeDisguise();
        w.removeDisguise();
        zamb.removeDisguise();
        zpig.removeDisguise();
        p.playSound(p.getLocation(), Sound.ZOMBIE_UNFECT, 5.0F, -12.0F);
      }
    }
  }
}
