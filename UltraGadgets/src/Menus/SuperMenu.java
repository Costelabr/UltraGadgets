package Menus;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import Core.UtilMenu;
import Core.ParticleEffect;
import Core.UtilParticle.ParticleType;

import com.floodeer.gadgets.UltraGadgets;

public class SuperMenu
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
  String invname = this.plugin.getMessagesFile().SuperMenuName;
  public UtilMenu spMenu = new UtilMenu(this.plugin, this.invname, 6);
  
  public void showSuperMenu(Player p) {
    
    this.spMenu.setItem(39, this.plugin.getItemStack().setBackArrow());
    
    if(p.hasPermission("ug.sparticula.lava") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.spMenu.setItem(12, this.plugin.getItemStack().newItemStack(Material.LAVA_BUCKET, "§aLava", null, 1, (byte)0));
  	}else{
  		this.spMenu.setItem(12, this.plugin.getItemStack().noPermissionItem("§7Lava"));
  	}
    
    if(p.hasPermission("ug.sparticula.agua") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.spMenu.setItem(13, this.plugin.getItemStack().newItemStack(Material.WATER_BUCKET, "§aÁgua", null, 1, (byte)0));
  	}else{
  		this.spMenu.setItem(13, this.plugin.getItemStack().noPermissionItem("§7Água"));
  	}
    
    if(p.hasPermission("ug.sparticula.rhappy") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.spMenu.setItem(14, this.plugin.getItemStack().newItemStack(Material.EMERALD_BLOCK, "§aRoration Happy", null, 1, (byte)0));
  	}else{
  		this.spMenu.setItem(14, this.plugin.getItemStack().noPermissionItem("§7Roration Happy"));
  	}
    
    if(p.hasPermission("ug.sparticula.rcoracoes") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.spMenu.setItem(21, this.plugin.getItemStack().newItemStack(Material.RED_ROSE, "§aRoration Corações", null, 1, (byte)0));
  	}else{
  		this.spMenu.setItem(21, this.plugin.getItemStack().noPermissionItem("§7Roration Corações"));
  	}
    
    if(p.hasPermission("ug.sparticula.flamehelix") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.spMenu.setItem(22, this.plugin.getItemStack().newItemStack(Material.BLAZE_POWDER, "§aHelix of Fire", null, 1, (byte)0));
  	}else{
  		this.spMenu.setItem(22, this.plugin.getItemStack().noPermissionItem("§7Flame Helix"));
  	}
    
    if(p.hasPermission("ug.sparticula.redhelix") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.spMenu.setItem(23, this.plugin.getItemStack().newItemStack(Material.REDSTONE_BLOCK, "§aHelix of Dust", null, 1, (byte)0));
  	}else{
  		this.spMenu.setItem(23, this.plugin.getItemStack().noPermissionItem("§7Red Helix"));
  	}
    
    if(p.hasPermission("ug.sparticula.frozen") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.spMenu.setItem(30, this.plugin.getItemStack().newItemStack(Material.SNOW_BLOCK, "§fFrozen", null, 1, (byte)0));
  	}else{
  		this.spMenu.setItem(30, this.plugin.getItemStack().noPermissionItem("§7Frozen"));
  	}
    
    if(p.hasPermission("ug.sparticula.watercircle") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.spMenu.setItem(31, this.plugin.getItemStack().newItemStack(Material.GLASS_BOTTLE, "§fCírculo de Água", null, 1, (byte)0));
  	}else{
  		this.spMenu.setItem(31, this.plugin.getItemStack().noPermissionItem("§7Circle of Water"));
  	}
    
    
    if(p.hasPermission("ug.sparticula.nuvem") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    this.spMenu.setItem(32, this.plugin.getItemStack().newItemStack(Material.ICE, "§fNuvem", null, 1, (byte)0));
  	}else{
  		this.spMenu.setItem(32, this.plugin.getItemStack().noPermissionItem("§7Nuvem"));
  	}
    
    this.spMenu.setItem(39, this.plugin.getItemStack().setBackArrow());
    
    this.spMenu.setItem(40, this.plugin.getItemStack().newItemStack(Material.BARRIER, "§aRemover Partículas", 
      null, 1, (byte)14));
    
    this.spMenu.setItem(41, this.plugin.getItemStack().setGoArrow());
    
    this.spMenu.showMenu(p);
  }
  
  @EventHandler
  public void onClickInParticlesMenu(InventoryClickEvent e)
  {
    if ((e.getInventory().getName().equalsIgnoreCase(this.invname)) && ((e.getWhoClicked() instanceof Player)))
    {
      Player p = (Player)e.getWhoClicked();
      e.setCancelled(true);
      e.setResult(Result.DENY);
      int slot = e.getSlot();
      if (slot == 12) {
      	if(!p.hasPermission("ug.sparticula.lava") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().superparticlepermission);
    		return;
    	}
       if (!this.plugin.getUtilPartciles().hasEffect(p)) {
        p.sendMessage(this.plugin.getMessagesFile().newParticle + "§cLava");
        this.plugin.getUtilPartciles().radarEffect(p, ParticleEffect.DRIP_LAVA);
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.LAVA, 1.0F, 1.0F);
      }
     }
      if (slot == 13){ 
        if(!p.hasPermission("ug.sparticula.agua") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
         p.sendMessage(plugin.getMessagesFile().superparticlepermission);
          return;
        }
        if(!this.plugin.getUtilPartciles().hasEffect(p)) {
        p.sendMessage(this.plugin.getMessagesFile().newParticle + "§cAgua");
        this.plugin.getUtilPartciles().radarEffect(p, ParticleEffect.DRIP_WATER);
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.WATER, 1.0F, 1.0F);
      }
     }
      if (slot == 14) { 
        if(!p.hasPermission("ug.sparticula.rhappy") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
        	p.sendMessage(plugin.getMessagesFile().superparticlepermission);
        	return;
        }
       if(!this.plugin.getUtilPartciles().hasEffect(p)) {
        p.sendMessage(this.plugin.getMessagesFile().newParticle + "§cRoration Happy");
        this.plugin.getUtilPartciles().SpiralEffect(p, ParticleEffect.VILLAGER_HAPPY);
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 12.0F);
      }
     }
      if (slot == 21) {
        if(!p.hasPermission("ug.sparticula.rcoracoes") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
          p.sendMessage(plugin.getMessagesFile().superparticlepermission);
        	return;
        }
        if(!this.plugin.getUtilPartciles().hasEffect(p)) {
        p.sendMessage(this.plugin.getMessagesFile().newParticle + "§cRoration Corações");
        this.plugin.getUtilPartciles().SpiralEffect(p, ParticleEffect.HEART);
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.GHAST_MOAN, 1.0F, 1.0F);
      }
     }
      if (slot == 22) {
        if(!p.hasPermission("ug.sparticula.flamehelix") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
          p.sendMessage(plugin.getMessagesFile().superparticlepermission);
            return;
        }
        if(!this.plugin.getUtilPartciles().hasEffect(p)) {
        this.plugin.getUtilPartciles().startHelix(p, ParticleType.FLAME);
        p.closeInventory();
        p.sendMessage(this.plugin.getMessagesFile().newParticle + "§cFlame Helix");
        p.playSound(p.getLocation(), Sound.FIZZ, 1.0F, 12.0F);
      }
     }
      if (slot == 23) {
          if(!p.hasPermission("ug.sparticula.redhelix") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().superparticlepermission);
              return;
          }
          if(!this.plugin.getUtilPartciles().hasEffect(p)) {
          this.plugin.getUtilPartciles().startHelix(p, ParticleType.REDSTONE);
          p.closeInventory();
          p.sendMessage(this.plugin.getMessagesFile().newParticle + "§cRed Relix");
          p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 1.0F, 12.0F);
        }
       }
     if(slot == 30) {
    	 if(!p.hasPermission("ug.sparticula.frozen") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
             p.sendMessage(plugin.getMessagesFile().superparticlepermission);
             return;
         }
    	 if(!this.plugin.getUtilPartciles().hasEffect(p)) {
    		 p.closeInventory();
    		 p.sendMessage(this.plugin.getMessagesFile().newParticle + "§7Frozen");
    		 p.playSound(p.getLocation(), Sound.STEP_SNOW, 1.0F, 12.0F);
    		 plugin.getUtilPartciles().otherType.put(p, "Frozen");
    	 }
     }
     if(slot == 31) {
    	 if(!p.hasPermission("ug.sparticula.watercircle") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
             p.sendMessage(plugin.getMessagesFile().superparticlepermission);
             return;
         }
    	 if(!this.plugin.getUtilPartciles().hasEffect(p)) {
    		 p.closeInventory();
    		 p.sendMessage(this.plugin.getMessagesFile().newParticle + "§7Circle of Water");
    		 p.playSound(p.getLocation(), Sound.WATER, 1.0F, 12.0F);
    		 plugin.getUtilPartciles().circleOfParticles(p, ParticleEffect.DRIP_WATER);
    	 }
     }
     if(slot == 32) {
    	 if(!p.hasPermission("ug.sparticula.nuvem") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
             p.sendMessage(plugin.getMessagesFile().superparticlepermission);
             return;
         }
    	 if(!this.plugin.getUtilPartciles().hasEffect(p)) {
    		 p.closeInventory();
    		 p.sendMessage(this.plugin.getMessagesFile().newParticle + "§7Nuvem");
    		 p.playSound(p.getLocation(), Sound.STEP_SNOW, 1.0F, 12.0F);
    		 plugin.getUtilPartciles().otherType.put(p, "Nuvem");
    	 }
     }
     
      if (slot == 40) {
    	if(!plugin.getUtilPartciles().hasEffect(p)) {
    		p.sendMessage("§cVocê não tem partículas para desativar.");
    		p.closeInventory();
    		return;
    	}
        this.plugin.getUtilPartciles().stopAll(p);
        p.closeInventory();
      }
      if (slot == 41)
      {
        p.closeInventory();
        p.sendMessage("§7§oEm breve!");
      }
      if (slot == 39)
      {
        p.closeInventory();
        this.plugin.getMenuManager().gadgetMenu.showMenu(p);
      }
    }
   }
}
