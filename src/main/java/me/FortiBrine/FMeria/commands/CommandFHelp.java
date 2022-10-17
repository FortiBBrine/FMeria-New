package me.FortiBrine.FMeria.commands;

import me.FortiBrine.FMeria.FMeria;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class CommandFHelp implements CommandExecutor {

    private FMeria plugin;
    private File messages;
    public CommandFHelp(FMeria plugin) {
        this.plugin = plugin;
        messages = new File(plugin.getDataFolder()+File.separator+"messages.yml");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        YamlConfiguration messageConfig = YamlConfiguration.loadConfiguration(this.messages);

        for (String message : messageConfig.getStringList("message.help")) {
            sender.sendMessage(message);
        }

        return true;
    }
}
