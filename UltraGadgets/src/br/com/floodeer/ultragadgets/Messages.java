package br.com.floodeer.ultragadgets;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import Utils.UtilCooldown;

public class Messages {
	
  UltraGadgets plugin = UltraGadgets.getMain();
  public String GadgetItem;
  public String prefix;
  
  protected String cooldown;
  public String newParticle;
  public String newDisguise;
  public String newHat;
  public String petNome;
  public String disguisePermission;
  public String gadgetPermission;
  public String particlepermission;
  public String superparticlepermission;
  public String petManagerError;
  public String petspermission;
  public String hatPermission;
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
  public String fogueteGadgetName;
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
  public String ExplosiveSheepName;
  public String discoArmorName;
  public String socoGadgetName;
  public String gravidadeGadgetName;
  
  public String GadgetItemLore;
  public String BombaGadgetLore;
  public String CookieGadgetLore;
  public String FunGunGadgetLore;
  public String FireworkPartyGadgetLore;
  public String MovireGadgetLore;
  public String PaintballGunGadgetLore;
  public String StickOfTpGadgetLore;
  public String fogueteGadgetLore;
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
  public String ExplosiveSheepLore;
  public String discoArmorLore;
  public String socoGadgetLore;
  public String gravidadeGadgetLore;
  
  public String SuperMenuName;
  public String ParticlesMenuName;
  public String PetsMenuName;
  public String mountMenuName;
  public String PetManagerMenuName;
  
  public String errorPet;
  
  
  public void loadMessagesConfiguration() {
	  
    FileConfiguration mensagens = plugin.getMensagensConfig();
    
    prefix = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Prefix"));
    cooldown = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Mensagem-Cooldown"));
    newParticle = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Nova-Particula"));
    newHat = ChatColor.translateAlternateColorCodes('&', mensagens.getString("Novo-Hat"));
    newDisguise = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Nova-Fantasia"));
    MainMenuName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Principal-Menu"));
    DisguiseMenuName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Fantasias-Menu"));
    GadgetsMenuName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Gadgets-Menu"));
    ParticlesMenuName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Particulas-Menu"));
    SuperMenuName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Super-Particulas-Menu"));
    mountMenuName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Mount-Menu"));
    petNome = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Pets-Formato"));
    PetsMenuName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Pets-Menu"));
    PetManagerMenuName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("PetManager-Menu"));
    
    GadgetItemName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Gadget-Item-Nome"));
    BombaGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Bomba-Gadget-Item-Nome"));
    CookieGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Cookie-Gadget-Item-Nome"));
    FunGunGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("FunGun-Gadget-Item-Nome"));
    FireworkPartyGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("FireWorkParty-Gadget-Item-Nome"));
    MovireGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Movire-Gadget-Item-Nome"));
    PaintballGunGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("PaintballGun-Gadget-Item-Nome"));
    StickOfTpGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Stick-Gadget-Item-Nome"));
    fogueteGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Foguete-Gadget-Item-Nome"));
    DiscoBallGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Disco-Ball-Item-Nome"));
    RailGunGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Rail-Gun-Item-Nome"));
    SmokeBombGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Smoke-Bomb-Item-Nome"));
    DiamondPartyGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Diamond-Party-Item-Nome"));
    ParaquedasGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Paraquedas-Item-Nome"));
    WitherShooterName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("WitherShoot-Item-Nome"));
    VampireGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Vampire-Item-Nome"));
    TrampolimName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Trampolim-Item-Nome"));
    VectorGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("VectorTNTGadget-Item-Nome"));
    CowboyGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("CowBoy-Item-Nome"));
    ExplosiveSheepName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("ExplosiveSheep-Item-Nome"));
    discoArmorName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("DiscoArmor-Item-Nome"));
    socoGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Soco-Item-Nome"));
    gravidadeGadgetName = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Gravidade-Item-Nome"));
    
    GadgetItemLore = mensagens.getString("Gadget-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    BombaGadgetLore = mensagens.getString("Bomba-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    CookieGadgetLore = mensagens.getString("Cookie-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    FunGunGadgetLore = mensagens.getString("FunGun-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    FireworkPartyGadgetLore = mensagens.getString("FireWorkParty-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    MovireGadgetLore = mensagens.getString("Movire-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    PaintballGunGadgetLore = mensagens.getString("PaintballGun-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    StickOfTpGadgetLore = mensagens.getString("Stick-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    fogueteGadgetLore = mensagens.getString("Foguete-Gadget-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    DiscoBallGadgetLore = mensagens.getString("Disco-Ball-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    RailGunGadgetLore = mensagens.getString("Rail-Gun-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    SmokeBombGadgetLore = mensagens.getString("Smoke-Bomb-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    DiamondPartyGadgetLore = mensagens.getString("Diamond-Party-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    ParaquedasGadgetLore = mensagens.getString("Paraquedas-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    WitherShooterLore = mensagens.getString("WitherShoot-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    VampireGadgetLore = mensagens.getString("Vampire-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    TrampolimLore = mensagens.getString("Trampolim-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    VectorGadgetLore = mensagens.getString("VectorTNTGadget-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    CowboyGadgetLore = mensagens.getString("CowBoy-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    ExplosiveSheepLore = mensagens.getString("ExplosiveSheep-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    discoArmorLore = mensagens.getString("DiscoArmor-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    socoGadgetLore = mensagens.getString("Soco-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    gravidadeGadgetLore = mensagens.getString("Gravidade-Item-Lore").replaceAll("&", "§").replaceAll("null", null);
    
    disguisePermission = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Disguise-Permissao"));
    gadgetPermission = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Gadget-Permissao"));
    particlepermission = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Particulas-Permissao"));
    superparticlepermission = ChatColor.translateAlternateColorCodes('&',mensagens.getString("SuperParticulas-Permissao"));
    petspermission = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Pets-Permissao"));
    petManagerError = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Pet-Manager-Permissao"));
    
    gadgetDesabilitado = ChatColor.translateAlternateColorCodes('&',mensagens.getString("Gadget-Desabilitado"));
    
    titleMessage =  ChatColor.translateAlternateColorCodes('&', mensagens.getString("Titulo-Cooldown"));
    subTitleMessage =  ChatColor.translateAlternateColorCodes('&', mensagens.getString("SubTitulo-Cooldown"));
    
    otherCooldown = ChatColor.translateAlternateColorCodes('&', mensagens.getString("Outro-Cooldown"));
    
    errorPet = ChatColor.translateAlternateColorCodes('&', mensagens.getString("Pet-Invalido"));
    
    hatPermission = ChatColor.translateAlternateColorCodes('&', mensagens.getString("Hats-Permissao"));
  }
  
  /**
   * 
   * @param localPlayer   Player 
   * @param gadgetName   Nome do gadget
   * @param localKey   Key do Cooldown
   * @param localCooldown   Tempo do cooldown
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
