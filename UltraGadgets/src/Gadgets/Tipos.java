package Gadgets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.floodeer.gadgets.Main;

public enum Tipos
{
  NENHUM,  BOMBA,  COOKIEK,  FIREWORKP,  FUNGUN,  MOVIRE,  PBGUN,  STICKTP,  DJ,  DISCOB,  RAILGUN,  SMOKEBOMB,  DIAMONDP,  PARAQUEDAS,  WITHERSHOOT,  TRAMPOLIM, VAMPIRE;
  
  private static Main plugin = Main.getMain();
  protected static String invname = plugin.getMessagesFile().GadgetsMenuName;
  protected static int slotAdd = plugin.getConfig().getInt("Gadget-Gadgets-Slot");
  public static final Map<Player, String> getPlayerGadget = new HashMap<>();
  
  public static boolean playerHasGadget(Player p)
  {
    if (getPlayerGadget.get(p) != "Nenhum") {
      return true;
    }
    return false;
  }
  
  public static void setGadget(Player p, Tipos gadgetTipo)
  {
    switch (gadgetTipo)
    {
    case NENHUM: 
      getPlayerGadget.put(p, "Nenhum");
      ItemStack air = new ItemStack(Material.AIR);
      p.sendMessage(plugin.getMensagensConfig().getString("Gadgets-Removidos").replaceAll("&", "�"));
      p.getInventory().setItem(4, air);
      p.closeInventory();
      break;
    case BOMBA:
      if(plugin.getConfigFile().BombaEnable) {
      getPlayerGadget.put(p, "Bomba");
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.CLAY_BALL, plugin.getMessagesFile().BombaGadgetName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)0));
      p.closeInventory();
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      }else{
    	  p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
      }
      
      break;
    case COOKIEK:
       if(plugin.getConfigFile().CookieEnable) {
      getPlayerGadget.put(p, "Cookies Party");
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.COOKIE, plugin.getMessagesFile().CookieGadgetName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)0));
      p.closeInventory();
      }else{
          p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
       }
      break;
    case FIREWORKP: 
       if(plugin.getConfigFile().FireworkPartyEnable) {
      getPlayerGadget.put(p, "Firework Party");
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.FIREWORK, plugin.getMessagesFile().FireworkPartyGadgetName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)0));
      p.closeInventory();
       }else{
    	   p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
       }
      break;
    case FUNGUN: 
        if(plugin.getConfigFile().FunGunEnable) {
      getPlayerGadget.put(p, "FunGun");
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.BLAZE_ROD, plugin.getMessagesFile().FunGunGadgetName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)0));
      p.closeInventory();
      }else{
    	  p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
      }
      break;
    case MOVIRE: 
      if(plugin.getConfigFile().MovireEnable) {
      getPlayerGadget.put(p, "Movire");
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.BLAZE_POWDER, plugin.getMessagesFile().MovireGadgetName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)0));
      p.closeInventory();
      }else{
         p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
      }
      
      break;
    case PBGUN: 
       if(plugin.getConfigFile().pbGunEnable) {
      getPlayerGadget.put(p, "Paintball Gun");
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.DIAMOND_BARDING, plugin.getMessagesFile().PaintballGunGadgetName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)0));
      p.closeInventory();
     }else{
        p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
       }
      break;
    case STICKTP: 
        if(plugin.getConfigFile().StickOfTpEnable) {
      getPlayerGadget.put(p, "Stick of Teleport");
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.STICK, plugin.getMessagesFile().StickOfTpGadgetName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)0));
      p.closeInventory();
        }else{
        	p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
        }
      break;
    case DJ: 
        if(plugin.getConfigFile().DjEnable) {
      getPlayerGadget.put(p, "Dj");
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.JUKEBOX, plugin.getMessagesFile().DjGadgetName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)0));
      p.closeInventory();
        }else{
        	p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
        }
      break;
    case DISCOB: 
        if(plugin.getConfigFile().DiscoBallEnable) {
      getPlayerGadget.put(p, "Disco Ball");
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.STAINED_GLASS, plugin.getMessagesFile().DiscoBallGadgetName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)5));
      p.closeInventory();
        }else{
        	p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
        }
      break;
    case RAILGUN: 
        if(plugin.getConfigFile().RailGunEnable) {
      getPlayerGadget.put(p, "Rail Gun");
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.DIAMOND_HOE, plugin.getMessagesFile().RailGunGadgetName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)0));
      p.closeInventory();
        }else{
        	p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
        }
      break;
    case SMOKEBOMB: 
        if(plugin.getConfigFile().SmokeBombEnable) {
      getPlayerGadget.put(p, "Smoke Bomb");
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.COAL, plugin.getMessagesFile().SmokeBombGadgetName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)0));
      p.closeInventory();
        }else{
        	
        }
      break;
    case DIAMONDP:
        if(plugin.getConfigFile().DiamondPartyEnable) {
      getPlayerGadget.put(p, "Diamond Party");
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.DIAMOND, plugin.getMessagesFile().DiamondPartyGadgetName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)0));
      p.closeInventory();
        }else{
        	p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
        }
      break;
    case PARAQUEDAS: 
        if(plugin.getConfigFile().ParaquedasEnable) {
      getPlayerGadget.put(p, "Paraquedas");
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.LEASH, plugin.getMessagesFile().ParaquedasGadgetName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)0));
      p.closeInventory();
        }else{
        	p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
        }
      break;
    case WITHERSHOOT: 
        if(plugin.getConfigFile().WitherShootEnable) {
      getPlayerGadget.put(p, "Wither Shoot");
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.SKULL_ITEM, plugin.getMessagesFile().WitherShooterName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)1));
      p.closeInventory();
        }else{
        	p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
        }
      break;
    case TRAMPOLIM: 
       if(plugin.getConfigFile().TrampolimEnable) {
      getPlayerGadget.put(p, "Trampolim");
      p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
      p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.HOPPER, plugin.getMessagesFile().TrampolimName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)0));
      p.closeInventory();
        }else{
        	p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
        }
    case VAMPIRE:
    	if(plugin.getConfigFile().vampireEnable) {
    		getPlayerGadget.put(p, "Vampire");    	
    	     p.sendMessage(plugin.getMensagensConfig().getString("Novo-Gadget").replaceAll("<GADGET>", (String)getPlayerGadget.get(p)).replaceAll("&", "�"));
    	     p.getInventory().setItem(4, plugin.getItemStack().newItemStack(Material.GHAST_TEAR, plugin.getMessagesFile().VampireGadgetName, Arrays.asList(new String[] { "�7Clique-Direito!" }), 1, (byte)0));
    	     p.closeInventory();
    	     }else{
    	        p.sendMessage(plugin.getMessagesFile().gadgetDesabilitado);
    	    }
    	}
    }
}
