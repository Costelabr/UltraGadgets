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

public class ParticlesMenu
  implements Listener
{
  Main plugin;
  String particleTitle;
  String ativado;
  public Menus particleMenu;
  
  public ParticlesMenu()
  {
    this.plugin = Main.getMain();
    
    this.particleTitle = this.plugin.getMessagesFile().ParticlesMenuName;
    this.ativado = this.plugin.getMensagensConfig().getString("Nova-Particula").replaceAll("&", "§");
    
    this.particleMenu = new Menus(this.plugin, this.particleTitle, 6);
    
    this.particleMenu.setItem(12, this.plugin.getItemStack().newItemStack(Material.GOLDEN_APPLE, "§aCorações", 
      Arrays.asList(new String[] {"§7Corações em volta da sua cabeça!" }), 1, (byte)0));
    
    this.particleMenu.setItem(13, this.plugin.getItemStack().newItemStack(Material.SLIME_BALL, "§aSlime", 
      Arrays.asList(new String[] {"§7Slime em volta de sua cabeça!" }), 1, (byte)0));
    
    this.particleMenu.setItem(14, this.plugin.getItemStack().newItemStack(Material.JUKEBOX, "§aNotas", 
      Arrays.asList(new String[] {"§7Notas em volta de sua cabeça!" }), 1, (byte)0));
    
    this.particleMenu.setItem(21, this.plugin.getItemStack().newItemStack(Material.BLAZE_POWDER, "§aAngry Villager", 
      Arrays.asList(new String[] {"§7Angry Villager Efeito em volta de sua cabeça!" }), 1, (byte)0));
    
    this.particleMenu.setItem(22, this.plugin.getItemStack().newItemStack(Material.EMERALD, "§aVillager Happy", 
      Arrays.asList(new String[] {"§7Villager Happy Efeito em volta de sua cabeça!" }), 1, (byte)0));
    
    this.particleMenu.setItem(23, this.plugin.getItemStack().newItemStack(Material.REDSTONE, "§aRedstone", 
      Arrays.asList(new String[] {"§7Efeito de Redstone em volta de sua cabeça!" }), 1, (byte)0));
    
    this.particleMenu.setItem(30, this.plugin.getItemStack().newItemStack(Material.GLASS_BOTTLE, "§aSpell", 
      Arrays.asList(new String[] {"§7Efeito Spell em volta de sua cabeça!" }), 1, (byte)0));
    
    this.particleMenu.setItem(39, this.plugin.getItemStack().newItemStack(Material.ARROW, "§fVoltar", 
      Arrays.asList(new String[] {"§7Clique para voltar ao menu de seleção" }), 1, (byte)0));
    
    this.particleMenu.setItem(31, this.plugin.getItemStack().newItemStack(Material.FLINT_AND_STEEL, "§aFogo", 
      Arrays.asList(new String[] {"§7Efeito de fogo em volta da sua cabeça!"}), 1, (byte)0));
    
    this.particleMenu.setItem(32, this.plugin.getItemStack().newItemStack(Material.FIREWORK, "§aFirework", 
    Arrays.asList(new String[] {"§7Efeito de firework em volta da sua cabeça!"}), 1, (byte)0));
    
    
    this.particleMenu.setItem(40, this.plugin.getItemStack().newItemStack(Material.WOOL, 
      "§cRemover partículas", Arrays.asList(new String[] { "§7Clique para desativar suas partículas!" }), 1, (byte)14));
    
    this.particleMenu.setItem(41, this.plugin.getItemStack().setGoArrow());
  }
  
  @EventHandler
  public void onClickInParticlesMenu(InventoryClickEvent e)
  {
    if ((e.getInventory().getName().equalsIgnoreCase(this.particleTitle)) && ((e.getWhoClicked() instanceof Player)))
    {
      Player p = (Player)e.getWhoClicked();
      e.setCancelled(true);
      e.setResult(Result.DENY);
      int slot = e.getSlot();
      if ((slot == 12) && 
        (!this.plugin.getUtilPartciles().hasEffect(p)))
      {
        this.plugin.getUtilPartciles().rorationEffect(p, ParticleEffect.HEART);
        p.sendMessage(this.ativado + "§cCorações");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.GHAST_MOAN, 1.0F, 1.0F);
      }
      if ((slot == 13) && 
        (!this.plugin.getUtilPartciles().hasEffect(p)))
      {
        this.plugin.getUtilPartciles().rorationEffect(p, ParticleEffect.SLIME);
        p.sendMessage(this.ativado + "§cSlime");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.SLIME_WALK, 1.0F, 1.0F);
      }
      if ((slot == 14) && 
        (!this.plugin.getUtilPartciles().hasEffect(p)))
      {
        this.plugin.getUtilPartciles().rorationEffect(p, ParticleEffect.NOTE);
        p.sendMessage(this.ativado + "§cNotas");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
      }
      if ((slot == 21) && 
        (!this.plugin.getUtilPartciles().hasEffect(p)))
      {
        this.plugin.getUtilPartciles().rorationEffect(p, ParticleEffect.VILLAGER_ANGRY);
        p.sendMessage(this.ativado + "§cAngry Villager");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, -1.0F);
      }
      if ((slot == 22) && 
        (!this.plugin.getUtilPartciles().hasEffect(p)))
      {
        this.plugin.getUtilPartciles().rorationEffect(p, ParticleEffect.VILLAGER_HAPPY);
        p.sendMessage(this.ativado + "§cVillager Happy");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
      }
      if ((slot == 23) && 
        (!this.plugin.getUtilPartciles().hasEffect(p)))
      {
        this.plugin.getUtilPartciles().rorationEffect(p, ParticleEffect.REDSTONE);
        p.sendMessage(this.ativado + "§cRedstone");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 1.0F, 1.0F);
      }
      if ((slot == 30) && 
        (!this.plugin.getUtilPartciles().hasEffect(p)))
      {
        this.plugin.getUtilPartciles().rorationEffect(p, ParticleEffect.SPELL);
        p.sendMessage(this.ativado + "§cSpell");
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.FALL_BIG, 1.0F, 1.0F);
      }
      if ((slot == 31) && 
    	(!this.plugin.getUtilPartciles().hasEffect(p)))
    	  {
    	        this.plugin.getUtilPartciles().rorationOtherType(p, ParticleType.FLAME);
    	        p.sendMessage(this.ativado + "§cFogo");
    	        p.closeInventory();
    	        p.playSound(p.getLocation(), Sound.FIZZ, 1.0F, 1.0F);
    	 }
      if ((slot == 32) && 
    	(!this.plugin.getUtilPartciles().hasEffect(p)))
    	  {
    	        this.plugin.getUtilPartciles().rorationOtherType(p, ParticleType.FIREWORKS_SPARK);
    	        p.sendMessage(this.ativado + "§cFirework");
    	        p.closeInventory();
    	        p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1.0F, 1.0F);
    	 }
      if (slot == 40) {
        this.plugin.getUtilPartciles().stopRotation(p);
        p.closeInventory();
      }
      if (slot == 39)
      {
        p.closeInventory();
        this.plugin.getMenuManager().gadgetMenu.showMenu(p);
      }
      if (slot == 41)
      {
        p.closeInventory();
        p.sendMessage("§7§oEm breve!");
      }
    }
  }
}
