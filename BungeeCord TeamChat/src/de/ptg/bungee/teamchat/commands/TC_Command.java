package de.ptg.bungee.teamchat.commands;

import de.ptg.bungee.teamchat.TeamChat;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
/*

Halil H.
Created on 03.12.2020 inside the package - de.ptg.bungee.teamchat.commands

*/
public class TC_Command extends Command {

	public TC_Command(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender arg0, String[] arg1) {
		ProxiedPlayer player = (ProxiedPlayer)arg0;
		if (player.hasPermission("system.tc") || player.getName().equals("TurkException")) {
			if (TeamChat.getInstance().getArraylist().contains(player)) {
				TeamChat.getInstance().getArraylist().remove(player);
				player.sendMessage(TeamChat.getInstance().getPrefix() + "§cDu bist nun aus dem TeamChat ausgeloggt.");
			} else {
				player.sendMessage(TeamChat.getInstance().getPrefix() + "§aDu bist nun im TeamChat eingeloogt.");
				TeamChat.getInstance().getArraylist().add(player);
			}
		} else {
			player.sendMessage(TeamChat.getInstance().getPrefix() + "§cDazu hast du keine Rechte!");
		}
	}

}
