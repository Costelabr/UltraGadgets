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
      Arrays.asList(new String[] {"§7Lava em sua cabe§a!" }), 1, (byte)0));
    
    this.spMenu.setItem(13, this.plugin.getItemStack().newItemStack(Material.WATER_BUCKET, "§a§gua", Arrays.asList(new String[] { "§7§gua na sua cabe§a!" }), 1, (byte)0));
    
    this.spMenu.setItem(14, this.plugin.getItemStack().newItemStack(Material.EMERALD_BLOCK, "§aHelix Happy", Arrays.asList(new String[] { "§7Helix de Happy em volta de voc§!" }), 1, (byte)0));
    
    this.spMenu.setItem(21, this.plugin.getItemStack().newItemStack(Material.RED_ROSE, "§aCora§§es", Arrays.asList(new String[] { "§7<3 Helix de cora§§es!" }), 1, (byte)0));
    
    this.spMenu.setItem(22, this.plugin.getItemStack().newItemStack(Material.BLAZE_POWDER, "§aHelix of Fire", Arrays.asList(new String[] { "§7Helix de fogo!" }), 1, (byte)0));
    
    this.spMenu.setItem(23, this.plugin.getItemStack().setSoonTM());
    
    this.spMenu.setItem(30, this.plugin.getItemStack().setSoonTM());
    
    this.spMenu.setItem(31, this.plugin.getItemStack().setSoonTM());
    
    this.spMenu.setItem(32, this.plugin.getItemStack().setSoonTM());
    
    this.spMenu.setItem(39, this.plugin.getItemStack().setBackArrow());
    
    this.spMenu.setItem(40, this.plugin.getItemStack().newItemStack(Material.WOOL, "§aRemover Part§culas", 
      Arrays.asList(new String[] {"§7Clique para desabilitar part§culas" }), 1, (byte)14));
    
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
      if ((slot == 12) && 
        (!this.plugin.getUtilPartciles().hasEffect(p)))
      {
        p.sendMessage(this.plugin.getMessagesFile().newParticle + "§cLava");
        this.plugin.getUtilPartciles().radarEffect(p, ParticleEffect.DRIP_LAVA);
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.LAVA, 1.0F, 1.0F);
      }
      if ((slot == 13) && 
        (!this.plugin.getUtilPartciles().hasEffect(p)))
      {
        p.sendMessage(this.plugin.getMessagesFile().newParticle + "§cAgua");
        this.plugin.getUtilPartciles().radarEffect(p, ParticleEffect.DRIP_WATER);
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.WATER, 1.0F, 1.0F);
      }
      if ((slot == 14) && 
        (!this.plugin.getUtilPartciles().hasEffect(p)))
      {
        p.sendMessage(this.plugin.getMessagesFile().newParticle + "§cHelix Happy");
        this.plugin.getUtilPartciles().SpiralEffect(p, ParticleEffect.VILLAGER_HAPPY);
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 12.0F);
      }
      if ((slot == 21) && 
        (!this.plugin.getUtilPartciles().hasEffect(p)))
      {
        p.sendMessage(this.plugin.getMessagesFile().newParticle + "§cHelix Cora§§es");
        this.plugin.getUtilPartciles().SpiralEffect(p, ParticleEffect.HEART);
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.GHAST_MOAN, 1.0F, 1.0F);
      }
      if ((slot == 22) && 
        (!this.plugin.getUtilPartciles().hasEffect(p)))
      {
        this.plugin.getUtilPartciles().startHelix(p);
        p.closeInventory();
        p.sendMessage(this.plugin.getMessagesFile().newParticle + "§cRedstone Helix");
        p.playSound(p.getLocation(), Sound.FIZZ, 1.0F, 12.0F);
      }
      if (slot == 40) {
        this.plugin.getUtilPartciles().stopRotation(p);
      }
      if (slot == 39)
      {
        p.closeInventory();
        this.plugin.getMenuManager().gadgetMenu.showMenu(p);
      }
    }
  }
}
