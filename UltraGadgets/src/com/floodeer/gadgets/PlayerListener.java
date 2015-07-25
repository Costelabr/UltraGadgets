package com.floodeer.gadgets;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener
  implements Listener
{
  Main plugin = Main.getMain();
  
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
}
