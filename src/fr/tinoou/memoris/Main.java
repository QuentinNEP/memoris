package fr.tinoou.memoris;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("Le plugin est up");
		getServer().getPluginManager().registerEvents(new eventsListener(), this);
	}
	
}
