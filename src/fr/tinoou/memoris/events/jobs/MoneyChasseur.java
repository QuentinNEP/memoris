package fr.tinoou.memoris.events.jobs;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import fr.tinoou.memoris.Main;

public class MoneyChasseur implements Listener {
	private Main main;
	
	public MoneyChasseur(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onMobKilled(EntityDeathEvent event) {
		Player player = event.getEntity().getKiller();
		
		
		if(player != null) {
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
			final ConfigurationSection configSectionValues = configValues.getConfigurationSection("mobs");
			final int oldMoney = configSectionMoney.getInt("balance");
			//player.sendMessage(key);
			//player.sendMessage("test" + oldMoney);
			final int newMoney;
			//player.sendMessage("oui ?" + configSectionMoney.getInt("balance"));
			
			
			String metier = configSection.getString("metier");
			if(metier.equalsIgnoreCase("chasseur")) {
				String entityKilled = event.getEntityType().toString();
				//player.sendMessage(event.getEntityType().toString());
				switch (entityKilled) {
				case "PLAYER":
					newMoney = oldMoney + configSectionValues.getInt("player");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "CAVE_SPIDER":
					newMoney = oldMoney + configSectionValues.getInt("cave_spider");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "HOGLIN":
					newMoney = oldMoney + configSectionValues.getInt("hoglin");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "GUARDIAN":
					newMoney = oldMoney + configSectionValues.getInt("guardian");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "ENDERMAN":
					newMoney = oldMoney + configSectionValues.getInt("enderman");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "GHAST":
					newMoney = oldMoney + configSectionValues.getInt("ghast");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "EVOKER":
					newMoney = oldMoney + configSectionValues.getInt("evoker");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "ELDER_GUARDIAN":
					newMoney = oldMoney + configSectionValues.getInt("elder_guardian");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "DROWNED":
					newMoney = oldMoney + configSectionValues.getInt("drowned");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "STRAY":
					newMoney = oldMoney + configSectionValues.getInt("stray");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "ZOGLIN":
					newMoney = oldMoney + configSectionValues.getInt("zoglin");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "PILLAGER":
					newMoney = oldMoney + configSectionValues.getInt("pillager");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "PIGLIN_BRUTE":
					newMoney = oldMoney + configSectionValues.getInt("piglin_brute");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "PIGLIN":
					newMoney = oldMoney + configSectionValues.getInt("piglin");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "PHANTOM":
					newMoney = oldMoney + configSectionValues.getInt("phantom");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "MAGMA_CUBE":
					newMoney = oldMoney + configSectionValues.getInt("magma_cube");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "ZOMBIE":
					newMoney = oldMoney + configSectionValues.getInt("zombie");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "HUSK":
					newMoney = oldMoney + configSectionValues.getInt("husk");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "RAVAGER":
					newMoney = oldMoney + configSectionValues.getInt("ravager");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "SILVERFISH":
					newMoney = oldMoney + configSectionValues.getInt("silverfish");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "SKELETON":
					newMoney = oldMoney + configSectionValues.getInt("skeleton");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "ZOMBIFIED_PIGLIN":
					newMoney = oldMoney + configSectionValues.getInt("zombified_piglin");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "VINDICATOR":
					newMoney = oldMoney + configSectionValues.getInt("vindicator");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "WITCH":
					newMoney = oldMoney + configSectionValues.getInt("witch");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "WITHER_SKELETON":
					newMoney = oldMoney + configSectionValues.getInt("wither_skeleton");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "CREEPER":
					newMoney = oldMoney + configSectionValues.getInt("creeper");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "SPIDER":
					newMoney = oldMoney + configSectionValues.getInt("spider");
					//player.sendMessage("Ta banque contient désormais " + newMoney);
					configMoney.set(key +".balance" , newMoney);
					
					try {
						configMoney.save(fileMoney);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "SLIME":
					newMoney = oldMoney + configSectionValues.getInt("slime");
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
			
			
			
			return;
			
		}
		
		
	}
}
