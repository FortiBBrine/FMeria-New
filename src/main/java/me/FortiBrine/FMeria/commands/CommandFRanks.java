package me.FortiBrine.FMeria.commands;

import me.FortiBrine.FMeria.FMeria;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CommandFRanks implements CommandExecutor {

    private FMeria plugin;
    private File messages;

    public CommandFRanks(FMeria plugin) {
        this.plugin = plugin;
        messages = new File(plugin.getDataFolder() + File.separator + "messages.yml");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        YamlConfiguration messageConfig = YamlConfiguration.loadConfiguration(this.messages);

        if (args.length < 2) return false;
        if (!sender.hasPermission(plugin.getDescription().getPermissions().get(3))) {
            sender.sendMessage(messageConfig.getString("message.factionRanksPermission"));
            return true;
        }
        if (!plugin.getConfig().getKeys(false).contains(args[0])) {
            sender.sendMessage(messageConfig.getString("message.factionNotExists"));
            return true;
        }

        List<String> ranks = new ArrayList<>();
        for (String arg : args) {
            ranks.add(arg);
        }
        ranks = ranks.subList(1, ranks.size());

        plugin.getConfig().set(args[0]+".ranks", ranks);

        plugin.saveConfig();
        plugin.reloadConfig();

        return true;
    }
}
