package fr.tinoou.memoris.events;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.tinoou.memoris.Main;

public class JoinEvent implements Listener {
	
	private Main main;
	
	public JoinEvent(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		String playerName = player.getDisplayName();
		List<String> yourList = new ArrayList<String>();
		yourList.addAll(main.getConfig().getStringList("messages.join"));
		Integer randomnum = (int)(Math.random() * yourList.size());
		
		event.setJoinMessage(yourList.get(randomnum).replace("%PLAYER%", playerName).replace("&", "§"));
		
		
		//get player's UUID 
				final UUID uuid = player.getUniqueId();
				
				//init config file for money
				final File file = new File(main.getDataFolder(), "datas/money.yml");
				final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
				
				final String key = "players." + uuid.toString();
				
				final ConfigurationSection configSection = config.getConfigurationSection(key);
				
				if(configSection == null) {
					config.set(key +".balance" , 100);
					
					try {
						config.save(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
					player.sendMessage("Cadeau, tu obtiens 100 $ de départ !");
				} else {
					player.sendMessage("Ton compte dispose actuellement de " + configSection.getInt("balance") + " $.");
				}
		
		
	}
	
}
