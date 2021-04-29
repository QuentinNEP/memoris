package fr.tinoou.memoris;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class eventsListener implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		
		Player player = event.getEntity();
		World world = player.getWorld();
		event.setDeathMessage(player.getDisplayName() + " a cassé sa pipe.");
		
		ItemStack playerskull = new ItemStack(Material.LEGACY_SKULL_ITEM,1, (short) SkullType.PLAYER.ordinal());
		
		SkullMeta meta = (SkullMeta) playerskull.getItemMeta();
		meta.setOwner(player.getDisplayName());
		playerskull.setItemMeta(meta);
		
		world.dropItem(player.getLocation(), playerskull);
		
	}
}
