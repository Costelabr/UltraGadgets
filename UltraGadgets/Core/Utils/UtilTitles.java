package Utils;

import java.lang.reflect.Constructor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import br.com.floodeer.ultragadgets.UltraGadgets;


public class UtilTitles {
	
	static UltraGadgets plugin = UltraGadgets.getMain();

	public static void sendCooldownTitle(Player player, String title, String subtitle, int fadeIn, int showTime, int fadeOut) {

		if(plugin.getConfigFile().useTitles) {
            try {
            	
                Object sitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
                Object subTitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
                
                Object chat = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{'text': '" + title + "'}");
                Object chatTitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{'text': '" + subtitle + "'}");
               
                Constructor<?> titleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class);
                Object packet = titleConstructor.newInstance(sitle, chat, fadeIn, showTime, fadeOut);
                Object packetSub = titleConstructor.newInstance(subTitle, chatTitle, fadeIn, showTime, fadeOut);
               
                sendPacket(player, packet);
                sendPacket(player, packetSub);
        }
       
        catch (Exception e1) {
                e1.printStackTrace();
        }
	}
}
	
	public static void sendForcedTitle(Player player, String title, String subtitle, int fadeIn, int showTime, int fadeOut) {

            try {
            	
                Object sitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
                Object subTitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
                
                Object chat = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{'text': '" + title + "'}");
                Object chatTitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{'text': '" + subtitle + "'}");
               
                Constructor<?> titleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class);
                Object packet = titleConstructor.newInstance(sitle, chat, fadeIn, showTime, fadeOut);
                Object packetSub = titleConstructor.newInstance(subTitle, chatTitle, fadeIn, showTime, fadeOut);
               
                sendPacket(player, packet);
                sendPacket(player, packetSub);
        }
       
        catch (Exception e1) {
                e1.printStackTrace();
	}
}
		
        public static void sendPacket(Player player, Object packet) {
            try {
                    Object handle = player.getClass().getMethod("getHandle").invoke(player);
                    Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
                    playerConnection.getClass().getMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnection, packet);
            }
           
            catch (Exception e) {
                    e.printStackTrace();
            }
    }
   
    public static Class<?> getNMSClass(String name) {
            String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            try {
                    return Class.forName("net.minecraft.server." + version + "." + name);
            }
           
            catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return null;
            }
    }
}