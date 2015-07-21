package com.floodeer.gadgets;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import Util.UtilCooldown;

public class Messages
{
  Main plugin = Main.getMain();
  public String GadgetItem;
  public String prefix;
  
  protected String cooldown;
  public String newParticle;
  public String newDisguise;
  public String petNome;
  public String disguisePermission;
  public String gadgetPermission;
  public String particlepermission;
  public String superparticlepermission;
  public String petspermission;
  
  public String gadgetDesabilitado;
  
  public String GadgetItemName;
  public String BombaGadgetName;
  public String CookieGadgetName;
  public String FunGunGadgetName;
  public String FireworkPartyGadgetName;
  public String MovireGadgetName;
  public String PaintballGunGadgetName;
  public String StickOfTpGadgetName;
  public String DjGadgetName;
  public String DiscoBallGadgetName;
  public String RailGunGadgetName;
  public String SmokeBombGadgetName;
  public String DiamondPartyGadgetName;
  public String ParaquedasGadgetName;
  public String WitherShooterName;
  public String TrampolimName;
  public String DisguiseMenuName;
  public String GadgetsMenuName;
  public String MainMenuName;
  public String VampireGadgetName;
  
  public String GadgetItemLore;
  public String BombaGadgetLore;
  public String CookieGadgetLore;
  public String FunGunGadgetLore;
  public String FireworkPartyGadgetLore;
  public String MovireGadgetLore;
  public String PaintballGunGadgetLore;
  public String StickOfTpGadgetLore;
  public String DjGadgetLore;
  public String DiscoBallGadgetLore;
  public String RailGunGadgetLore;
  public String SmokeBombGadgetLore;
  public String DiamondPartyGadgetLore;
  public String ParaquedasGadgetLore;
  public String WitherShooterLore;
  public String TrampolimLore;
  public String DisguiseMenuLore;
  public String GadgetsMenuLore;
  public String MainMenuLore;
  public String VampireGadgetLore;
  
  public String SuperMenuName;
  public String ParticlesMenuName;
  public String PetsMenuName;
  public String Particle_Hearth;
  public String Particle_Slime;
  public String Particle_Jukebox;
  public String Particle_AngryVillager;
  public String Particle_HappyVillager;
  public String Particle_Redstone;
  public String Particle_Spell;
  
  
  public void loadMessagesConfiguration()
  {
    FileConfiguration mensagens = plugin.getMensagensConfig();
    
    prefix = mensagens.getString("Prefix").replaceAll("&", "§");
    cooldown = mensagens.getString("Mensagem-Cooldown").replaceAll("&", "§");
    newParticle = mensagens.getString("Nova-Particula").replaceAll("&", "§");
    newDisguise = mensagens.getString("Nova-Fantasia").replaceAll("&", "§");
    MainMenuName = mensagens.getString("Principal-Menu").replaceAll("&", "§");
    DisguiseMenuName = mensagens.getString("Fantasias-Menu").replaceAll("&", "§");
    GadgetsMenuName = mensagens.getString("Gadgets-Menu").replaceAll("&", "§");
    ParticlesMenuName = mensagens.getString("Particulas-Menu").replaceAll("&", "§");
    SuperMenuName = mensagens.getString("Super-Particulas-Menu").replaceAll("&", "§");
    petNome = mensagens.getString("Pets-Formato").replaceAll("&", "§");
    PetsMenuName = mensagens.getString("Pets-Menu").replaceAll("&", "§");
    
    GadgetItemName = mensagens.getString("Gadget-Item-Nome").replaceAll("&", "§");
    BombaGadgetName = mensagens.getString("Bomba-Gadget-Item-Nome").replaceAll("&", "§");
    CookieGadgetName = mensagens.getString("Cookie-Gadget-Item-Nome").replaceAll("&", "§");
    FunGunGadgetName = mensagens.getString("FunGun-Gadget-Item-Nome").replaceAll("&", "§");
    FireworkPartyGadgetName = mensagens.getString("FireWorkParty-Gadget-Item-Nome").replaceAll("&", "§");
    MovireGadgetName = mensagens.getString("Movire-Gadget-Item-Nome").replaceAll("&", "§");
    PaintballGunGadgetName = mensagens.getString("PaintballGun-Gadget-Item-Nome").replaceAll("&", "§");
    StickOfTpGadgetName = mensagens.getString("Stick-Gadget-Item-Nome").replaceAll("&", "§");
    DjGadgetName = mensagens.getString("Dj-Gadget-Item-Nome").replaceAll("&", "§");
    DiscoBallGadgetName = mensagens.getString("Disco-Ball-Item-Nome").replaceAll("&", "§");
    RailGunGadgetName = mensagens.getString("Rail-Gun-Item-Nome").replaceAll("&", "§");
    SmokeBombGadgetName = mensagens.getString("Smoke-Bomb-Item-Nome").replaceAll("&", "§");
    DiamondPartyGadgetName = mensagens.getString("Diamond-Party-Item-Nome").replaceAll("&", "§");
    ParaquedasGadgetName = mensagens.getString("Paraquedas-Item-Nome").replaceAll("&", "§");
    WitherShooterName = mensagens.getString("WitherShoot-Item-Nome").replaceAll("&", "§");
    VampireGadgetName = mensagens.getString("Vampire-Item-Nome").replaceAll("&", "§");
    TrampolimName = mensagens.getString("Trampolim-Item-Nome").replaceAll("&", "§");
    
    GadgetItemLore = mensagens.getString("Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    BombaGadgetLore = mensagens.getString("Bomba-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    CookieGadgetLore = mensagens.getString("Cookie-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    FunGunGadgetLore = mensagens.getString("FunGun-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    FireworkPartyGadgetLore = mensagens.getString("FireWorkParty-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    MovireGadgetLore = mensagens.getString("Movire-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    PaintballGunGadgetLore = mensagens.getString("PaintballGun-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    StickOfTpGadgetLore = mensagens.getString("Stick-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    DjGadgetLore = mensagens.getString("Dj-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    DiscoBallGadgetLore = mensagens.getString("Disco-Ball-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    RailGunGadgetLore = mensagens.getString("Rail-Gun-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    SmokeBombGadgetLore = mensagens.getString("Smoke-Bomb-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    DiamondPartyGadgetLore = mensagens.getString("Diamond-Party-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    ParaquedasGadgetLore = mensagens.getString("Paraquedas-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    WitherShooterLore = mensagens.getString("WitherShoot-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    VampireGadgetLore = mensagens.getString("Vampire-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    TrampolimLore = mensagens.getString("Trampolim-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", "\n");
    
    disguisePermission = mensagens.getString("Disguise-Permissao").replaceAll("&", "§");
    gadgetPermission = mensagens.getString("Gadget-Permissao").replaceAll("&", "§");
    particlepermission = mensagens.getString("Particulas-Permissao").replaceAll("&", "§");
    superparticlepermission = mensagens.getString("SuperParticulas-Permissao").replaceAll("&", "§");
    petspermission = mensagens.getString("Pets-Permissao").replaceAll("&", "§");
    
    gadgetDesabilitado = mensagens.getString("Gadget-Desabilitado").replaceAll("&", "§");
  }
  
  /**
   * 
   * @param localPlayer - Player 
   * @param gadgetName - Nome do gadget
   * @param localKey - Key do Cooldown
   * @param localCooldown - Tempo do cooldown
   */
  public void sendCooldownMessage(Player localPlayer, String gadgetName, String localKey, long localCooldown) {
	  
	  localCooldown = UtilCooldown.getCooldown(localPlayer, localKey) / 1000L;
	  String cooldown = ""+localCooldown;
      
	 localPlayer.sendMessage(plugin.getMensagensConfig().getString("Mensagem-Cooldown").replaceAll("&", "§")
	 .replaceAll("<COOLDOWN>", cooldown)
	 .replaceAll("<GADGET>", gadgetName)
	 .replaceAll("<PLAYER>", localPlayer.getName()));
	  
  }
}
