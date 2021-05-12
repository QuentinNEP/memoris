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

public class Metier implements CommandExecutor {
	
	private Main main;
	
	public Metier(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			final Player player = (Player)sender;
			
			
			//get player's UUID 
			final UUID uuid = player.getUniqueId();
			
			//init config file for money
			final File file = new File(main.getDataFolder(), "datas/metiers.yml");
			final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
			
			final String key = "players." + uuid.toString();
			
			final ConfigurationSection configSection = config.getConfigurationSection(key);
			
			if(label.equalsIgnoreCase("metier")) {
				if (args.length == 0) {
					
					
					if(configSection == null) {
						player.sendMessage("Tu n'as pas encore de m�tier.");
						player.sendMessage("Tu peux faire /metier liste pour avoir la liste des m�tiers.");
						player.sendMessage("Tu peux faire /metier join <metier> pour rejoindre le m�tier de ton choix.");
					} else {
						player.sendMessage("Ton m�tier actuel est " + configSection.getString("metier") + " .");
					}
					
				}else {
					if(args[0].equalsIgnoreCase("liste")) {
						
						final String keyMetiers = "metiers";
						final ConfigurationSection configSectionMetiers = config.getConfigurationSection(keyMetiers);
						
						player.sendMessage(configSectionMetiers.getString("mineur.name") + " :");
						player.sendMessage(configSectionMetiers.getString("mineur.description"));
						
						player.sendMessage("");
						player.sendMessage(configSectionMetiers.getString("bucheron.name") + " :");
						player.sendMessage(configSectionMetiers.getString("bucheron.description"));
						
						player.sendMessage("");
						player.sendMessage(configSectionMetiers.getString("chasseur.name") + " :");
						player.sendMessage(configSectionMetiers.getString("chasseur.description"));
						
						player.sendMessage("");
						player.sendMessage(configSectionMetiers.getString("terraformage.name") + " :");
						player.sendMessage(configSectionMetiers.getString("terraformage.description"));
						
						
						
					}else if(args[0].equalsIgnoreCase("join")) {
						if (args.length == 2) {
							switch (args[1]) {
							case "mineur":
								
								if(configSection == null) {
									player.sendMessage("Tu es d�sormais mineur");
									Bukkit.broadcastMessage("[BROADCAST]" + player.getDisplayName() + " devient mineur !");
									config.set(key +".metier" , "mineur");
									
									try {
										config.save(file);
									} catch (IOException e) {
										e.printStackTrace();
									}
								}else {
									player.sendMessage("D�sol� mais tu es d�j� " + configSection.getString("metier"));
								}
								break;
							case "bucheron":
								if(configSection == null) {
									player.sendMessage("Tu es d�sormais bucheron");
									Bukkit.broadcastMessage("[BROADCAST]" + player.getDisplayName() + " devient bucheron !");
									config.set(key +".metier" , "bucheron");
									
									try {
										config.save(file);
									} catch (IOException e) {
										e.printStackTrace();
									}
								}else {
									player.sendMessage("D�sol� mais tu es d�j� " + configSection.getString("metier"));
								}
								break;
							case "chasseur":
								if(configSection == null) {
									player.sendMessage("Tu es d�sormais chasseur");
									Bukkit.broadcastMessage("[BROADCAST]" + player.getDisplayName() + " devient chasseur !");
									config.set(key +".metier" , "chasseur");
									
									try {
										config.save(file);
									} catch (IOException e) {
										e.printStackTrace();
									}
								}else {
									player.sendMessage("D�sol� mais tu es d�j� " + configSection.getString("metier"));
								}
								break;
							case "terraformage":
								if(configSection == null) {
									player.sendMessage("Tu es d�sormais terraformage");
									Bukkit.broadcastMessage("[BROADCAST]" + player.getDisplayName() + " devient terraformage !");
									config.set(key +".metier" , "terraformage");
									
									try {
										config.save(file);
									} catch (IOException e) {
										e.printStackTrace();
									}
								}else {
									player.sendMessage("D�sol� mais tu es d�j� " + configSection.getString("metier"));
								}
								break;
							default:
								player.sendMessage("Entre un m�tier correct");
								break;
							}
						}
					}
				}
			}
		}
		
		
		return false;
	}

}
