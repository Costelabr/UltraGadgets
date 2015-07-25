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
import org.bukkit.plugin.java.JavaPlugin;

import Commands.*;
import Gadgets.*;
import Menus.*;
import Pets.*;
import Pets.Pets.PetsType;
import Util.*;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

public class Main
  extends JavaPlugin
{
  public String internal_error = "************************* ERROR ********************************";
  FileConfiguration palavras = null;
  File plf = null;
  public boolean debugg = getConfig().getBoolean("System-Debugg");
  public ProtocolManager protocolManager;
  private static Main plugin;
  private UtilItemStack uis;
  private UtilParticleType upt;
  private MenuManager mn;
  private ParticlesMenu pm;
  private UtilItem u;
  private DisguiseMenu dm;
  private SuperMenu spm;
  private Gadgets gdt;
  private UtilBlock ub;
  private UtilFireworks uf;
  private Messages ms;
  private Tipos gadgets;
  private ConfigFile cfile;
  private UtilLocations ul;
  private PetMenu petsm;
  
  public static Main getMain()
  {
    return plugin;
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
  
  public UtilFireworks getUtilFirework()
  {
    return this.uf;
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
  
  private void setupClasses()
  {
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
    this.uf = new UtilFireworks();
    petsm = new PetMenu();
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
    this.protocolManager = ProtocolLibrary.getProtocolManager();
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
    Bukkit.getServer().getPluginManager().registerEvents(new Pets(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new PetMenu(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new PluginListener(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new ParticleUpdateManager(), this);
    Bukkit.getPluginManager().registerEvents(new UtilLag(this), this);
    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Updater(this), 1L, 1L);
    System.out.print("Sucesso! Registrando comandos...");
    getCommand("ultragadgets").setExecutor(new UltraGadgetsCMD());
    getCommand("ug").setExecutor(new UltraGadgetsCMD());
    System.out.print("Sucesso! Enviando informações:");
    System.out.print("[UltraGadgets] Desenvolvido por: [Floodeer]");
    System.out.print("[UltraGadgets] Versão: Build v1.8-R_1");
    System.out.print("[UltraGadgets] Todos os direitos reservados.");
    System.out.print("[UltraGadgets] Dev Page: https://github.com/Floodeer/UltraGadgets");
    System.out.print("O plugin foi habilitado.");
    System.out.print("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
  }
  
  @Override
  public void onDisable() {
	  
	 for (Player p : Bukkit.getOnlinePlayers())
	  {
	   if (PetsType.HasPet(p)) {
	    PetsType.removePet(p);
	    }
	     if (this.getUtilPartciles().hasEffect(p)) {
	       this.getUtilPartciles().stopRotation(p);
        }
	     for(Player localParam : Bukkit.getOnlinePlayers()) {
	         RestoreBlocks.saves.clear();
	         RestoreBlocks.restore(localParam);

	     }
	  }
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
