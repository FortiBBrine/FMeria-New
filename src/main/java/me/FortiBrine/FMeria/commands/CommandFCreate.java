package me.FortiBrine.FMeria.commands;

import me.FortiBrine.FMeria.FMeria;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CommandFCreate implements CommandExecutor {

    private FMeria plugin;
    private File messages;

    public CommandFCreate(FMeria plugin) {
        this.plugin = plugin;
        messages = new File(plugin.getDataFolder() + File.separator + "messages.yml");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        YamlConfiguration messageConfig = YamlConfiguration.loadConfiguration(this.messages);

        if (args.length < 2) return false;

        if (!sender.hasPermission(plugin.getDescription().getPermissions().get(2))) {
            sender.sendMessage(messageConfig.getString("message.factionCreatePermission"));
            return true;
        }

        if (plugin.getConfig().getKeys(false).contains(args[0])) {
            sender.sendMessage(messageConfig.getString("message.factionExists"));
            return true;
        }

        String name;

        List<String> arguments = new ArrayList<>();
        for (String arg : args) arguments.add(arg);

        name = String.join(" ", arguments.subList(1, arguments.size()));

        plugin.getConfig().set(args[0] + ".name", name);

        plugin.saveConfig();
        plugin.reloadConfig();

        sender.sendMessage(messageConfig.getString("message.factionCreated"));

        return true;
    }

}