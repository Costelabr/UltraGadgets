package br.com.floodeer.ultragadgets;

import java.io.*;
import java.util.logging.Level;

import org.apache.commons.lang.SystemUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.UltraGadgetsCMD;
import EventManager.*;
import Exception.*;
import Gadgets.*;
import Menus.*;
import Mounts.*;
import Particulas.*;
import Pets.*;
import Update.*;
import Utils.*;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

public class UltraGadgets extends JavaPlugin {
	
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
    private HatsMenu hm;
    public PastebinReporter paste;
    
    private File msgsFile = null;
    private FileConfiguration mensagens = null;
    
    public static UltraGadgets getMain()
    {
      return plugin;
    }
    public HatsMenu getHatsMenu() {
  	  return hm;
    }
    
    public MountMenu getMountsMenu() {
  	  return mountn;
    }
    
    public ConfigFile getConfigFile() {
      return cfile;
   }
    
    public PetMenu getPetsMenu() {
  	  return petsm;
   }
    
    public Tipos getGadgets() {
      return gadgets;
   }
    
    public Messages getMessagesFile() {
      return ms;
   }

    
    public UtilBlock getUtilBlock() {
      return ub;
   }
    
    public UtilLocations getUtilLocation() {
      return ul;
   }
    
    public Gadgets getGadgetsMenu() {
      return gdt;
   }
    
    public SuperMenu getSuperMenu() {
      return spm;
   }
    
    public DisguiseMenu getDisguiseMenu() {
      return dm;
   }
    
    public UtilItem getItem() {
      return u;
   }
    
    public UtilItemStack getItemStack() {
      return uis;
   }
    
    public UtilParticleType getUtilPartciles() {
      return upt;
   }
    
    public MenuManager getMenuManager(){
      return mn;
   }
    
    public ParticlesMenu getParticlesMenu() {
      return pm;
   }
    
    private void setupVersionSystemAndPlugin(){
        String version = Bukkit.getBukkitVersion();
        if (!version.startsWith("1.8")){
          System.out.print("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
          System.out.print("Ocorreu um erro interno ao tentar habilitar " + getName() + ":");
          System.out.print("[UltraGadgets] Nao tem compatibilidades para versoes inferiores a 1.8!");
          setEnabled(false);
          System.out.print("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
        }
        if (SystemUtils.IS_OS_LINUX)
        {
          SystemDebugg(getName() + " Carregando com configuracoes para Linux");
          SystemDebugg("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
          SystemDebugg("Voce esta usando sistema operacional LINUX, porfavor saiba que:");
          SystemDebugg("Nao ha qualquer suporte dedicado para esse sistema.");
          SystemDebugg("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
        }
        if (SystemUtils.IS_OS_MAC)
        {
          SystemDebugg(getName() + " Carregando com configuracoes para Mac");
          SystemDebugg("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
          SystemDebugg("Voce esta usando sistema operacional MAC, porfavor saiba que:");
          SystemDebugg("Nao ha qualquer suporte dedicado para esse sistema.");
          SystemDebugg("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
        }
        if (SystemUtils.IS_OS_WINDOWS)
        {
          SystemDebugg(getName() + " Carregando com configuracoes para Windows");
          SystemDebugg("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
          SystemDebugg("Voce esta usando sistema operacional WINDOWS, porfavor saiba que:");
          SystemDebugg("Arquivos, pastas e atualizacoes estao habilitadas para esse sistema.");
          SystemDebugg("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
        }
      }
    
    
	public void SystemDebugg(String info){
	  if (debugg) {
	    System.out.print(info);
	  }
	}
	
	public String serverVersion() {
		String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		return version;
	 }
	
	  String version;
	  private boolean setupNMS() {
	    try{
	      version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
	    }catch (ArrayIndexOutOfBoundsException invalidVersion) {
	    throw new InvalidVersionException("[UltraGadgets] Nao pode achar 1.8 vR1, vR2 ou vR3!", invalidVersion);	
	 }
	    return false;
   }
	  
	private void setupClasses() {
		  
	ActionBar.nmsver = Bukkit.getServer().getClass().getPackage().getName();
	ActionBar.nmsver = ActionBar.nmsver.substring(ActionBar.nmsver.lastIndexOf(".") + 1);
	plugin = this;
	ms = new Messages();
	getMessagesFile().loadMessagesConfiguration();
	cfile = new ConfigFile();
	cfile.loadConfigFile();
	ub = new UtilBlock();
	uis = new UtilItemStack();
	upt = new UtilParticleType();
	mn = new MenuManager();
	pm = new ParticlesMenu();
	u = new UtilItem();
	dm = new DisguiseMenu();
	spm = new SuperMenu();
	gdt = new Gadgets();
	ul = new UtilLocations();
	petsm = new PetMenu();
	mountn = new MountMenu();
	hm = new HatsMenu();
 }
	
	@Override
	public void onEnable() {
		try{
		getMensagensConfig().options().copyDefaults(true);
		saveDefaultMensagem();
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	    try {
			saveResource("sons.zip", false);
			saveResource("leia.yml", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    SystemDebugg("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
		SystemDebugg("Aguarde, o plugin está sendo carregado...");
		setupVersionSystemAndPlugin();
		setupNMS();
		SystemDebugg("Pesquisando por ProtocolLib...");
		if(!Bukkit.getPluginManager().isPluginEnabled("ProtocolLib")) {
		    SystemDebugg("ProtocolLib não foi encontrado! Desabilitando plugin... Porfavor instale ProtocolLib!");
		    setEnabled(false);
		    return;
		 }
		 SystemDebugg("ProtocolLib foi encontrado com sucesso!");
		 protocolManager = ProtocolLibrary.getProtocolManager();
		 SystemDebugg("Registrando configurações e classes...");    
		 setupClasses();
		 SystemDebugg("Registrado com sucesso!");
		 SystemDebugg("Registrando Eventos e Runnables...");
		 SetupGadgets.registerGadgets(this);
		 Bukkit.getServer().getPluginManager().registerEvents(new LocalUpdate(), this);
		 Bukkit.getServer().getPluginManager().registerEvents(new InventoryMoveManager(), this);
		 Bukkit.getServer().getPluginManager().registerEvents(new PetManager(), this);
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
		 Bukkit.getServer().getPluginManager().registerEvents(new WorldChange(), this);
		 Bukkit.getServer().getPluginManager().registerEvents(new ParticleUpdateManager(), this);
		 Bukkit.getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		 Bukkit.getServer().getPluginManager().registerEvents(new HatsMenu(), this);
		 Bukkit.getServer().getPluginManager().registerEvents(new IFallingBlocks(), this);
		 Bukkit.getServer().getPluginManager().registerEvents(new EntitySpawnPriority(), this);
		 Bukkit.getServer().getPluginManager().registerEvents(new UtilGravity(), this);
		 RegisterMounts.registerMouts(this);
		 WardrobeUtils w = new WardrobeUtils();
		 Bukkit.getPluginManager().registerEvents(w, this);
		 Bukkit.getPluginManager().registerEvents(new UtilLag(this), this);
		 Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new SchedulerRunner(this), 1L, 1L);
		 SystemDebugg("Registrado com sucesso!");
		 SystemDebugg("Registrando comandos e Listeners...");
		 getCommand("ultragadgets").setExecutor(new UltraGadgetsCMD());
		 getCommand("ug").setExecutor(new UltraGadgetsCMD());
		 SystemDebugg("Comandos e Listeners registrados com sucesso!");
		 SystemDebugg("Você pode remover este log na configuração. Em 'System-Debugg'");
		 System.out.print("[UltraGadgets] Desenvolvido por: [Floodeer]");
		 System.out.print("[UltraGadgets] Versão: Suporte v_1.8-R1 & v_1.8-R3");
		 System.out.print("[UltraGadgets] Todos os direitos reservados.");
		 System.out.print("[UltraGadgets] Dev Page: https://github.com/Floodeer/UltraGadgets");
		 System.out.print("[UltraGadgets] Core Utils: Core for 1.8X version 2.2.0");
		 System.out.print("O plugin foi habilitado.");
		 System.out.print("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
	}
	
	public void reloadMensagensConfig() throws UnsupportedEncodingException {
	    if (msgsFile == null) {
		msgsFile = new File(getDataFolder(), "mensagens.yml");
	}
		mensagens = YamlConfiguration.loadConfiguration(msgsFile);
		Reader defConfigStream = new InputStreamReader(getResource("mensagens.yml"), "UTF8");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			 mensagens.setDefaults(defConfig);
		}
	}
			  
	public FileConfiguration getMensagensConfig(){
		if (mensagens == null) {
			try{
			reloadMensagensConfig();
            }catch (UnsupportedEncodingException e) {
			     e.printStackTrace();
			 }
		  }
		return mensagens;
	}
			  
		 public void saveMensagensConfig() {
			    if ((mensagens == null) || (msgsFile == null)) {
			      return;
			    }try {
			      getMensagensConfig().save(msgsFile);
			    }catch (IOException ex){
			      getLogger().log(Level.SEVERE, "Nao foi possivel salvar " + msgsFile, ex);
			    }
			  }
			  
			  public void saveDefaultMensagem() {
			    if (msgsFile == null) {
			       msgsFile = new File(getDataFolder(), "mensagens.yml");
			    }
			 if (!msgsFile.exists()) {
			   saveResource("mensagens.yml", false);
		  }
	}
}
