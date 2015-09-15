package Menus;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import Utils.ParticleEffect;
import Utils.UtilMenu;
import Utils.UtilParticle.ParticleType;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class SuperMenu
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
  String invname = plugin.getMessagesFile().SuperMenuName;
  public UtilMenu spMenu = new UtilMenu(plugin, invname, 6);
  
  public void showSuperMenu(Player p) {
    
    if(p.hasPermission("ug.sparticula.lava") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    spMenu.setItem(10, plugin.getItemStack().newItemStack(Material.LAVA_BUCKET, "§aRoration Lava", null, 1, (byte)0));
  	}else{
  		spMenu.setItem(10, plugin.getItemStack().noPermissionItem("§7Roration Lava"));
  	}
    
    if(p.hasPermission("ug.sparticula.agua") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    spMenu.setItem(11, plugin.getItemStack().newItemStack(Material.WATER_BUCKET, "§aRoration água", null, 1, (byte)0));
  	}else{
  		spMenu.setItem(11, plugin.getItemStack().noPermissionItem("§7Roration Lava"));
  	}
    
    if(p.hasPermission("ug.sparticula.rhappy") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    spMenu.setItem(12, plugin.getItemStack().newItemStack(Material.EMERALD_BLOCK, "§aRotação Happy", null, 1, (byte)0));
  	}else{
  		spMenu.setItem(12, plugin.getItemStack().noPermissionItem("§7Rotação Happy"));
  	}
    
    if(p.hasPermission("ug.sparticula.rcoracoes") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    spMenu.setItem(13, plugin.getItemStack().newItemStack(Material.RED_ROSE, "§aRatação Corações", null, 1, (byte)0));
  	}else{
  		spMenu.setItem(13, plugin.getItemStack().noPermissionItem("§7Rotação Corações"));
  	}
    
    if(p.hasPermission("ug.sparticula.flamehelix") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    spMenu.setItem(14, plugin.getItemStack().newItemStack(Material.BLAZE_POWDER, "§aHelix of Fire", null, 1, (byte)0));
  	}else{
  		spMenu.setItem(14, plugin.getItemStack().noPermissionItem("§7Flame Helix"));
  	}
    
    if(p.hasPermission("ug.sparticula.redhelix") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    spMenu.setItem(15, plugin.getItemStack().newItemStack(Material.REDSTONE_BLOCK, "§aHelix of Dust", null, 1, (byte)0));
  	}else{
  		spMenu.setItem(15, plugin.getItemStack().noPermissionItem("§7Red Helix"));
  	}
    
    if(p.hasPermission("ug.sparticula.frozen") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    spMenu.setItem(16, plugin.getItemStack().newItemStack(Material.SNOW_BLOCK, "§aFrozen", null, 1, (byte)0));
  	}else{
  		spMenu.setItem(16, plugin.getItemStack().noPermissionItem("§7Frozen"));
  	}
    
    if(p.hasPermission("ug.sparticula.watercircle") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    spMenu.setItem(19, plugin.getItemStack().newItemStack(Material.GLASS_BOTTLE, "§aCírculo", null, 1, (byte)0));
  	}else{
  		spMenu.setItem(19, plugin.getItemStack().noPermissionItem("§7Círculo"));
  	}
    
    
    if(p.hasPermission("ug.sparticula.nuvem") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    spMenu.setItem(20, plugin.getItemStack().newItemStack(Material.ICE, "§aNuvem", null, 1, (byte)0));
  	}else{
  		spMenu.setItem(20, plugin.getItemStack().noPermissionItem("§7Nuvem"));
  	}
    
    if(p.hasPermission("ug.sparticula.vortex") || (p.hasPermission("ug.sparticulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    spMenu.setItem(21, plugin.getItemStack().newItemStack(Material.BLAZE_ROD, "§aVortex", null, 1, (byte)0));
  	}else{
  		spMenu.setItem(21, plugin.getItemStack().noPermissionItem("§7Vortex"));
  	}
    
    spMenu.setItem(49, plugin.getItemStack().newItemStack(Material.BARRIER, "§aRemover Partículas", 
	Arrays.asList(new String[] {"§7Clique para remover todas suas partículas" }), 1, (byte)0));
			    	    
	spMenu.setItem(50, plugin.getItemStack().setGoArrow());
			    
	spMenu.setItem(48, plugin.getItemStack().setBackArrow());
    
    spMenu.showMenu(p);
  }
  
  @EventHandler
  public void onClickInParticlesMenu(InventoryClickEvent e)
  {
    if ((e.getInventory().getName().equalsIgnoreCase(invname)) && ((e.getWhoClicked() instanceof Player)))
    {
      Player p = (Player)e.getWhoClicked();
      e.setCancelled(true);
      e.setResult(Result.DENY);
      int slot = e.getSlot();
      if (slot == 10) {
      	if(!p.hasPermission("ug.sparticula.lava") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		p.sendMessage(plugin.getMessagesFile().superparticlepermission);
		    p.closeInventory();
		    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		return;
    	}
       if (!plugin.getUtilPartciles().hasEffect(p)) {
        p.sendMessage(plugin.getMessagesFile().newParticle + "§cLava");
        plugin.getUtilPartciles().radarEffect(p, ParticleEffect.DRIP_LAVA);
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.LAVA, 1.0F, 1.0F);
      }
     }
      if (slot == 11){ 
        if(!p.hasPermission("ug.sparticula.agua") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
         p.sendMessage(plugin.getMessagesFile().superparticlepermission);
          return;
        }
        if(!plugin.getUtilPartciles().hasEffect(p)) {
        p.sendMessage(plugin.getMessagesFile().newParticle + "§cAgua");
        plugin.getUtilPartciles().radarEffect(p, ParticleEffect.DRIP_WATER);
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.WATER, 1.0F, 1.0F);
      }
     }
      if (slot == 12) { 
        if(!p.hasPermission("ug.sparticula.rhappy") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
        	p.sendMessage(plugin.getMessagesFile().superparticlepermission);
		    p.closeInventory();
		    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
        	return;
        }
       if(!plugin.getUtilPartciles().hasEffect(p)) {
        p.sendMessage(plugin.getMessagesFile().newParticle + "§cRoration Happy");
        plugin.getUtilPartciles().SpiralEffect(p, ParticleEffect.VILLAGER_HAPPY);
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 12.0F);
      }
     }
      if (slot == 13) {
        if(!p.hasPermission("ug.sparticula.rcoracoes") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
          p.sendMessage(plugin.getMessagesFile().superparticlepermission);
		    p.closeInventory();
		    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
        	return;
        }
        if(!plugin.getUtilPartciles().hasEffect(p)) {
        p.sendMessage(plugin.getMessagesFile().newParticle + "§cRoration Corações");
        plugin.getUtilPartciles().SpiralEffect(p, ParticleEffect.HEART);
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.GHAST_MOAN, 1.0F, 1.0F);
      }
     }
      if (slot == 14) {
        if(!p.hasPermission("ug.sparticula.flamehelix") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
          p.sendMessage(plugin.getMessagesFile().superparticlepermission);
		  p.closeInventory();
		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
            return;
        }
        if(!plugin.getUtilPartciles().hasEffect(p)) {
        plugin.getUtilPartciles().startHelix(p, ParticleType.FLAME);
        p.closeInventory();
        p.sendMessage(plugin.getMessagesFile().newParticle + "§cFlame Helix");
        p.playSound(p.getLocation(), Sound.FIZZ, 1.0F, 12.0F);
      }
     }
      if (slot == 15) {
          if(!p.hasPermission("ug.sparticula.redhelix") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().superparticlepermission);
  		  p.closeInventory();
  		  p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
              return;
          }
          if(!plugin.getUtilPartciles().hasEffect(p)) {
          plugin.getUtilPartciles().startHelix(p, ParticleType.REDSTONE);
          p.closeInventory();
          p.sendMessage(plugin.getMessagesFile().newParticle + "§cRed Relix");
          p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 1.0F, 12.0F);
        }
       }
     if(slot == 16) {
    	 if(!p.hasPermission("ug.sparticula.frozen") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
             p.sendMessage(plugin.getMessagesFile().superparticlepermission);
   		     p.closeInventory();
   		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
             return;
         }
    	 if(!plugin.getUtilPartciles().hasEffect(p)) {
    		 p.closeInventory();
    		 p.sendMessage(plugin.getMessagesFile().newParticle + "§7Frozen");
    		 p.playSound(p.getLocation(), Sound.STEP_SNOW, 1.0F, 12.0F);
    		 plugin.getUtilPartciles().otherType.put(p, "Frozen");
    	 }
     }
     if(slot == 19) {
    	 if(!p.hasPermission("ug.sparticula.watercircle") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
             p.sendMessage(plugin.getMessagesFile().superparticlepermission);
   		     p.closeInventory();
   		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
             return;
         }
    	 if(!plugin.getUtilPartciles().hasEffect(p)) {
    		 p.closeInventory();
    		 p.sendMessage(plugin.getMessagesFile().newParticle + "§7Circle of Water");
    		 p.playSound(p.getLocation(), Sound.WATER, 1.0F, 12.0F);
    		 plugin.getUtilPartciles().circleOfParticles(p, ParticleEffect.DRIP_WATER);
    	 }
     }
     if(slot == 20) {
    	 if(!p.hasPermission("ug.sparticula.nuvem") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
             p.sendMessage(plugin.getMessagesFile().superparticlepermission);
   		     p.closeInventory();
   		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
             return;
         }
    	 if(!plugin.getUtilPartciles().hasEffect(p)) {
    		 p.closeInventory();
    		 p.sendMessage(plugin.getMessagesFile().newParticle + "§7Nuvem");
    		 p.playSound(p.getLocation(), Sound.STEP_SNOW, 1.0F, 12.0F);
    		 plugin.getUtilPartciles().otherType.put(p, "Nuvem");
    	 }
     }
     
     if(slot == 21) {
    	 if(!p.hasPermission("ug.sparticula.vortex") & !p.hasPermission("ug.sparticulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
             p.sendMessage(plugin.getMessagesFile().superparticlepermission);
   		     p.closeInventory();
   		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
             return;
         }
    	 if(!plugin.getUtilPartciles().hasEffect(p)) {
    		 p.closeInventory();
    		 p.sendMessage(plugin.getMessagesFile().newParticle + "§7Vortex");
    		 p.playSound(p.getLocation(), Sound.BLAZE_BREATH, 1.0F, -12.0F);
    		 plugin.getUtilPartciles().newVortex.put(p, "VTEX");
    	 }
     }
     
      if (slot == 49) {
    	if(!plugin.getUtilPartciles().hasEffect(p)) {
    		p.sendMessage("§cVocê não tem partículas para desativar.");
    		p.closeInventory();
    		return;
    	}
        plugin.getUtilPartciles().stopAll(p);
        p.closeInventory();
      }
      if (slot == 50)
      {
        p.closeInventory();
        p.sendMessage("§7§oEm breve!");
      }
      if (slot == 48)
      {
        p.closeInventory();
        plugin.getMenuManager().gadgetMenu.showMenu(p);
      }
    }
   }
}
