package Core;

import com.floodeer.gadgets.Main;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UtilItemStack
{
  Main plugin = Main.getMain();
  
  public ItemStack newItemStack(Material tipo, String nome, List<String> lore, int quantidade, byte data)
  {
    ItemStack i = new ItemStack(tipo, quantidade, data);
    ItemMeta im = i.getItemMeta();
    im.setDisplayName(nome);
    im.setLore(lore);
    i.setItemMeta(im);
    return i;
  }
  
  public ItemStack setSoonTM()
  {
    ItemStack soonTM = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
    ItemMeta soonTMeta = soonTM.getItemMeta();
    soonTMeta.setDisplayName("§cEm breve");
    soonTMeta.setLore(Arrays.asList(new String[] { "§7Em breve..." }));
    soonTM.setItemMeta(soonTMeta);
    return soonTM;
  }
  
  public ItemStack setBackArrow()
  {
    ItemStack back = new ItemStack(Material.ARROW, 1);
    ItemMeta backMeta = back.getItemMeta();
    backMeta.setDisplayName("§cVoltar");
    backMeta.setLore(Arrays.asList(new String[] { "§7Clique para voltar ao menu interior" }));
    back.setItemMeta(backMeta);
    return back;
  }
  
  public ItemStack setGoArrow()
  {
    ItemStack go = new ItemStack(Material.ARROW, 1);
    ItemMeta goMeta = go.getItemMeta();
    goMeta.setDisplayName("§aPróxima página");
    goMeta.setLore(Arrays.asList(new String[] { "§7Clique para ir a pr§xima p§gina!" }));
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
