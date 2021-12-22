package me.lifelessnerd.scoreboardexport;

import me.lifelessnerd.scoreboardexport.commands.ScoreboardExportCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.Set;

public final class ScoreboardExport extends JavaPlugin {

    @Override
    public void onEnable() {

        System.out.println("Starting plugin ScoreboardExport");
        getCommand("exportscoreboard").setExecutor(new ScoreboardExportCommand());

    }

}
