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
import com.floodeer.gadgets.UltraGadgets;

public class DisguiseMenu
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();;
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
    this.disguiseMenu.setItem(13, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Skeleton", Arrays.asList(new String[] { "§7Clique para virar um Esqueleto" }), 1, (byte)51));
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
    
	if(p.hasPermission("ug.disguise.enderman") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	this.disguiseMenu.setItem(23, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Enderman", Arrays.asList(new String[] { "§7Clique para virar um Enderman" }), 1, (byte)58));
  	}else{
  		this.disguiseMenu.setItem(23, this.plugin.getItemStack().noPermissionItem("§7Enderman"));
  	}  
	
	if(p.hasPermission("ug.disguise.blaze") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	this.disguiseMenu.setItem(30, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Blaze", Arrays.asList(new String[] { "§7Clique para virar um Blaze" }), 1, (byte)61));
  	}else{
  		this.disguiseMenu.setItem(30, this.plugin.getItemStack().noPermissionItem("§7Blaze"));
  	}    
	if(p.hasPermission("ug.disguise.creeper") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	this.disguiseMenu.setItem(31, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Creeper", Arrays.asList(new String[] { "§7Clique para virar um Creeper" }), 1, (byte)50));
  	}else{
  		this.disguiseMenu.setItem(31, this.plugin.getItemStack().noPermissionItem("§7Creeper"));
  	} 
    
	if(p.hasPermission("ug.disguise.witherskeleton") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	this.disguiseMenu.setItem(32, this.plugin.getItemStack().newItemStack(Material.SOUL_SAND, "§7Wither Skeleton", Arrays.asList(new String[] { "§7Clique para virar um WitherSkeleton" }), 1, (byte)0));
  	}else{
  		this.disguiseMenu.setItem(32, this.plugin.getItemStack().noPermissionItem("§7Wither Skeleton"));
  	} 
    
    this.disguiseMenu.setItem(40, this.plugin.getItemStack().newItemStack(Material.BARRIER, "§cRemover Fantasia", Arrays.asList(new String[] { "§7Clique para voltar a ser um Player!" }), 1, (byte)14));
    
    this.disguiseMenu.setItem(39, this.plugin.getItemStack().setBackArrow());
    
    this.disguiseMenu.setItem(41, this.plugin.getItemStack().setGoArrow());
    
    this.disguiseMenu.showMenu(p);
  }
  
  public void disguisePlayer(Player p, DisguiseType type) {
	  
      UtilDisguise zamb = new UtilDisguise(DisguiseType.ZOMBIE, p.getUniqueId());
      UtilDisguise skelly = new Core.UtilDisguise(DisguiseType.SKELETON, p.getUniqueId());
      UtilDisguise spider = new UtilDisguise(DisguiseType.SPIDER, p.getUniqueId());
      UtilDisguise w = new UtilDisguise(DisguiseType.WITCH, p.getUniqueId());
      UtilDisguise zpig = new UtilDisguise(DisguiseType.ZOMBIEPIG, p.getUniqueId());
      UtilDisguise enderman = new UtilDisguise(DisguiseType.ENDERMAN, p.getUniqueId());
      UtilDisguise blaze = new UtilDisguise(DisguiseType.BLAZE, p.getUniqueId());
      UtilDisguise creeper = new UtilDisguise(DisguiseType.CREEPER, p.getUniqueId());
      
      switch (type) {
	case ZOMBIE:
		zamb.disguiseToAll();
		
		break;

	case SKELETON:
		skelly.disguiseToAll();
		break;
		
	case SPIDER:
		spider.disguiseToAll();
		break;
		
	case WITCH:
		w.disguiseToAll();
		break;
		
		
	case ZOMBIEPIG:
		zpig.disguiseToAll();
		break;
		
		
	case ENDERMAN:
		enderman.disguiseToAll();
		break;
		
	case BLAZE:
	    blaze.disguiseToAll();
		break;
		
	case CREEPER:
		creeper.disguiseToAll();
	default:
		break;
	}
  }
  
  public void removeAllDisguises(Player p) {
	  
      UtilDisguise zamb = new UtilDisguise(DisguiseType.ZOMBIE, p.getUniqueId());
      UtilDisguise skelly = new Core.UtilDisguise(DisguiseType.SKELETON, p.getUniqueId());
      UtilDisguise spider = new UtilDisguise(DisguiseType.SPIDER, p.getUniqueId());
      UtilDisguise w = new UtilDisguise(DisguiseType.WITCH, p.getUniqueId());
      UtilDisguise zpig = new UtilDisguise(DisguiseType.ZOMBIEPIG, p.getUniqueId());
      UtilDisguise enderman = new UtilDisguise(DisguiseType.ENDERMAN, p.getUniqueId());
      UtilDisguise blaze = new UtilDisguise(DisguiseType.BLAZE, p.getUniqueId());
      UtilDisguise creeper = new UtilDisguise(DisguiseType.CREEPER, p.getUniqueId());
      zamb.removeDisguise();
      skelly.removeDisguise();
      spider.removeDisguise();
      w.removeDisguise();
      zpig.removeDisguise();
      enderman.removeDisguise();
      blaze.removeDisguise();
      creeper.removeDisguise();
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
      if (slotClicked == 12)
      {
      	if(!p.hasPermission("ug.disguise.zumbi") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        disguisePlayer(p, DisguiseType.ZOMBIE);
        p.sendMessage(this.trans + "§c§lZumbi");
      }
      if (slotClicked == 13)
      {
    	if(!p.hasPermission("ug.disguise.esqueleto") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        disguisePlayer(p, DisguiseType.SKELETON);
        p.sendMessage(this.trans + "§c§lEsqueleto");
      }
      if (slotClicked == 14)
      {
      	if(!p.hasPermission("ug.disguise.aranha") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        disguisePlayer(p, DisguiseType.SPIDER);
        p.sendMessage(this.trans + "§c§lAranha");
      }
      if (slotClicked == 21)
      {
      	if(!p.hasPermission("ug.disguise.bruxa") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        disguisePlayer(p, DisguiseType.WITCH);
        p.sendMessage(this.trans + "§c§lBruxa");
      }
      if (slotClicked == 22)
      {
      	if(!p.hasPermission("ug.disguise.pigzumbi") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        disguisePlayer(p, DisguiseType.ZOMBIEPIG);
        p.sendMessage(this.trans + "§c§lPorco Zumbi");
      }
      
      if (slotClicked == 23)
      {
      	if(!p.hasPermission("ug.disguise.enderman") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        disguisePlayer(p, DisguiseType.ENDERMAN);
        p.sendMessage(this.trans + "§c§lEnderman");
      }
      
      if (slotClicked == 30)
      {
      	if(!p.hasPermission("ug.disguise.blaze") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        disguisePlayer(p, DisguiseType.BLAZE);
        p.sendMessage(this.trans + "§c§lBlaze");
      }
      
      if (slotClicked == 31)
      {
      	if(!p.hasPermission("ug.disguise.creeper") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        disguisePlayer(p, DisguiseType.CREEPER);
        p.sendMessage(this.trans + "§c§lCreeper");
      }
      if (slotClicked == 32)
      {
      	if(!p.hasPermission("ug.disguise.witherskeleton") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        disguisePlayer(p, DisguiseType.WITHER_SKELETON);
        p.sendMessage(this.trans + "§c§lWither Skeleton");
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
        removeAllDisguises(p);	
        p.playSound(p.getLocation(), Sound.ZOMBIE_UNFECT, 5.0F, -12.0F);
      }
    }
  }
}
