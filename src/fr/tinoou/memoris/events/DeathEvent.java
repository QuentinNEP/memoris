package fr.tinoou.memoris.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import fr.tinoou.memoris.Main;

public class DeathEvent implements Listener {
	
private Main main;
	
	public DeathEvent(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		
		Player player = event.getEntity();
		World world = player.getWorld();
		
		List<String> yourList = new ArrayList<String>();
		yourList.addAll(main.getConfig().getStringList("messages.death"));
		Integer randomnum = (int)(Math.random() * yourList.size());
		
		event.setDeathMessage(yourList.get(randomnum).replace("%PLAYER%", player.getDisplayName()).replace("&", "§"));
		
		ItemStack playerskull = new ItemStack(Material.LEGACY_SKULL_ITEM,1, (short) SkullType.PLAYER.ordinal());
		
		SkullMeta meta = (SkullMeta) playerskull.getItemMeta();
		meta.setOwner(player.getDisplayName());
		playerskull.setItemMeta(meta);
		
		world.dropItem(player.getLocation(), playerskull);
		
	}
}