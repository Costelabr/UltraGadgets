package Util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import Util.Reflections.RefClass;
import Util.Reflections.RefConstructor;
import Util.Reflections.RefField;
import Util.Reflections.RefMethod;


public class UtilDisguise
{
	 
    private DisguiseType disguise;
    private String player;
    private RefClass entity;
    private Class<?> entityObject;
    private Object thisObject;

    @SuppressWarnings("deprecation")
    public UtilDisguise(DisguiseType d, String p) {
    disguise = d;
    player = p;
    Location location = Bukkit.getServer().getPlayer(p).getLocation();
    switch(disguise) {
    case ZOMBIE:
    entity = getEntity("EntityZombie", p);
    break;
    case WITHER_SKELETON:
    entity = getEntity("EntitySkeleton", p);

    RefMethod methodSkeleton = entity.findMethodByName("setSkeletonType");

    methodSkeleton.of(thisObject).call(1);
    break;
    case SKELETON:
        entity = getEntity("EntitySkeleton", p);
    break;
    case ZOMBIEPIG:
        entity = getEntity("EntityPigZombie", p);
    break;
    case BLAZE:
        entity = getEntity("EntityBlaze", p);
    break;
    case ENDERMAN:
        entity = getEntity("EntityEnderman", p);
    break;
    case CREEPER:
        entity = getEntity("EntityCreeper", p);
    break;
    case SPIDER:
        entity = getEntity("EntitySpider", p);
    break;
    case WITCH:
        entity = getEntity("EntityWitch", p);
    break;
    case WITHER_BOSS:
        entity = getEntity("EntityWither", p);
    break;
    case GHAST:
        entity = getEntity("EntityGhast", p);
    break;
    case GIANT:
        entity = getEntity("EntityGiant", p);
    break;
    }
    if(d != null) {

    RefMethod m = entity.getMethod("setPosition", double.class, double.class, double.class);
    RefMethod mm = entity.getMethod("d", int.class);
    RefMethod mmm = entity.getMethod("setCustomName", String.class);
    RefMethod mmmm = entity.getMethod("setCustomNameVisible", boolean.class);

    m.of(thisObject).call(location.getX(), location.getY(), location.getZ());
    mm.of(thisObject).call(Bukkit.getServer().getPlayer(p).getEntityId());
    mmm.of(thisObject).call(ChatColor.YELLOW + Bukkit.getServer().getPlayer(p).getName());
    mmmm.of(thisObject).call(true);

    RefField rf = entity.getField("locX");

    rf.of(thisObject).set(location.getX());

    RefField rf1 = entity.getField("locY");

    rf1.of(thisObject).set(location.getY());

    RefField rf2 = entity.getField("locZ");

    rf2.of(thisObject).set(location.getZ());


    RefField rf3 = entity.getField("yaw");

    rf3.of(thisObject).set(location.getYaw());

    RefField rf4 = entity.getField("pitch");

    rf4.of(thisObject).set(location.getPitch());

    }
    }

    @SuppressWarnings("deprecation")
    public Player getPlayer() {
    return Bukkit.getPlayer(player);
    }

    @SuppressWarnings("deprecation")
    public void removeDisguise() {
    this.disguise = null;

    RefClass p29 = Reflections.getRefClass("{nms}.PacketPlayOutEntityDestroy");

    RefClass p20 = Reflections.getRefClass("{nms}.PacketPlayOutNamedEntitySpawn");

    RefConstructor pp20 = p20.getConstructor(Reflections.getRefClass("{nms}.EntityHuman"));

    RefConstructor pp29 = p29.getConstructor(int[].class);

    int[] entityId;

    entityId = new int[1];

    entityId[0] = Bukkit.getPlayer(player).getEntityId();

    Object packetEntityDestroy = pp29.create(entityId);

    Object packetNamedEntitySpawn = pp20.create((Reflections.getRefClass("{cb}.entity.CraftPlayer")).getMethod("getHandle").of(getPlayer()).call());

    RefClass classCraftPlayer = Reflections.getRefClass("{cb}.entity.CraftPlayer");
    RefMethod methodGetHandle = classCraftPlayer.getMethod("getHandle");
    RefClass classEntityPlayer = Reflections.getRefClass("{nms}.EntityPlayer");
    RefField fieldPlayerConnection = classEntityPlayer.getField("playerConnection");
    RefClass classPlayerConnection = Reflections.getRefClass("{nms}.PlayerConnection");
    RefMethod methodSendPacket = classPlayerConnection.findMethodByName("sendPacket");

    for (Player player : Bukkit.getOnlinePlayers()) {
 
        if(player != getPlayer()) {
        Object handle = methodGetHandle.of(player).call();
        Object connection = fieldPlayerConnection.of(handle).get();
 
        methodSendPacket.of(connection).call(packetEntityDestroy);
        methodSendPacket.of(connection).call(packetNamedEntitySpawn);
        }
    }

    }

    public void changeDisguise(DisguiseType d) {
    removeDisguise();
    this.disguise = d;
    UtilDisguise dis = new UtilDisguise(d, player);
    dis.disguiseToAll();
    }

    @SuppressWarnings("deprecation")
    public void disguiseToAll() {
 
        RefClass p29 = Reflections.getRefClass("{nms}.PacketPlayOutEntityDestroy");
 
        RefClass p20 = Reflections.getRefClass("{nms}.PacketPlayOutSpawnEntityLiving");
 
        RefConstructor pp20 = p20.getConstructor(Reflections.getRefClass("{nms}.EntityLiving"));
 
        RefConstructor pp29 = p29.getConstructor(int[].class);
 
        int[] entityId;
 
        entityId = new int[1];
 
        entityId[0] = Bukkit.getPlayer(player).getEntityId();
 
        Object packetEntityDestroy = pp29.create(entityId);
 
        Object packetNamedEntitySpawn = pp20.create(thisObject);
 
        RefClass classCraftPlayer = Reflections.getRefClass("{cb}.entity.CraftPlayer");
        RefMethod methodGetHandle = classCraftPlayer.getMethod("getHandle");
        RefClass classEntityPlayer = Reflections.getRefClass("{nms}.EntityPlayer");
        RefField fieldPlayerConnection = classEntityPlayer.getField("playerConnection");
        RefClass classPlayerConnection = Reflections.getRefClass("{nms}.PlayerConnection");
        RefMethod methodSendPacket = classPlayerConnection.findMethodByName("sendPacket");
 
        for (Player all : Bukkit.getOnlinePlayers()) {
            if(all != Bukkit.getPlayer(player)) {
            Object handle = methodGetHandle.of(all).call();
            Object connection = fieldPlayerConnection.of(handle).get();
     
            methodSendPacket.of(connection).call(packetEntityDestroy);
            methodSendPacket.of(connection).call(packetNamedEntitySpawn);
            }
        }
    }

    public static enum DisguiseType {
     ZOMBIE(Type.BIPED),
     WITHER_SKELETON(Type.BIPED),
     SKELETON(Type.BIPED),
     ZOMBIEPIG(Type.BIPED),
     BLAZE(Type.MOB),
     ENDERMAN(Type.MOB),
     CREEPER(Type.MOB),
     SPIDER(Type.MOB),
     WITCH(Type.MOB),
     WITHER_BOSS(Type.MOB),
     GHAST(Type.MOB),
     GIANT(Type.MOB);

     private Type type;

     DisguiseType(Type type) {
     this.type = type;
     }

     public Type getType() {
     return type;
     }

     public boolean isBiped() {
     if(type == Type.BIPED) {
     return true;
     }
     return false;
     }

     public static enum Type {
     BIPED, MOB;
     }
     }

    @SuppressWarnings("deprecation")
    private RefClass getEntity(String entity, String p) {
         RefClass ent = Reflections.getRefClass("{nms}." + entity);
 
         RefConstructor entConstructor = ent.getConstructor(Reflections.getRefClass("{nms}.World"));
 
         RefClass classCraftWorld = Reflections.getRefClass("{cb}.CraftWorld");
          RefMethod methodGetHandle = classCraftWorld.getMethod("getHandle");
 
          Object handle = methodGetHandle.of(Bukkit.getServer().getPlayer(p).getWorld()).call();
 
          Object fin = entConstructor.create(handle);
   
          this.thisObject = fin;
          this.entityObject = fin.getClass();
   
          return Reflections.getRefClass(entityObject);
     }

}