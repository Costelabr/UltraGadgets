package Menus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import Utils.*;
import Utils.UtilDisguise.DisguiseType;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class DisguiseMenu
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();;
  String invname =  this.plugin.getMessagesFile().DisguiseMenuName;;
  String trans = this.plugin.getMessagesFile().newDisguise;
  public UtilMenu disguiseMenu = new UtilMenu(this.plugin, this.invname, 6);
  public static Map<UUID, String> disguiseType = new HashMap<UUID, String>();
  public List<Player> blazes = new ArrayList<Player>();
  
  public void showDisguiseMenu(Player p) {
    
  	if(p.hasPermission("ug.disguise.zumbi") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.disguiseMenu.setItem(12, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Zombie", Arrays.asList(new String[] { "§7Clique para virar um Zumbi" }), 1, (byte)54));
  	}else{
  		this.disguiseMenu.setItem(12, this.plugin.getItemStack().noPermissionItem("§aZombie"));
  	}
    
	if(p.hasPermission("ug.disguise.esqueleto") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.disguiseMenu.setItem(13, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Skeleton", Arrays.asList(new String[] { "§7Clique para virar um Esqueleto" }), 1, (byte)51));
  	}else{
  		this.disguiseMenu.setItem(13, this.plugin.getItemStack().noPermissionItem("§aEsqueleto"));
  	}  
    
	if(p.hasPermission("ug.disguise.aranha") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.disguiseMenu.setItem(14, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Spider", Arrays.asList(new String[] { "§7Clique para virar uma Aranha" }), 1, (byte)52));
  	}else{
  		this.disguiseMenu.setItem(14, this.plugin.getItemStack().noPermissionItem("§aAranha"));
  	}  
    
	if(p.hasPermission("ug.disguise.bruxa") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.disguiseMenu.setItem(21, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Witch", Arrays.asList(new String[] { "§7Clique para virar uma Bruxa" }), 1, (byte)66));
  	}else{
  		this.disguiseMenu.setItem(21, this.plugin.getItemStack().noPermissionItem("§aBruxa"));
  	}
    
	if(p.hasPermission("ug.disguise.pigzumbi") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.disguiseMenu.setItem(22, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Zombie Pigman", Arrays.asList(new String[] { "§7Clique para virar um Porco Zumbi" }), 1, (byte)57));
  	}else{
  		this.disguiseMenu.setItem(22, this.plugin.getItemStack().noPermissionItem("§aZombie Pigman"));
  	}
    
	if(p.hasPermission("ug.disguise.enderman") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	this.disguiseMenu.setItem(23, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Enderman", Arrays.asList(new String[] { "§7Clique para virar um Enderman" }), 1, (byte)58));
  	}else{
  		this.disguiseMenu.setItem(23, this.plugin.getItemStack().noPermissionItem("§aEnderman"));
  	}  
	
	if(p.hasPermission("ug.disguise.blaze") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	this.disguiseMenu.setItem(30, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Blaze", Arrays.asList(new String[] { "§7Clique para virar um Blaze" }), 1, (byte)61));
  	}else{
  		this.disguiseMenu.setItem(30, this.plugin.getItemStack().noPermissionItem("§aBlaze"));
  	}    
	if(p.hasPermission("ug.disguise.creeper") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	this.disguiseMenu.setItem(31, this.plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§7Creeper", Arrays.asList(new String[] { "§7Clique para virar um Creeper" }), 1, (byte)50));
  	}else{
  		this.disguiseMenu.setItem(31, this.plugin.getItemStack().noPermissionItem("§aCreeper"));
  	} 
    
	if(p.hasPermission("ug.disguise.witherskeleton") || (p.hasPermission("ug.disguise.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	this.disguiseMenu.setItem(32, this.plugin.getItemStack().newItemStack(Material.SOUL_SAND, "§7Wither Skeleton", Arrays.asList(new String[] { "§7Clique para virar um WitherSkeleton" }), 1, (byte)0));
  	}else{
  		this.disguiseMenu.setItem(32, this.plugin.getItemStack().noPermissionItem("§aWither Skeleton"));
  	} 
    
    this.disguiseMenu.setItem(40, this.plugin.getItemStack().newItemStack(Material.BARRIER, "§cRemover Fantasia", Arrays.asList(new String[] { "§7Clique para voltar a ser um Player!" }), 1, (byte)14));
    
    this.disguiseMenu.setItem(39, this.plugin.getItemStack().setBackArrow());
    
    this.disguiseMenu.setItem(41, this.plugin.getItemStack().setGoArrow());
    
    this.disguiseMenu.showMenu(p);
  }
  
  public boolean hasDisguise(Player p) {
	  if(disguiseType.get(p.getUniqueId()) != null && disguiseType.get(p.getUniqueId()) != "Nenhum") {
		  return true;
	  }
	  return false;
  }
  
  public void disguisePlayer(Player p, DisguiseType type) {
	  
      UtilDisguise zamb = new UtilDisguise(DisguiseType.ZOMBIE, p.getUniqueId());
      UtilDisguise skelly = new Utils.UtilDisguise(DisguiseType.SKELETON, p.getUniqueId());
      UtilDisguise spider = new UtilDisguise(DisguiseType.SPIDER, p.getUniqueId());
      UtilDisguise w = new UtilDisguise(DisguiseType.WITCH, p.getUniqueId());
      UtilDisguise zpig = new UtilDisguise(DisguiseType.ZOMBIEPIG, p.getUniqueId());
      UtilDisguise enderman = new UtilDisguise(DisguiseType.ENDERMAN, p.getUniqueId());
      UtilDisguise blaze = new UtilDisguise(DisguiseType.BLAZE, p.getUniqueId());
      UtilDisguise creeper = new UtilDisguise(DisguiseType.CREEPER, p.getUniqueId());
      UtilDisguise wskelly = new UtilDisguise(DisguiseType.WITHER_SKELETON, p.getUniqueId());
      
      switch (type) {
	case ZOMBIE:
		zamb.disguiseToAll();
		disguiseType.put(p.getUniqueId(), "Zombie");
		
		break;

	case SKELETON:
		skelly.disguiseToAll();
		disguiseType.put(p.getUniqueId(), "Skeleton");
		break;
		
	case SPIDER:
		spider.disguiseToAll();
		disguiseType.put(p.getUniqueId(), "Spider");
		break;
		
	case WITCH:
		w.disguiseToAll();
		disguiseType.put(p.getUniqueId(), "Witch");
		break;
		
		
	case ZOMBIEPIG:
		zpig.disguiseToAll();
		disguiseType.put(p.getUniqueId(), "ZombiePig");
		break;
		
		
	case ENDERMAN:
		enderman.disguiseToAll();
		disguiseType.put(p.getUniqueId(), "Enderman");
		break;
		
	case BLAZE:
	    blaze.disguiseToAll();
	    blazes.add(p);
		disguiseType.put(p.getUniqueId(), "Blaze");
		break;
		
	case CREEPER:
		creeper.disguiseToAll();
		disguiseType.put(p.getUniqueId(), "Creeper");
		break;
	case WITHER_SKELETON:
		wskelly.disguiseToAll();
		disguiseType.put(p.getUniqueId(), "WitherSkeleton");
    break;
	default:
		break;
	}
  }
  
  public void removeAllDisguises(Player p) {
	  
      UtilDisguise zamb = new UtilDisguise(DisguiseType.ZOMBIE, p.getUniqueId());
      UtilDisguise skelly = new Utils.UtilDisguise(DisguiseType.SKELETON, p.getUniqueId());
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
      disguiseType.put(p.getUniqueId(), "Nenhum");
      if(blazes.contains(p)) {
    	  blazes.remove(p);
      }
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
        p.sendMessage("§cHabilidade: §7Clique com botão esquerdo para usar suas habilidades de Teleport!");
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
        p.sendMessage("§cHabilidade: §7Segure Shift para voar!");
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
        p.sendMessage("§cHabilidade: §7Aperte Shift para Explodir!");
      }
      if (slotClicked == 32)
      {
      	if(!p.hasPermission("ug.disguise.witherskeleton") & !p.hasPermission("ug.disguise.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().disguisePermission);
    		return;
    	}
        p.playSound(p.getLocation(), Sound.ZOMBIE_INFECT, 5.0F, -12.0F);
        disguisePlayer(p, DisguiseType.WITHER_SKELETON);
        p.sendMessage(trans + "§c§lWither Skeleton");
        p.sendMessage("§cHabilidade: §7Clique com botão esquerdo para lançar cabeças de Wither!");
      }
      if (slotClicked == 39)
      {
        p.closeInventory();
        this.plugin.getMenuManager().gadgetMenu.showMenu(p);
      }
      if(slotClicked == 41) {
    	  p.sendMessage("§7§oEm breve!");
      }
      if (slotClicked == 40)  {
    	p.sendMessage("§cSua fantasia foram removida.");
        removeAllDisguises(p);	
        p.playSound(p.getLocation(), Sound.ZOMBIE_UNFECT, 5.0F, -12.0F);
        p.closeInventory();
      }
    }
  }
}
