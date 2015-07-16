package com.floodeer.gadgets;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;

import Pets.Pets.PetsType;

public class ServerListener
  implements Listener
{
  Main plugin = Main.getMain();
  
  @EventHandler
  public void onServiceDisable(PluginDisableEvent e)
  {
    if (e.getPlugin().equals(this.plugin))
    {
      for (Player p : Bukkit.getOnlinePlayers())
      {
        if (PetsType.HasPet(p)) {
          PetsType.removePet(p);
        }
        if (this.plugin.getUtilPartciles().hasEffect(p)) {
          this.plugin.getUtilPartciles().stopRotation(p);
        }
      }
    }
  }
}