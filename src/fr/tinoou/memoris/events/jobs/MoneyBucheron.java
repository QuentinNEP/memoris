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

public class MoneyBucheron implements Listener {
	private Main main;
	
	public MoneyBucheron(Main main) {
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
		final ConfigurationSection configSectionValues = configValues.getConfigurationSection("logs");
		final int oldMoney = configSectionMoney.getInt("balance");
		//player.sendMessage(key);
		//player.sendMessage("test" + oldMoney);
		final int newMoney;
		//player.sendMessage("oui ?" + configSectionMoney.getInt("balance"));
		
		
		String metier = configSection.getString("metier");
		

		final String itemType = player.getInventory().getItemInMainHand().getType().name();
		//
		if(metier.equalsIgnoreCase("bucheron")) {
			//player.sendMessage(itemType);
			if (itemType.equalsIgnoreCase("WOOD_AXE") || itemType.equalsIgnoreCase("stone_axe") || itemType.equalsIgnoreCase("iron_AXE") || itemType.equalsIgnoreCase("golDEN_AXE") || itemType.equalsIgnoreCase("diamond_AXE") || itemType.equalsIgnoreCase("netherite_axe")) {
				//player.sendMessage(block.getType().toString());
				
					switch (block.getType().toString()) {
					case "OAK_LOG":
						newMoney = oldMoney + configSectionValues.getInt("oak");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "SPRUCE_LOG":
						newMoney = oldMoney + configSectionValues.getInt("spruce");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "BIRCH_LOG":
						newMoney = oldMoney + configSectionValues.getInt("birch");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "JUNGLE_LOG":
						newMoney = oldMoney + configSectionValues.getInt("jungle");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "ACACIA_LOG":
						newMoney = oldMoney + configSectionValues.getInt("acacia");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "DARK_OAK_LOG":
						newMoney = oldMoney + configSectionValues.getInt("dark_oak");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "CRIMSON_STEM":
						newMoney = oldMoney + configSectionValues.getInt("crimson");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "WARPED_STEM":
						newMoney = oldMoney + configSectionValues.getInt("warped");
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
