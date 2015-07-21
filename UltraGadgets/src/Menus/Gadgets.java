package Menus;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import Gadgets.Tipos;
import Util.Menus;

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
    plugin = Main.getMain();
    
    invname = plugin.getMessagesFile().GadgetsMenuName;
    invname2 = (plugin.getMessagesFile().GadgetsMenuName + " Página 2");
    
    gadgets = new Menus(plugin, invname, 6);
    
    gadgets2page = new Menus(plugin, invname2, 6);
    
    gadgets.setItem(12, plugin.getItemStack().newItemStack(Material.CLAY_BALL, plugin.getMessagesFile().BombaGadgetName,
      Arrays.asList(plugin.getMessagesFile().BombaGadgetLore), 1, (byte)0));
    
    gadgets.setItem(13, plugin.getItemStack().newItemStack(Material.BLAZE_ROD, plugin.getMessagesFile().FunGunGadgetName,
      Arrays.asList(plugin.getMessagesFile().FunGunGadgetLore), 1, (byte)0));
    
    gadgets.setItem(14, plugin.getItemStack().newItemStack(Material.COOKIE, plugin.getMessagesFile().CookieGadgetName,
      Arrays.asList(plugin.getMessagesFile().CookieGadgetLore), 1, (byte)0));
    
    gadgets.setItem(21, plugin.getItemStack().newItemStack(Material.STICK, plugin.getMessagesFile().StickOfTpGadgetName,
      Arrays.asList(plugin.getMessagesFile().StickOfTpGadgetLore), 1, (byte)0));
    
    gadgets.setItem(22, plugin.getItemStack().newItemStack(Material.DIAMOND_BARDING, plugin.getMessagesFile().PaintballGunGadgetName,
      Arrays.asList(plugin.getMessagesFile().PaintballGunGadgetLore), 1, (byte)0));
    
    gadgets.setItem(23, plugin.getItemStack().newItemStack(Material.FIREWORK, plugin.getMessagesFile().FireworkPartyGadgetName,
      Arrays.asList(plugin.getMessagesFile().FireworkPartyGadgetLore), 1, (byte)0));
    
    gadgets.setItem(30, plugin.getItemStack().newItemStack(Material.BLAZE_POWDER, plugin.getMessagesFile().MovireGadgetName,
      Arrays.asList(plugin.getMessagesFile().MovireGadgetLore), 1, (byte)0));
    
    gadgets.setItem(31, plugin.getItemStack().newItemStack(Material.JUKEBOX, plugin.getMessagesFile().DjGadgetName, 
      Arrays.asList(plugin.getMessagesFile().DjGadgetLore), 1, (byte)0));
    
    gadgets.setItem(32, plugin.getItemStack().newItemStack(Material.STAINED_GLASS, plugin.getMessagesFile().DiscoBallGadgetName, 
      Arrays.asList(plugin.getMessagesFile().DiscoBallGadgetLore), 1, (byte)4));
    
    gadgets.setItem(39, plugin.getItemStack().setBackArrow());
    
    gadgets.setItem(40, plugin.getItemStack().newItemStack(Material.WOOL, "§aRemover Gadget", 
      Arrays.asList(new String[] {"§7Clique para remover seu Gadget" }), 1, (byte)14));
    
    gadgets.setItem(41, plugin.getItemStack().setGoArrow());
    
    gadgets2page.setItem(12, plugin.getItemStack().newItemStack(Material.DIAMOND_HOE, plugin.getMessagesFile().RailGunGadgetName, 
      Arrays.asList(plugin.getMessagesFile().RailGunGadgetLore), 1, (byte)0));
    
    gadgets2page.setItem(13, plugin.getItemStack().newItemStack(Material.COAL, plugin.getMessagesFile().SmokeBombGadgetName, 
      Arrays.asList(plugin.getMessagesFile().SmokeBombGadgetLore), 1, (byte)0));
    
    gadgets2page.setItem(14, plugin.getItemStack().newItemStack(Material.DIAMOND, plugin.getMessagesFile().DiamondPartyGadgetName, 
      Arrays.asList(plugin.getMessagesFile().DiamondPartyGadgetLore), 1, (byte)0));
    
    gadgets2page.setItem(21, plugin.getItemStack().newItemStack(Material.LEASH, plugin.getMessagesFile().ParaquedasGadgetName, 
      Arrays.asList(plugin.getMessagesFile().ParaquedasGadgetLore), 1, (byte)0));
    
    gadgets2page.setItem(22, plugin.getItemStack().newItemStack(Material.SKULL_ITEM, plugin.getMessagesFile().WitherShooterName, 
      Arrays.asList(plugin.getMessagesFile().WitherShooterLore), 1, (byte)1));
    
    gadgets2page.setItem(23, plugin.getItemStack().newItemStack(Material.HOPPER, plugin.getMessagesFile().TrampolimName, 
     Arrays.asList(plugin.getMessagesFile().TrampolimLore), 1, (byte)0));
    
    gadgets2page.setItem(30, plugin.getItemStack().newItemStack(Material.GHAST_TEAR, plugin.getMessagesFile().VampireGadgetName, 
      Arrays.asList(plugin.getMessagesFile().VampireGadgetLore), 1, (byte)0));
    
    gadgets2page.setItem(31, plugin.getItemStack().setSoonTM());
    
    gadgets2page.setItem(32, plugin.getItemStack().setSoonTM());
    
    gadgets2page.setItem(39, plugin.getItemStack().setBackArrow());
    
    gadgets2page.setItem(40, plugin.getItemStack().newItemStack(Material.WOOL, "§aRemover Gadget", 
      Arrays.asList(new String[] {"§7Clique para remover seu Gadget" }), 1, (byte)14));
    
    gadgets2page.setItem(41, plugin.getItemStack().setGoArrow());
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
        plugin.getMenuManager().gadgetMenu.showMenu(p);
      }
      if (slot == 40) {
        Tipos.setGadget(p, Tipos.NENHUM);
      }
      if (slot == 41)
      {
        p.closeInventory();
        gadgets2page.showMenu(p);
      }
    }
    if ((e.getInventory().getName().equalsIgnoreCase(invname2)) & ((e.getWhoClicked() instanceof Player)))
    {
      Player p = (Player)e.getWhoClicked();
      e.setCancelled(true);
      e.setResult(Result.DENY);
      int slot = e.getSlot();
      if (slot == 39)
      {
        p.closeInventory();
        gadgets.showMenu(p);
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
      if (slot == 30) {
        	if(!p.hasPermission("ug.gadgets.vampire") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
              p.sendMessage(plugin.getMessagesFile().gadgetPermission);
              return;
             }
          Tipos.setGadget(p, Tipos.VAMPIRE);
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
