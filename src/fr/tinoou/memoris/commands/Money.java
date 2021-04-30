package fr.tinoou.memoris.commands;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import fr.tinoou.memoris.Main;

public class Money implements CommandExecutor {
	
	private Main main;
	
	public Money(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(label.equalsIgnoreCase("money")) {
			if(args.length == 0) {
				
				if (sender instanceof Player) {
					
					final Player player = (Player)sender;
					
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
				
				
				
				return true;
			}
			else {
				if (sender instanceof Player) {
					final Player player = (Player)sender;
					player.sendMessage("Pour utiliser la commande fais seulement /money");
				} 
				return false;
			}
		}
		
		return false;
	}

}
