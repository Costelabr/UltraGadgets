package com.floodeer.gadgets;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import Core.UtilCooldown;

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
  public String titleMessage;
  public String subTitleMessage;
  public String otherCooldown;
  
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
  public String VectorGadgetName;
  public String CowboyGadgetName;
  
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
  public String VectorGadgetLore;
  public String CowboyGadgetLore;
  
  public String SuperMenuName;
  public String ParticlesMenuName;
  public String PetsMenuName;
  
  
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
    VectorGadgetName = mensagens.getString("VectorTNTGadget-Item-Nome").replaceAll("&", "§");
    CowboyGadgetName = mensagens.getString("CowBoy-Item-Nome").replaceAll("&", "§");
    
    GadgetItemLore = mensagens.getString("Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    BombaGadgetLore = mensagens.getString("Bomba-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    CookieGadgetLore = mensagens.getString("Cookie-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    FunGunGadgetLore = mensagens.getString("FunGun-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    FireworkPartyGadgetLore = mensagens.getString("FireWorkParty-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    MovireGadgetLore = mensagens.getString("Movire-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    PaintballGunGadgetLore = mensagens.getString("PaintballGun-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    StickOfTpGadgetLore = mensagens.getString("Stick-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    DjGadgetLore = mensagens.getString("Dj-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    DiscoBallGadgetLore = mensagens.getString("Disco-Ball-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    RailGunGadgetLore = mensagens.getString("Rail-Gun-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    SmokeBombGadgetLore = mensagens.getString("Smoke-Bomb-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    DiamondPartyGadgetLore = mensagens.getString("Diamond-Party-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    ParaquedasGadgetLore = mensagens.getString("Paraquedas-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    WitherShooterLore = mensagens.getString("WitherShoot-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    VampireGadgetLore = mensagens.getString("Vampire-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    TrampolimLore = mensagens.getString("Trampolim-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    VectorGadgetLore = mensagens.getString("VectorTNTGadget-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    CowboyGadgetLore = mensagens.getString("CowBoy-Item-Lore").replaceAll("&", "§").replaceAll("<newLine>", ChatColor.RESET + "\n");
    
    disguisePermission = mensagens.getString("Disguise-Permissao").replaceAll("&", "§");
    gadgetPermission = mensagens.getString("Gadget-Permissao").replaceAll("&", "§");
    particlepermission = mensagens.getString("Particulas-Permissao").replaceAll("&", "§");
    superparticlepermission = mensagens.getString("SuperParticulas-Permissao").replaceAll("&", "§");
    petspermission = mensagens.getString("Pets-Permissao").replaceAll("&", "§");
    
    gadgetDesabilitado = mensagens.getString("Gadget-Desabilitado").replaceAll("&", "§");
    
    titleMessage = mensagens.getString("Titulo-Cooldown").replaceAll("&", "§");
    subTitleMessage = mensagens.getString("SubTitulo-Cooldown").replaceAll("&", "§");
    
    otherCooldown = mensagens.getString("Outro-Cooldown").replaceAll("&", "§");
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
