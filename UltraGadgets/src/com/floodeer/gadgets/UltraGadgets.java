package com.floodeer.gadgets;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import org.apache.commons.lang.SystemUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.*;
import Core.*;
import Core.PastebinReporter.Paste;
import EventManager.DisguisesEvent;
import EventManager.InventoryMoveManager;
import EventManager.JoinEvent;
import EventManager.PlayerListener;
import EventManager.PluginListener;
import EventManager.QuitEvent;
import Gadgets.*;
import Menus.*;
import Mounts.MountHandler;
import Mounts.RegisterMounts;
import Particulas.ParticleUpdateManager;
import Particulas.UtilParticleType;
import Pets.*;
import Pets.Pets.PetsType;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

public class UltraGadgets
  extends JavaPlugin
{
  public String internal_error = "************************* ERROR ********************************";
  FileConfiguration palavras = null;
  File plf = null;
  public boolean debugg = getConfig().getBoolean("System-Debugg");
  public ProtocolManager protocolManager;
  private static UltraGadgets plugin;
  private UtilItemStack uis;
  private UtilParticleType upt;
  private MenuManager mn;
  private ParticlesMenu pm;
  private UtilItem u;
  private DisguiseMenu dm;
  private SuperMenu spm;
  private Gadgets gdt;
  private UtilBlock ub;
  private Messages ms;
  private Tipos gadgets;
  private ConfigFile cfile;
  private UtilLocations ul;
  private PetMenu petsm;
  private MountMenu mountn;
  public PastebinReporter paste;
  public Paste ugPaster = new Paste("UltraGadgets Reporter");
  
  
  public static UltraGadgets getMain()
  {
    return plugin;
  }
  public MountMenu getMountsMenu() {
	  return mountn;
  }
  
  public ConfigFile getConfigFile()
  {
    return this.cfile;
  }
  
  public PetMenu getPetsMenu() {
	  return petsm;
  }
  
  public Tipos getGadgets()
  {
    return this.gadgets;
  }
  
  public Messages getMessagesFile()
  {
    return this.ms;
  }

  
  public UtilBlock getUtilBlock()
  {
    return this.ub;
  }
  
  public UtilLocations getUtilLocation()
  {
    return this.ul;
  }
  
  public Gadgets getGadgetsMenu()
  {
    return this.gdt;
  }
  
  public SuperMenu getSuperMenu()
  {
    return this.spm;
  }
  
  public DisguiseMenu getDisguiseMenu()
  {
    return this.dm;
  }
  
  public UtilItem getItem()
  {
    return this.u;
  }
  
  public UtilItemStack getItemStack()
  {
    return this.uis;
  }
  
  public UtilParticleType getUtilPartciles()
  {
    return this.upt;
  }
  
  public MenuManager getMenuManager()
  {
    return this.mn;
  }
  
  public ParticlesMenu getParticlesMenu()
  {
    return this.pm;
  }
  
  public void SystemDebugg(String info)
  {
    if (this.debugg) {
      System.out.print(info);
    }
  }
  
  private void setupClasses() {
	  
   File userfiles;
	  try {
	      userfiles = new File(getDataFolder(), "/sons");
	    if(!userfiles.exists()){
	         userfiles.mkdirs();
	      }
	   } catch(SecurityException e) {
	       userfiles = null;
	  }
	     
	 if(userfiles == null) {
	}
	        
	ActionBar.nmsver = Bukkit.getServer().getClass().getPackage().getName();
    ActionBar.nmsver = ActionBar.nmsver.substring(ActionBar.nmsver.lastIndexOf(".") + 1);
    plugin = this;
    this.ms = new Messages();
    getMessagesFile().loadMessagesConfiguration();
    this.cfile = new ConfigFile();
    this.cfile.loadConfigFile();
    this.ub = new UtilBlock();
    this.uis = new UtilItemStack();
    this.upt = new UtilParticleType();
    this.mn = new MenuManager();
    this.pm = new ParticlesMenu();
    this.u = new UtilItem();
    this.dm = new DisguiseMenu();
    this.spm = new SuperMenu();
    this.gdt = new Gadgets();
    this.ul = new UtilLocations();
    petsm = new PetMenu();
    this.mountn = new MountMenu();
  }
  
  private void setupVersionSystemAndPlugin()
  {
    String version = Bukkit.getBukkitVersion();
    if (!version.startsWith("1.8"))
    {
      System.out.print("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
      System.out.print("Ocorreu um erro interno ao tentar habilitar " + getName() + ":");
      System.out.print(getName() + " Nao tem compatibilidades para versoes inferiores a 1.8!");
      setEnabled(false);
      System.out.print("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
    }
    if (SystemUtils.IS_OS_LINUX)
    {
      SystemDebugg(getName() + " Carregando com configuracoes para Linux");
      SystemDebugg("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
      SystemDebugg("Voce esta usando sistema operacional LINUX, porfavor saiba que:");
      SystemDebugg("Nao ha qualquer suporte dedicado para esse sistema.");
      SystemDebugg("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
    }
    if (SystemUtils.IS_OS_MAC)
    {
      SystemDebugg(getName() + " Carregando com configuracoes para Mac");
      SystemDebugg("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
      SystemDebugg("Voce esta usando sistema operacional MAC, porfavor saiba que:");
      SystemDebugg("Nao ha qualquer suporte dedicado para esse sistema.");
      SystemDebugg("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
    }
    if (SystemUtils.IS_OS_WINDOWS)
    {
      SystemDebugg(getName() + " Carregando com configuracoes para Windows");
      SystemDebugg("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
      SystemDebugg("Voce esta usando sistema operacional WINDOWS, porfavor saiba que:");
      SystemDebugg("Arquivos, pastas e atualizacoes estao habilitadas para esse sistema.");
      SystemDebugg("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
    }
  }
  
  public void onEnable()
  {
    SystemDebugg("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
    SystemDebugg("Carregando versao...");
    setupVersionSystemAndPlugin();
    SystemDebugg("Pesquisando por ProtocolLib...");
    if(!Bukkit.getPluginManager().isPluginEnabled("ProtocolLib")) {
    	SystemDebugg("ProtocolLib não foi encontrado! Desabilitando plugin... Porfavor instale ProtocolLib!");
        setEnabled(false);
    	return;
    }
    protocolManager = ProtocolLibrary.getProtocolManager();
    SystemDebugg("Sucesso! Habilitando classes....");    
    getMensagensConfig().options().copyDefaults(true);
    saveDefaultMensagem();
    getConfig().options().copyDefaults(true);
    saveDefaultConfig();
    setupClasses();
    SystemDebugg("Sucesso! Registrando eventos...");
    SetupGadgets.registerGadgets(this);
    Bukkit.getServer().getPluginManager().registerEvents(new PlayerIsInMoviment(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new InventoryMoveManager(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteractPetEvent(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new MenuManager(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new ParticlesMenu(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new DisguiseMenu(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new SuperMenu(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Gadgets(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new DisguisesEvent(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Pets(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new PetMenu(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new PluginListener(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new UtilPet(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new ParticleUpdateManager(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new QuitEvent(), this);
    RegisterMounts.registerMouts(this);
    WardrobeUtils w = new WardrobeUtils();
    Bukkit.getPluginManager().registerEvents(w, this);
    Bukkit.getPluginManager().registerEvents(new UtilLag(this), this);
    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Updater(this), 1L, 1L);
    System.out.print("Sucesso! Registrando comandos...");
    getCommand("ultragadgets").setExecutor(new UltraGadgetsCMD());
    getCommand("ug").setExecutor(new UltraGadgetsCMD());
    System.out.print("Sucesso! Enviando informações:");
    System.out.print("[UltraGadgets] Desenvolvido por: [Floodeer]");
    System.out.print("[UltraGadgets] Versão: Build v1.8-R_3");
    System.out.print("[UltraGadgets] Todos os direitos reservados.");
    System.out.print("[UltraGadgets] Dev Page: https://github.com/Floodeer/UltraGadgets");
    System.out.print("[UltraGadgets] Core Utils: Core for 1.8R-3 version 2.0.2 ");
    System.out.print("O plugin foi habilitado.");
    System.out.print("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
    paste = new PastebinReporter("5855abe282936dd958dbbaa24a06fdd2");
  }
  
  public PastebinReporter getReporter() {
	  return this.paste;
	}
  
  @Override
  public void onDisable() {
	  
	  for(Player p : Bukkit.getOnlinePlayers()) {
		  if(p == null) return;
		  if(PetsType.HasPet(p)) {
			  PetsType.removePet(p);
		  }
		  if(MountHandler.HasPet(p)) {
			  MountHandler.removePlayerMount(p);
		  }
	  }
	  HandlerList.unregisterAll(this);
 }

  public void reloadMensagensConfig()
    throws UnsupportedEncodingException
  {
    if (this.plf == null) {
      this.plf = new File(getDataFolder(), "mensagens.yml");
    }
    this.palavras = YamlConfiguration.loadConfiguration(this.plf);
    
    Reader defConfigStream = new InputStreamReader(getResource("mensagens.yml"), "UTF8");
    if (defConfigStream != null)
    {
      YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
      this.palavras.setDefaults(defConfig);
    }
  }
  
  public FileConfiguration getMensagensConfig()
  {
    if (this.palavras == null) {
      try
      {
        reloadMensagensConfig();
      }
      catch (UnsupportedEncodingException e)
      {
        e.printStackTrace();
      }
    }
    return this.palavras;
  }
  
  public void saveMensagensConfig()
  {
    if ((this.palavras == null) || (this.plf == null)) {
      return;
    }
    try
    {
      getMensagensConfig().save(this.plf);
    }
    catch (IOException ex)
    {
      getLogger().log(Level.SEVERE, "Nao foi possivel salvar " + this.plf, ex);
    }
  }
  
  public void saveDefaultMensagem()
  {
    if (this.plf == null) {
      this.plf = new File(getDataFolder(), "mensagens.yml");
    }
    if (!this.plf.exists()) {
      saveResource("mensagens.yml", false);
    }
  }
}