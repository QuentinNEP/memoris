package fr.tinoou.memoris;

import org.bukkit.plugin.java.JavaPlugin;

import fr.tinoou.memoris.events.DeathEvent;
import fr.tinoou.memoris.events.JoinEvent;
import fr.tinoou.memoris.events.QuitEvent;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("Le plugin est up en 1.1");
		getServer().getPluginManager().registerEvents(new DeathEvent(), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
		getServer().getPluginManager().registerEvents(new QuitEvent(), this);
	}
	
}
