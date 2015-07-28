package Core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.floodeer.gadgets.Main;

public class WardrobeUtils implements Listener {
	
	  public Inventory inv;
	  public Inventory invlh;
	  public Inventory invll;
	  public Inventory invlc;
	  public Inventory invlb;
	  
	  public WardrobeUtils() {}
	  public void register(JavaPlugin loader) {
		  Bukkit.getPluginManager().registerEvents(this, loader);
	  }
	  
	  public WardrobeUtils(Main plugin, Player p)
	  {
	  inv = Bukkit.getServer().createInventory(null, 36, "Guarda-Roupa");
	  invlh = Bukkit.getServer().createInventory(null, 36, "Cor do Capacete");
	  invlc = Bukkit.getServer().createInventory(null, 36, "Cor do Chestplate");
	  invll = Bukkit.getServer().createInventory(null, 36, "Cor da Calça");
	  invlb = Bukkit.getServer().createInventory(null, 36, "Cor das Botas");
	  
    ItemStack lh = new ItemStack(Material.LEATHER_HELMET, 1);
    ItemStack ch = new ItemStack(Material.CHAINMAIL_HELMET, 1);
    ItemStack ih = new ItemStack(Material.IRON_HELMET, 1);
    ItemStack gh = new ItemStack(Material.GOLD_HELMET, 1);
    ItemStack dh = new ItemStack(Material.DIAMOND_HELMET, 1);
    
    ItemStack lc = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    ItemStack cc = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
    ItemStack ic = new ItemStack(Material.IRON_CHESTPLATE, 1);
    ItemStack gc = new ItemStack(Material.GOLD_CHESTPLATE, 1);
    ItemStack dc = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
    
    ItemStack ll = new ItemStack(Material.LEATHER_LEGGINGS, 1);
    ItemStack cl = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
    ItemStack il = new ItemStack(Material.IRON_LEGGINGS, 1);
    ItemStack gl = new ItemStack(Material.GOLD_LEGGINGS, 1);
    ItemStack dl = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
    
    ItemStack lb = new ItemStack(Material.LEATHER_BOOTS, 1);
    ItemStack cb = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
    ItemStack ib = new ItemStack(Material.IRON_BOOTS, 1);
    ItemStack gb = new ItemStack(Material.GOLD_BOOTS, 1);
    ItemStack db = new ItemStack(Material.DIAMOND_BOOTS, 1);
    
    ItemStack WEB1 = new ItemStack(Material.WEB, 1);
    ItemMeta WEBmeta1 = WEB1.getItemMeta();
    WEB1.setAmount(1);
    WEBmeta1.setDisplayName("Selecione a cor");
    WEB1.setItemMeta(WEBmeta1);
    ItemStack WEB2 = new ItemStack(Material.WEB, 1);
    ItemMeta WEBmeta2 = WEB2.getItemMeta();
    WEB2.setAmount(2);
    WEBmeta2.setDisplayName("Selecione a cor");
    WEB2.setItemMeta(WEBmeta2);
    ItemStack WEB3 = new ItemStack(Material.WEB, 1);
    ItemMeta WEBmeta3 = WEB3.getItemMeta();
    WEB3.setAmount(3);
    WEBmeta3.setDisplayName("Selecione a cor");
    WEB3.setItemMeta(WEBmeta3);
    ItemStack WEB4 = new ItemStack(Material.WEB, 1);
    WEB4.setAmount(4);
    ItemMeta WEBmeta4 = WEB4.getItemMeta();
    WEBmeta4.setDisplayName("Selecione a cor");
    WEB4.setItemMeta(WEBmeta4);
    
    ItemStack white = new ItemStack(Material.INK_SACK, 1, (short)15);
    ItemMeta whitemeta = white.getItemMeta();
    whitemeta.setDisplayName("§aBranco");
    white.setItemMeta(whitemeta);
    
    ItemStack orange = new ItemStack(Material.INK_SACK, 1, (short)14);
    ItemMeta orangemeta = orange.getItemMeta();
    orangemeta.setDisplayName("§6Laranja");
    orange.setItemMeta(orangemeta);
    
    ItemStack magenta = new ItemStack(Material.INK_SACK, 1, (short)13);
    ItemMeta magentameta = magenta.getItemMeta();
    magentameta.setDisplayName("Magenta");
    magenta.setItemMeta(magentameta);
    
    ItemStack lightblue = new ItemStack(Material.INK_SACK, 1, (short)12);
    ItemMeta lightbluemeta = lightblue.getItemMeta();
    lightbluemeta.setDisplayName("§1Azul Escuro");
    lightblue.setItemMeta(lightbluemeta);
    
    ItemStack yellow = new ItemStack(Material.INK_SACK, 1, (short)11);
    ItemMeta yellowmeta = yellow.getItemMeta();
    yellowmeta.setDisplayName("§eAmarelo");
    yellow.setItemMeta(yellowmeta);
    
    ItemStack lime = new ItemStack(Material.INK_SACK, 1, (short)10);
    ItemMeta limemeta = lime.getItemMeta();
    limemeta.setDisplayName("§aLimão");
    lime.setItemMeta(limemeta);
    
    ItemStack pink = new ItemStack(Material.INK_SACK, 1, (short)9);
    ItemMeta pinkmeta = pink.getItemMeta();
    pinkmeta.setDisplayName("§dRosa");
    pink.setItemMeta(pinkmeta);
    
    ItemStack gray = new ItemStack(Material.INK_SACK, 1, (short)8);
    ItemMeta graymeta = gray.getItemMeta();
    graymeta.setDisplayName("§7Cinza");
    gray.setItemMeta(graymeta);
    
    ItemStack silver = new ItemStack(Material.INK_SACK, 1, (short)7);
    ItemMeta silvermeta = silver.getItemMeta();
    silvermeta.setDisplayName("§aBranco");
    silver.setItemMeta(silvermeta);
    
    ItemStack cyan = new ItemStack(Material.INK_SACK, 1, (short)6);
    ItemMeta cyanmeta = cyan.getItemMeta();
    cyanmeta.setDisplayName("§bCiano");
    cyan.setItemMeta(cyanmeta);
    
    ItemStack purple = new ItemStack(Material.INK_SACK, 1, (short)5);
    ItemMeta purplemeta = purple.getItemMeta();
    purplemeta.setDisplayName("§5Roxo");
    purple.setItemMeta(purplemeta);
    
    ItemStack blue = new ItemStack(Material.INK_SACK, 1, (short)4);
    ItemMeta bluemeta = blue.getItemMeta();
    bluemeta.setDisplayName("§9Azul");
    blue.setItemMeta(bluemeta);
    
    ItemStack brown = new ItemStack(Material.INK_SACK, 1, (short)3);
    ItemMeta brownmeta = brown.getItemMeta();
    brownmeta.setDisplayName("§fCastanho");
    brown.setItemMeta(brownmeta);
    
    ItemStack green = new ItemStack(Material.INK_SACK, 1, (short)2);
    ItemMeta greenmeta = green.getItemMeta();
    greenmeta.setDisplayName("§2Verde");
    green.setItemMeta(greenmeta);
    
    ItemStack red = new ItemStack(Material.INK_SACK, 1, (short)1);
    ItemMeta redmeta = red.getItemMeta();
    redmeta.setDisplayName("§cVermelho");
    red.setItemMeta(redmeta);
    
    ItemStack black = new ItemStack(Material.INK_SACK, 1, (short)0);
    ItemMeta blackmeta = black.getItemMeta();
    blackmeta.setDisplayName("§8Preto");
    black.setItemMeta(blackmeta);
    
    ItemStack glass5 = new ItemStack(Material.GLASS, 1);
    glass5.setAmount(1);
    ItemMeta glassmeta5 = glass5.getItemMeta();
    glassmeta5.setDisplayName("§7Nenhum");
    glass5.setItemMeta(glassmeta5);
    
    ItemStack arrow = new ItemStack(Material.ARROW, 1);
    arrow.setAmount(1);
    ItemMeta arrowmeta = arrow.getItemMeta();
    arrowmeta.setDisplayName("§cCancelar");
    arrow.setItemMeta(arrowmeta);
    
    ItemStack glass1 = new ItemStack(Material.GLASS, 1);
    ItemMeta glassmeta1 = glass1.getItemMeta();
    glass1.setAmount(1);
    glassmeta1.setDisplayName("§7Remover capacete");
    glass1.setItemMeta(glassmeta1);
    ItemStack glass2 = new ItemStack(Material.GLASS, 1);
    ItemMeta glassmeta2 = glass2.getItemMeta();
    glass2.setAmount(2);
    glassmeta2.setDisplayName("§7Remover peitoral");
    glass2.setItemMeta(glassmeta2);
    ItemStack glass3 = new ItemStack(Material.GLASS, 1);
    ItemMeta glassmeta3 = glass3.getItemMeta();
    glass3.setAmount(3);
    glassmeta3.setDisplayName("§7Remover calça");
    glass3.setItemMeta(glassmeta3);
    ItemStack glass4 = new ItemStack(Material.GLASS, 1);
    glass4.setAmount(4);
    ItemMeta glassmeta4 = glass4.getItemMeta();
    glassmeta4.setDisplayName("§7Remover botas");
    glass4.setItemMeta(glassmeta4);
    
    inv.setItem(2, lh);
    inv.setItem(3, ch);
    inv.setItem(4, ih);
    inv.setItem(5, gh);
    inv.setItem(6, dh);
    
    inv.setItem(11, lc);
    inv.setItem(12, cc);
    inv.setItem(13, ic);
    inv.setItem(14, gc);
    inv.setItem(15, dc);
    
    inv.setItem(20, ll);
    inv.setItem(21, cl);
    inv.setItem(22, il);
    inv.setItem(23, gl);
    inv.setItem(24, dl);
    
    inv.setItem(29, lb);
    inv.setItem(30, cb);
    inv.setItem(31, ib);
    inv.setItem(32, gb);
    inv.setItem(33, db);
    
    inv.setItem(0, WEB1);
    inv.setItem(9, WEB2);
    inv.setItem(18, WEB3);
    inv.setItem(27, WEB4);
    
    inv.setItem(8, glass1);
    inv.setItem(17, glass2);
    inv.setItem(26, glass3);
    inv.setItem(35, glass4);
    
    invlh.setItem(0, white);
    invlh.setItem(1, orange);
    invlh.setItem(2, magenta);
    invlh.setItem(3, lightblue);
    invlh.setItem(4, yellow);
    invlh.setItem(5, lime);
    invlh.setItem(6, pink);
    invlh.setItem(7, gray);
    invlh.setItem(8, silver);
    
    invlh.setItem(10, cyan);
    invlh.setItem(11, purple);
    invlh.setItem(12, blue);
    invlh.setItem(13, brown);
    invlh.setItem(14, green);
    invlh.setItem(15, red);
    invlh.setItem(16, black);
    
    invlh.setItem(30, glass5);
    invlh.setItem(32, arrow);
    
    invlc.setItem(0, white);
    invlc.setItem(1, orange);
    invlc.setItem(2, magenta);
    invlc.setItem(3, lightblue);
    invlc.setItem(4, yellow);
    invlc.setItem(5, lime);
    invlc.setItem(6, pink);
    invlc.setItem(7, gray);
    invlc.setItem(8, silver);
    
    invlc.setItem(10, cyan);
    invlc.setItem(11, purple);
    invlc.setItem(12, blue);
    invlc.setItem(13, brown);
    invlc.setItem(14, green);
    invlc.setItem(15, red);
    invlc.setItem(16, black);
    
    invlc.setItem(30, glass5);
    invlc.setItem(32, arrow);
    
    invll.setItem(0, white);
    invll.setItem(1, orange);
    invll.setItem(2, magenta);
    invll.setItem(3, lightblue);
    invll.setItem(4, yellow);
    invll.setItem(5, lime);
    invll.setItem(6, pink);
    invll.setItem(7, gray);
    invll.setItem(8, silver);
    
    invll.setItem(10, cyan);
    invll.setItem(11, purple);
    invll.setItem(12, blue);
    invll.setItem(13, brown);
    invll.setItem(14, green);
    invll.setItem(15, red);
    invll.setItem(16, black);
    
    invll.setItem(30, glass5);
    invll.setItem(32, arrow);
    
    invlb.setItem(0, white);
    invlb.setItem(1, orange);
    invlb.setItem(2, magenta);
    invlb.setItem(3, lightblue);
    invlb.setItem(4, yellow);
    invlb.setItem(5, lime);
    invlb.setItem(6, pink);
    invlb.setItem(7, gray);
    invlb.setItem(8, silver);
    
    invlb.setItem(10, cyan);
    invlb.setItem(11, purple);
    invlb.setItem(12, blue);
    invlb.setItem(13, brown);
    invlb.setItem(14, green);
    invlb.setItem(15, red);
    invlb.setItem(16, black);
    
    invlb.setItem(30, glass5);
    invlb.setItem(32, arrow);
    
    p.openInventory(inv);
  }
  
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event)
  {
    Player player = (Player)event.getWhoClicked();
    ItemStack clicked = event.getCurrentItem();
    Inventory inventory = event.getInventory();
    if (clicked == null) {
      return;
    }
    if ((!inventory.getName().equals("Guarda-Roupa")) && 
      (!inventory.getName().equals("Cor do Capacete")) && 
      (!inventory.getName().equals("Chestplate Color")) && 
      (!inventory.getName().equals("Cor da Calça")) && 
      (!inventory.getName().equals("Cor das Botas"))) {
      return;
    }
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
    ItemStack orangel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
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
    ItemStack magental = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
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
    ItemStack lightbluel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
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
    ItemStack yellowl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
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
    ItemStack limel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
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
    ItemStack pinkl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
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
    ItemStack grayl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
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
    ItemStack silverl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
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
    ItemStack cyanl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
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
    ItemStack purplel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
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
    ItemStack bluel = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
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
    ItemStack brownl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
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
    ItemStack greenl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
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
    ItemStack redl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
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
    ItemStack blackl = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    LeatherArmorMeta blacklmeta = (LeatherArmorMeta)blackl.getItemMeta();
    blacklmeta.setColor(Color.BLACK);
    blackl.setItemMeta(blacklmeta);
    ItemStack blackb = new ItemStack(Material.LEATHER_BOOTS, 1);
    LeatherArmorMeta blackbmeta = (LeatherArmorMeta)blackb.getItemMeta();
    blackbmeta.setColor(Color.BLACK);
    blackb.setItemMeta(blackbmeta);
    if ((inventory.getName().equals("Guarda-Roupa")) && 
      (clicked.getType() == Material.LEATHER_HELMET))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.LEATHER_HELMET);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setHelmet(item);
    }
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
      (clicked.getType() == Material.LEATHER_LEGGINGS))
    {
      event.setCancelled(true);
      player.closeInventory();
      ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
      if (player.hasPermission("ug.wardrobe.encantado")) {
        item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
      }
      player.getInventory().setLeggings(item);
    }
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
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
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
      (clicked.getType() == Material.GLASS) && 
      (clicked.getAmount() == 1))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(null);
    }
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
      (clicked.getType() == Material.GLASS) && 
      (clicked.getAmount() == 2))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(null);
    }
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
      (clicked.getType() == Material.GLASS) && 
      (clicked.getAmount() == 3))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(null);
    }
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
      (clicked.getType() == Material.GLASS) && 
      (clicked.getAmount() == 4))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(null);
    }
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
      (clicked.getType() == Material.WEB) && 
      (clicked.getAmount() == 1)) {
    	player.sendMessage(ChatColor.RED + "Em breve!");
    	event.setCancelled(true);
    }
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
      (clicked.getType() == Material.WEB) && 
      (clicked.getAmount() == 2)) {
    	player.sendMessage(ChatColor.RED + "Em breve!");
    	event.setCancelled(true);
    }
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
      (clicked.getType() == Material.WEB) && 
      (clicked.getAmount() == 3))
    {
    	player.sendMessage(ChatColor.RED + "Em breve!");
    	event.setCancelled(true);
    }
    else if ((inventory.getName().equals("Guarda-Roupa")) && 
      (clicked.getType() == Material.WEB) && 
      (clicked.getAmount() == 4))
    {
    	player.sendMessage(ChatColor.RED + "Em breve!");
    	event.setCancelled(true);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getType() == Material.ARROW))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.openInventory(inv);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getType() == Material.ARROW))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.openInventory(inv);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getType() == Material.ARROW))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.openInventory(inv);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getType() == Material.ARROW))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.openInventory(inv);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getType() == Material.GLASS))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(lh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getType() == Material.GLASS))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(lc);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getType() == Material.GLASS))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(ll);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getType() == Material.GLASS))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(lb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Branco")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(whiteh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Branco")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(whitecp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Branco")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(whitel);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Branco")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(whiteb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Laranja")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(orangeh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Laranja")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(orangecp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Laranja")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(orangel);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Laranja")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(orangeb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Magenta")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(magentah);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Magenta")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(magentacp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Magenta")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(magental);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Magenta")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(magentab);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul Escuro")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(lightblueh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul Escuro")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(lightbluecp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul Escuro")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(lightbluel);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul Escuro")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(lightblueb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Amarelo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(yellowh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Amarelo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(yellowcp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Amarelo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(yellowl);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Amarelo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(yellowb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Limão")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(limeh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Limão")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(limecp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Limão")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(limel);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Limão")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(limeb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Rosa")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(pinkh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Rosa")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(pinkcp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Rosa")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(pinkl);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Rosa")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(pinkb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Cinza")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(grayh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Cinza")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(graycp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Cinza")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(grayl);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Cinza")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(grayb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Branco")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(silverh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Branco")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(silvercp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Branco")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(silverl);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Branco")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(silverb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Ciano")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(cyanh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Ciano")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(cyancp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Ciano")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(cyanl);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Ciano")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(cyanb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Roxo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(purpleh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Roxo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(purplecp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Roxo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(purplel);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Roxo")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(purpleb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(blueh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(bluecp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(bluel);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Azul")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(blueb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Castanho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(brownh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Castanho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(browncp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Castanho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(brownl);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Castanho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(brownb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Verde")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(greenh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Verde")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(greencp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Verde")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(greenl);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Verde")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(greenb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Vermelho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(redh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Vermelho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(redcp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Vermelho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(redl);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
      (clicked.getItemMeta().getDisplayName().contains("Vermelho")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setBoots(redb);
    }
    else if ((inventory.getName().equals("Cor do Capacete")) && 
      (clicked.getItemMeta().getDisplayName().contains("Preto")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setHelmet(blackh);
    }
    else if ((inventory.getName().equals("Chestplate Color")) && 
      (clicked.getItemMeta().getDisplayName().contains("Preto")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setChestplate(blackcp);
    }
    else if ((inventory.getName().equals("Cor da Calça")) && 
      (clicked.getItemMeta().getDisplayName().contains("Preto")))
    {
      event.setCancelled(true);
      player.closeInventory();
      player.getInventory().setLeggings(blackl);
    }
    else if ((inventory.getName().equals("Cor das Botas")) && 
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