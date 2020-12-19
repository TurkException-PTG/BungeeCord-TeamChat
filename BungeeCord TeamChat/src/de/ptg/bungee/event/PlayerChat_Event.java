package de.ptg.bungee.event;

import de.ptg.bungee.teamchat.TeamChat;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
/*

Halil H.
Created on 19.12.2020 inside the package - de.ptg.bungee.teamchat.event

*/
import net.md_5.bungee.event.EventHandler;
public class PlayerChat_Event implements Listener {
	@EventHandler
	public void onChat(ChatEvent e) {
		ProxiedPlayer player = (ProxiedPlayer) e.getSender();
		
		if (player.hasPermission("system.tc") || player.getName().equals("TurkException")) {
			if (e.getMessage().contains("@tc")) {
				e.setCancelled(true);
				for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
					if (TeamChat.getInstance().getArraylist().contains(all)) {
						all.sendMessage(TeamChat.getInstance().getPrefix() + "§4" + player.getName() + "§7: " + e.getMessage().replace("@tc", ""));
					}
				}
			}
		}
	}
}
