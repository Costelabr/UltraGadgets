package Util;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.floodeer.gadgets.Main;

public class Util18 {
	
	static Main plugin = Main.getMain();

	public static void sendTitle(Player player, String title, String subtitle,
			int fadeIn, int showTime, int fadeOut) {

		if(plugin.getConfigFile().useTitles) {
		CraftPlayer craftplayer = (CraftPlayer) player;
		PlayerConnection connection = craftplayer.getHandle().playerConnection;
		IChatBaseComponent titleJSON = ChatSerializer.a("{'text': '" + title
				+ "'}");
		IChatBaseComponent subtitleJSON = ChatSerializer.a("{'text': '"
				+ subtitle + "'}");
		PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(
				EnumTitleAction.TITLE, titleJSON, fadeIn, showTime, fadeOut);
		PacketPlayOutTitle subtitlePacket = new PacketPlayOutTitle(
				EnumTitleAction.SUBTITLE, subtitleJSON, fadeIn, showTime,
				fadeOut);
		connection.sendPacket(titlePacket);
		connection.sendPacket(subtitlePacket);
		}
	}
}
