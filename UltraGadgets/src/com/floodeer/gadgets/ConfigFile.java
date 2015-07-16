package com.floodeer.gadgets;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigFile
{
Main plugin = Main.getMain();
  
  public int joinSlot;
  
  public int gadgetSlot;
  public boolean useXPCooldown;
  public long BombaCooldown;
  public long CookieCooldown;
  public long FunGunCooldown;
  public long FireworkPartyCooldown;
  public long MovireCooldown;
  public long StickOfTpCooldown;
  public long DjCooldown;
  public long DiscoBallCooldown;
  public long RailGunCooldown;
  public long SmokeBombCooldown;
  public long DiamondPartyCooldown;
  public long ParaquedasCooldown;
  public long WitherShootCooldown;
  public long TrampolimCooldown;
  
  public void loadConfigFile()
  {
     FileConfiguration config = this.plugin.getConfig();
    
     this.gadgetSlot = config.getInt("Gadgets-Slot");
     this.BombaCooldown = config.getLong("Bomba-Gadget-Cooldown");
     this.CookieCooldown = config.getLong("Cookie-Gadget-Cooldown");
     this.FunGunCooldown = config.getLong("FunGun-Gadget-Cooldown");
     this.FireworkPartyCooldown = config.getLong("FireworkParty-Gadget-Cooldown");
     this.MovireCooldown = config.getLong("Movire-Gadget-Cooldown");
     this.StickOfTpCooldown = config.getLong("StickTp-Gadget-Cooldown");
     this.DjCooldown = config.getLong("Dj-Gadget-Cooldown");
     this.DiscoBallCooldown = config.getLong("Disco-Gadget-Cooldown");
     this.RailGunCooldown = config.getLong("RailGun-Gadget-Cooldown");
     this.SmokeBombCooldown = config.getLong("SmokeBomb-Gadget-Cooldown");
     this.DiamondPartyCooldown = config.getLong("DiamondParty-Gadget-Cooldown");
     this.ParaquedasCooldown = config.getLong("Paraquedas-Gadget-Cooldown");
     this.WitherShootCooldown = config.getLong("WitherShoot-Gadget-Cooldown");
     this.useXPCooldown = config.getBoolean("Usar-Cooldown-No-LevelExp");
     this.TrampolimCooldown = config.getLong("Trampolim-Gadget-Cooldown");
  }
}