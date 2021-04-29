package fr.tinoou.memoris.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

	@EventHandler
	public void onJoin(PlayerQuitEvent e) {
		
		Player player = e.getPlayer();
		String playerName = player.getDisplayName();
		e.setQuitMessage("§fBisous bisous mon ptit amour §e" + playerName + "§f!");
		
	}
	
}
