package Menus;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import Gadgets.Tipos;
import Metodos.Menus;

import com.floodeer.gadgets.Main;

public class Gadgets
  implements Listener
{
  Main plugin;
  String invname;
  String invname2;
  public Menus gadgets;
  public Menus gadgets2page;
  
  public Gadgets()
  {
    this.plugin = Main.getMain();
    
    this.invname = this.plugin.getMessagesFile().GadgetsMenuName;
    this.invname2 = (this.plugin.getMessagesFile().GadgetsMenuName + " Página 2");
    
    this.gadgets = new Menus(this.plugin, this.invname, 6);
    
    this.gadgets2page = new Menus(this.plugin, this.invname2, 6);
    
    this.gadgets.setItem(12, this.plugin.getItemStack().newItemStack(Material.CLAY_BALL, "§aBomba", 
      Arrays.asList(new String[] {"§7BOOOOOOOM!" }), 1, (byte)0));
    
    this.gadgets.setItem(13, this.plugin.getItemStack().newItemStack(Material.BLAZE_ROD, "§aFunGun", 
      Arrays.asList(new String[] {"§7Meow!" }), 1, (byte)0));
    
    this.gadgets.setItem(14, this.plugin.getItemStack().newItemStack(Material.COOKIE, "§aCoolKies", 
      Arrays.asList(new String[] {"§7Cookies man, Cookies!" }), 1, (byte)0));
    
    this.gadgets.setItem(21, this.plugin.getItemStack().newItemStack(Material.STICK, "§aStick Of Teleport", 
      Arrays.asList(new String[] {"§7Você agora é um Enderman!" }), 1, (byte)0));
    
    this.gadgets.setItem(22, this.plugin.getItemStack().newItemStack(Material.DIAMOND_BARDING, "§aPaintball Gun", 
      Arrays.asList(new String[] {"§7Pup, pup, pup." }), 1, (byte)0));
    
    this.gadgets.setItem(23, this.plugin.getItemStack().newItemStack(Material.FIREWORK, "§aFirework Party", 
      Arrays.asList(new String[] {"§7FIIIIIIIIIIIIIZZZZ.... BOOOOM" }), 1, (byte)0));
    
    this.gadgets.setItem(30, this.plugin.getItemStack().newItemStack(Material.BLAZE_POWDER, "§aMovire", 
      Arrays.asList(new String[] {"§7FIRE, FIRE, FIRE!" }), 1, (byte)0));
    
    this.gadgets.setItem(31, this.plugin.getItemStack().newItemStack(Material.JUKEBOX, "§aDj", 
      Arrays.asList(new String[] {"§7Pronto para balada!?" }), 1, (byte)0));
    
    this.gadgets.setItem(32, this.plugin.getItemStack().newItemStack(Material.STAINED_GLASS, "§aDisco Ball", 
      Arrays.asList(new String[] {"§7Disco-Ball!" }), 1, (byte)4));
    
    this.gadgets.setItem(39, this.plugin.getItemStack().setBackArrow());
    
    this.gadgets.setItem(40, this.plugin.getItemStack().newItemStack(Material.WOOL, "§aRemover Gadget", 
      Arrays.asList(new String[] {"§7Clique para remover seu Gadget" }), 1, (byte)14));
    
    this.gadgets.setItem(41, this.plugin.getItemStack().setGoArrow());
    
    this.gadgets2page.setItem(12, this.plugin.getItemStack().newItemStack(Material.DIAMOND_HOE, this.plugin.getMessagesFile().RailGunGadgetName, Arrays.asList(new String[] { "§7Chuva de fogos!" }), 1, (byte)0));
    
    this.gadgets2page.setItem(13, this.plugin.getItemStack().newItemStack(Material.COAL, this.plugin.getMessagesFile().SmokeBombGadgetName, Arrays.asList(new String[] { "§7Onde est§ todo mundo?" }), 1, (byte)0));
    
    this.gadgets2page.setItem(14, this.plugin.getItemStack().newItemStack(Material.DIAMOND, this.plugin.getMessagesFile().DiamondPartyGadgetName, Arrays.asList(new String[] { "§7DIAMONDS!" }), 1, (byte)0));
    
    this.gadgets2page.setItem(21, this.plugin.getItemStack().newItemStack(Material.LEASH, this.plugin.getMessagesFile().ParaquedasGadgetName, Arrays.asList(new String[] { "§7Est§ pronto para voar?" }), 1, (byte)0));
    
    this.gadgets2page.setItem(22, this.plugin.getItemStack().newItemStack(Material.SKULL_ITEM, this.plugin.getMessagesFile().WitherShooterName, Arrays.asList(new String[] { "§7Shoot, Shoot, Shoot" }), 1, (byte)1));
    
    this.gadgets2page.setItem(23, this.plugin.getItemStack().newItemStack(Material.HOPPER, this.plugin.getMessagesFile().TrampolimName, Arrays.asList(new String[] { "§7;)" }), 1, (byte)0));
    
    this.gadgets2page.setItem(30, this.plugin.getItemStack().setSoonTM());
    
    this.gadgets2page.setItem(31, this.plugin.getItemStack().setSoonTM());
    
    this.gadgets2page.setItem(32, this.plugin.getItemStack().setSoonTM());
    
    this.gadgets2page.setItem(39, this.plugin.getItemStack().setBackArrow());
    
    this.gadgets2page.setItem(40, this.plugin.getItemStack().newItemStack(Material.WOOL, "§aRemover Gadget", 
      Arrays.asList(new String[] {"§7Clique para remover seu Gadget" }), 1, (byte)14));
    
    this.gadgets2page.setItem(41, this.plugin.getItemStack().setGoArrow());
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
    	if(!p.hasPermission("ug.gadgets.bomba") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
         p.sendMessage(plugin.getMessagesFile().gadgetPermission);
         return;
        }
        Tipos.setGadget(p, Tipos.BOMBA);
      }
      if (slot == 13) {
      	if(!p.hasPermission("ug.gadgets.fungun") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            return;
         }
        Tipos.setGadget(p, Tipos.FUNGUN);
      }
      if (slot == 14) {
        if(!p.hasPermission("ug.gadgets.cookies") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
             p.sendMessage(plugin.getMessagesFile().gadgetPermission);
             return;
        }
        Tipos.setGadget(p, Tipos.COOKIEK);
      }
      if (slot == 21) {
        if(!p.hasPermission("ug.gadgets.sticktp") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            return;
        }
        Tipos.setGadget(p, Tipos.STICKTP);
      }
      if (slot == 22) {
          if(!p.hasPermission("ug.gadgets.pbgun") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
              p.sendMessage(plugin.getMessagesFile().gadgetPermission);
              return;
         }
        Tipos.setGadget(p, Tipos.PBGUN);
      }
      if (slot == 23) {
          if(!p.hasPermission("ug.gadgets.fireworkparty") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
              p.sendMessage(plugin.getMessagesFile().gadgetPermission);
              return;
         }
        Tipos.setGadget(p, Tipos.FIREWORKP);
      }
      if (slot == 30) {
          if(!p.hasPermission("ug.gadgets.movire") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
              p.sendMessage(plugin.getMessagesFile().gadgetPermission);
              return;
         }
        Tipos.setGadget(p, Tipos.MOVIRE);
      }
      if (slot == 31) {
      	if(!p.hasPermission("ug.gadgets.dj") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            return;
           }
        Tipos.setGadget(p, Tipos.DJ);
      }
      if (slot == 32) {
      	if(!p.hasPermission("ug.gadgets.discoball") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            return;
           }
        Tipos.setGadget(p, Tipos.DISCOB);
      }
      if (slot == 39) {
        p.closeInventory();
        this.plugin.getMenuManager().gadgetMenu.showMenu(p);
      }
      if (slot == 40) {
        Tipos.setGadget(p, Tipos.NENHUM);
      }
      if (slot == 41)
      {
        p.closeInventory();
        this.gadgets2page.showMenu(p);
      }
    }
    if ((e.getInventory().getName().equalsIgnoreCase(this.invname2)) & ((e.getWhoClicked() instanceof Player)))
    {
      Player p = (Player)e.getWhoClicked();
      e.setCancelled(true);
      e.setResult(Result.DENY);
      int slot = e.getSlot();
      if (slot == 39)
      {
        p.closeInventory();
        this.gadgets.showMenu(p);
      }
      if (slot == 12) {
      	if(!p.hasPermission("ug.gadgets.railgun") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            return;
           }
        Tipos.setGadget(p, Tipos.RAILGUN);
      }
      if (slot == 13) {
      	if(!p.hasPermission("ug.gadgets.smokebomb") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            return;
           }
        Tipos.setGadget(p, Tipos.SMOKEBOMB);
      }
      if (slot == 14) {
      	if(!p.hasPermission("ug.gadgets.diamondparty") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            return;
           }
        Tipos.setGadget(p, Tipos.DIAMONDP);
      }
      if (slot == 21) {
      	if(!p.hasPermission("ug.gadgets.paraquedas") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            return;
          }
        Tipos.setGadget(p, Tipos.PARAQUEDAS);
      }
      if (slot == 22) {
      	if(!p.hasPermission("ug.gadgets.withershoot") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            return;
           }
        Tipos.setGadget(p, Tipos.WITHERSHOOT);
      }
      if (slot == 23) {
      	if(!p.hasPermission("ug.gadgets.trampolim") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            return;
           }
        Tipos.setGadget(p, Tipos.TRAMPOLIM);
      }
      if (slot == 40) {
    	  
        Tipos.setGadget(p, Tipos.NENHUM);
      }
      if (slot == 41)
      {
        p.closeInventory();
        p.sendMessage("§7§oEm breve!");
      }
    }
  }
}
