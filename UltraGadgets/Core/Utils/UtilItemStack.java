package Utils;

import br.com.floodeer.ultragadgets.UltraGadgets;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class UtilItemStack
{
  UltraGadgets plugin = UltraGadgets.getMain();
  
  public ItemStack newItemStack(Material tipo, String nome, List<String> lore, int quantidade, byte data)
  {
    ItemStack i = new ItemStack(tipo, quantidade, data);
    ItemMeta im = i.getItemMeta();
    im.setDisplayName(nome);
    im.setLore(lore);
    i.setItemMeta(im);
    return i;
  }
  
  public ItemStack buildArmor(Material tipo, Enchantment enchant, int level) {
	  ItemStack i = new ItemStack(tipo);
	  ItemMeta im = i.getItemMeta();
	  im.addEnchant(enchant, level, true);
	  i.setItemMeta(im);
	  return i;
  }
  
  public ItemStack buildColoredArmor(Material tipo, Color color) {
	  ItemStack i = new ItemStack(tipo);
	  LeatherArmorMeta l = (LeatherArmorMeta)i.getItemMeta();
	  l.setColor(color);
	  i.setItemMeta(l);
	  return i;
  }
  
  public Item dropToRemove(ItemStack item, final long delay, Location l) {
		  final Item drop = l.getWorld().dropItem(l, item);
		  drop.setPickupDelay(Integer.MAX_VALUE);
		  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			
			@Override
			public void run() {
			drop.remove();
			}
		},delay*20); 
	  return drop;
  }
  
  public ItemStack setSoonTM()
  {
    ItemStack soonTM = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
    ItemMeta soonTMeta = soonTM.getItemMeta();
    soonTMeta.setDisplayName("§cEm breve");
    soonTMeta.setLore(null);
    soonTM.setItemMeta(soonTMeta);
    return soonTM;
  }
  
  public ItemStack setBackArrow()
  {
    ItemStack back = new ItemStack(Material.ARROW, 1);
    ItemMeta backMeta = back.getItemMeta();
    backMeta.setDisplayName("§c§l⇦⇦⇦");
    backMeta.setLore(Arrays.asList(new String[] { "§7Clique para voltar ao menu interior" }));
    back.setItemMeta(backMeta);
    return back;
  }
  
  public ItemStack setGoArrow()
  {
    ItemStack go = new ItemStack(Material.ARROW, 1);
    ItemMeta goMeta = go.getItemMeta();
    goMeta.setDisplayName("§a§l⇨⇨⇨ ");
    goMeta.setLore(Arrays.asList(new String[] { "§7Clique para ir a proxima página!" }));
    go.setItemMeta(goMeta);
    return go;
  }
  
  public ItemStack noPermissionItem(String itemName) {
	  
	    ItemStack np = new ItemStack(Material.INK_SACK, 1, (short)8);
	    ItemMeta npm = np.getItemMeta();
	    npm.setDisplayName(itemName);
	    npm.setLore(Arrays.asList(new String[] { "§cVoce não tem permissão!" }));
	    np.setItemMeta(npm);
	    return np;
   }
}
