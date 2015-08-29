package Menus;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import Gadgets.Tipos;
import Utils.UtilMenu;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class Gadgets
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
  String invname = plugin.getMessagesFile().GadgetsMenuName;
  String invname2 = invname + " 2/3";
  String invname3 = invname + " 3/3";
  public UtilMenu gadgets = new UtilMenu(plugin, invname, 6);
  public UtilMenu gadgets2page = new UtilMenu(plugin, invname2, 6);
  public UtilMenu gadgets3page = new UtilMenu(plugin, invname3, 6);
  
  public void showGadgetsPage1(Player p) {
	  
  	if(p.hasPermission("ug.gadgets.bomba") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets.setItem(12, plugin.getItemStack().newItemStack(Material.CLAY_BALL, plugin.getMessagesFile().BombaGadgetName,
      Arrays.asList(plugin.getMessagesFile().BombaGadgetLore), 1, (byte)0));
 	}else{
  		gadgets.setItem(12, plugin.getItemStack().noPermissionItem("§7Bomba"));
  	}  
    
  	if(p.hasPermission("ug.gadgets.fungun") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets.setItem(13, plugin.getItemStack().newItemStack(Material.BLAZE_ROD, plugin.getMessagesFile().FunGunGadgetName,
      Arrays.asList(plugin.getMessagesFile().FunGunGadgetLore), 1, (byte)0));
 	}else{
  		gadgets.setItem(13, plugin.getItemStack().noPermissionItem("§7FunGun"));
  	} 
  	
    if(p.hasPermission("ug.gadgets.cookies") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets.setItem(14, plugin.getItemStack().newItemStack(Material.COOKIE, plugin.getMessagesFile().CookieGadgetName,
      Arrays.asList(plugin.getMessagesFile().CookieGadgetLore), 1, (byte)0));
 	}else{
  		gadgets.setItem(14, plugin.getItemStack().noPermissionItem("§7Cookies"));
  	}
    
    if(p.hasPermission("ug.gadgets.stickp") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets.setItem(21, plugin.getItemStack().newItemStack(Material.STICK, plugin.getMessagesFile().StickOfTpGadgetName,
      Arrays.asList(plugin.getMessagesFile().StickOfTpGadgetLore), 1, (byte)0));
 	}else{
  		gadgets.setItem(21, plugin.getItemStack().noPermissionItem("§7Stick of Teleport"));
  	}
    
    if(p.hasPermission("ug.gadgets.pbgun") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets.setItem(22, plugin.getItemStack().newItemStack(Material.DIAMOND_BARDING, plugin.getMessagesFile().PaintballGunGadgetName,
      Arrays.asList(plugin.getMessagesFile().PaintballGunGadgetLore), 1, (byte)0));
 	}else{
  		gadgets.setItem(22, plugin.getItemStack().noPermissionItem("§7Paintball Gun"));
  	}
    
    if(p.hasPermission("ug.gadgets.fireworkparty") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets.setItem(23, plugin.getItemStack().newItemStack(Material.FIREWORK, plugin.getMessagesFile().FireworkPartyGadgetName,
      Arrays.asList(plugin.getMessagesFile().FireworkPartyGadgetLore), 1, (byte)0));
 	}else{
  		gadgets.setItem(23, plugin.getItemStack().noPermissionItem("§7Firework Party"));
  	}
    
    if(p.hasPermission("ug.gadgets.movire") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets.setItem(30, plugin.getItemStack().newItemStack(Material.BLAZE_POWDER, plugin.getMessagesFile().MovireGadgetName,
      Arrays.asList(plugin.getMessagesFile().MovireGadgetLore), 1, (byte)0));
 	}else{
  		gadgets.setItem(30, plugin.getItemStack().noPermissionItem("§7Movire"));
  	}
    
    if(p.hasPermission("ug.gadgets.foguete") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets.setItem(31, plugin.getItemStack().newItemStack(Material.IRON_BLOCK, plugin.getMessagesFile().fogueteGadgetName, 
      Arrays.asList(plugin.getMessagesFile().fogueteGadgetLore), 1, (byte)0));
 	}else{
  		gadgets.setItem(31, plugin.getItemStack().noPermissionItem("§7Foguete"));
  	}
    
    if(p.hasPermission("ug.gadgets.discoball") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets.setItem(32, plugin.getItemStack().newItemStack(Material.STAINED_GLASS, plugin.getMessagesFile().DiscoBallGadgetName, 
      Arrays.asList(plugin.getMessagesFile().DiscoBallGadgetLore), 1, (byte)4));
 	}else{
  		gadgets.setItem(32, plugin.getItemStack().noPermissionItem("§7Discoball"));
  	}
    
    gadgets.setItem(40, plugin.getItemStack().newItemStack(Material.BARRIER, "§aRemover Gadget", 
      Arrays.asList(new String[] {"§7Clique para remover seu Gadget" }), 1, (byte)14));
    
    gadgets.setItem(41, plugin.getItemStack().setGoArrow());
    
    gadgets.setItem(39, plugin.getItemStack().setBackArrow());
    
    gadgets.showMenu(p);
    
  }
  
  public void showGadgetPage2(Player p) {
	 if(p.hasPermission("ug.gadgets.railgun") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets2page.setItem(12, plugin.getItemStack().newItemStack(Material.DIAMOND_HOE, plugin.getMessagesFile().RailGunGadgetName, 
      Arrays.asList(plugin.getMessagesFile().RailGunGadgetLore), 1, (byte)0));
	 }else{
	  		gadgets2page.setItem(12, plugin.getItemStack().noPermissionItem("§7RailGun"));
	 }
	 
    if(p.hasPermission("ug.gadgets.smokebomb") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets2page.setItem(13, plugin.getItemStack().newItemStack(Material.COAL, plugin.getMessagesFile().SmokeBombGadgetName, 
      Arrays.asList(plugin.getMessagesFile().SmokeBombGadgetLore), 1, (byte)0));
	 }else{
	  		gadgets2page.setItem(13, plugin.getItemStack().noPermissionItem("§7Smokebomb"));
	 }
	 
    if(p.hasPermission("ug.gadgets.diamondparty") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets2page.setItem(14, plugin.getItemStack().newItemStack(Material.DIAMOND, plugin.getMessagesFile().DiamondPartyGadgetName, 
      Arrays.asList(plugin.getMessagesFile().DiamondPartyGadgetLore), 1, (byte)0));
	 }else{
	  		gadgets2page.setItem(14, plugin.getItemStack().noPermissionItem("§7DiamondParty"));
	 }
	 
    if(p.hasPermission("ug.gadgets.paraquedas") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets2page.setItem(21, plugin.getItemStack().newItemStack(Material.LEASH, plugin.getMessagesFile().ParaquedasGadgetName, 
      Arrays.asList(plugin.getMessagesFile().ParaquedasGadgetLore), 1, (byte)0));
	 }else{
	  		gadgets2page.setItem(21, plugin.getItemStack().noPermissionItem("§7Paraquedas"));
	 }
	 
    if(p.hasPermission("ug.gadgets.whitershoot") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets2page.setItem(22, plugin.getItemStack().newItemStack(Material.SKULL_ITEM, plugin.getMessagesFile().WitherShooterName, 
      Arrays.asList(plugin.getMessagesFile().WitherShooterLore), 1, (byte)1));
	 }else{
	  		gadgets2page.setItem(22, plugin.getItemStack().noPermissionItem("§7WitherShoot"));
	 }
	 
    if(p.hasPermission("ug.gadgets.trampolim") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets2page.setItem(23, plugin.getItemStack().newItemStack(Material.HOPPER, plugin.getMessagesFile().TrampolimName, 
     Arrays.asList(plugin.getMessagesFile().TrampolimLore), 1, (byte)0));
	 }else{
	  		gadgets2page.setItem(23, plugin.getItemStack().noPermissionItem("§7Trampolim"));
	 }
	 
    if(p.hasPermission("ug.gadgets.vampire") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets2page.setItem(30, plugin.getItemStack().newItemStack(Material.GHAST_TEAR, plugin.getMessagesFile().VampireGadgetName, 
      Arrays.asList(plugin.getMessagesFile().VampireGadgetLore), 1, (byte)0));
	 }else{
	  		gadgets2page.setItem(30, plugin.getItemStack().noPermissionItem("§7Vampiro"));
	 }
	 
    if(p.hasPermission("ug.gadgets.vectortnt") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets2page.setItem(31, plugin.getItemStack().newItemStack(Material.TNT, plugin.getMessagesFile().VectorGadgetName, 
    	      Arrays.asList(plugin.getMessagesFile().VectorGadgetLore), 1, (byte)0));
	 }else{
	  		gadgets2page.setItem(31, plugin.getItemStack().noPermissionItem("§7VectorTNT"));
	 }
	 
    if(p.hasPermission("ug.gadgets.cowboy") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    gadgets2page.setItem(32, plugin.getItemStack().newItemStack(Material.CACTUS, plugin.getMessagesFile().CowboyGadgetLore, 
  	      Arrays.asList(plugin.getMessagesFile().CowboyGadgetLore), 1, (byte)0));
	 }else{
	  		gadgets2page.setItem(32, plugin.getItemStack().noPermissionItem("§7Cowboy"));
	 }
	 
    gadgets2page.setItem(39, plugin.getItemStack().setBackArrow());
    
    gadgets2page.setItem(40, plugin.getItemStack().newItemStack(Material.BARRIER, "§aRemover Gadget", 
      Arrays.asList(new String[] {"§7Clique para remover seu Gadget" }), 1, (byte)14));
    
    gadgets2page.setItem(41, plugin.getItemStack().setGoArrow());
    gadgets2page.showMenu(p);
  }
  
  public void showGadgetsPage3(Player p) {
	  if(p.hasPermission("ug.gadgets.mobgun") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	  gadgets3page.setItem(12, plugin.getItemStack().newItemStack(Material.BLAZE_ROD, "§6§lMob Gun", null, 1, (byte)0));
		 }else{
		  	gadgets2page.setItem(12, plugin.getItemStack().noPermissionItem("§7Cowboy"));
	 }
	  
	  if(p.hasPermission("ug.gadgets.explosivesheep") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	  gadgets3page.setItem(13, plugin.getItemStack().newItemStack(Material.SHEARS, plugin.getMessagesFile().ExplosiveSheepName, Arrays.asList(plugin.getMessagesFile().ExplosiveSheepLore), 1, (byte)0));
		 }else{
		  	gadgets2page.setItem(13, plugin.getItemStack().noPermissionItem("§7Cowboy"));
	 }
	  
	  if(p.hasPermission("ug.gadgets.discoarmor") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	  gadgets3page.setItem(14, plugin.getItemStack().newItemStack(Material.INK_SACK, plugin.getMessagesFile().discoArmorName, Arrays.asList(plugin.getMessagesFile().discoArmorLore), 1, (byte)13));
		 }else{
		  	gadgets2page.setItem(14, plugin.getItemStack().noPermissionItem("§7DiscoArmor"));
	    }
	  
	  if(p.hasPermission("ug.gadgets.soco") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	  gadgets3page.setItem(21, plugin.getItemStack().newItemStack(Material.DIAMOND_SWORD, plugin.getMessagesFile().socoGadgetName, Arrays.asList(plugin.getMessagesFile().socoGadgetLore), 1, (byte)0));
		 }else{
		  	gadgets2page.setItem(21, plugin.getItemStack().noPermissionItem("§7Super Soco"));
	   }
	  
	  if(p.hasPermission("ug.gadgets.gravidade") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	  gadgets3page.setItem(22, plugin.getItemStack().newItemStack(Material.IRON_FENCE, plugin.getMessagesFile().gravidadeGadgetName, Arrays.asList(plugin.getMessagesFile().gravidadeGadgetLore), 1, (byte)0));
		 }else{
		  	gadgets2page.setItem(22, plugin.getItemStack().noPermissionItem("§7Gravidade"));
	   }
	  
	  gadgets3page.setItem(23, plugin.getItemStack().setSoonTM());
	  
	  gadgets3page.setItem(30, plugin.getItemStack().setSoonTM());
	  
	  gadgets3page.setItem(31, plugin.getItemStack().setSoonTM());
	  
	  gadgets3page.setItem(32, plugin.getItemStack().setSoonTM());
	  
	  gadgets3page.setItem(39, plugin.getItemStack().setSoonTM());
	  
	  gadgets3page.setItem(40, plugin.getItemStack().setSoonTM());
	  
	  gadgets3page.setItem(40, plugin.getItemStack().newItemStack(Material.BARRIER, "§aRemover Gadget", 
	    Arrays.asList(new String[] {"§7Clique para remover seu Gadget" }), 1, (byte)14));
	    	    
	  gadgets3page.setItem(41, plugin.getItemStack().setGoArrow());
	    
	  gadgets3page.setItem(39, plugin.getItemStack().setBackArrow());
	 
	  gadgets3page.showMenu(p);
  }
  
@EventHandler
  public void onClickInParticlesMenu(InventoryClickEvent e)
  {
    if ((e.getInventory().getName().equalsIgnoreCase(invname)) && ((e.getWhoClicked() instanceof Player)))
    {
      final Player p = (Player)e.getWhoClicked();
      e.setCancelled(true);
      e.setResult(Result.DENY);
      int slot = e.getSlot();
      e.setCurrentItem(new ItemStack(Material.BARRIER));
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
      	if(!p.hasPermission("ug.gadgets.foguete") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            return;
           }
        Tipos.setGadget(p, Tipos.GRAVIDADE);
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
        new BukkitRunnable() {
            @Override
            public void run() {
                plugin.getMenuManager().showMenu(p);
            }
        }.runTaskLater(plugin, 1);
      }
      if (slot == 40) {
      	if(!Tipos.playerHasGadget(p)) {
    		p.sendMessage("§cVocê não tem nenhum gadget selecionado!");
    		p.closeInventory();
    		return;
    	}
        Tipos.setGadget(p, Tipos.NENHUM);
      }
      if (slot == 41)
      {
        p.closeInventory();
        new BukkitRunnable() {
            @Override
            public void run() {
                showGadgetPage2(p);
            }
        }.runTaskLater(plugin, 1);
      }
    }
    if ((e.getInventory().getName().equalsIgnoreCase(invname2)) & ((e.getWhoClicked() instanceof Player)))
    {
      final Player p = (Player)e.getWhoClicked();
      e.setCancelled(true);
      int slot = e.getSlot();
      if (slot == 39)
      {
    	  p.closeInventory();
          new BukkitRunnable() {
              @Override
              public void run() {
                  showGadgetsPage1(p);
              }
          }.runTaskLater(plugin, 1);
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
      if (slot == 31) {
      	if(!p.hasPermission("ug.gadgets.vectorTNT") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            return;
           }
        Tipos.setGadget(p, Tipos.VECTORTNT);
      }
      if (slot == 32) {
        	if(!p.hasPermission("ug.gadgets.cowboy") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
              p.sendMessage(plugin.getMessagesFile().gadgetPermission);
              return;
             }
          Tipos.setGadget(p, Tipos.COWBOY);
        }
      if (slot == 40) {  
        	if(!Tipos.playerHasGadget(p)) {
        		p.sendMessage("§cVocê não tem nenhum gadget selecionado!");
        		p.closeInventory();
        		return;
        	}
            Tipos.setGadget(p, Tipos.NENHUM);
          }
      if (slot == 41)
      {
    	 p.closeInventory();
          new BukkitRunnable() {
              @Override
              public void run() {
                  showGadgetsPage3(p);
              }
          }.runTaskLater(plugin, 1);
      }
    }
    if ((e.getInventory().getName().equalsIgnoreCase(invname3)) && ((e.getWhoClicked() instanceof Player))) {
    	final Player p = (Player)e.getWhoClicked();
    	int slot = e.getSlot();
    	if(slot == 12) {
          	if(!p.hasPermission("ug.gadgets.mobgun") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
               p.sendMessage(plugin.getMessagesFile().gadgetPermission);
               return;
             }
    		Tipos.setGadget(p, Tipos.MOBGUN);    		
    	}
    	if(slot == 13) {
          	if(!p.hasPermission("ug.gadgets.explosivesheep") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
                p.sendMessage(plugin.getMessagesFile().gadgetPermission);
                return;
               }
    		Tipos.setGadget(p, Tipos.EXSHEEP);
    	}
    	if(slot == 14) {	
          	if(!p.hasPermission("ug.gadgets.discoarmor") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
                p.sendMessage(plugin.getMessagesFile().gadgetPermission);
                return;
               }
    		Tipos.setGadget(p, Tipos.DISCOARMOR);
    	}
    	if(slot == 21) {	
          	if(!p.hasPermission("ug.gadgets.soco") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
                p.sendMessage(plugin.getMessagesFile().gadgetPermission);
                return;
               }
    		Tipos.setGadget(p, Tipos.SOCO);
    	}
    	if(slot == 22) {	
          	if(!p.hasPermission("ug.gadgets.gravidade") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
                p.sendMessage(plugin.getMessagesFile().gadgetPermission);
                return;
               }
    		Tipos.setGadget(p, Tipos.GRAVIDADE);
    	}
        if (slot == 40) {
        	if(!Tipos.playerHasGadget(p)) {
        		p.sendMessage("§cVocê não tem nenhum gadget selecionado!");
        		p.closeInventory();
        		return;
        	}
            Tipos.setGadget(p, Tipos.NENHUM);
          }
        if(slot == 39) {
        	p.closeInventory();
            new BukkitRunnable() {
                @Override
                public void run() {
                    showGadgetPage2(p);
                }
            }.runTaskLater(plugin, 1);
        }
          if (slot == 41)
          {
              p.closeInventory();
              p.sendMessage("§7§oEm breve!");
          }
    }
  }
}
