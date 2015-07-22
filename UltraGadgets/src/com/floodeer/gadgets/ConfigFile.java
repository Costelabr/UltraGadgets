package com.floodeer.gadgets;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigFile
{
Main plugin = Main.getMain();
  
  public int joinSlot;
  
  public int gadgetSlot;
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
  public long VampireCooldown;
  
  public boolean BombaEnable;
  public boolean CookieEnable;
  public boolean FunGunEnable;
  public boolean FireworkPartyEnable;
  public boolean MovireEnable;
  public boolean StickOfTpEnable;
  public boolean DjEnable;
  public boolean DiscoBallEnable;
  public boolean RailGunEnable;
  public boolean SmokeBombEnable;
  public boolean DiamondPartyEnable;
  public boolean ParaquedasEnable;
  public boolean WitherShootEnable;
  public boolean pbGunEnable;
  public boolean TrampolimEnable;
  public boolean vampireEnable;
  
  public boolean useTitles;
  
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
     this.TrampolimCooldown = config.getLong("Trampolim-Gadget-Cooldown");
     this.VampireCooldown = config.getLong("Vampire-Gadget-Cooldown");
     

     this.BombaEnable = config.getBoolean("Bomba-Gadget-Habilitar");
     this.CookieEnable = config.getBoolean("Cookie-Gadget-Habilitar");
     this.FunGunEnable = config.getBoolean("FunGun-Gadget-Habilitar");
     this.FireworkPartyEnable = config.getBoolean("FireworkParty-Gadget-Habilitar");
     this.MovireEnable = config.getBoolean("Movire-Gadget-Habilitar");
     this.StickOfTpEnable = config.getBoolean("StickTp-Gadget-Habilitar");
     this.DjEnable = config.getBoolean("Dj-Gadget-Habilitar");
     this.DiscoBallEnable = config.getBoolean("Disco-Gadget-Habilitar");
     this.RailGunEnable = config.getBoolean("RailGun-Gadget-Habilitar");
     this.SmokeBombEnable = config.getBoolean("SmokeBomb-Gadget-Habilitar");
     this.DiamondPartyEnable = config.getBoolean("DiamondParty-Gadget-Habilitar");
     this.ParaquedasEnable = config.getBoolean("Paraquedas-Gadget-Habilitar");
     this.WitherShootEnable = config.getBoolean("WitherShoot-Gadget-Habilitar");
     this.TrampolimEnable = config.getBoolean("Trampolim-Gadget-Habilitar");
     this.pbGunEnable = config.getBoolean("PaintballGun-Gadget-Habilitar");
     this.vampireEnable = config.getBoolean("Vampire-Gadget-Habilitar");
     
     this.useTitles = config.getBoolean("Usar-Titulos");
  }
}