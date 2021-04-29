package fr.tinoou.memoris.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player player = e.getPlayer();
		String playerName = player.getDisplayName();
		e.setJoinMessage("§fHello ptit bg de la night §e" + playerName + "§f!");
		
	}
	
}
