package fr.tinoou.memoris.commands;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import fr.tinoou.memoris.Main;

public class Pay implements CommandExecutor {

	private Main main;
	
	public Pay(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("pay")) {
			if(args.length == 2) {
				
				if (sender instanceof Player) {
					
					final Player player = (Player)sender;
					
					if (Bukkit.getPlayer(args[0]) != null) {
						final int amount = Integer.parseInt(args[1]);
						
						if(amount > 0) {
							final Player target = Bukkit.getPlayer(args[0]);
							
							final UUID playerUuid = player.getUniqueId();
							final UUID targetUuid = target.getUniqueId();
							
							//init config file for money
							final File file = new File(main.getDataFolder(), "datas/money.yml");
							final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
							
							final String keySender = "players." + playerUuid.toString();
							final String keyTarget = "players." + targetUuid.toString();
							
							final ConfigurationSection configSectionSender = config.getConfigurationSection(keySender);
							final ConfigurationSection configSectionTarget = config.getConfigurationSection(keyTarget);
							
							if (configSectionSender != null && configSectionTarget != null) {
								
								final int senderNewBalance = configSectionSender.getInt("balance") - amount;
								
								if (senderNewBalance >= 0) {
									final int targetNewBalance = configSectionTarget.getInt("balance") + amount;
									
									config.set(keySender +".balance" , senderNewBalance);
									config.set(keyTarget +".balance" , targetNewBalance);
									
									try {
										config.save(file);
									} catch (IOException e) {
										e.printStackTrace();
									}
									player.sendMessage("Tu envoies " + amount + " $ à " + target.getDisplayName() + ".");
									target.sendMessage("Tu recois " + amount + " $ de " + player.getDisplayName() + ".");
								}else {
									player.sendMessage("Tu ne peux pas donner de l'argent dont tu ne dispose pas.");
								}
								
								
							
							} 
			
							
						}else {
							player.sendMessage("Entre un montant correct.");
						}
						
						
						
						
					}else {
						player.sendMessage("Entre le nom d'un joueur connecté");
					}
					
				}
				
				return true;
			}
			else {
				if (sender instanceof Player) {
					final Player player = (Player)sender;
					player.sendMessage("Pour utiliser la commande fais /pay <joueur ciblé> <montant>.");
				} 
				return false;
			}
		}
		return false;
	}

}
