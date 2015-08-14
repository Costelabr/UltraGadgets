package Core;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.floodeer.gadgets.UltraGadgets;

public class WardrobeUtils implements Listener {
  
	UltraGadgets plugin = UltraGadgets.getMain();
	  private ItemStack probally() {
		    ItemStack WEB4 = new ItemStack(Material.STAINED_CLAY, 1, (byte)5);
		    return WEB4;
	  }
	  
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event)
  {
    Player player = (Player)event.getWhoClicked();
    ItemStack clicked = event.getCurrentItem();
    Inventory inventory = event.getInventory();
    if(inventory.getName() == null) return;
    if ((!inventory.getName().contains("Guarda-Roupa")) &&
      (!inventory.getName().contains("Cor do Capacete")) &&
      (!inventory.getName().contains("Cor do Chestplate")) && 
      (!inventory.getName().contains("Cor da Calça")) && 
      (!inventory.getName().contains("Cor das Botas"))) {
      return;
    }
    if(event.isCancelled()) return;
    event.setCancelled(true);
    Ward w = new Ward(player, plugin);
    player.closeInventory();
    ItemStack lh = new ItemStack(Material.LEATHER_HELMET, 1);
    ItemStack lc = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    ItemStack ll = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    ItemStack lb = new ItemStack(Material.LEATHER_BOOTS, 1);
    
    ItemStack whiteh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta whitehmeta = (LeatherArmorMeta)whiteh.getItemMeta();
    whitehmeta.setColor(Color.WHITE);
    whiteh.setItemMeta(whitehmeta);
    ItemStack whitecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta whitecpmeta = (LeatherArmorMeta)whitecp.getItemMeta();
    whitecpmeta.setColor(Color.TEAL);
    whitecp.setItemMeta(whitecpmeta);
    ItemStack whitel = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta whitelmeta = (LeatherArmorMeta)whitel.getItemMeta();
    whitelmeta.setColor(Color.WHITE);
    whitel.setItemMeta(whitelmeta);
    ItemStack whiteb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta whitebmeta = (LeatherArmorMeta)whiteb.getItemMeta();
    whitebmeta.setColor(Color.WHITE);
    whiteb.setItemMeta(whitebmeta);
    
    ItemStack orangeh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta orangehmeta = (LeatherArmorMeta)orangeh.getItemMeta();
    orangehmeta.setColor(Color.ORANGE);
    orangeh.setItemMeta(orangehmeta);
    ItemStack orangecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta orangecpmeta = (LeatherArmorMeta)orangecp.getItemMeta();
    orangecpmeta.setColor(Color.ORANGE);
    orangecp.setItemMeta(orangecpmeta);
    ItemStack orangel = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta orangelmeta = (LeatherArmorMeta)orangel.getItemMeta();
    orangelmeta.setColor(Color.ORANGE);
    orangel.setItemMeta(orangelmeta);
    ItemStack orangeb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta orangebmeta = (LeatherArmorMeta)orangeb.getItemMeta();
    orangebmeta.setColor(Color.ORANGE);
    orangeb.setItemMeta(orangebmeta);
    
    ItemStack magentah = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta magentahmeta = (LeatherArmorMeta)magentah.getItemMeta();
    magentahmeta.setColor(Color.fromBGR(216, 76, 178));
    magentah.setItemMeta(magentahmeta);
    ItemStack magentacp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta magentacpmeta = (LeatherArmorMeta)magentacp.getItemMeta();
    magentacpmeta.setColor(Color.fromBGR(216, 76, 178));
    magentacp.setItemMeta(magentacpmeta);
    ItemStack magental = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta magentalmeta = (LeatherArmorMeta)magental.getItemMeta();
    magentalmeta.setColor(Color.fromBGR(216, 76, 178));
    magental.setItemMeta(magentalmeta);
    ItemStack magentab = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta magentabmeta = (LeatherArmorMeta)magentab.getItemMeta();
    magentabmeta.setColor(Color.fromBGR(216, 76, 178));
    magentab.setItemMeta(magentabmeta);
    
    ItemStack lightblueh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta lightbluehmeta = (LeatherArmorMeta)lightblueh.getItemMeta();
    lightbluehmeta.setColor(Color.fromBGR(216, 153, 102));
    lightblueh.setItemMeta(lightbluehmeta);
    ItemStack lightbluecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta lightbluecpmeta = (LeatherArmorMeta)lightbluecp.getItemMeta();
    lightbluecpmeta.setColor(Color.fromBGR(216, 153, 102));
    lightbluecp.setItemMeta(lightbluecpmeta);
    ItemStack lightbluel = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta lightbluelmeta = (LeatherArmorMeta)lightbluel.getItemMeta();
    lightbluelmeta.setColor(Color.fromBGR(216, 153, 102));
    lightbluel.setItemMeta(lightbluelmeta);
    ItemStack lightblueb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta lightbluebmeta = (LeatherArmorMeta)lightblueb.getItemMeta();
    lightbluebmeta.setColor(Color.fromBGR(216, 153, 102));
    lightblueb.setItemMeta(lightbluebmeta);
    
    ItemStack yellowh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta yellowhmeta = (LeatherArmorMeta)yellowh.getItemMeta();
    yellowhmeta.setColor(Color.YELLOW);
    yellowh.setItemMeta(yellowhmeta);
    ItemStack yellowcp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta yellowcpmeta = (LeatherArmorMeta)yellowcp.getItemMeta();
    yellowcpmeta.setColor(Color.YELLOW);
    yellowcp.setItemMeta(yellowcpmeta);
    ItemStack yellowl = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta yellowlmeta = (LeatherArmorMeta)yellowl.getItemMeta();
    yellowlmeta.setColor(Color.YELLOW);
    yellowl.setItemMeta(yellowlmeta);
    ItemStack yellowb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta yellowbmeta = (LeatherArmorMeta)yellowb.getItemMeta();
    yellowbmeta.setColor(Color.YELLOW);
    yellowb.setItemMeta(yellowbmeta);
    
    ItemStack limeh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta limehmeta = (LeatherArmorMeta)limeh.getItemMeta();
    limehmeta.setColor(Color.LIME);
    limeh.setItemMeta(limehmeta);
    ItemStack limecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta limecpmeta = (LeatherArmorMeta)limecp.getItemMeta();
    limecpmeta.setColor(Color.LIME);
    limecp.setItemMeta(limecpmeta);
    ItemStack limel = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta limelmeta = (LeatherArmorMeta)limel.getItemMeta();
    limelmeta.setColor(Color.LIME);
    limel.setItemMeta(limelmeta);
    ItemStack limeb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta limebmeta = (LeatherArmorMeta)limeb.getItemMeta();
    limebmeta.setColor(Color.LIME);
    limeb.setItemMeta(limebmeta);
    
    ItemStack pinkh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta pinkhmeta = (LeatherArmorMeta)pinkh.getItemMeta();
    pinkhmeta.setColor(Color.fromBGR(165, 127, 242));
    pinkh.setItemMeta(pinkhmeta);
    ItemStack pinkcp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta pinkcpmeta = (LeatherArmorMeta)pinkcp.getItemMeta();
    pinkcpmeta.setColor(Color.fromBGR(165, 127, 242));
    pinkcp.setItemMeta(pinkcpmeta);
    ItemStack pinkl = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta pinklmeta = (LeatherArmorMeta)pinkl.getItemMeta();
    pinklmeta.setColor(Color.fromBGR(165, 127, 242));
    pinkl.setItemMeta(pinklmeta);
    ItemStack pinkb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta pinkbmeta = (LeatherArmorMeta)pinkb.getItemMeta();
    pinkbmeta.setColor(Color.fromBGR(165, 127, 242));
    pinkb.setItemMeta(pinkbmeta);
    
    ItemStack grayh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta grayhmeta = (LeatherArmorMeta)grayh.getItemMeta();
    grayhmeta.setColor(Color.GRAY);
    grayh.setItemMeta(grayhmeta);
    ItemStack graycp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta graycpmeta = (LeatherArmorMeta)graycp.getItemMeta();
    graycpmeta.setColor(Color.GRAY);
    graycp.setItemMeta(graycpmeta);
    ItemStack grayl = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta graylmeta = (LeatherArmorMeta)grayl.getItemMeta();
    graylmeta.setColor(Color.GRAY);
    grayl.setItemMeta(graylmeta);
    ItemStack grayb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta graybmeta = (LeatherArmorMeta)grayb.getItemMeta();
    graybmeta.setColor(Color.GRAY);
    grayb.setItemMeta(graybmeta);
    
    ItemStack silverh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta silverhmeta = (LeatherArmorMeta)silverh.getItemMeta();
    silverhmeta.setColor(Color.SILVER);
    silverh.setItemMeta(silverhmeta);
    ItemStack silvercp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta silvercpmeta = (LeatherArmorMeta)silvercp.getItemMeta();
    silvercpmeta.setColor(Color.SILVER);
    silvercp.setItemMeta(silvercpmeta);
    ItemStack silverl = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta silverlmeta = (LeatherArmorMeta)silverl.getItemMeta();
    silverlmeta.setColor(Color.SILVER);
    silverl.setItemMeta(silverlmeta);
    ItemStack silverb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta silverbmeta = (LeatherArmorMeta)silverb.getItemMeta();
    silverbmeta.setColor(Color.SILVER);
    silverb.setItemMeta(silverbmeta);
    
    ItemStack cyanh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta cyanhmeta = (LeatherArmorMeta)cyanh.getItemMeta();
    cyanhmeta.setColor(Color.fromBGR(153, 127, 76));
    cyanh.setItemMeta(cyanhmeta);
    ItemStack cyancp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta cyancpmeta = (LeatherArmorMeta)cyancp.getItemMeta();
    cyancpmeta.setColor(Color.fromBGR(153, 127, 76));
    cyancp.setItemMeta(cyancpmeta);
    ItemStack cyanl = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta cyanlmeta = (LeatherArmorMeta)cyanl.getItemMeta();
    cyanlmeta.setColor(Color.fromBGR(153, 127, 76));
    cyanl.setItemMeta(cyanlmeta);
    ItemStack cyanb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta cyanbmeta = (LeatherArmorMeta)cyanb.getItemMeta();
    cyanbmeta.setColor(Color.fromBGR(153, 127, 76));
    cyanb.setItemMeta(cyanbmeta);
    
    ItemStack purpleh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta purplehmeta = (LeatherArmorMeta)purpleh.getItemMeta();
    purplehmeta.setColor(Color.PURPLE);
    purpleh.setItemMeta(purplehmeta);
    ItemStack purplecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta purplecpmeta = (LeatherArmorMeta)purplecp.getItemMeta();
    purplecpmeta.setColor(Color.PURPLE);
    purplecp.setItemMeta(purplecpmeta);
    ItemStack purplel = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta purplelmeta = (LeatherArmorMeta)purplel.getItemMeta();
    purplelmeta.setColor(Color.PURPLE);
    purplel.setItemMeta(purplelmeta);
    ItemStack purpleb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta purplebmeta = (LeatherArmorMeta)purpleb.getItemMeta();
    purplebmeta.setColor(Color.PURPLE);
    purpleb.setItemMeta(purplebmeta);
    
    ItemStack blueh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta bluehmeta = (LeatherArmorMeta)blueh.getItemMeta();
    bluehmeta.setColor(Color.fromBGR(178, 76, 51));
    blueh.setItemMeta(bluehmeta);
    ItemStack bluecp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta bluecpmeta = (LeatherArmorMeta)bluecp.getItemMeta();
    bluecpmeta.setColor(Color.fromBGR(178, 76, 51));
    bluecp.setItemMeta(bluecpmeta);
    ItemStack bluel = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta bluelmeta = (LeatherArmorMeta)bluel.getItemMeta();
    bluelmeta.setColor(Color.fromBGR(178, 76, 51));
    bluel.setItemMeta(bluelmeta);
    ItemStack blueb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta bluebmeta = (LeatherArmorMeta)blueb.getItemMeta();
    bluebmeta.setColor(Color.fromBGR(178, 76, 51));
    blueb.setItemMeta(bluebmeta);
    
    ItemStack brownh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta brownhmeta = (LeatherArmorMeta)brownh.getItemMeta();
    brownhmeta.setColor(Color.fromBGR(51, 76, 102));
    brownh.setItemMeta(brownhmeta);
    ItemStack browncp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta browncpmeta = (LeatherArmorMeta)browncp.getItemMeta();
    browncpmeta.setColor(Color.fromBGR(51, 76, 102));
    browncp.setItemMeta(browncpmeta);
    ItemStack brownl = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta brownlmeta = (LeatherArmorMeta)brownl.getItemMeta();
    brownlmeta.setColor(Color.fromBGR(51, 76, 102));
    brownl.setItemMeta(brownlmeta);
    ItemStack brownb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta brownbmeta = (LeatherArmorMeta)brownb.getItemMeta();
    brownbmeta.setColor(Color.fromBGR(51, 76, 102));
    brownb.setItemMeta(brownbmeta);
    
    ItemStack greenh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta greenhmeta = (LeatherArmorMeta)greenh.getItemMeta();
    greenhmeta.setColor(Color.GREEN);
    greenh.setItemMeta(greenhmeta);
    ItemStack greencp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta greencpmeta = (LeatherArmorMeta)greencp.getItemMeta();
    greencpmeta.setColor(Color.GREEN);
    greencp.setItemMeta(greencpmeta);
    ItemStack greenl = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta greenlmeta = (LeatherArmorMeta)greenl.getItemMeta();
    greenlmeta.setColor(Color.GREEN);
    greenl.setItemMeta(greenlmeta);
    ItemStack greenb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta greenbmeta = (LeatherArmorMeta)greenb.getItemMeta();
    greenbmeta.setColor(Color.GREEN);
    greenb.setItemMeta(greenbmeta);
    
    ItemStack redh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta redhmeta = (LeatherArmorMeta)redh.getItemMeta();
    redhmeta.setColor(Color.RED);
    redh.setItemMeta(redhmeta);
    ItemStack redcp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta redcpmeta = (LeatherArmorMeta)redcp.getItemMeta();
    redcpmeta.setColor(Color.RED);
    redcp.setItemMeta(redcpmeta);
    ItemStack redl = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta redlmeta = (LeatherArmorMeta)redl.getItemMeta();
    redlmeta.setColor(Color.RED);
    redl.setItemMeta(redlmeta);
    ItemStack redb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta redbmeta = (LeatherArmorMeta)redb.getItemMeta();
    redbmeta.setColor(Color.RED);
    redb.setItemMeta(redbmeta);
    
    ItemStack blackh = new ItemStack(Material.LEATHER_HELMET, 1);
    LeatherArmorMeta blackhmeta = (LeatherArmorMeta)blackh.getItemMeta();
    blackhmeta.setColor(Color.BLACK);
    blackh.setItemMeta(blackhmeta);
    ItemStack blackcp = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta blackcpmeta = (LeatherArmorMeta)blackcp.getItemMeta();
    blackcpmeta.setColor(Color.BLACK);
    blackcp.setItemMeta(blackcpmeta);
    ItemStack blackl = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    LeatherArmorMeta blacklmeta = (LeatherArmorMeta)blackl.getItemMeta();
    blacklmeta.setColor(Color.BLACK);
    blackl.setItemMeta(blacklmeta);
    ItemStack blackb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta blackbmeta = (LeatherArmorMeta)blackb.getItemMeta();
    blackbmeta.setColor(Color.BLACK);
    blackb.setItemMeta(blackbmeta);
    if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.LEATHER_HELMET)){
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.LEATHER_HELMET);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setHelmet(item);
    }
    else if((inventory.getName().contains("Guarda-Roupa")) && 
     (clicked.getType() == Material.REDSTONE)) {
    	event.setCancelled(true);
    player.closeInventory();
    player.getInventory().setHelmet(null);
    player.getInventory().setChestplate(null);
    player.getInventory().setLeggings(null);
    player.getInventory().setBoots(null);
}
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.LEATHER_CHESTPLATE))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setChestplate(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.LEATHER_LEGGINGS))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setLeggings(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.LEATHER_BOOTS))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setBoots(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.CHAINMAIL_HELMET))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.CHAINMAIL_HELMET);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setHelmet(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.CHAINMAIL_CHESTPLATE))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setChestplate(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.CHAINMAIL_LEGGINGS))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.CHAINMAIL_LEGGINGS);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setLeggings(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.CHAINMAIL_BOOTS))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setBoots(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.IRON_HELMET))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.IRON_HELMET);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setHelmet(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.IRON_CHESTPLATE))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setChestplate(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.IRON_LEGGINGS))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setLeggings(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.IRON_BOOTS))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.IRON_BOOTS);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setBoots(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.GOLD_HELMET))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.GOLD_HELMET);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setHelmet(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.GOLD_CHESTPLATE))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.GOLD_CHESTPLATE);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setChestplate(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.GOLD_LEGGINGS))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.GOLD_LEGGINGS);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setLeggings(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.GOLD_BOOTS))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.GOLD_BOOTS);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setBoots(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.DIAMOND_HELMET))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setHelmet(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.DIAMOND_CHESTPLATE))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setChestplate(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.DIAMOND_LEGGINGS))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setLeggings(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.DIAMOND_BOOTS))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setBoots(item);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.BARRIER) && 
      (clicked.getAmount() == 1))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(null);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.BARRIER) && 
      (clicked.getAmount() == 2))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(null);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.BARRIER) && 
      (clicked.getAmount() == 3))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(null);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == Material.BARRIER) && 
      (clicked.getAmount() == 4))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(null);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == probally().getType()) && 
      (clicked.getAmount() == 1)) {
    	player.closeInventory();
    	w.invlh.showMenu(player);
    	event.setCancelled(true);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == probally().getType()) && 
      (clicked.getAmount() == 2)) {
    	player.closeInventory();
    	w.invlc.showMenu(player);
    	event.setCancelled(true);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == probally().getType()) && 
      (clicked.getAmount() == 3))
    {
    	player.closeInventory();
    	w.invll.showMenu(player);
    	event.setCancelled(true);
    }
    else if ((inventory.getName().contains("Guarda-Roupa")) && 
      (clicked.getType() == probally().getType()) && 
      (clicked.getAmount() == 4))
    {
    	player.closeInventory();
    	w.invlb.showMenu(player);
    	event.setCancelled(true);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getType() == Material.ARROW))
    {
      event.setCancelled(true);
      player.closeInventory();
      w.inv.showMenu(player);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getType() == Material.ARROW))
    {
      event.setCancelled(true);
      player.closeInventory();
      w.inv.showMenu(player);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getType() == Material.ARROW))
    {
      event.setCancelled(true);
      player.closeInventory();
      w.inv.showMenu(player);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getType() == Material.ARROW))
    {
      event.setCancelled(true);
      player.closeInventory();
      w.inv.showMenu(player);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getType() == Material.BARRIER))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(lh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getType() == Material.BARRIER))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(lc);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getType() == Material.BARRIER))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(ll);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getType() == Material.BARRIER))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(lb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Prata")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(silverh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Prata")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(silvercp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Prata")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(silverl);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Branco")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(silverb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Laranja")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(orangeh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Laranja")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(orangecp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Laranja")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(orangel);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Laranja")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(orangeb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Magenta")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(magentah);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Magenta")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(magentacp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Magenta")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(magental);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Magenta")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(magentab);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul Escuro")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(lightblueh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul Escuro")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(lightbluecp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul Escuro")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(lightbluel);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul Escuro")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(lightblueb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Amarelo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(yellowh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Amarelo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(yellowcp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Amarelo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(yellowl);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Amarelo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(yellowb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("LimÃ£o")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(limeh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("LimÃ£o")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(limecp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("LimÃ£o")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(limel);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("LimÃ£o")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(limeb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Rosa")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(pinkh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Rosa")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(pinkcp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Rosa")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(pinkl);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Rosa")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(pinkb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Cinza")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(grayh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Cinza")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(graycp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Cinza")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(grayl);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Cinza")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(grayb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Branco")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(whiteh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Branco")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(whitecp);
    }
    
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Branco")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(whitel);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Branco")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(whiteb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Ciano")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(cyanh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Ciano")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(cyancp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Ciano")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(cyanl);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Ciano")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(cyanb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Roxo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(purpleh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Roxo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(purplecp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Roxo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(purplel);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Roxo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(purpleb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(blueh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(bluecp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(bluel);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(blueb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Castanho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(brownh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Castanho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(browncp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Castanho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(brownl);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Castanho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(brownb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Verde")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(greenh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Verde")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(greencp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Verde")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(greenl);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Verde")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(greenb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Vermelho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(redh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Vermelho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(redcp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Vermelho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(redl);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Vermelho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(redb);
    }
    else if ((inventory.getName().contains("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Preto")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(blackh);
    }
    else if ((inventory.getName().contains("Cor do Chestplate")) && 
      (clicked.getItemMeta().getDisplayName().contains("Preto")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(blackcp);
    }
    else if ((inventory.getName().contains("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Preto"))){
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(blackl);
    }
    else if ((inventory.getName().contains("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Preto")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(blackb);
    }
    else
    {
      event.setCancelled(true);
    }
  }
}