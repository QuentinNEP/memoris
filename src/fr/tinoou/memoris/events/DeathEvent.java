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
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.tinoou.memoris.Main;

public class DeathEvent implements Listener {
	
private Main main;
	
	public DeathEvent(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		
		
		//Message
		Player player = event.getEntity();
		World world = player.getWorld();
		String causeOfDeath = player.getLastDamageCause().getCause().toString();
		//player.sendMessage(causeOfDeath);
		Boolean byPlayer = false;
		String key;
			
		switch(causeOfDeath) {
		  case "LAVA":
			key = "messages.death.lava";
			//player.sendMessage(key);
		    break;
		  case "FALL":
			key = "messages.death.fall";
			//player.sendMessage(key);
		    break;
		  case "ENTITY_ATTACK":
			if(player.getKiller() == null) {
				key = "messages.death.monsters";
				//player.sendMessage(key);
			}else {
				key = "messages.death.player";
				byPlayer = true;
				//player.sendMessage(key);
			}
		    break;
		  case "DROWNING":
				key = "messages.death.drowned";
				//player.sendMessage(key);
			    break;
		  case "SUFFOCATION":
				key = "messages.death.suffocation";
				//player.sendMessage(key);
			    break;
		  case "ENTITY_EXPLOSION":
				key = "messages.death.explosion";
				//player.sendMessage(key);
			    break;
		  case "PROJECTILE":
				key = "messages.death.projectile";
				//player.sendMessage(key);
			    break;
		  default:
			key = "messages.death.default";
			//player.sendMessage(key);
			}

		
		List<String> yourList = new ArrayList<String>();
		yourList.addAll(main.getConfig().getStringList(key));
		Integer randomnum = (int)(Math.random() * yourList.size());
		
		
		String message = yourList.get(randomnum).replace("%PLAYER%", player.getDisplayName()).replace("&", "§");
		
		if(byPlayer) {
			message = message.replace("%KILLER%", player.getKiller().getDisplayName());
			//player.sendMessage(player.getKiller().getDisplayName());
		}
		
		event.setDeathMessage(message);
		
		//.replace("%KILLER%", player.getKiller().getDisplayName())
		
		
		//Drops head at death
		ItemStack playerskull = new ItemStack(Material.LEGACY_SKULL_ITEM,1, (short) SkullType.PLAYER.ordinal());
		
		SkullMeta meta = (SkullMeta) playerskull.getItemMeta();
		meta.setOwner(player.getDisplayName());
		playerskull.setItemMeta(meta);
		
		world.dropItem(player.getLocation(), playerskull);
		
	}
}