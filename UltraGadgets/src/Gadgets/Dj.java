package Gadgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldEvent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
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
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import Core.UtilBallEffect;
import Core.UtilMenu;
import Core.ParticleEffect;
import Core.Util18;
import Core.UtilCooldown;
import Exception.GadgetException;

import com.floodeer.gadgets.Main;

public class Dj
  implements Listener
{
  public final ArrayList<Player> dj;
  Main plugin;
  int task1;
  int task2;
  int task3;
  int task4;
  int task5;
  int task6;
  int rt;
  public final Map<Player, String> _ativado;
  public final Map<String, Boolean> dropDiscs;
  public final Map<String, Boolean> notes;
  public static final Map<String, Boolean> discoBall = new HashMap<>();
  public final List<Entity> armor;
  UtilMenu DjMenu;
  Map<Location, Block> blockToRemove = new HashMap<>();
  List<Location> l = new ArrayList<Location>();
  
  public Dj()
  {
    this.dj = new ArrayList<>();
    this.plugin = Main.getMain();
    
    this._ativado = new HashMap<>();
    
    this.dropDiscs = new HashMap<>();
    this.notes = new HashMap<>();
    
    this.armor = new ArrayList<>();
    
    this.DjMenu = new UtilMenu(this.plugin, ChatColor.RED + "�lDj", 1);
    
    this.DjMenu.setItem(0, this.plugin.getItemStack().newItemStack(Material.RECORD_10, "Dropar Discos", Arrays.asList(new String[] { "�7Ativar/Desativar o drop de discos" }), 1, (byte)0));
    
    this.DjMenu.setItem(2, this.plugin.getItemStack().newItemStack(Material.JUKEBOX, "Notas de M�sica", Arrays.asList(new String[] { "�7Ativar/Desativar as notas" }), 1, (byte)0));
    
    this.DjMenu.setItem(4, this.plugin.getItemStack().newItemStack(Material.REDSTONE_COMPARATOR, "Disco-Ball", Arrays.asList(new String[] { "�7Ativar/Desativar Disco-Ball efeito" }), 1, (byte)0));
  }
  
  @SuppressWarnings("deprecation")
private void playRecord(Player p, Location loc, Material record)
  {
    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldEvent(1005, new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()), record.getId(), false));
  }
  
  private void stopRecord(Player p, Location loc)
  {
    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldEvent(1005, new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()), 0, false));
  }
  
  private String layers(int y, int layloc){
		
	    String[] layer1 = {
	            "STONE_SLAB2", "STONE_SLAB2", "REDSTONE_LAMP_ON",
	            "STONE_SLAB2", "STONE_SLAB2", "JUKEBOX",
	            "STONE_SLAB2", "STONE_SLAB2", "REDSTONE_LAMP_ON"
	    };

	    String[] layer2 = {
	            "AIR", "AIR", "DAYLIGHT_DETECTOR",
	            "AIR", "AIR", "AIR",
	            "AIR", "AIR", "DAYLIGHT_DETECTOR"
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
                  l.add(block);
                  layloc++;
              }
          }                     
      }
  }
  
  @SuppressWarnings("deprecation")
private void destroy() {
	  for(Location locals : l) {
          locals.getWorld().playEffect(locals, Effect.STEP_SOUND, locals.getBlock().getTypeId());
		  blockToRemove.get(locals).setType(Material.AIR);
          this.dropDiscs.remove("Discos");
          this.notes.remove("Notas");
	  }  
  }
  
  private final ItemStack boots()
  {
    try
    {
      ItemStack i = new ItemStack(Material.DIAMOND_BOOTS);
      ItemMeta data = i.getItemMeta();
      data.addEnchant(Enchantment.LUCK, 10, true);
      i.setItemMeta(data);
      return i;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  private final ItemStack legg()
  {
    try
    {
      ItemStack i = new ItemStack(Material.DIAMOND_LEGGINGS);
      ItemMeta data = i.getItemMeta();
      data.addEnchant(Enchantment.LUCK, 10, true);
      i.setItemMeta(data);
      return i;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  private final ItemStack chestplate()
  {
    try
    {
      ItemStack i = new ItemStack(Material.DIAMOND_CHESTPLATE);
      ItemMeta data = i.getItemMeta();
      data.addEnchant(Enchantment.LUCK, 10, true);
      i.setItemMeta(data);
      return i;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  private final ItemStack skull(Player p)
  {
    try
    {
      ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
      SkullMeta meta = (SkullMeta)skull.getItemMeta();
      meta.setOwner(p.getName());
      meta.setDisplayName(p.getName());
      skull.setItemMeta(meta);
      return skull;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  
  public void summonArmorStand(Location l, final Player p)
  {
    final ArmorStand a = (ArmorStand)l.getWorld().spawn(l, ArmorStand.class);
    playRecord(p, a.getLocation(), Material.RECORD_7);
    
    a.setArms(true);
    a.setBasePlate(true);
    a.setCustomNameVisible(true);
    p.teleport(p.getLocation().add(0.5D, 0.0D, 0.5D));
    a.setBoots(boots());
    a.setLeggings(legg());
    a.setChestplate(chestplate());
    a.setHelmet(skull(p));
    
    a.setCustomName("�c�lDj �e�l" + p.getName());
    startBuilder(a);
    this.armor.add(a);
    this.dropDiscs.put("Discos", Boolean.valueOf(true));
    this.notes.put("Notas", Boolean.valueOf(true));
    discoBall.put("DiscoBall", Boolean.valueOf(true));
    this.dj.add(p);
    UtilBallEffect newAbf = new UtilBallEffect();
    newAbf.startDisco(a.getLocation().add(0.0D, 12.0D, 0.0D), 40);
    a.teleport(a.getLocation().add(0, 1.0, 0));
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
          stopRecord(p, a.getLocation());
          a.remove();
        }
        catch (Exception ex)
        {
          throw new GadgetException("[DJ] Imposs�vel desabilitar eventos do Dj!");
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
  public void onClickInParticlesMenu(InventoryClickEvent e)
  {
    if ((e.getInventory().getName().equalsIgnoreCase("�c�lDj")) && ((e.getWhoClicked() instanceof Player)))
    {
      e.setCancelled(true);
      e.setResult(Result.DENY);
      e.getWhoClicked().closeInventory();
      int slot = e.getSlot();
      if (slot == 0) {
        if (!((Boolean)this.dropDiscs.get("Discos")).booleanValue()) {
          this.dropDiscs.put("Discos", Boolean.valueOf(true));
        } else {
          this.dropDiscs.put("Discos", Boolean.valueOf(false));
        }
      }
      if (slot == 2) {
        if (!((Boolean)this.notes.get("Notas")).booleanValue()) {
          this.notes.put("Notas", Boolean.valueOf(true));
        } else {
          this.notes.put("Notas", Boolean.valueOf(false));
        }
      }
      if (slot == 4) {
        if (!((Boolean)discoBall.get("DiscoBall")).booleanValue()) {
          discoBall.put("DiscoBall", Boolean.valueOf(true));
        } else {
          discoBall.put("DiscoBall", Boolean.valueOf(false));
        }
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
