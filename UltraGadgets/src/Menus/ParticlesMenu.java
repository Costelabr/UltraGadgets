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

public class ParticlesMenu
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
  String particleTitle = plugin.getMessagesFile().ParticlesMenuName;
  String ativado = plugin.getMensagensConfig().getString("Nova-Particula").replaceAll("&", "§");
  public UtilMenu particleMenu = new UtilMenu(plugin, particleTitle, 6);
  

  public void showParticlesMenu(Player p) {
    
   if(p.hasPermission("ug.particulas.coracoes") || (p.hasPermission("ug.particulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    particleMenu.setItem(10, plugin.getItemStack().newItemStack(Material.GOLDEN_APPLE, "§aCorações", 
      Arrays.asList(new String[] {"§7Corações em volta da sua cabeça!" }), 1, (byte)0));
 	}else{
  		particleMenu.setItem(10, plugin.getItemStack().noPermissionItem("§7Corações"));
  	}    
    
   if(p.hasPermission("ug.particulas.slime") || (p.hasPermission("ug.particulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    particleMenu.setItem(11, plugin.getItemStack().newItemStack(Material.SLIME_BALL, "§aSlime", 
      Arrays.asList(new String[] {"§7Slime em volta de sua cabeça!" }), 1, (byte)0));
	}else{
  		particleMenu.setItem(11, plugin.getItemStack().noPermissionItem("§7Corações"));
  	}        
     
    if(p.hasPermission("ug.particulas.notas") || (p.hasPermission("ug.particulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    particleMenu.setItem(12, plugin.getItemStack().newItemStack(Material.JUKEBOX, "§aNotas", 
      Arrays.asList(new String[] {"§7Notas em volta de sua cabeça!" }), 1, (byte)0));
 	}else{
  		particleMenu.setItem(12, plugin.getItemStack().noPermissionItem("§7Notas"));
  	}    
    
    if(p.hasPermission("ug.particulas.angry") || (p.hasPermission("ug.particulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    particleMenu.setItem(13, plugin.getItemStack().newItemStack(Material.BLAZE_POWDER, "§aAngry Villager", 
      Arrays.asList(new String[] {"§7Angry Villager Efeito em volta de sua cabeça!" }), 1, (byte)0));
 	}else{
  		particleMenu.setItem(13, plugin.getItemStack().noPermissionItem("§7Angry"));
  	}    
    
    if(p.hasPermission("ug.particulas.happy") || (p.hasPermission("ug.particulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    particleMenu.setItem(14, plugin.getItemStack().newItemStack(Material.EMERALD, "§aVillager Happy", 
      Arrays.asList(new String[] {"§7Villager Happy Efeito em volta de sua cabeça!" }), 1, (byte)0));
 	}else{
  		particleMenu.setItem(14, plugin.getItemStack().noPermissionItem("§7Villager Happy"));
  	}    
    
    if(p.hasPermission("ug.particulas.redstone") || (p.hasPermission("ug.particulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    particleMenu.setItem(15, plugin.getItemStack().newItemStack(Material.REDSTONE, "§aRedstone", 
      Arrays.asList(new String[] {"§7Efeito de Redstone em volta de sua cabeça!" }), 1, (byte)0));
 	}else{
  		particleMenu.setItem(15, plugin.getItemStack().noPermissionItem("§7Redstone"));
  	}    
    
    if(p.hasPermission("ug.particulas.spell") || (p.hasPermission("ug.particulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    particleMenu.setItem(16, plugin.getItemStack().newItemStack(Material.GLASS_BOTTLE, "§aSpell", 
      Arrays.asList(new String[] {"§7Efeito Spell em volta de sua cabeça!" }), 1, (byte)0));
 	}else{
  		particleMenu.setItem(16, plugin.getItemStack().noPermissionItem("§7Spell"));
  	}    
    
    
    if(p.hasPermission("ug.particulas.fogo") || (p.hasPermission("ug.particulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    particleMenu.setItem(19, plugin.getItemStack().newItemStack(Material.FLINT_AND_STEEL, "§aFogo", 
      Arrays.asList(new String[] {"§7Efeito de fogo em volta da sua cabeça!"}), 1, (byte)0));
 	}else{
  		particleMenu.setItem(19, plugin.getItemStack().noPermissionItem("§7Fogo"));
  	}    
    
    if(p.hasPermission("ug.particulas.firework") || (p.hasPermission("ug.particulas.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
    particleMenu.setItem(20, plugin.getItemStack().newItemStack(Material.FIREWORK, "§aFirework", 
    Arrays.asList(new String[] {"§7Efeito de firework em volta da sua cabeça!"}), 1, (byte)0));
 	}else{
  		particleMenu.setItem(20, plugin.getItemStack().noPermissionItem("§7Firework"));
  	}    
    
    particleMenu.setItem(48, plugin.getItemStack().newItemStack(Material.ARROW, "§fVoltar", 
    	      Arrays.asList(new String[] {"§7Clique para voltar ao menu de seleção" }), 1, (byte)0)); 
    
    particleMenu.setItem(49, plugin.getItemStack().newItemStack(Material.BARRIER, 
      "§cRemover partículas", Arrays.asList(new String[] { "§7Clique para desativar suas partículas!" }), 1, (byte)14));
    
    particleMenu.setItem(50, plugin.getItemStack().setGoArrow());
    
    particleMenu.showMenu(p);
  }
  
  @EventHandler
  public void onClickInParticlesMenu(InventoryClickEvent e)
  {
    if ((e.getInventory().getName().equalsIgnoreCase(particleTitle)) & ((e.getWhoClicked() instanceof Player)))
    {
      Player p = (Player)e.getWhoClicked();
      e.setCancelled(true);
      e.setResult(Result.DENY);
      int slot = e.getSlot();
      if ((slot == 10) && 
        (!plugin.getUtilPartciles().hasEffect(p))) {
    	 if(!p.hasPermission("ug.particulas.coracoes") & !p.hasPermission("ug.particulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().particlepermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		 return;
    	 }
        plugin.getUtilPartciles().rorationEffect(p, ParticleEffect.HEART);
        p.sendMessage(ativado + "§cCorações");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.GHAST_MOAN, 1.0F, 1.0F);
      }
      if ((slot == 11) && 
        (!plugin.getUtilPartciles().hasEffect(p))) {	  
     	 if(!p.hasPermission("ug.particulas.slime") & !p.hasPermission("ug.particulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().particlepermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		 return;
    	 }
        plugin.getUtilPartciles().rorationEffect(p, ParticleEffect.SLIME);
        p.sendMessage(ativado + "§cSlime");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.SLIME_WALK, 1.0F, 1.0F);
      }
      if ((slot == 12) && 
        (!plugin.getUtilPartciles().hasEffect(p))) {
     	 if(!p.hasPermission("ug.particulas.notas") & !p.hasPermission("ug.particulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().particlepermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		 return;
    	 }
        plugin.getUtilPartciles().rorationEffect(p, ParticleEffect.NOTE);
        p.sendMessage(ativado + "§cNotas");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
      }
      if ((slot == 13) && 
        (!plugin.getUtilPartciles().hasEffect(p))){
     	 if(!p.hasPermission("ug.particulas.angry") & !p.hasPermission("ug.particulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().particlepermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		 return;
    	 }
        plugin.getUtilPartciles().rorationEffect(p, ParticleEffect.VILLAGER_ANGRY);
        p.sendMessage(ativado + "§cAngry Villager");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, -1.0F);
      }
      if ((slot == 14) && 
        (!plugin.getUtilPartciles().hasEffect(p))) {
     	 if(!p.hasPermission("ug.particulas.happy") & !p.hasPermission("ug.particulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().particlepermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		 return;
    	 }
        plugin.getUtilPartciles().rorationEffect(p, ParticleEffect.VILLAGER_HAPPY);
        p.sendMessage(ativado + "§cVillager Happy");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
      }
      if ((slot == 15) && 
        (!plugin.getUtilPartciles().hasEffect(p))) {
     	 if(!p.hasPermission("ug.particulas.redstone") & !p.hasPermission("ug.particulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().particlepermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		 return;
    	 }
        plugin.getUtilPartciles().rorationEffect(p, ParticleEffect.REDSTONE);
        p.sendMessage(ativado + "§cRedstone");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 1.0F, 1.0F);
      }
      if ((slot == 16) && 
        (!plugin.getUtilPartciles().hasEffect(p))) {
     	 if(!p.hasPermission("ug.particulas.spell") & !p.hasPermission("ug.particulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().particlepermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		 return;
    	 }
        plugin.getUtilPartciles().rorationEffect(p, ParticleEffect.SPELL);
        p.sendMessage(ativado + "§cSpell");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.FALL_BIG, 1.0F, 1.0F);
      }
      if ((slot == 19) && 
    	(!plugin.getUtilPartciles().hasEffect(p))) {
     	 if(!p.hasPermission("ug.particulas.fogo") & !p.hasPermission("ug.particulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().particlepermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		 return;
    	 }
    	        plugin.getUtilPartciles().rorationOtherType(p, ParticleType.FLAME);
    	        p.sendMessage(ativado + "§cFogo");
    	        p.closeInventory();
    	        p.playSound(p.getLocation(), Sound.FIZZ, 1.0F, 1.0F);
    	 }
      if ((slot == 20) && 
    	(!plugin.getUtilPartciles().hasEffect(p))) {
     	 if(!p.hasPermission("ug.particulas.firework") & !p.hasPermission("ug.particulas.usar.todos") & !p.hasPermission("ug.usar.todos")) {
    		 p.sendMessage(plugin.getMessagesFile().particlepermission);
		     p.closeInventory();
		     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, -5);
    		 return;
    	 }
    	        plugin.getUtilPartciles().rorationOtherType(p, ParticleType.FIREWORKS_SPARK);
    	        p.sendMessage(ativado + "§cFirework");
    	        p.closeInventory();
    	        p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0F, 1.0F);
    	 }
      if (slot == 49) {
        plugin.getUtilPartciles().stopAll(p);
        p.closeInventory();
      }
      if (slot == 48)
      {
        p.closeInventory();
        plugin.getMenuManager().gadgetMenu.showMenu(p);
      }
      if (slot == 50)
      {
        p.closeInventory();
        p.sendMessage("§7§oEm breve!");
      }
    }
  }
}
