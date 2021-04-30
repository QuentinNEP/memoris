package fr.tinoou.memoris.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.tinoou.memoris.Main;

public class QuitEvent implements Listener {
	
	private Main main;
	
	public QuitEvent(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onJoin(PlayerQuitEvent e) {
		
		//Player player = e.getPlayer();
		//String playerName = player.getDisplayName();
		//e.setQuitMessage("§fBisous bisous mon ptit amour §e" + playerName + "§f!");
		
		Player player = e.getPlayer();
		String playerName = player.getDisplayName();
		List<String> yourList = new ArrayList<String>();
		yourList.addAll(main.getConfig().getStringList("messages.quit"));
		Integer randomnum = (int)(Math.random() * yourList.size());
		
		e.setQuitMessage(yourList.get(randomnum).replace("%PLAYER%", playerName).replace("&", "§"));
		
	}
	
}
