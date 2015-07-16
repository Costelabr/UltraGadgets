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
    FileConfiguration mensagens = this.plugin.getMensagensConfig();
    
    this.prefix = mensagens.getString("Prefix").replaceAll("&", "§");
    this.cooldown = mensagens.getString("Mensagem-Cooldown").replaceAll("&", "§");
    this.newParticle = mensagens.getString("Nova-Particula").replaceAll("&", "§");
    this.newDisguise = mensagens.getString("Nova-Fantasia").replaceAll("&", "§");
    this.MainMenuName = mensagens.getString("Principal-Menu").replaceAll("&", "§");
    this.DisguiseMenuName = mensagens.getString("Fantasias-Menu").replaceAll("&", "§");
    this.GadgetsMenuName = mensagens.getString("Gadgets-Menu").replaceAll("&", "§");
    this.ParticlesMenuName = mensagens.getString("Particulas-Menu").replaceAll("&", "§");
    this.SuperMenuName = mensagens.getString("Super-Particulas-Menu").replaceAll("&", "§");
    this.petNome = mensagens.getString("Pets-Formato").replaceAll("&", "§");
    this.PetsMenuName = mensagens.getString("Pets-Menu").replaceAll("&", "§");
    
    this.GadgetItemName = mensagens.getString("Gadget-Item-Nome").replaceAll("&", "§");
    this.BombaGadgetName = mensagens.getString("Bomba-Gadget-Item-Nome").replaceAll("&", "§");
    this.CookieGadgetName = mensagens.getString("Cookie-Gadget-Item-Nome").replaceAll("&", "§");
    this.FunGunGadgetName = mensagens.getString("FunGun-Gadget-Item-Nome").replaceAll("&", "§");
    this.FireworkPartyGadgetName = mensagens.getString("FireWorkParty-Gadget-Item-Nome").replaceAll("&", "§");
    this.MovireGadgetName = mensagens.getString("Movire-Gadget-Item-Nome").replaceAll("&", "§");
    this.PaintballGunGadgetName = mensagens.getString("PaintballGun-Gadget-Item-Nome").replaceAll("&", "§");
    this.StickOfTpGadgetName = mensagens.getString("Stick-Gadget-Item-Nome").replaceAll("&", "§");
    this.DjGadgetName = mensagens.getString("Dj-Gadget-Item-Nome").replaceAll("&", "§");
    this.DiscoBallGadgetName = mensagens.getString("Disco-Ball-Item-Nome").replaceAll("&", "§");
    this.RailGunGadgetName = mensagens.getString("Rail-Gun-Item-Nome").replaceAll("&", "§");
    this.SmokeBombGadgetName = mensagens.getString("Smoke-Bomb-Item-Nome").replaceAll("&", "§");
    this.DiamondPartyGadgetName = mensagens.getString("Diamond-Party-Item-Nome").replaceAll("&", "§");
    this.ParaquedasGadgetName = mensagens.getString("Paraquedas-Item-Nome").replaceAll("&", "§");
    this.WitherShooterName = mensagens.getString("WitherShoot-Item-Nome").replaceAll("&", "§");
    this.TrampolimName = mensagens.getString("Trampolim-Item-Nome").replaceAll("&", "§");
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
