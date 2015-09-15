package Gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import Update.SchedulerEvent;
import Update.SchedulerType;
import Utils.Direction;
import Utils.UtilCooldown;
import Utils.UtilMath;
import Utils.UtilTitles;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class Trampolim
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
  HashMap<Player, ArrayList<Block>> _tBlocks = new HashMap<>();
  public final Map<Player, List<Block>> playerBlocks = new HashMap<>();
  public final Map<Player, Location> playerTrampoline = new HashMap<>();
  public static final ArrayList<Block> localArrayList = new ArrayList<>();
  public static final char[] schematic = { 
   'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 
   'B', 'B', 'B', 'B', 'B', 
   'A', 'A', 
   'B','B', 'B', 'B', 'B', 
   'A', 'A', 
   'B', 'B', 'B', 'B', 'B', 
   'A', 'A', 
   'B', 'B', 'B', 'B', 'B', 
   'A', 'A', 
   'B', 'B', 'B', 'B', 'B', 
   'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' };
  
  @SuppressWarnings("deprecation")
public void buildTrampolim(Player player) {
	  Location playerLocation = player.getLocation();
	  Direction direction = Direction.getCardinalDirection(player);
      Location corner = playerLocation.clone().add(-4.0D, 1.0D, -4.0D);
      Location line = corner.clone();
      Location location = corner.clone();
      List<Block> blocks = new ArrayList<Block>();
      for (int i = 0; i < schematic.length; i++)
      {
        if (i % 7 == 0) {
          location = line.add(1.0D, 0.0D, 0.0D).clone();
        }
        location.add(0.0D, 0.0D, 1.0D);
        if (i == 24) {
          this.playerTrampoline.put(player, location.clone().add(0.0D, 1.0D, 0.0D));
        }
        char type = schematic[i];
        Block block = location.getBlock();
        block.setType(Material.WOOL);
        block.setData(type == 'A' ? DyeColor.BLUE.getWoolData() : DyeColor.BLACK.getWoolData());
        blocks.add(block);
      }
      Location blockLocation = playerLocation.clone().add(0.0D, 1.0D, 0.0D);
      Block firstStair = blockLocation.add(direction == Direction.SOUTH ? -5 : direction == Direction.NORTH ? 5 : 0, -1.0D, direction == Direction.WEST ? -5 : direction == Direction.EAST ? 5 : 0).getBlock();
      Block secondStair = blockLocation.add(direction == Direction.SOUTH ? 1 : direction == Direction.NORTH ? -1 : 0, 1.0D, direction == Direction.WEST ? 1 : direction == Direction.EAST ? -1 : 0).getBlock();
      firstStair.setType(Material.WOOD_STAIRS);
      firstStair.setData((byte)(direction == Direction.WEST ? 2 : direction == Direction.EAST ? 3 : direction == Direction.NORTH ? 1 : 0));
      secondStair.setType(Material.WOOD_STAIRS);
      secondStair.setData((byte)(direction == Direction.WEST ? 2 : direction == Direction.EAST ? 3 : direction == Direction.NORTH ? 1 : 0));
      blocks.add(firstStair);
      blocks.add(secondStair);
      player.teleport(playerLocation.add(0.0D, 2.0D, 0.0D));
      this.playerBlocks.put(player, blocks);
  }
  
@SuppressWarnings("deprecation")
public void breakTrampolim(Player player) {
	List<Block> blocks = playerBlocks.remove(player);
		if (blocks != null) {
		  for (Block block : blocks) {
			player.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, block.getTypeId());
		   block.setType(Material.AIR);
		}
	}
  }
  
@EventHandler
  public void playerInteractWithTrampolim(PlayerInteractEvent paramPlayerInteractEvent)
  {
    final Player localPlayer = paramPlayerInteractEvent.getPlayer();
    if ((paramPlayerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR) && (paramPlayerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = localPlayer.getItemInHand();
    if (plugin.getItem().isGadgetItem(paramItem, plugin.getMessagesFile().TrampolimName)) {
      if (plugin.getUtilBlock().usable(paramPlayerInteractEvent.getClickedBlock())) {
        return;
      }
      if (_tBlocks.containsKey(localPlayer))
      {
        localPlayer.sendMessage(plugin.getMensagensConfig().getString("Em-Trampolim").replaceAll("&", "§"));
        return;
      }
      if (!plugin.getUtilLocation().checkEmptyArea(localPlayer.getLocation().clone().add(-5.0D, 0.0D, -5.0D), localPlayer.getLocation().clone().add(5.0D, 1.0D, 5.0D))) {
    	  localPlayer.sendMessage("§cVocê precisa de uma área maior para spawnar um Tramplim!");
    	  return;
      }
      paramPlayerInteractEvent.setCancelled(true);
      if (UtilCooldown.tryCooldown(localPlayer, "Trampolim", plugin.getConfigFile().TrampolimCooldown))
      {
         buildTrampolim(localPlayer);
         Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
			
			@Override
			public void run() {
				breakTrampolim(localPlayer);
				
			}
		}, 35*20L);
      }else{
    	long cooldown = UtilCooldown.getCooldown(localPlayer, "Trampolim") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(localPlayer, "Trampolim", "Trampolim", cooldown);
        localPlayer.playSound(localPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
        UtilTitles.sendCooldownTitle(localPlayer, 
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
      localPlayer.sendMessage(plugin.getMensagensConfig().getString("Quebrar-Trampolim-MetaData").replaceAll("&", "§"));
    }
    ItemStack toBlock = paramBlockPlaceEvent.getItemInHand();
    if (plugin.getItem().isGadgetItem(toBlock, plugin.getMessagesFile().TrampolimName))
    {
      paramBlockPlaceEvent.setBuild(false);
      paramBlockPlaceEvent.setCancelled(true);
    }
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void update(SchedulerEvent e) {
	  if(e.getType() == SchedulerType.TICK) {
		  for(Player localPlayer : Bukkit.getOnlinePlayers()) {
		    Block localBlock = localPlayer.getWorld().getBlockAt(localPlayer.getLocation().add(0.0D, -1.0D, 0.0D));
		    if ((localBlock.getType() == Material.WOOL) && (localBlock.getData() == new Byte((byte)15).byteValue())) {
		          localPlayer.setVelocity(new Vector(0.0D, UtilMath.randomRange(1.8, 3.2), 0.0D));
		    }
      }
	 }
  }
}