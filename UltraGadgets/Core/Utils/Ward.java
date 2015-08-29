package Utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import br.com.floodeer.ultragadgets.UltraGadgets;

public class Ward {
	
	
	public Ward() {}
	   
	public UtilMenu inv;
	public UtilMenu invlh;
	public UtilMenu invll;
	public UtilMenu invlc;
	public UtilMenu invlb;
	
	public Ward(Player p, UltraGadgets plugin) {
	inv = new UtilMenu(plugin, "Guarda-Roupa", 5);
	invlh = new UtilMenu(plugin, "Cor do Capacete", 4);
	invll = new UtilMenu(plugin, "Cor da Calça", 4);
	invlc = new UtilMenu(plugin, "Cor do Chestplate", 4);
	invlb = new UtilMenu(plugin, "Cor das Botas", 4);
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
    
    ItemStack WEB1 = new ItemStack(Material.STAINED_CLAY, 1, (byte)5);
    ItemMeta WEBmeta1 = WEB1.getItemMeta();
    WEB1.setAmount(1);
    WEBmeta1.setDisplayName("Selecione a cor");
    WEB1.setItemMeta(WEBmeta1);
    ItemStack WEB2 = new ItemStack(Material.STAINED_CLAY, 1, (byte)5);
    ItemMeta WEBmeta2 = WEB2.getItemMeta();
    WEB2.setAmount(2);
    WEBmeta2.setDisplayName("Selecione a cor");
    WEB2.setItemMeta(WEBmeta2);
    ItemStack WEB3 = new ItemStack(Material.STAINED_CLAY, 1, (byte)5);
    ItemMeta WEBmeta3 = WEB3.getItemMeta();
    WEB3.setAmount(3);
    WEBmeta3.setDisplayName("Selecione a cor");
    WEB3.setItemMeta(WEBmeta3);
    ItemStack WEB4 = new ItemStack(Material.STAINED_CLAY, 1, (byte)5);
    WEB4.setAmount(4);
    ItemMeta WEBmeta4 = WEB4.getItemMeta();
    WEBmeta4.setDisplayName("Selecione a cor");
    WEB4.setItemMeta(WEBmeta4);
    
    ItemStack white = new ItemStack(Material.INK_SACK, 1, (short)15);
    ItemMeta whitemeta = white.getItemMeta();
    whitemeta.setDisplayName("§fBranco");
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
    lightbluemeta.setDisplayName("Azul Escuro");
    lightblue.setItemMeta(lightbluemeta);
    
    ItemStack yellow = new ItemStack(Material.INK_SACK, 1, (short)11);
    ItemMeta yellowmeta = yellow.getItemMeta();
    yellowmeta.setDisplayName("Amarelo");
    yellow.setItemMeta(yellowmeta);
    
    ItemStack lime = new ItemStack(Material.INK_SACK, 1, (short)10);
    ItemMeta limemeta = lime.getItemMeta();
    limemeta.setDisplayName("Limao");
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
    silvermeta.setDisplayName("§8Prata");
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
    
    ItemStack glass5 = new ItemStack(Material.BARRIER, 1);
    glass5.setAmount(1);
    ItemMeta glassmeta5 = glass5.getItemMeta();
    glassmeta5.setDisplayName("§7Nenhum");
    glass5.setItemMeta(glassmeta5);
    
    ItemStack arrow = new ItemStack(Material.ARROW, 1);
    arrow.setAmount(1);
    ItemMeta arrowmeta = arrow.getItemMeta();
    arrowmeta.setDisplayName("§cCancelar");
    arrow.setItemMeta(arrowmeta);
    
    ItemStack clearArmor = new ItemStack(Material.REDSTONE);
    ItemMeta clearArmorMeta = clearArmor.getItemMeta();
    clearArmorMeta.setDisplayName("§7Remover armadura");
    clearArmor.setItemMeta(clearArmorMeta);
    inv.setItem(40, clearArmor);
    
    ItemStack glass1 = new ItemStack(Material.BARRIER, 1);
    ItemMeta glassmeta1 = glass1.getItemMeta();
    glass1.setAmount(1);
    glassmeta1.setDisplayName("§7Remover capacete");
    glass1.setItemMeta(glassmeta1);
    ItemStack glass2 = new ItemStack(Material.BARRIER, 1);
    ItemMeta glassmeta2 = glass2.getItemMeta();
    glass2.setAmount(2);
    glassmeta2.setDisplayName("§7Remover peitoral");
    glass2.setItemMeta(glassmeta2);
    ItemStack glass3 = new ItemStack(Material.BARRIER, 1);
    ItemMeta glassmeta3 = glass3.getItemMeta();
    glass3.setAmount(3);
    glassmeta3.setDisplayName("§7Remover calça");
    glass3.setItemMeta(glassmeta3);
    ItemStack glass4 = new ItemStack(Material.BARRIER, 1);
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
    
    inv.showMenu(p);
  }

}
