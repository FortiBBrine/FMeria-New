package me.FortiBrine.FMeria.utils;

import me.FortiBrine.FMeria.commands.*;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import me.FortiBrine.FMeria.FMeria;
import me.FortiBrine.FMeria.listeners.LawInventoryListener;

public class loadUtil {
	
	public static void loadTabCompleters(FMeria plugin) {
		
		plugin.getCommand("setrank").setTabCompleter(new CommandSetrank(plugin));
	}
	
	public static void loadCommands(FMeria plugin) {
		
		plugin.getCommand("f").setExecutor(new CommandFLeave(plugin));
		plugin.getCommand("fmeria").setExecutor(new CommandFMeria(plugin));
		plugin.getCommand("invite").setExecutor(new CommandInvite(plugin));
		plugin.getCommand("inv").setExecutor(new CommandInv(plugin));
		plugin.getCommand("uprang").setExecutor(new CommandUprang(plugin));
		plugin.getCommand("fblock").setExecutor(new CommandFBlock(plugin));
		plugin.getCommand("funblock").setExecutor(new CommandFunBlock(plugin));
		plugin.getCommand("downrang").setExecutor(new CommandDownrang(plugin));
		plugin.getCommand("rb").setExecutor(new CommandRb(plugin));
		plugin.getCommand("fvig").setExecutor(new CommandFVig(plugin));
		plugin.getCommand("funvig").setExecutor(new CommandFunVig(plugin));
		plugin.getCommand("gov").setExecutor(new CommandGov(plugin));
		plugin.getCommand("uninvite").setExecutor(new CommandUninvite(plugin));
		plugin.getCommand("fonline").setExecutor(new CommandFonline(plugin));
		plugin.getCommand("d").setExecutor(new CommandD(plugin));
		plugin.getCommand("rr").setExecutor(new CommandR(plugin));
		plugin.getCommand("fhome").setExecutor(new CommandFhome(plugin));
		plugin.getCommand("leaders").setExecutor(new CommandLeaders(plugin));
	
		plugin.getCommand("makeleader").setExecutor(new CommandMakeleader(plugin));
		plugin.getCommand("hp").setExecutor(new CommandHP(plugin));
		plugin.getCommand("law").setExecutor(new CommandLaw(plugin));
		
		plugin.getCommand("fbalance").setExecutor(new CommandFbalance(plugin));
		plugin.getCommand("setfhome").setExecutor(new CommandSetfhome(plugin));
		plugin.getCommand("setfname").setExecutor(new CommandSetfname(plugin));
		plugin.getCommand("setrank").setExecutor(new CommandSetrank(plugin));
		plugin.getCommand("setsalary").setExecutor(new CommandSetsalary(plugin));

		plugin.getCommand("fhelp").setExecutor(new CommandFHelp(plugin));
		plugin.getCommand("fcreate").setExecutor(new CommandFCreate(plugin));
		plugin.getCommand("franks").setExecutor(new CommandFRanks(plugin));
	}
	
	public static void loadListeners(FMeria plugin) {
		PluginManager pluginManager = Bukkit.getPluginManager();
		
		pluginManager.registerEvents(new LawInventoryListener(plugin), plugin);
	}

}
