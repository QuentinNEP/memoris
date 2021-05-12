package fr.tinoou.memoris.events.jobs;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import fr.tinoou.memoris.Main;

public class MoneyTerraformage implements Listener {
	private Main main;
	
	public MoneyTerraformage(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onDestroy(BlockBreakEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();
		UUID uuid = player.getUniqueId();
		
		//init config file for money
		final File fileMetier = new File(main.getDataFolder(), "datas/metiers.yml");
		final YamlConfiguration configMetier = YamlConfiguration.loadConfiguration(fileMetier);
		final File fileValues = new File(main.getDataFolder(), "datas/values.yml");
		final YamlConfiguration configValues = YamlConfiguration.loadConfiguration(fileValues);
		final File fileMoney = new File(main.getDataFolder(), "datas/money.yml");
		final YamlConfiguration configMoney = YamlConfiguration.loadConfiguration(fileMoney);
		
		final String key = "players." + uuid.toString();
		
		final ConfigurationSection configSection = configMetier.getConfigurationSection(key);
		final ConfigurationSection configSectionMoney = configMoney.getConfigurationSection(key);
		final ConfigurationSection configSectionValues = configValues.getConfigurationSection("dusts");
		final int oldMoney = configSectionMoney.getInt("balance");
		//player.sendMessage(key);
		//player.sendMessage("test" + oldMoney);
		final int newMoney;
		//player.sendMessage("oui ?" + configSectionMoney.getInt("balance"));
		
		
		String metier = configSection.getString("metier");

		final String itemType = player.getInventory().getItemInMainHand().getType().name();
		//
		if(metier.equalsIgnoreCase("terraformage")) {
			//player.sendMessage(itemType);
			if (itemType.equalsIgnoreCase("WOODEN_shovel") || itemType.equalsIgnoreCase("stone_shovel") || itemType.equalsIgnoreCase("iron_shovel") || itemType.equalsIgnoreCase("golDEN_shovel") || itemType.equalsIgnoreCase("diamond_shovel") || itemType.equalsIgnoreCase("netherite_shovel")) {
				//player.sendMessage(block.getType().toString());
					//player.sendMessage(block.getType().toString());
					switch (block.getType().toString()) {
					case "GRASS_BLOCK":
						newMoney = oldMoney + configSectionValues.getInt("grass");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "DIRT":
						newMoney = oldMoney + configSectionValues.getInt("dirt");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "COARSE_DIRT":
						newMoney = oldMoney + configSectionValues.getInt("coarse_dirt");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "PODZOL":
						newMoney = oldMoney + configSectionValues.getInt("podzol");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "SAND":
						newMoney = oldMoney + configSectionValues.getInt("sand");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "RED_SAND":
						newMoney = oldMoney + configSectionValues.getInt("red_sand");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "GRAVEL":
						newMoney = oldMoney + configSectionValues.getInt("gravel");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					default:
						break;
					}
				}
				
			
			
		}
		
		
	}
}
