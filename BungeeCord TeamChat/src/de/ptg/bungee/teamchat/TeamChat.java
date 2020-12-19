package de.ptg.bungee.teamchat;

import java.util.ArrayList;

import de.ptg.bungee.event.PlayerChat_Event;
import de.ptg.bungee.teamchat.commands.TC_Command;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;

/*

Halil H.
Created on 03.12.2020 inside the package - de.ptg.bungee.teamchat

*/
public class TeamChat extends Plugin{
	private final String Prefix = "§7[§4TC§7] ";
	private static TeamChat instance;
	private final ArrayList<ProxiedPlayer> teamchat = new ArrayList<>();
	
	@Override
	public void onEnable() {
		instance = this;
        BungeeCord.getInstance().getPluginManager().registerCommand(this, new TC_Command("tc"));
        BungeeCord.getInstance().getPluginManager().registerListener(this, new PlayerChat_Event());
	}
	
	public static TeamChat getInstance() {
		return instance;
	}
	public String getPrefix() {
		return Prefix;
	}
	public ArrayList<ProxiedPlayer> getArraylist(){
		return teamchat;
	}
}
