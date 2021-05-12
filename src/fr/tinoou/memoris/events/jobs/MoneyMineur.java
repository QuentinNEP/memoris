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



public class MoneyMineur implements Listener {

	private Main main;
	
	public MoneyMineur(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onDestroy(BlockBreakEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();
		event.getEventName();
		
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
		final ConfigurationSection configSectionValues = configValues.getConfigurationSection("ores");
		final int oldMoney = configSectionMoney.getInt("balance");
		//player.sendMessage(key);
		//player.sendMessage("test" + oldMoney);
		final int newMoney;
		//player.sendMessage("oui ?" + configSectionMoney.getInt("balance"));
		
		
		String metier = configSection.getString("metier");
		
		final String itemType = player.getInventory().getItemInMainHand().getType().name();
		//
		if(metier.equalsIgnoreCase("mineur")) {
			
			if (itemType.equalsIgnoreCase("WOODEN_PICKAXE") || itemType.equalsIgnoreCase("stone_pickaxe") || itemType.equalsIgnoreCase("iron_PICKAXE") || itemType.equalsIgnoreCase("golDEN_PICKAXE") || itemType.equalsIgnoreCase("diamond_PICKAXE") || itemType.equalsIgnoreCase("netherite_pickaxe")) {
				
					//player.sendMessage(block.getType().toString());
					switch (block.getType().toString()) {
					case "STONE":
						
						newMoney = oldMoney + configSectionValues.getInt("stone");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "DIAMOND_ORE":
						newMoney = oldMoney + configSectionValues.getInt("diamond");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "LAPIS_ORE":
						newMoney = oldMoney + configSectionValues.getInt("lapis");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "REDSTONE_ORE":
						newMoney = oldMoney + configSectionValues.getInt("redstone");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "IRON_ORE":
						newMoney = oldMoney + configSectionValues.getInt("iron");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "COAL_ORE":
						newMoney = oldMoney + configSectionValues.getInt("coal");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "GOLD_ORE":
						newMoney = oldMoney + configSectionValues.getInt("gold");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "NETHER_GOLD_ORE":
						newMoney = oldMoney + configSectionValues.getInt("nether_gold");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "EMERALD_ORE":
						newMoney = oldMoney + configSectionValues.getInt("emerald");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "NETHER_QUARTZ_ORE":
						newMoney = oldMoney + configSectionValues.getInt("nether_quartz");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "GRANITE":
						newMoney = oldMoney + configSectionValues.getInt("granite");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "ANDESITE":
						newMoney = oldMoney + configSectionValues.getInt("andesite");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "DIORITE":
						newMoney = oldMoney + configSectionValues.getInt("diorite");
						//player.sendMessage("Ta banque contient désormais " + newMoney);
						configMoney.set(key +".balance" , newMoney);
						
						try {
							configMoney.save(fileMoney);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "ANCIENT_DEBRIS":
						newMoney = oldMoney + configSectionValues.getInt("netherite");
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
