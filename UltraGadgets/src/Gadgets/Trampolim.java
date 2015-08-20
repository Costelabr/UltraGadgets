package Gadgets;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

import Core.Util18;
import Core.UtilCooldown;

import com.floodeer.gadgets.UltraGadgets;

public class Trampolim
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
  public static HashMap<Player, ArrayList<Block>> _tBlocks = new HashMap<>();
  ArrayList<Player> arrayPlayer = new ArrayList<>();
  ArrayList<Player> paramPlayerArray = new ArrayList<>();
  public static final ArrayList<Block> localArrayList = new ArrayList<>();
  
  public Block gb(Location paramLocation)
  {
    return Bukkit.getWorld(paramLocation.getWorld().getName()).getBlockAt(paramLocation);
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void Activate(PlayerInteractEvent paramPlayerInteractEvent)
  {
    final Player localPlayer = paramPlayerInteractEvent.getPlayer();
    if ((paramPlayerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR) && (paramPlayerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = localPlayer.getItemInHand();
    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().TrampolimName))
    {
      if (this.plugin.getUtilBlock().usable(paramPlayerInteractEvent.getClickedBlock())) {
        return;
      }
      if (_tBlocks.containsKey(localPlayer))
      {
        localPlayer.sendMessage(this.plugin.getMensagensConfig().getString("Em-Trampolim").replaceAll("&", "§"));
        return;
      }
      paramPlayerInteractEvent.setCancelled(true);
      if (UtilCooldown.tryCooldown(localPlayer, "Trampolim", this.plugin.getConfigFile().TrampolimCooldown))
      {
        this.arrayPlayer.add(localPlayer);
        this.paramPlayerArray.add(localPlayer);
        Block localBlock1 = gb(localPlayer.getLocation());
        Block localBlock2 = gb(localPlayer.getLocation().add(1.0D, 0.0D, 0.0D));
        Block localBlock3 = gb(localPlayer.getLocation().add(2.0D, 0.0D, 0.0D));
        Block localBlock4 = gb(localPlayer.getLocation().add(0.0D, 0.0D, 1.0D));
        Block localBlock5 = gb(localPlayer.getLocation().add(0.0D, 0.0D, 2.0D));
        Block localBlock6 = gb(localPlayer.getLocation().add(-1.0D, 0.0D, 0.0D));
        Block localBlock7 = gb(localPlayer.getLocation().add(-2.0D, 0.0D, 0.0D));
        Block localBlock8 = gb(localPlayer.getLocation().add(0.0D, 0.0D, -1.0D));
        Block localBlock9 = gb(localPlayer.getLocation().add(0.0D, 0.0D, -2.0D));
        Block localBlock10 = gb(localPlayer.getLocation().add(-1.0D, 0.0D, -1.0D));
        Block localBlock11 = gb(localPlayer.getLocation().add(-2.0D, 0.0D, -2.0D));
        Block localBlock12 = gb(localPlayer.getLocation().add(1.0D, 0.0D, 1.0D));
        Block localBlock13 = gb(localPlayer.getLocation().add(2.0D, 0.0D, 2.0D));
        Block localBlock14 = gb(localPlayer.getLocation().add(1.0D, 0.0D, -1.0D));
        Block localBlock15 = gb(localPlayer.getLocation().add(2.0D, 0.0D, -2.0D));
        Block localBlock16 = gb(localPlayer.getLocation().add(-1.0D, 0.0D, 1.0D));
        Block localBlock17 = gb(localPlayer.getLocation().add(-2.0D, 0.0D, 2.0D));
        Block localBlock18 = gb(localPlayer.getLocation().add(-2.0D, 0.0D, 1.0D));
        Block localBlock19 = gb(localPlayer.getLocation().add(-2.0D, 0.0D, -1.0D));
        Block localBlock20 = gb(localPlayer.getLocation().add(2.0D, 0.0D, 1.0D));
        Block localBlock21 = gb(localPlayer.getLocation().add(2.0D, 0.0D, -1.0D));
        Block localBlock22 = gb(localPlayer.getLocation().add(-1.0D, 0.0D, 2.0D));
        Block localBlock23 = gb(localPlayer.getLocation().add(1.0D, 0.0D, 2.0D));
        Block localBlock24 = gb(localPlayer.getLocation().add(-1.0D, 0.0D, -2.0D));
        Block localBlock25 = gb(localPlayer.getLocation().add(1.0D, 0.0D, -2.0D));
        
        Block localBlock26 = gb(localPlayer.getLocation().add(0.0D, 1.0D, 0.0D));
        Block localBlock27 = gb(localPlayer.getLocation().add(1.0D, 1.0D, 0.0D));
        Block localBlock28 = gb(localPlayer.getLocation().add(2.0D, 1.0D, 0.0D));
        Block localBlock29 = gb(localPlayer.getLocation().add(0.0D, 1.0D, 1.0D));
        Block localBlock30 = gb(localPlayer.getLocation().add(0.0D, 1.0D, 2.0D));
        Block localBlock31 = gb(localPlayer.getLocation().add(-1.0D, 1.0D, 0.0D));
        Block localBlock32 = gb(localPlayer.getLocation().add(-2.0D, 1.0D, 0.0D));
        Block localBlock33 = gb(localPlayer.getLocation().add(0.0D, 1.0D, -1.0D));
        Block localBlock34 = gb(localPlayer.getLocation().add(0.0D, 1.0D, -2.0D));
        Block localBlock35 = gb(localPlayer.getLocation().add(-1.0D, 1.0D, -1.0D));
        Block localBlock36 = gb(localPlayer.getLocation().add(-2.0D, 1.0D, -2.0D));
        Block localBlock37 = gb(localPlayer.getLocation().add(1.0D, 1.0D, 1.0D));
        Block localBlock38 = gb(localPlayer.getLocation().add(2.0D, 1.0D, 2.0D));
        Block localBlock39 = gb(localPlayer.getLocation().add(1.0D, 1.0D, -1.0D));
        Block localBlock40 = gb(localPlayer.getLocation().add(2.0D, 1.0D, -2.0D));
        Block localBlock41 = gb(localPlayer.getLocation().add(-1.0D, 1.0D, 1.0D));
        Block localBlock42 = gb(localPlayer.getLocation().add(-2.0D, 1.0D, 2.0D));
        Block localBlock43 = gb(localPlayer.getLocation().add(-2.0D, 1.0D, 1.0D));
        Block localBlock44 = gb(localPlayer.getLocation().add(-2.0D, 1.0D, -1.0D));
        Block localBlock45 = gb(localPlayer.getLocation().add(2.0D, 1.0D, 1.0D));
        Block localBlock46 = gb(localPlayer.getLocation().add(2.0D, 1.0D, -1.0D));
        Block localBlock47 = gb(localPlayer.getLocation().add(-1.0D, 1.0D, 2.0D));
        Block localBlock48 = gb(localPlayer.getLocation().add(1.0D, 1.0D, 2.0D));
        Block localBlock49 = gb(localPlayer.getLocation().add(-1.0D, 1.0D, -2.0D));
        Block localBlock50 = gb(localPlayer.getLocation().add(1.0D, 1.0D, -2.0D));
        
        final Block localBlock51 = gb(localPlayer.getLocation().add(3.0D, 0.0D, 0.0D));
        final Block localBlock52 = gb(localPlayer.getLocation().add(3.0D, 1.0D, 0.0D));
        if ((localBlock1.getType() != Material.AIR) && 
          (localBlock2.getType() != Material.AIR) && 
          (localBlock3.getType() != Material.AIR) && 
          (localBlock4.getType() != Material.AIR) && 
          (localBlock5.getType() != Material.AIR) && 
          (localBlock6.getType() != Material.AIR) && 
          (localBlock7.getType() != Material.AIR) && 
          (localBlock8.getType() != Material.AIR) && 
          (localBlock9.getType() != Material.AIR) && 
          (localBlock10.getType() != Material.AIR) && 
          (localBlock11.getType() != Material.AIR) && 
          (localBlock12.getType() != Material.AIR) && 
          (localBlock13.getType() != Material.AIR) && 
          (localBlock14.getType() != Material.AIR) && 
          (localBlock15.getType() != Material.AIR) && 
          (localBlock16.getType() != Material.AIR) && 
          (localBlock17.getType() != Material.AIR) && 
          (localBlock18.getType() != Material.AIR) && 
          (localBlock19.getType() != Material.AIR) && 
          (localBlock20.getType() != Material.AIR) && 
          (localBlock21.getType() != Material.AIR) && 
          (localBlock22.getType() != Material.AIR) && 
          (localBlock23.getType() != Material.AIR) && 
          (localBlock24.getType() != Material.AIR) && 
          (localBlock25.getType() != Material.AIR) && 
          (localBlock26.getType() != Material.AIR) && 
          (localBlock27.getType() != Material.AIR) && 
          (localBlock28.getType() != Material.AIR) && 
          (localBlock29.getType() != Material.AIR) && 
          (localBlock30.getType() != Material.AIR) && 
          (localBlock31.getType() != Material.AIR) && 
          (localBlock32.getType() != Material.AIR) && 
          (localBlock33.getType() != Material.AIR) && 
          (localBlock34.getType() != Material.AIR) && 
          (localBlock35.getType() != Material.AIR) && 
          (localBlock36.getType() != Material.AIR) && 
          (localBlock37.getType() != Material.AIR) && 
          (localBlock38.getType() != Material.AIR) && 
          (localBlock39.getType() != Material.AIR) && 
          (localBlock40.getType() != Material.AIR) && 
          (localBlock41.getType() != Material.AIR) && 
          (localBlock42.getType() != Material.AIR) && 
          (localBlock43.getType() != Material.AIR) && 
          (localBlock44.getType() != Material.AIR) && 
          (localBlock45.getType() != Material.AIR) && 
          (localBlock46.getType() != Material.AIR) && 
          (localBlock47.getType() != Material.AIR) && 
          (localBlock48.getType() != Material.AIR) && 
          (localBlock49.getType() != Material.AIR) && 
          (localBlock50.getType() != Material.AIR) && 
          (localBlock51.getType() != Material.AIR) && 
          (localBlock52.getType() != Material.AIR))
        {
          localPlayer.sendMessage(this.plugin.getMensagensConfig().getString("Area-Pequena").replaceAll("&", "§"));
          UtilCooldown.setCooldown(paramPlayerInteractEvent.getPlayer(), "Trampolim", 0L);
          return;
        }
        if (!localPlayer.isOnGround())
        {
          localPlayer.sendMessage(this.plugin.getMensagensConfig().getString("On-Ground-Trampolim").replaceAll("&", "§"));
          UtilCooldown.setCooldown(paramPlayerInteractEvent.getPlayer(), "Trampolim", 0L);
          return;
        }
        localArrayList.add(localBlock1);
        localArrayList.add(localBlock2);
        localArrayList.add(localBlock3);
        localArrayList.add(localBlock4);
        localArrayList.add(localBlock5);
        localArrayList.add(localBlock6);
        localArrayList.add(localBlock7);
        localArrayList.add(localBlock8);
        localArrayList.add(localBlock9);
        localArrayList.add(localBlock10);
        localArrayList.add(localBlock11);
        localArrayList.add(localBlock12);
        localArrayList.add(localBlock13);
        localArrayList.add(localBlock14);
        localArrayList.add(localBlock15);
        localArrayList.add(localBlock16);
        localArrayList.add(localBlock17);
        localArrayList.add(localBlock18);
        localArrayList.add(localBlock19);
        localArrayList.add(localBlock20);
        localArrayList.add(localBlock21);
        localArrayList.add(localBlock22);
        localArrayList.add(localBlock23);
        localArrayList.add(localBlock24);
        localArrayList.add(localBlock25);
        localArrayList.add(localBlock26);
        localArrayList.add(localBlock27);
        localArrayList.add(localBlock28);
        localArrayList.add(localBlock29);
        localArrayList.add(localBlock30);
        localArrayList.add(localBlock31);
        localArrayList.add(localBlock32);
        localArrayList.add(localBlock33);
        localArrayList.add(localBlock34);
        localArrayList.add(localBlock35);
        localArrayList.add(localBlock36);
        localArrayList.add(localBlock37);
        localArrayList.add(localBlock38);
        localArrayList.add(localBlock39);
        localArrayList.add(localBlock40);
        localArrayList.add(localBlock41);
        localArrayList.add(localBlock42);
        localArrayList.add(localBlock43);
        localArrayList.add(localBlock44);
        localArrayList.add(localBlock45);
        localArrayList.add(localBlock46);
        localArrayList.add(localBlock47);
        localArrayList.add(localBlock48);
        localArrayList.add(localBlock49);
        localArrayList.add(localBlock50);
        localArrayList.add(localBlock51);
        localArrayList.add(localBlock52);
        
        localBlock1.setMetadata("Fix1", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock2.setMetadata("Fix2", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock3.setMetadata("Fix3", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock4.setMetadata("Fix4", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock5.setMetadata("Fix5", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock6.setMetadata("Fix6", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock7.setMetadata("Fix7", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock8.setMetadata("Fix8", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock9.setMetadata("Fix9", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock10.setMetadata("Fix10", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock11.setMetadata("Fix11", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock12.setMetadata("Fix12", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock13.setMetadata("Fix13", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock14.setMetadata("Fix14", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock15.setMetadata("Fix15", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock16.setMetadata("Fix16", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock17.setMetadata("Fix17", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock18.setMetadata("Fix18", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock19.setMetadata("Fix19", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock20.setMetadata("Fix20", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock21.setMetadata("Fix21", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock22.setMetadata("Fix22", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock23.setMetadata("Fix23", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock24.setMetadata("Fix24", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock25.setMetadata("Fix25", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock26.setMetadata("Fix26", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock27.setMetadata("Fix27", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock28.setMetadata("Fix28", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock29.setMetadata("Fix29", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock30.setMetadata("Fix30", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock31.setMetadata("Fix31", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock32.setMetadata("Fix32", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock33.setMetadata("Fix33", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock34.setMetadata("Fix34", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock35.setMetadata("Fix35", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock36.setMetadata("Fix36", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock37.setMetadata("Fix37", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock38.setMetadata("Fix38", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock39.setMetadata("Fix39", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock40.setMetadata("Fix40", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock41.setMetadata("Fix41", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock42.setMetadata("Fix42", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock43.setMetadata("Fix43", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock44.setMetadata("Fix44", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock45.setMetadata("Fix45", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock46.setMetadata("Fix46", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock47.setMetadata("Fix47", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock48.setMetadata("Fix48", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock49.setMetadata("Fix49", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock50.setMetadata("Fix50", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock51.setMetadata("Fix51", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        localBlock52.setMetadata("Fix52", new FixedMetadataValue(this.plugin, "paramUltraGadgetsMetas"));
        
        localBlock3.setType(Material.WOOL);
        localBlock3.setData((byte)11);
        localBlock11.setType(Material.FENCE);
        localBlock13.setType(Material.FENCE);
        localBlock15.setType(Material.FENCE);
        localBlock17.setType(Material.FENCE);
        localBlock26.setType(Material.WOOL);
        localBlock26.setData((byte)15);
        localBlock27.setType(Material.WOOL);
        localBlock27.setData((byte)15);
        localBlock28.setType(Material.WOOL);
        localBlock28.setData((byte)11);
        localBlock29.setType(Material.WOOL);
        localBlock29.setData((byte)15);
        localBlock30.setType(Material.WOOL);
        localBlock30.setData((byte)11);
        localBlock31.setType(Material.WOOL);
        localBlock31.setData((byte)15);
        localBlock32.setType(Material.WOOL);
        localBlock32.setData((byte)11);
        localBlock33.setType(Material.WOOL);
        localBlock33.setData((byte)15);
        localBlock34.setType(Material.WOOL);
        localBlock34.setData((byte)11);
        localBlock35.setType(Material.WOOL);
        localBlock35.setData((byte)15);
        localBlock36.setType(Material.WOOL);
        localBlock36.setData((byte)11);
        localBlock37.setType(Material.WOOL);
        localBlock37.setData((byte)15);
        localBlock38.setType(Material.WOOL);
        localBlock38.setData((byte)11);
        localBlock39.setType(Material.WOOL);
        localBlock39.setData((byte)15);
        localBlock40.setType(Material.WOOL);
        localBlock40.setData((byte)11);
        localBlock41.setType(Material.WOOL);
        localBlock41.setData((byte)15);
        localBlock42.setType(Material.WOOL);
        localBlock42.setData((byte)11);
        localBlock43.setType(Material.WOOL);
        localBlock43.setData((byte)11);
        localBlock44.setType(Material.WOOL);
        localBlock44.setData((byte)11);
        localBlock45.setType(Material.WOOL);
        localBlock45.setData((byte)11);
        localBlock46.setType(Material.WOOL);
        localBlock46.setData((byte)11);
        localBlock47.setType(Material.WOOL);
        localBlock47.setData((byte)11);
        localBlock48.setType(Material.WOOL);
        localBlock48.setData((byte)11);
        localBlock49.setType(Material.WOOL);
        localBlock49.setData((byte)11);
        localBlock50.setType(Material.WOOL);
        localBlock50.setData((byte)11);
        localBlock51.setType(Material.LADDER);
        localBlock51.setData(new Byte((byte)5).byteValue());
        localBlock52.setType(Material.LADDER);
        localBlock52.setData(new Byte((byte)5).byteValue());
        localPlayer.teleport(new Location(localPlayer.getWorld(), localPlayer.getLocation().getX(), localPlayer.getLocation().getY() + 100.0D, localPlayer.getLocation().getZ(), 90.0F, 180.0F));
        localPlayer.setVelocity(new Vector(0.0D, -10.0D, 0.0D));
        for (Entity localEntity : localPlayer.getNearbyEntities(3.0D, 3.0D, 3.0D)) {
          try
          {
            localEntity.teleport(new Location(localPlayer.getWorld(), localPlayer.getLocation().getX(), localPlayer.getLocation().getY() + 100.0D, localPlayer.getLocation().getZ(), 90.0F, 180.0F));
            localEntity.setVelocity(new Vector(0.0D, -10.0D, 0.0D));
          }
          catch (Exception localException) {}
        }
        _tBlocks.put(localPlayer, localArrayList);
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            localBlock51.setType(Material.AIR);
            localBlock52.setType(Material.AIR);
            for (Block localBlock : Trampolim.localArrayList) {
              if ((localBlock != localBlock51) && (localBlock != localBlock52) && (localBlock.getType() != Material.AIR))
              {
                localBlock.getWorld().playEffect(localBlock.getLocation(), Effect.STEP_SOUND, localBlock.getTypeId());
                localBlock.setType(Material.AIR);
              }
            }
            Trampolim.localArrayList.clear();
            Trampolim.this.arrayPlayer.remove(localPlayer);
            Trampolim._tBlocks.clear();
          }
        }, 500L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
        {
          public void run()
          {
            Trampolim.this.paramPlayerArray.clear();
          }
        }, 600L);
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(localPlayer, "Trampolim") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(localPlayer, "Trampolim", "Trampolim", cooldown);
        localPlayer.playSound(localPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
        Util18.sendTitle(localPlayer, 
        plugin.getMessagesFile().titleMessage,
        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(localPlayer)), 
        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
      }
    }
  }
  
  @SuppressWarnings("rawtypes")
@EventHandler
  public void onPlace(BlockPlaceEvent paramBlockPlaceEvent)
  {
    Player localPlayer = paramBlockPlaceEvent.getPlayer();
    if (!_tBlocks.containsKey(localPlayer)) {
      return;
    }
    if (((ArrayList)_tBlocks.get(localPlayer)).contains(paramBlockPlaceEvent.getBlock()))
    {
      paramBlockPlaceEvent.setCancelled(true);
      localPlayer.sendMessage(this.plugin.getMensagensConfig().getString("Quebrar-Trampolim-MetaData").replaceAll("&", "§"));
    }
    ItemStack toBlock = paramBlockPlaceEvent.getItemInHand();
    if (this.plugin.getItem().isGadgetItem(toBlock, this.plugin.getMessagesFile().TrampolimName))
    {
      paramBlockPlaceEvent.setBuild(false);
      paramBlockPlaceEvent.setCancelled(true);
    }
  }
  
  @SuppressWarnings({ "rawtypes", "deprecation" })
@EventHandler
  public void move(PlayerMoveEvent e)
  {
    Player localPlayer = e.getPlayer();
    Block localBlock = localPlayer.getWorld().getBlockAt(localPlayer.getLocation().add(0.0D, -1.0D, 0.0D));
    if ((localBlock.getType() == Material.WOOL) && (localBlock.getData() == new Byte((byte)15).byteValue())) {
      for (ArrayList localArrayList : _tBlocks.values()) {
        if (localArrayList.contains(localBlock))
        {
          localPlayer.setVelocity(new Vector(0.0D, 3.0D, 0.0D));
          this.paramPlayerArray.add(localPlayer);
        }
      }
    }
  }
  
  @SuppressWarnings("rawtypes")
@EventHandler
  public void onBreak(BlockBreakEvent paramBlockBreakEvent)
  {
    Player localPlayer = paramBlockBreakEvent.getPlayer();
    if (!_tBlocks.containsKey(localPlayer)) {
      return;
    }
    if (((ArrayList)_tBlocks.get(localPlayer)).contains(paramBlockBreakEvent.getBlock()))
    {
      paramBlockBreakEvent.setCancelled(true);
      localPlayer.sendMessage(this.plugin.getMensagensConfig().getString("Quebrar-Trampolim-MetaData").replaceAll("&", "§"));
    }
  }
  
  @EventHandler
  public void onDamage(EntityDamageEvent e)
  {
    if (((e.getEntity() instanceof Player)) && (e.getCause() == EntityDamageEvent.DamageCause.FALL))
    {
      Player p = (Player)e.getEntity();
      if (this.paramPlayerArray.contains(p)) {
        e.setCancelled(true);
      }
    }
  }
}