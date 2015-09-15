package br.com.floodeer.ultragadgets;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigFile
{
UltraGadgets plugin = UltraGadgets.getMain();
  
  public int joinSlot;
  
  public int GadgetSlot;
  public long BombaCooldown;
  public long CookieCooldown;
  public long FunGunCooldown;
  public long FireworkPartyCooldown;
  public long MovireCooldown;
  public long StickOfTpCooldown;
  public long fogueteCooldown;
  public long DiscoBallCooldown;
  public long RailGunCooldown;
  public long SmokeBombCooldown;
  public long DiamondPartyCooldown;
  public long ParaquedasCooldown;
  public long WitherShootCooldown;
  public long TrampolimCooldown;
  public long VampireCooldown;
  public long vectorTNTCooldown;
  public long explosiveSheepCooldown;
  public long discoArmorCooldown;
  public long supersocoCooldown;
  public long gravidadeCooldown;
  public long partyPopperCooldown;
  public long poopCooldown;
  public long rainbowCooldown;
  
  public boolean BombaEnable;
  public boolean CookieEnable;
  public boolean FunGunEnable;
  public boolean FireworkPartyEnable;
  public boolean MovireEnable;
  public boolean StickOfTpEnable;
  public boolean fogueteEnable;
  public boolean DiscoBallEnable;
  public boolean RailGunEnable;
  public boolean SmokeBombEnable;
  public boolean DiamondPartyEnable;
  public boolean ParaquedasEnable;
  public boolean WitherShootEnable;
  public boolean pbGunEnable;
  public boolean TrampolimEnable;
  public boolean vampireEnable;
  public boolean vectorTNTEnable;
  public boolean cowBoyEnable;
  public boolean mobGunEnable;
  public boolean explosiveSheepEnable;
  public boolean discoArmorEnable;
  public boolean supersocoEnable;
  public boolean gravidadeEnable;
  public boolean partyPopperEnable;
  public boolean poopEnable;
  public boolean rainbowEnable;
  
  public boolean useMountBlockEffect;
  public boolean useTitles;
  public boolean useCustomSounds;
  
  public void loadConfigFile()
  {
     FileConfiguration config = plugin.getConfig();
    
     GadgetSlot = config.getInt("Gadgets-Slot");
     BombaCooldown = config.getLong("Bomba-Gadget-Cooldown");
     CookieCooldown = config.getLong("Cookie-Gadget-Cooldown");
     FunGunCooldown = config.getLong("FunGun-Gadget-Cooldown");
     FireworkPartyCooldown = config.getLong("FireworkParty-Gadget-Cooldown");
     MovireCooldown = config.getLong("Movire-Gadget-Cooldown");
     StickOfTpCooldown = config.getLong("StickTp-Gadget-Cooldown");
     fogueteCooldown = config.getLong("Foguete-Gadget-Cooldown");
     DiscoBallCooldown = config.getLong("Disco-Gadget-Cooldown");
     RailGunCooldown = config.getLong("RailGun-Gadget-Cooldown");
     SmokeBombCooldown = config.getLong("SmokeBomb-Gadget-Cooldown");
     DiamondPartyCooldown = config.getLong("DiamondParty-Gadget-Cooldown");
     ParaquedasCooldown = config.getLong("Paraquedas-Gadget-Cooldown");
     WitherShootCooldown = config.getLong("WitherShoot-Gadget-Cooldown");
     TrampolimCooldown = config.getLong("Trampolim-Gadget-Cooldown");
     VampireCooldown = config.getLong("Vampire-Gadget-Cooldown");
     vectorTNTCooldown = config.getLong("VectorTNT-Gadget-Cooldown");
     explosiveSheepCooldown = config.getLong("ExplosiveSheep-Gadget-Cooldown");
     discoArmorCooldown = config.getLong("DiscoArmor-Gadget-Cooldown");
     supersocoCooldown = config.getLong("Soco-Gadget-Cooldown");
     gravidadeCooldown = config.getLong("Gravidade-Gadget-Cooldown");
     partyPopperCooldown = config.getLong("PartyPopper-Gadget-Cooldown");
     poopCooldown = config.getLong("Poop-Gadget-Cooldown");
     rainbowCooldown = config.getLong("Rainbow-Gadget-Cooldown");
     
     BombaEnable = config.getBoolean("Bomba-Gadget-Habilitar");
     CookieEnable = config.getBoolean("Cookie-Gadget-Habilitar");
     FunGunEnable = config.getBoolean("FunGun-Gadget-Habilitar");
     FireworkPartyEnable = config.getBoolean("FireworkParty-Gadget-Habilitar");
     MovireEnable = config.getBoolean("Movire-Gadget-Habilitar");
     StickOfTpEnable = config.getBoolean("StickTp-Gadget-Habilitar");
     fogueteEnable = config.getBoolean("Foguete-Gadget-Habilitar");
     DiscoBallEnable = config.getBoolean("Disco-Gadget-Habilitar");
     RailGunEnable = config.getBoolean("RailGun-Gadget-Habilitar");
     SmokeBombEnable = config.getBoolean("SmokeBomb-Gadget-Habilitar");
     DiamondPartyEnable = config.getBoolean("DiamondParty-Gadget-Habilitar");
     ParaquedasEnable = config.getBoolean("Paraquedas-Gadget-Habilitar");
     WitherShootEnable = config.getBoolean("WitherShoot-Gadget-Habilitar");
     TrampolimEnable = config.getBoolean("Trampolim-Gadget-Habilitar");
     pbGunEnable = config.getBoolean("PaintballGun-Gadget-Habilitar");
     vampireEnable = config.getBoolean("Vampire-Gadget-Habilitar");
     vectorTNTEnable = config.getBoolean("VectorTNT-Gadget-Habilitar");
     cowBoyEnable = config.getBoolean("CowBoy-Gadget-Habilitar");
     mobGunEnable = config.getBoolean("MobGun-Gadget-Habilitar");
     explosiveSheepEnable = config.getBoolean("ExplosiveSheep-Gadget-Habilitar");
     discoArmorEnable = config.getBoolean("DiscoArmor-Gadget-Habilitar");
     supersocoEnable = config.getBoolean("Soco-Gadget-Habilitar");
     gravidadeEnable = config.getBoolean("Gravidade-Gadget-Habilitar");
     partyPopperEnable = config.getBoolean("PartyPopper-Gadget-Habilitar");
     poopEnable = config.getBoolean("Poop-Gadget-Habilitar");
     rainbowEnable = config.getBoolean("Rainbow-Gadget-Habilitar");
     
     useMountBlockEffect = config.getBoolean("Mounts-Podem-Mudar-Blocos");
     useTitles = config.getBoolean("Usar-Titulos");
     useCustomSounds = config.getBoolean("Usar-Sons-Customizados");
  }
}