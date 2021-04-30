package fr.tinoou.memoris;

import org.bukkit.plugin.java.JavaPlugin;

import fr.tinoou.memoris.events.DeathEvent;
import fr.tinoou.memoris.events.JoinEvent;
import fr.tinoou.memoris.events.QuitEvent;
import fr.tinoou.memoris.commands.GiveMoney;
import fr.tinoou.memoris.commands.Money;
import fr.tinoou.memoris.commands.Pay;
import fr.tinoou.memoris.Main;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		saveDefaultConfig();
		
		//Events
		System.out.println("Le plugin est up en 1.2");
		getServer().getPluginManager().registerEvents(new DeathEvent(this), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		getServer().getPluginManager().registerEvents(new QuitEvent(this), this);
		
		//Commands
		getCommand("money").setExecutor(new Money(this));
		getCommand("pay").setExecutor(new Pay(this));
		getCommand("givemoney").setExecutor(new GiveMoney(this));
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
}
