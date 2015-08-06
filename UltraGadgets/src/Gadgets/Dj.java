package Gadgets;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.minecraft.server.v1_8_R3.EntityArmorStand;
import net.minecraft.server.v1_8_R3.NBTTagCompound;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftArmorStand;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import Core.ParticleEffect;
import Core.Util18;
import Core.UtilBallEffect;
import Core.UtilCooldown;
import Core.UtilMenu;
import Exception.GadgetException;
import Song.NBSDecoder;
import Song.RadioSongPlayer;
import Song.Song;
import Song.SongPlayer;

import com.floodeer.gadgets.UltraGadgets;

public class Dj
  implements Listener
{
  public final ArrayList<Player> dj = new ArrayList<Player>();
  UltraGadgets plugin;
  int task1;
  int task2;
  int task3;
  int task4;
  int task5;
  int task6;
  int rt;
  public final Map<Player, String> _ativado = new HashMap<Player, String>();
  public final Map<UUID, Boolean> dropDiscs = new HashMap<UUID, Boolean>();
  public final Map<UUID, Boolean> notes = new HashMap<UUID, Boolean>();
  public static Map<String, SongPlayer> song = new HashMap<String, SongPlayer>();
  public static final Map<String, Boolean> discoBall = new HashMap<>();
  public final List<Entity> armor = new ArrayList<Entity>();
  UtilMenu DjMenu = new UtilMenu(this.plugin, ChatColor.RED + "§lDj", 1);
  Map<Location, Block> blockToRemove = new HashMap<>();
  List<Location> l = new ArrayList<Location>();
  HashMap<UUID, String> songType = new HashMap<UUID, String>();
  UtilMenu musicas = new UtilMenu(plugin, ChatColor.GRAY + "Músicas", 1);
  
  public Song song1 = NBSDecoder.parse(new File(plugin.getDataFolder() + "/sons", "DubStep.nbs"));
  public Song song2 = NBSDecoder.parse(new File(plugin.getDataFolder() + "/sons", "Popcorn.nbs"));
  public Song song3 = NBSDecoder.parse(new File(plugin.getDataFolder() + "/sons", "Imagine.nbs"));
  public Song song4 = NBSDecoder.parse(new File(plugin.getDataFolder() + "/sons", "Sweden.nbs"));
  public Song song5 = NBSDecoder.parse(new File(plugin.getDataFolder() + "/sons", "Nyancat.nbs"));
  public SongPlayer sp;
  
  public void showMusicMenu(Player p) {
	  
	musicas.setItem(2, plugin.getItemStack().newItemStack(Material.RECORD_3, "DubStep", null, 1, (byte)0));
		  
	musicas.setItem(3, plugin.getItemStack().newItemStack(Material.RECORD_5, "Popcorn", null, 1, (byte)0));
		  
	musicas.setItem(4, plugin.getItemStack().newItemStack(Material.RECORD_8, "Imagine Dragons", null, 1, (byte)0));
		  
	musicas.setItem(5, plugin.getItemStack().newItemStack(Material.RECORD_7, "Sweden", null, 1, (byte)0));
		  
	musicas.setItem(6, plugin.getItemStack().newItemStack(Material.RECORD_12, "Nyancat", null, 1, (byte)0));
		  
	musicas.showMenu(p);
}
  
  protected Vector getVelocityParameter() {
	   float j = 0.0F;
      Vector vector = new Vector(Math.cos(j) * 0.6000000238418579D, j * 0.01F, Math.sin(j) * 0.6000000238418579D);
      return vector;
  }
  
  public void play(Player[] players, Song s)
  {
    if (sp != null)
    {
      if (sp.isPlaying())
      {
        sp.setPlaying(false);
        sp.destroy();
        if (s.equals(sp.getSong()))
        {
          sp = null;
          return;
        }
        sp = null;
      }
    }
    else {
      sp = new RadioSongPlayer(s);
    }
    if (sp == null) {
      sp = new RadioSongPlayer(s);
    }
    sp.setAutoDestroy(true);
      for(Player pl : players) {
   	 for(Player pw : pl.getWorld().getPlayers()) {
       sp.addPlayer(pw);
    }
    sp.setPlaying(true);
  }
 }
  
  public void showDjMenu(Player p) {
	  DjMenu.setItem(1, this.plugin.getItemStack().newItemStack(Material.RECORD_10, "Dropar Discos", Arrays.asList(new String[] { "§aAtivar §7ou §cDesativar §7o drop de discos"}), 1, (byte)0));
	    
	  DjMenu.setItem(2, this.plugin.getItemStack().newItemStack(Material.NETHER_STAR, "Notas de Música", Arrays.asList(new String[] { "§aAtivar §7ou §cDesativar §7as partículas de nota" }), 1, (byte)0));
	    
	  DjMenu.setItem(4, this.plugin.getItemStack().newItemStack(Material.REDSTONE_COMPARATOR, "Disco-Ball", Arrays.asList(new String[] { "§aAtivar §7ou §cDesativar §7o efeito de Disco-Ball" }), 1, (byte)0));
	    
	  DjMenu.setItem(6, this.plugin.getItemStack().newItemStack(Material.JUKEBOX, "Selecionar o Som", Arrays.asList(new String[] { "§7Selecionar música" }), 1, (byte)0));
	    
	  DjMenu.setItem(7, this.plugin.getItemStack().newItemStack(Material.BARRIER, "Destruir", Arrays.asList(new String[] { "§7Destruir Dj" }), 1, (byte)14));
	  
	  DjMenu.showMenu(p);
  }
  
  public void stop() {
	   for(Player p : dj) {
	   Song s = NBSDecoder.parse(new File(plugin.getDataFolder() + "/sons", songType.get(p.getUniqueId()).replaceAll(".nbs", "") + ".nbs"));
	    SongPlayer sp = new RadioSongPlayer(s);
	    sp.setAutoDestroy(true);
	    sp.setPlaying(false);
	  }
  }
  
  
  private String layers(int y, int layloc){
		
	    String[] layer1 = {
	            "REDSTONE_LAMP_ON", "NOTE_BLOCK", "REDSTONE_LAMP_ON",
	            "JUKEBOX", "AIR", "JUKEBOX",
	            "REDSTONE_LAMP_ON", "NOTE_BLOCK", "REDSTONE_LAMP_ON"
	    };

	    String[] layer2 = {
	            "DAYLIGHT_DETECTOR", "AIR", "DAYLIGHT_DETECTOR",
	            "AIR", "AIR", "AIR",
	            "DAYLIGHT_DETECTOR", "AIR", "DAYLIGHT_DETECTOR"
	    };

	    String[] layer3 = {
	            "AIR", "AIR", "AIR",
	            "AIR", "AIR", "AIR",
	            "AIR", "AIR", "AIR"
	    };
	    if (y == 0){
	    	return layer1[layloc];
	    }
	    if (y == 1){
	    	return layer2[layloc];
	    }
	    if (y == 2){
	    	return layer3[layloc];
	    }
	    return null;
	 }

  private void startBuilder(Entity arroundLocation) {
      Block base = arroundLocation.getLocation().getBlock();
      Location ori = base.getRelative(BlockFace.NORTH_WEST).getLocation();
      int layloc;
      for (int y = 0; y < 3; y++){
          int by = ori.getBlock().getY() + y;
          layloc = 0;
          for (int x = 0; x < 3; x++){
              int bx = ori.getBlock().getX() + x;
              for (int z = 0; z < 3; z++){
                  int bz = ori.getBlock().getZ() + z;
                  Location block = new Location(arroundLocation.getLocation().getBlock().getWorld(), bx, by, bz);
                  block.getBlock().setType(Material.matchMaterial(layers(y, layloc)));
                  this.blockToRemove.put(block, block.getBlock());
                  plugin.getUtilBlock().setBlockToRestore(block.getBlock(), 0, (byte)0, 800L, true, true, true);
                  block.getBlock().setMetadata("DJBlock", new FixedMetadataValue(plugin, null));
                  layloc++;
              }
          }                     
      }
  }
  
  @SuppressWarnings("deprecation")
 public void destroy() {
	  for(Location locals : l) {
          locals.getWorld().playEffect(locals, Effect.STEP_SOUND, locals.getBlock().getTypeId());
		  blockToRemove.get(locals).setType(Material.AIR);
          Bukkit.getScheduler().cancelTask(Dj.this.task1);
          Bukkit.getScheduler().cancelTask(Dj.this.task2);
          Bukkit.getScheduler().cancelTask(Dj.this.task3);
          Bukkit.getScheduler().cancelTask(Dj.this.task4);
          Bukkit.getScheduler().cancelTask(Dj.this.task5);
          Bukkit.getScheduler().cancelTask(Dj.this.task6);
          Bukkit.getScheduler().cancelTask(Dj.this.rt);
          for(Entity e : locals.getWorld().getEntities()) {
        	  if(e.getType() == EntityType.ARMOR_STAND) {
        		  ArmorStand aToRemove = (ArmorStand)e;
        		  if(aToRemove.hasMetadata("Dj")) {
        			  aToRemove.remove();
        		  }
        	  }
          }
          discoBall.put("Disco", false);
          stop();
	  }  
  }  

  public void summonArmorStand(Location l, final Player p) 
  {
    final ArmorStand a = (ArmorStand)l.getWorld().spawn(l.getBlock().getRelative(BlockFace.SELF).getLocation(), ArmorStand.class);
	CraftArmorStand c = ((CraftArmorStand)a);
	EntityArmorStand s = c.getHandle();
	NBTTagCompound n = new NBTTagCompound();
	n.setBoolean("invulnerable", true);
	n.setBoolean("PersistenceRequired", true);
	n.setBoolean("NoBasePlate", true);
	n.setBoolean("ShowArms", true);
	n.setBoolean("NoBasePlate", true);
	n.setBoolean("CustomNameVisible", true);
	s.a(n);
    play((Player[])p.getWorld().getPlayers().toArray(new Player[0]), song1);
    a.setArms(true);
    a.setBasePlate(true);
    a.setCustomNameVisible(true);
	a.setCustomName("§b§lDj" + p.getName());
	ItemStack i = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
	SkullMeta m = (SkullMeta)i.getItemMeta();
	m.setOwner(p.getName());
	i.setItemMeta(m);
    a.setHelmet(i); 
	a.setChestplate(plugin.getItemStack().buildColoredArmor(Material.LEATHER_CHESTPLATE, Color.GREEN));
	a.setBoots(plugin.getItemStack().buildArmor(Material.DIAMOND_BOOTS, Enchantment.LUCK, 10));
    a.setMetadata("Dj", new FixedMetadataValue(this.plugin, null));
    a.setGravity(false);
    
    a.setCustomName("§c§lDj §e§l" + p.getName());
    startBuilder(a);
    this.armor.add(a);
    this.dropDiscs.put(a.getUniqueId(), Boolean.valueOf(true));
    this.notes.put(a.getUniqueId(), Boolean.valueOf(true));
    discoBall.put("DiscoBall", Boolean.valueOf(true));
    this.dj.add(p);
    UtilBallEffect newAbf = new UtilBallEffect();
    newAbf.startDisco(a.getLocation().add(0.0D, 12.0D, 0.0D), 40);
    a.getLocation().setDirection(new Vector(1,0,0));
    
    final EulerAngle p1 = new EulerAngle(0.1D, 0.0D, 0.0D);
    final EulerAngle p2 = new EulerAngle(0.3D, 0.0D, 0.0D);
    final EulerAngle m1 = new EulerAngle(-3.0D, 0.0D, 0.0D);
    final EulerAngle m2 = new EulerAngle(-1.0D, 0.0D, 0.0D);
    
    final EulerAngle mr1 = new EulerAngle(-1.3D, -0.5D, 1.0D);
    final EulerAngle mr2 = new EulerAngle(-1.3D, -0.5D, 2.0D);
    
    EulerAngle normal2 = new EulerAngle(1.0D, 0.0D, 0.0D);
    a.setLeftArmPose(normal2);
    
    a.setHeadPose(p2);
    
    this.task1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable()
    {
      public void run()
      {
        a.setHeadPose(p2);
      }
    }, 3L, 5L);
    this.task2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable()
    {
      public void run()
      {
        a.setHeadPose(p1);
      }
    }, 3L, 5L);
    
    this.task3 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable()
    {
      public void run()
      {
        a.setLeftArmPose(m1);
      }
    }, 3L, 5L);
    this.task4 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable()
    {
      public void run()
      {
        a.setLeftArmPose(m2);
        a.setRightArmPose(mr1);
      }
    }, 3L, 5L);
    this.task5 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable()
    {
      public void run()
      {
        a.setRightArmPose(mr2);
      }
    }, 3L, 5L);
    
    this.task6 = Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
    {
      public void run()
      {
        if (((Boolean)Dj.this.dropDiscs.get("Discos")).booleanValue())
        {
          ItemStack disc = new ItemStack(Material.RECORD_11);
          final Item drop1 = a.getWorld().dropItemNaturally(a.getLocation(), disc);
          drop1.setPickupDelay(Integer.MAX_VALUE);
          Vector added = new Vector(0.0D, 0.8D, 0.0D);
          drop1.setVelocity(added);
          Bukkit.getScheduler().scheduleSyncDelayedTask(Dj.this.plugin, new Runnable()
          {
            public void run()
            {
              drop1.remove();
            }
          }, 40L);
        }
      }
    }, 3L, 5L).getTaskId();
    
    this.rt = Bukkit.getServer().getScheduler().runTaskTimer(this.plugin, new Runnable()
    {
      float j = 0.0F;
      
      public void run()
      {
        Location loc = a.getLocation();
        loc.setY(loc.getY() + 1.9D + 0.03D);
        for (int k = 0; k < 1.0F; k++)
        {
          loc.add(Math.cos(this.j) * 0.6000000238418579D, this.j * 0.01F, Math.sin(this.j) * 
            0.6000000238418579D);
          if (((Boolean)Dj.this.notes.get("Notas")).booleanValue()) {
            ParticleEffect.NOTE.display(0.0F, 0.0F, 0.0F, 3.0F, 1, loc, 25.0D);
          }
        }
        this.j += 0.2F;
        if (this.j > 50.0F) {
          this.j = 0.0F;
        }
      }
    }, 1L, 1L).getTaskId();
    
    Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
    {
      public void run()
      {
        Bukkit.getScheduler().cancelTask(Dj.this.task1);
        Bukkit.getScheduler().cancelTask(Dj.this.task2);
        Bukkit.getScheduler().cancelTask(Dj.this.task3);
        Bukkit.getScheduler().cancelTask(Dj.this.task4);
        Bukkit.getScheduler().cancelTask(Dj.this.task5);
        Bukkit.getScheduler().cancelTask(Dj.this.task6);
        Bukkit.getScheduler().cancelTask(Dj.this.rt);
        try
        {
          destroy();
          a.remove();
          
        }
        catch (Exception ex)
        {
          throw new GadgetException("[DJ] Impossível desabilitar eventos do Dj!");
        }
      }
    }, 800L);
  }
  
  @EventHandler
  public void paramPlayerUseDj(PlayerInteractEvent paramPlayerUseDjEvent)
  {
    Player paramPlayer = paramPlayerUseDjEvent.getPlayer();
    Action paramAction = paramPlayerUseDjEvent.getAction();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().DjGadgetName))
    {
      if (this.plugin.getUtilBlock().usable(paramPlayerUseDjEvent.getClickedBlock())) {
        return;
      }
      if (UtilCooldown.tryCooldown(paramPlayer, "Dj", this.plugin.getConfigFile().DjCooldown))
      {
        summonArmorStand(paramPlayer.getLocation().add(0.5, 0, 0.5), paramPlayer);
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "Dj") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Dj", "Dj", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
        Util18.sendTitle(paramPlayer, 
        plugin.getMessagesFile().titleMessage,
        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
      }
    }
  }
  
  @EventHandler
  public void onInteract(PlayerInteractAtEntityEvent e)
  {
    if ((e.getRightClicked() instanceof ArmorStand))
    {
      ArmorStand stand = (ArmorStand)e.getRightClicked();
      if (this.armor.contains(stand)) {
        for (Player p : this.dj) {
          if (e.getPlayer() == p)
          {
            e.setCancelled(true);
            this.DjMenu.showMenu(e.getPlayer());
          }
        }
      }
    }
  }
  
  @EventHandler
  public void handleInventory(InventoryClickEvent e) {
	   if(e.getWhoClicked() instanceof Player && e.getInventory().getName().equals(ChatColor.RED + "§lDj")) {
		  int slot = e.getSlot();
		  e.setCancelled(true);
		  e.setResult(Result.DENY);
		  Player p = (Player) e.getWhoClicked();
		  ArmorStand a = (ArmorStand)dj;
	      if (slot == 1) {
	          if (dropDiscs.get(a.getUniqueId()) == false) {
	            dropDiscs.put(a.getUniqueId(), true);
	          }else {
	            dropDiscs.put(a.getUniqueId(), false);
	          }
	        }
	        if (slot == 2) {
		          if (notes.get(a.getUniqueId()) == false) {
		        	notes.put(a.getUniqueId(), true);
			    }else {
			     notes.put(a.getUniqueId(), false);
			   }
			}
	        if (slot == 4) {
		          if (discoBall.get("DiscoBall") == false) {
		        	discoBall.put("DiscoBall", true);
			    }else {
			     discoBall.put("DiscoBall", false);
			   }
			}
	        if(slot == 6) {
	      	  p.closeInventory();
	      	  showMusicMenu(p);
	        }
	        if(slot == 8) {
	        	a.remove();
	        	dj.remove(a);
	        }
	     }
	    if((e.getWhoClicked() instanceof Player) && e.getInventory().getName().equals("§7Músicas")) {
	        int s = e.getSlot();
	        Player p = (Player)e.getWhoClicked();
	        p.closeInventory();
	        if(s == 2) {
	         play((Player[])p.getWorld().getPlayers().toArray(new Player[0]), song1);
	         songType.put(p.getUniqueId(), "DubStep");
	      }
	        if(s == 3) {
	       	 play((Player[])p.getWorld().getPlayers().toArray(new Player[0]), song2);
	       	songType.put(p.getUniqueId(), "Popcorn");
	        }
	        if(s == 4) {
	       	 play((Player[])p.getWorld().getPlayers().toArray(new Player[0]), song3);
	       	songType.put(p.getUniqueId(), "Imagine");
	        }
	        if(s == 5) {
	       	 play((Player[])p.getWorld().getPlayers().toArray(new Player[0]), song4);
	       	songType.put(p.getUniqueId(), "Sweden");
	        }
	        if(s == 6) {
	           play((Player[])p.getWorld().getPlayers().toArray(new Player[0]), song5);
	           songType.put(p.getUniqueId(), "Nyancat");
	        }
	     }
	 }
  
  @EventHandler
  public void onDamage(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof ArmorStand))
    {
      ArmorStand entity = (ArmorStand)e.getEntity();
      if (this.armor.contains(entity)) {
        e.setCancelled(true);
      }
    }
  }

}
