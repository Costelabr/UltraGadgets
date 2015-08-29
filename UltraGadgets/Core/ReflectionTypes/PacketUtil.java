package ReflectionTypes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

import org.bukkit.entity.Player;

import ReflectionTypes.ReflectionUtil.PackageType;
import ReflectionTypes.ReflectionUtil.PacketType;
import ReflectionTypes.ReflectionUtil.SubPackageType;

public class PacketUtil {

	private static Class<?> obc_CraftPlayer;
	private static Method getHandle;

	private static Field playerConnection;
	private static Method sendPacket;

	static {
		try {
			obc_CraftPlayer = ReflectionUtil.getClass("CraftPlayer", SubPackageType.ENTITY);
			getHandle = ReflectionUtil.getMethod(obc_CraftPlayer, "getHandle");
			playerConnection = ReflectionUtil.getField("EntityPlayer", PackageType.MINECRAFT_SERVER, "playerConnection");
			sendPacket = ReflectionUtil.getMethod(playerConnection.getType(), "sendPacket", ReflectionUtil.getClass("Packet", PackageType.MINECRAFT_SERVER));
		} catch (Exception e) {
	  }
	}
	
	public static void sendPacket(Player player, Object packet) {
		try {
			sendPacket.invoke(playerConnection.get(getHandle.invoke(obc_CraftPlayer.cast(player))), packet);
		} catch (Exception e) {
			throw new PacketSendingException("Falha ao enviar packet para '" + player.getName() + "'", e);
		}
	}
	
	public static void sendPacket(Collection<Player> players, Object packet) {
		for (Player player : players)
			sendPacket(player, packet);
	}
	
	public static Object getPacket(PacketType type, Object... args) {
		try {
			Class<?>[] paramTypes = new Class<?>[args.length];
			for (int i = 0; i < args.length; i++) {
				Object arg = args[i];
				paramTypes[i] = arg.getClass();
			}
			Constructor<?> c_packet = ReflectionUtil.getConstructor(type.getPacket(), paramTypes);
			Object packet = c_packet.newInstance(args);
			return packet;
		} catch (Exception e) {
			throw new PacketInstantiationException("Erro ao estabilizar Packet", e);
		}
	}
	
	public static final class PacketInstantiationException extends
			RuntimeException {
		private static final long serialVersionUID = -5179311826851333234L;
		
		public PacketInstantiationException(String message) {
			super(message);
		}
		
		public PacketInstantiationException(String message, Throwable cause) {
			super(message, cause);
		}
	}
	
	public static final class PacketSendingException extends RuntimeException {
		private static final long serialVersionUID = 5840716116919917394L;
		
		public PacketSendingException(String message, Throwable cause) {
			super(message, cause);
		}
	}
}