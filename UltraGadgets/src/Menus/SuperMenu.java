package Menus;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import Metodos.Menus;
import Util.ParticleEffect;
import Util.UtilParticle.ParticleType;

import com.floodeer.gadgets.Main;

public class SuperMenu
  implements Listener
{
  Main plugin;
  String invname;
  public Menus spMenu;
  
  public SuperMenu()
  {
    this.plugin = Main.getMain();
    
    this.invname = this.plugin.getMessagesFile().SuperMenuName;
    
    this.spMenu = new Menus(this.plugin, this.invname, 6);
    
    this.spMenu.setItem(39, this.plugin.getItemStack().setBackArrow());
    
    this.spMenu.setItem(12, this.plugin.getItemStack().newItemStack(Material.LAVA_BUCKET, "§aLava", 
      Arrays.asList(new String[] {"§7Lava em sua cabeça!" }), 1, (byte)0));
    
    this.spMenu.setItem(13, this.plugin.getItemStack().newItemStack(Material.WATER_BUCKET, "§aÁgua", Arrays.asList(new String[] { "§7Água na sua cabeça!" }), 1, (byte)0));
    
    this.spMenu.setItem(14, this.plugin.getItemStack().newItemStack(Material.EMERALD_BLOCK, "§aRoration Happy", Arrays.asList(new String[] { "§7Helix de Happy em volta de você!" }), 1, (byte)0));
    
    this.spMenu.setItem(21, this.plugin.getItemStack().newItemStack(Material.RED_ROSE, "§aRoration Corações", Arrays.asList(new String[] { "§7<3 Helix de corações!" }), 1, (byte)0));
    
    this.spMenu.setItem(22, this.plugin.getItemStack().newItemStack(Material.BLAZE_POWDER, "§aHelix of Fire", Arrays.asList(new String[] { "§7Helix de fogo!" }), 1, (byte)0));
    
    this.spMenu.setItem(23, this.plugin.getItemStack().newItemStack(Material.REDSTONE_BLOCK, "§aHelix of Dust", Arrays.asList(new String[] { "§7Helix de redstone!" }), 1, (byte)0));
    
    this.spMenu.setItem(30, this.plugin.getItemStack().setSoonTM());
    
    this.spMenu.setItem(31, this.plugin.getItemStack().setSoonTM());
    
    this.spMenu.setItem(32, this.plugin.getItemStack().setSoonTM());
    
    this.spMenu.setItem(39, this.plugin.getItemStack().setBackArrow());
    
    this.spMenu.setItem(40, this.plugin.getItemStack().newItemStack(Material.WOOL, "§aRemover Partículas", 
      Arrays.asList(new String[] {"§7Clique para desabilitar partículas" }), 1, (byte)14));
    
    this.spMenu.setItem(41, this.plugin.getItemStack().setGoArrow());
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
      if (slot == 40) {
        this.plugin.getUtilPartciles().stopRotation(p);
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
