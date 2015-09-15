package Menus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import Gadgets.Tipos;
import Utils.UtilMenu;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class Gadgets
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
  String invname = plugin.getMessagesFile().GadgetsMenuName;
  public UtilMenu gadgets = new UtilMenu(plugin, invname, 6);
  public static Map<UUID, ItemStack> glow = new HashMap<>();
  
  @SuppressWarnings("deprecation")
public void showGadgetsPage1(Player p) {
	if(p.hasPermission("ug.gadgets.bomba") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	if(Tipos.getPlayerGadget.get(p) == "Bomba") {
		 gadgets.setItem(10, plugin.getItemStack().newGlowedItemStack(Material.CLAY_BALL, plugin.getMessagesFile().BombaGadgetName,Arrays.asList(plugin.getMessagesFile().BombaGadgetLore), 1, (byte)0));
	}else{
    gadgets.setItem(10, plugin.getItemStack().newItemStack(Material.CLAY_BALL, plugin.getMessagesFile().BombaGadgetName,Arrays.asList(plugin.getMessagesFile().BombaGadgetLore), 1, (byte)0));
	}
	}else{
  		gadgets.setItem(10, plugin.getItemStack().noPermissionItem("§7Bomba"));
  	}  
    
  	if(p.hasPermission("ug.gadgets.fungun") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
  	if(Tipos.getPlayerGadget.get(p) == "FunGun") {
  	  gadgets.setItem(11, plugin.getItemStack().newItemStack(Material.BLAZE_ROD, plugin.getMessagesFile().FunGunGadgetName,Arrays.asList(plugin.getMessagesFile().FunGunGadgetLore), 1, (byte)0));
  	}else{
    gadgets.setItem(11, plugin.getItemStack().newItemStack(Material.BLAZE_ROD, plugin.getMessagesFile().FunGunGadgetName,Arrays.asList(plugin.getMessagesFile().FunGunGadgetLore), 1, (byte)0));
  	}
  	}else{
  		gadgets.setItem(11, plugin.getItemStack().noPermissionItem("§7FunGun"));
  	} 
  	
    if(p.hasPermission("ug.gadgets.cookies") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "Cookies Party") {
    	  gadgets.setItem(12, plugin.getItemStack().newGlowedItemStack(Material.COOKIE, plugin.getMessagesFile().CookieGadgetName, Arrays.asList(plugin.getMessagesFile().CookieGadgetLore), 1, (byte)0));
    }else{
    gadgets.setItem(12, plugin.getItemStack().newItemStack(Material.COOKIE, plugin.getMessagesFile().CookieGadgetName, Arrays.asList(plugin.getMessagesFile().CookieGadgetLore), 1, (byte)0));
    }
    }else{
  		gadgets.setItem(12, plugin.getItemStack().noPermissionItem("§7Cookies"));
  	}
    
    if(p.hasPermission("ug.gadgets.stickp") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "Teleport Stick") {
    	 gadgets.setItem(13, plugin.getItemStack().newGlowedItemStack(Material.STICK, plugin.getMessagesFile().StickOfTpGadgetName, Arrays.asList(plugin.getMessagesFile().StickOfTpGadgetLore), 1, (byte)0));
    }else{
    gadgets.setItem(13, plugin.getItemStack().newItemStack(Material.STICK, plugin.getMessagesFile().StickOfTpGadgetName, Arrays.asList(plugin.getMessagesFile().StickOfTpGadgetLore), 1, (byte)0));
    }
    }else{
  		gadgets.setItem(13, plugin.getItemStack().noPermissionItem("§7Stick of Teleport"));
  	}
    
    if(p.hasPermission("ug.gadgets.pbgun") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "Paintball Gun") {
    	 gadgets.setItem(14, plugin.getItemStack().newGlowedItemStack(Material.DIAMOND_BARDING, plugin.getMessagesFile().PaintballGunGadgetName, Arrays.asList(plugin.getMessagesFile().PaintballGunGadgetLore), 1, (byte)0));
    }else{
    gadgets.setItem(14, plugin.getItemStack().newItemStack(Material.DIAMOND_BARDING, plugin.getMessagesFile().PaintballGunGadgetName, Arrays.asList(plugin.getMessagesFile().PaintballGunGadgetLore), 1, (byte)0));
    }
    }else{
  		gadgets.setItem(14, plugin.getItemStack().noPermissionItem("§7Paintball Gun"));
  	}
    
    if(p.hasPermission("ug.gadgets.fireworkparty") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "Firework Party") {
    	 gadgets.setItem(15, plugin.getItemStack().newGlowedItemStack(Material.FIREWORK, plugin.getMessagesFile().FireworkPartyGadgetName, Arrays.asList(plugin.getMessagesFile().FireworkPartyGadgetLore), 1, (byte)0));
    }else{
    gadgets.setItem(15, plugin.getItemStack().newItemStack(Material.FIREWORK, plugin.getMessagesFile().FireworkPartyGadgetName, Arrays.asList(plugin.getMessagesFile().FireworkPartyGadgetLore), 1, (byte)0));
    }
    }else{
  		gadgets.setItem(15, plugin.getItemStack().noPermissionItem("§7Firework Party"));
  	}
    
    if(p.hasPermission("ug.gadgets.movire") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "Movire") {
    	gadgets.setItem(16, plugin.getItemStack().newGlowedItemStack(Material.BLAZE_POWDER, plugin.getMessagesFile().MovireGadgetName, Arrays.asList(plugin.getMessagesFile().MovireGadgetLore), 1, (byte)0));   
    }else{
    gadgets.setItem(16, plugin.getItemStack().newItemStack(Material.BLAZE_POWDER, plugin.getMessagesFile().MovireGadgetName, Arrays.asList(plugin.getMessagesFile().MovireGadgetLore), 1, (byte)0));   
    }
    }else{
  		gadgets.setItem(16, plugin.getItemStack().noPermissionItem("§7Movire"));
  	}
    
    if(p.hasPermission("ug.gadgets.foguete") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "Foguete") {
    	 gadgets.setItem(19, plugin.getItemStack().newGlowedItemStack(Material.IRON_BLOCK, plugin.getMessagesFile().fogueteGadgetName, Arrays.asList(plugin.getMessagesFile().fogueteGadgetLore), 1, (byte)0));
    }else{
    gadgets.setItem(19, plugin.getItemStack().newItemStack(Material.IRON_BLOCK, plugin.getMessagesFile().fogueteGadgetName, Arrays.asList(plugin.getMessagesFile().fogueteGadgetLore), 1, (byte)0));
    }
    }else{
  		gadgets.setItem(19, plugin.getItemStack().noPermissionItem("§7Foguete"));
  	}
    
    if(p.hasPermission("ug.gadgets.discoball") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "Disco Ball") {
    	gadgets.setItem(20, plugin.getItemStack().newGlowedItemStack(Material.STAINED_GLASS, plugin.getMessagesFile().DiscoBallGadgetName, Arrays.asList(plugin.getMessagesFile().DiscoBallGadgetLore), 1, (byte)4));
    }else{
    gadgets.setItem(20, plugin.getItemStack().newItemStack(Material.STAINED_GLASS, plugin.getMessagesFile().DiscoBallGadgetName, Arrays.asList(plugin.getMessagesFile().DiscoBallGadgetLore), 1, (byte)4));
    }
    }else{
  		gadgets.setItem(20, plugin.getItemStack().noPermissionItem("§7Discoball"));
  	}
    
	 if(p.hasPermission("ug.gadgets.railgun") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	if(Tipos.getPlayerGadget.get(p) == "Rail Gun") {
		   gadgets.setItem(21, plugin.getItemStack().newGlowedItemStack(Material.DIAMOND_HOE, plugin.getMessagesFile().RailGunGadgetName, Arrays.asList(plugin.getMessagesFile().RailGunGadgetLore), 1, (byte)0));
	}else{
    gadgets.setItem(21, plugin.getItemStack().newItemStack(Material.DIAMOND_HOE, plugin.getMessagesFile().RailGunGadgetName, Arrays.asList(plugin.getMessagesFile().RailGunGadgetLore), 1, (byte)0));
	}
	}else{
	  	gadgets.setItem(21, plugin.getItemStack().noPermissionItem("§7RailGun"));
	 }
	 
    if(p.hasPermission("ug.gadgets.smokebomb") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "Smoke Bomb") {
    	gadgets.setItem(22, plugin.getItemStack().newGlowedItemStack(Material.COAL, plugin.getMessagesFile().SmokeBombGadgetName, Arrays.asList(plugin.getMessagesFile().SmokeBombGadgetLore), 1, (byte)0));
    }else{
    	 gadgets.setItem(22, plugin.getItemStack().newItemStack(Material.COAL, plugin.getMessagesFile().SmokeBombGadgetName, Arrays.asList(plugin.getMessagesFile().SmokeBombGadgetLore), 1, (byte)0));
    }
	 }else{
	  	gadgets.setItem(22, plugin.getItemStack().noPermissionItem("§7SmokeBomb"));
	 }
	 
    if(p.hasPermission("ug.gadgets.diamondparty") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "Diamond Party") {
    gadgets.setItem(23, plugin.getItemStack().newGlowedItemStack(Material.DIAMOND, plugin.getMessagesFile().DiamondPartyGadgetName, Arrays.asList(plugin.getMessagesFile().DiamondPartyGadgetLore), 1, (byte)0));
    }else{
    gadgets.setItem(23, plugin.getItemStack().newItemStack(Material.DIAMOND, plugin.getMessagesFile().DiamondPartyGadgetName, Arrays.asList(plugin.getMessagesFile().DiamondPartyGadgetLore), 1, (byte)0));
    }
    }else{
	  		gadgets.setItem(23, plugin.getItemStack().noPermissionItem("§7DiamondParty"));
	 }
	 
    if(p.hasPermission("ug.gadgets.paraquedas") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "Paraquedas") {
    gadgets.setItem(24, plugin.getItemStack().newGlowedItemStack(Material.LEASH, plugin.getMessagesFile().ParaquedasGadgetName, Arrays.asList(plugin.getMessagesFile().ParaquedasGadgetLore), 1, (byte)0));
    }else{
    	 gadgets.setItem(24, plugin.getItemStack().newItemStack(Material.LEASH, plugin.getMessagesFile().ParaquedasGadgetName, Arrays.asList(plugin.getMessagesFile().ParaquedasGadgetLore), 1, (byte)0));
    }
    }else{
	  	gadgets.setItem(24, plugin.getItemStack().noPermissionItem("§7Paraquedas"));
	 }
	 
    if(p.hasPermission("ug.gadgets.whitershoot") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "Wither Shoot") {
    	gadgets.setItem(25, plugin.getItemStack().newGlowedItemStack(Material.SKULL_ITEM, plugin.getMessagesFile().WitherShooterName, Arrays.asList(plugin.getMessagesFile().WitherShooterLore), 1, (byte)1));
    }else{
    gadgets.setItem(25, plugin.getItemStack().newItemStack(Material.SKULL_ITEM, plugin.getMessagesFile().WitherShooterName, Arrays.asList(plugin.getMessagesFile().WitherShooterLore), 1, (byte)1));
    }
    }else{
	  		gadgets.setItem(25, plugin.getItemStack().noPermissionItem("§7WitherShoot"));
	}
	 
    if(p.hasPermission("ug.gadgets.trampolim") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "Trampolim") {
    	 gadgets.setItem(28, plugin.getItemStack().newGlowedItemStack(Material.HOPPER, plugin.getMessagesFile().TrampolimName, Arrays.asList(plugin.getMessagesFile().TrampolimLore), 1, (byte)0));
    }else{
    gadgets.setItem(28, plugin.getItemStack().newItemStack(Material.HOPPER, plugin.getMessagesFile().TrampolimName, Arrays.asList(plugin.getMessagesFile().TrampolimLore), 1, (byte)0));
    }
    }else{
	  	gadgets.setItem(28, plugin.getItemStack().noPermissionItem("§7Trampolim"));
	}
	 
    if(p.hasPermission("ug.gadgets.vampire") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "Vampire") {
    	  gadgets.setItem(29, plugin.getItemStack().newGlowedItemStack(Material.GHAST_TEAR, plugin.getMessagesFile().VampireGadgetName,  Arrays.asList(plugin.getMessagesFile().VampireGadgetLore), 1, (byte)0));
    }else{
    gadgets.setItem(29, plugin.getItemStack().newItemStack(Material.GHAST_TEAR, plugin.getMessagesFile().VampireGadgetName,  Arrays.asList(plugin.getMessagesFile().VampireGadgetLore), 1, (byte)0));
    }
    }else{
	  	gadgets.setItem(29, plugin.getItemStack().noPermissionItem("§7Vampiro"));
	}
	 
    if(p.hasPermission("ug.gadgets.vectortnt") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "VectorTNT") {
    	  gadgets.setItem(30, plugin.getItemStack().newGlowedItemStack(Material.TNT, plugin.getMessagesFile().VectorGadgetName,  Arrays.asList(plugin.getMessagesFile().VectorGadgetLore), 1, (byte)0));
    }else{
    gadgets.setItem(30, plugin.getItemStack().newItemStack(Material.TNT, plugin.getMessagesFile().VectorGadgetName,  Arrays.asList(plugin.getMessagesFile().VectorGadgetLore), 1, (byte)0));
    }
    }else{
	  		gadgets.setItem(30, plugin.getItemStack().noPermissionItem("§7VectorTNT"));
	}
	 
    if(p.hasPermission("ug.gadgets.cowboy") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    if(Tipos.getPlayerGadget.get(p) == "Cowboy") {
    	 gadgets.setItem(31, plugin.getItemStack().newGlowedItemStack(Material.CACTUS, plugin.getMessagesFile().CowboyGadgetLore, Arrays.asList(plugin.getMessagesFile().CowboyGadgetLore), 1, (byte)0));
    }else{
    gadgets.setItem(31, plugin.getItemStack().newItemStack(Material.CACTUS, plugin.getMessagesFile().CowboyGadgetLore, Arrays.asList(plugin.getMessagesFile().CowboyGadgetLore), 1, (byte)0));
    }
    }else{
	  		gadgets.setItem(31, plugin.getItemStack().noPermissionItem("§7Cowboy"));
	 }
    
    
	  if(p.hasPermission("ug.gadgets.mobgun") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	  if(Tipos.getPlayerGadget.get(p) == "MobGun") {
		  gadgets.setItem(32, plugin.getItemStack().newGlowedItemStack(Material.BLAZE_ROD, "§6§lMob Gun", null, 1, (byte)0));
	  }else{
	  gadgets.setItem(32, plugin.getItemStack().newItemStack(Material.BLAZE_ROD, "§6§lMob Gun", null, 1, (byte)0));
	  }
	  }else{
		gadgets.setItem(32, plugin.getItemStack().noPermissionItem("§7Cowboy"));
	 }
	  
	  if(p.hasPermission("ug.gadgets.explosivesheep") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	  if(Tipos.getPlayerGadget.get(p) == "ExplosiveSheep") {
			gadgets.setItem(33, plugin.getItemStack().newGlowedItemStack(Material.SHEARS, plugin.getMessagesFile().ExplosiveSheepName, Arrays.asList(plugin.getMessagesFile().ExplosiveSheepLore), 1, (byte)0));
	  }else{
		gadgets.setItem(33, plugin.getItemStack().newItemStack(Material.SHEARS, plugin.getMessagesFile().ExplosiveSheepName, Arrays.asList(plugin.getMessagesFile().ExplosiveSheepLore), 1, (byte)0));
	  }
	  }else{
      gadgets.setItem(33, plugin.getItemStack().noPermissionItem("§7Cowboy"));
	 }
	  
	  if(p.hasPermission("ug.gadgets.discoarmor") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	 if(Tipos.getPlayerGadget.get(p) == "DiscoArmor") {
		  gadgets.setItem(34, plugin.getItemStack().newGlowedItemStack(Material.INK_SACK, plugin.getMessagesFile().discoArmorName, Arrays.asList(plugin.getMessagesFile().discoArmorLore), 1, (byte)13));
	 }else{
	  gadgets.setItem(34, plugin.getItemStack().newItemStack(Material.INK_SACK, plugin.getMessagesFile().discoArmorName, Arrays.asList(plugin.getMessagesFile().discoArmorLore), 1, (byte)13));
	 }
	 }else{
		  gadgets.setItem(34, plugin.getItemStack().noPermissionItem("§7DiscoArmor"));
	  }
	  
	  if(p.hasPermission("ug.gadgets.soco") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	   if(Tipos.getPlayerGadget.get(p) == "Soco") {
		   gadgets.setItem(37, plugin.getItemStack().newGlowedItemStack(Material.DIAMOND_SWORD, plugin.getMessagesFile().socoGadgetName, Arrays.asList(plugin.getMessagesFile().socoGadgetLore), 1, (byte)0));
	   }else{
	   gadgets.setItem(37, plugin.getItemStack().newItemStack(Material.DIAMOND_SWORD, plugin.getMessagesFile().socoGadgetName, Arrays.asList(plugin.getMessagesFile().socoGadgetLore), 1, (byte)0));
	   }
	   }else{
		  	gadgets.setItem(37, plugin.getItemStack().noPermissionItem("§7Super Soco"));
	   }
	  
	  if(p.hasPermission("ug.gadgets.gravidade") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	if(Tipos.getPlayerGadget.get(p) == "Gravidade") {
		gadgets.setItem(38, plugin.getItemStack().newGlowedItemStack(Material.IRON_FENCE, plugin.getMessagesFile().gravidadeGadgetName, Arrays.asList(plugin.getMessagesFile().gravidadeGadgetLore), 1, (byte)0));
	}else{
	  gadgets.setItem(38, plugin.getItemStack().newItemStack(Material.IRON_FENCE, plugin.getMessagesFile().gravidadeGadgetName, Arrays.asList(plugin.getMessagesFile().gravidadeGadgetLore), 1, (byte)0));
	} 
	}else{
		  	gadgets.setItem(38, plugin.getItemStack().noPermissionItem("§7Gravidade"));
	}
	  
	  if(p.hasPermission("ug.gadgets.partypopper") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
	  if(Tipos.getPlayerGadget.get(p) == "PartyPoppereU") {
		 gadgets.setItem(39, plugin.getItemStack().newGlowedItemStack(Material.ENDER_CHEST, plugin.getMessagesFile().partyPopperGadgetName, Arrays.asList(plugin.getMessagesFile().partyPopperGadgetLore), 1, (byte)0));
	 }else{
	  gadgets.setItem(39, plugin.getItemStack().newItemStack(Material.ENDER_CHEST, plugin.getMessagesFile().partyPopperGadgetName, Arrays.asList(plugin.getMessagesFile().partyPopperGadgetLore), 1, (byte)0));
	 }
	 }else{
		  	gadgets.setItem(39, plugin.getItemStack().noPermissionItem("§7PartyPopper"));
     }
	  
	  
	  if(p.hasPermission("ug.gadgets.poop") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
		if(Tipos.getPlayerGadget.get(p) == "Poop") {
			 gadgets.setItem(40, plugin.getItemStack().newGlowedItemStack(Material.INK_SACK, plugin.getMessagesFile().poopGadgetName, Arrays.asList(plugin.getMessagesFile().poopGadgetLore), 1, (byte)3));
	  }else{
	  gadgets.setItem(40, plugin.getItemStack().newItemStack(Material.INK_SACK, plugin.getMessagesFile().poopGadgetName, Arrays.asList(plugin.getMessagesFile().poopGadgetLore), 1, (byte)3));
	  }
	  }else{
		  	gadgets.setItem(40, plugin.getItemStack().noPermissionItem("§7Poop"));
      }
	  
	  if(p.hasPermission("ug.gadgets.rainbow") || (p.hasPermission("ug.gadgets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
		if(Tipos.getPlayerGadget.get(p) == "Rainbow") {
			gadgets.setItem(41, plugin.getItemStack().newGlowedItemStack(Material.getMaterial(349), plugin.getMessagesFile().rainbowGadgetName, Arrays.asList(plugin.getMessagesFile().rainbowGadgetLore), 1, (byte)2));
	  }else{
	  gadgets.setItem(41, plugin.getItemStack().newItemStack(Material.getMaterial(349), plugin.getMessagesFile().rainbowGadgetName, Arrays.asList(plugin.getMessagesFile().rainbowGadgetLore), 1, (byte)2));
	  }
	  }else{
		  	gadgets.setItem(41, plugin.getItemStack().noPermissionItem("§7Rainbow"));
      }
	  
	  gadgets.setItem(49, plugin.getItemStack().newItemStack(Material.BARRIER, "§aRemover Gadget", 
	    Arrays.asList(new String[] {"§7Clique para remover seu Gadget" }), 1, (byte)0));
	    	    
	  gadgets.setItem(50, plugin.getItemStack().setGoArrow());
	    
	  gadgets.setItem(48, plugin.getItemStack().setBackArrow());
	 
	  gadgets.showMenu(p);
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
      if(e.getCurrentItem() == null) return;
       if(e.getCurrentItem().getType() == null) return;
      if((e.getCurrentItem().getType() != Material.AIR) && (e.getCurrentItem().getType() != Material.BARRIER) && (e.getCurrentItem().getType() != Material.ARROW)) {
    	  p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 0.5F);
    	  p.closeInventory();
      }
      if (slot == 10) {
    	if(!p.hasPermission("ug.gadgets.bomba") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
         p.sendMessage(plugin.getMessagesFile().gadgetPermission);
         p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
         return;
        }
        Tipos.setGadget(p, Tipos.BOMBA);
      }
      if (slot == 11) {
      	if(!p.hasPermission("ug.gadgets.fungun") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
            return;
         }
        Tipos.setGadget(p, Tipos.FUNGUN);
      }
      if (slot == 12) {
        if(!p.hasPermission("ug.gadgets.cookies") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
             p.sendMessage(plugin.getMessagesFile().gadgetPermission);
             p.closeInventory();
             p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
             return;
        }
        Tipos.setGadget(p, Tipos.COOKIEK);
      }
      if (slot == 13) {
        if(!p.hasPermission("ug.gadgets.sticktp") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
            return;
        }
        Tipos.setGadget(p, Tipos.STICKTP);
      }
      if (slot == 14) {
          if(!p.hasPermission("ug.gadgets.pbgun") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
              p.sendMessage(plugin.getMessagesFile().gadgetPermission);
              p.closeInventory();
              p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
              return;
         }
        Tipos.setGadget(p, Tipos.PBGUN);
      }
      if (slot == 15) {
          if(!p.hasPermission("ug.gadgets.fireworkparty") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
              p.sendMessage(plugin.getMessagesFile().gadgetPermission);
              p.closeInventory();
              p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
              return;
         }
        Tipos.setGadget(p, Tipos.FIREWORKP);
      }
      if (slot == 16) {
          if(!p.hasPermission("ug.gadgets.movire") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
              p.sendMessage(plugin.getMessagesFile().gadgetPermission);
              p.closeInventory();
              p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
              return;
         }
        Tipos.setGadget(p, Tipos.MOVIRE);
      }
      if (slot == 19) {
      	if(!p.hasPermission("ug.gadgets.foguete") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
            return;
           }
        Tipos.setGadget(p, Tipos.FOGUETE);
      }
      if (slot == 20) {
      	if(!p.hasPermission("ug.gadgets.discoball") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
            return;
           }
        Tipos.setGadget(p, Tipos.DISCOB);
      }
      if (slot == 21) {
      	if(!p.hasPermission("ug.gadgets.railgun") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
            return;
           }
        Tipos.setGadget(p, Tipos.RAILGUN);
      }
      if (slot == 22) {
      	if(!p.hasPermission("ug.gadgets.smokebomb") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
            return;
           }
        Tipos.setGadget(p, Tipos.SMOKEBOMB);
      }
      if (slot == 23) {
      	if(!p.hasPermission("ug.gadgets.diamondparty") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
            return;
           }
        Tipos.setGadget(p, Tipos.DIAMONDP);
      }
      if (slot == 24) {
      	if(!p.hasPermission("ug.gadgets.paraquedas") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
            return;
          }
        Tipos.setGadget(p, Tipos.PARAQUEDAS);
      }
      if (slot == 25) {
      	if(!p.hasPermission("ug.gadgets.withershoot") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
            return;
           }
        Tipos.setGadget(p, Tipos.WITHERSHOOT);
      }
      if (slot == 28) {
      	if(!p.hasPermission("ug.gadgets.trampolim") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
            return;
           }
        Tipos.setGadget(p, Tipos.TRAMPOLIM);
      }
      if (slot == 29) {
        	if(!p.hasPermission("ug.gadgets.vampire") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
              p.sendMessage(plugin.getMessagesFile().gadgetPermission);
              p.closeInventory();
              p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
              return;
             }
          Tipos.setGadget(p, Tipos.VAMPIRE);
        }
      if (slot == 30) {
      	if(!p.hasPermission("ug.gadgets.vectorTNT") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
            p.sendMessage(plugin.getMessagesFile().gadgetPermission);
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
            return;
           }
        Tipos.setGadget(p, Tipos.VECTORTNT);
      }
      if (slot == 31) {
        	if(!p.hasPermission("ug.gadgets.cowboy") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
              p.sendMessage(plugin.getMessagesFile().gadgetPermission);
              p.closeInventory();
              p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
              return;
             }
          Tipos.setGadget(p, Tipos.COWBOY);
        }
    	if(slot == 32) {
          	if(!p.hasPermission("ug.gadgets.mobgun") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
               p.sendMessage(plugin.getMessagesFile().gadgetPermission);
               p.closeInventory();
               p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
               return;
             }
    		Tipos.setGadget(p, Tipos.MOBGUN);    		
    	}
    	if(slot == 33) {
          	if(!p.hasPermission("ug.gadgets.explosivesheep") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
                p.sendMessage(plugin.getMessagesFile().gadgetPermission);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
                return;
               }
    		Tipos.setGadget(p, Tipos.EXSHEEP);
    	}
    	if(slot == 34) {	
          	if(!p.hasPermission("ug.gadgets.discoarmor") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
                p.sendMessage(plugin.getMessagesFile().gadgetPermission);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
                return;
               }
    		Tipos.setGadget(p, Tipos.DISCOARMOR);
    	}
    	if(slot == 37) {	
          	if(!p.hasPermission("ug.gadgets.soco") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
                p.sendMessage(plugin.getMessagesFile().gadgetPermission);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
                return;
               }
    		Tipos.setGadget(p, Tipos.SOCO);
    	}
    	if(slot == 38) {	
          	if(!p.hasPermission("ug.gadgets.gravidade") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
                p.sendMessage(plugin.getMessagesFile().gadgetPermission);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
                return;
               }
    		Tipos.setGadget(p, Tipos.GRAVIDADE);
    	}
    	if(slot == 39) {	
          	if(!p.hasPermission("ug.gadgets.partypopper") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
                p.sendMessage(plugin.getMessagesFile().gadgetPermission);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
                return;
               }
    		Tipos.setGadget(p, Tipos.PARTYPOPPER);
    	}
    	if(slot == 40) {	
          	if(!p.hasPermission("ug.gadgets.poop") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
                p.sendMessage(plugin.getMessagesFile().gadgetPermission);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
                return;
               }
    		Tipos.setGadget(p, Tipos.EPOOP);
    	}
    	if(slot == 41) {	
          	if(!p.hasPermission("ug.gadgets.rainbow") & !p.hasPermission("ug.gadgets.usar.todos") & !p.hasPermission("ug.usar.todos")) {
                p.sendMessage(plugin.getMessagesFile().gadgetPermission);
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
                return;
               }
    		Tipos.setGadget(p, Tipos.RAINBOW);
    	}
        if (slot == 49) {
        	if(!Tipos.playerHasGadget(p)) {
        		p.sendMessage("§cVocê não tem nenhum gadget selecionado!");
        		p.closeInventory();
        		return;
        	}
            Tipos.setGadget(p, Tipos.NENHUM);
            plugin.trampGadget().breakTrampolim(p);
          }
          if (slot == 50){
              p.closeInventory();
              p.sendMessage("§7§oEm breve!");
              
      }
          if (slot == 48){
              p.closeInventory();
              plugin.getMenuManager().showMenu(p);
      }     
    }
  }
}
