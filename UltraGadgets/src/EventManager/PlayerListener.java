package EventManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;

import com.floodeer.gadgets.UltraGadgets;

public class PlayerListener
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
  
  @EventHandler(priority=EventPriority.HIGH)
  public void paramPlayerPlaceBlock(BlockPlaceEvent paramBlockPlace)
  {
    Player paramPlayer = paramBlockPlace.getPlayer();
    ItemStack paramStackPlacer = paramPlayer.getItemInHand();
    if (this.plugin.getItem().isGadgetItem(paramStackPlacer, this.plugin.getMessagesFile().GadgetItemName)) {
      paramBlockPlace.setBuild(false);
    }
    if (this.plugin.getItem().isGadgetItem(paramStackPlacer, this.plugin.getMessagesFile().DiscoBallGadgetName)) {
      paramBlockPlace.setCancelled(true);
    }
    if (this.plugin.getItem().isGadgetItem(paramStackPlacer, this.plugin.getMessagesFile().DjGadgetName)) {
      paramBlockPlace.setCancelled(true);
    }
    if(plugin.getItem().isGadgetItem(paramStackPlacer, plugin.getMessagesFile().WitherShooterName)) {
    	paramBlockPlace.setCancelled(true);
    }
    if(plugin.getItem().isGadgetItem(paramStackPlacer, plugin.getMessagesFile().VectorGadgetName)) {
    	paramBlockPlace.setCancelled(true);
    }
  }
  
  @EventHandler
  public void paramPlayerDestroy(BlockBreakEvent paramBreakBlock)
  {
    Player paramPlayer = paramBreakBlock.getPlayer();
    ItemStack paramStackPlayer = paramPlayer.getItemInHand();
    if (this.plugin.getItem().isGadgetItem(paramStackPlayer, this.plugin.getMessagesFile().GadgetItemName)) {
      paramBreakBlock.setCancelled(true);
    }
    if (this.plugin.getItem().isGadgetItem(paramStackPlayer, this.plugin.getMessagesFile().DiscoBallGadgetName)) {
      paramBreakBlock.setCancelled(true);
    }
    if (this.plugin.getItem().isGadgetItem(paramStackPlayer, this.plugin.getMessagesFile().DjGadgetName)) {
      paramBreakBlock.setCancelled(true);
    }
    if (paramBreakBlock.getBlock().hasMetadata("MetaBlocked")) {
      paramBreakBlock.setCancelled(true);
    }
    if(plugin.getItem().isGadgetItem(paramStackPlayer, plugin.getMessagesFile().WitherShooterName)) {
    	paramBreakBlock.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onProcess(PlayerCommandPreprocessEvent e) {
	  if(e.getMessage().equals("/reload")|| e.getMessage().equals("/rl")){
	  if(e.getPlayer().isOp()) {
		  e.getPlayer().sendMessage(plugin.getMessagesFile().prefix + ChatColor.RED + " Não use o comando '/reload' com o plugin instalado, isso pode causar problemas de Timers e Packets!");
	  }
		  
	}
  }
}
