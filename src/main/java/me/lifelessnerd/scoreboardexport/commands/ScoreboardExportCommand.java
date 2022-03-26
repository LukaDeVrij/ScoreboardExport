package me.lifelessnerd.scoreboardexport.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.time.Period;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ScoreboardExportCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("exportscoreboard")){

            ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
            Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
            Set<Objective> objectives = scoreboard.getObjectives();

            ArrayList masterScoresList = new ArrayList();

            Set<String> entries = scoreboard.getEntries();

            for (Objective objective : objectives){

                //Get all entries and put their scores in a hashmap with their name as key
                HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
                scoreMap.put(objective.getName(), -1);
                for (String entry : entries) {
                    Score score = objective.getScore(entry);
                    int scoreInt = score.getScore();
                    scoreMap.put(entry, scoreInt);
                }
                masterScoresList.add(scoreMap);

            }

            String output = masterScoresList.toString();
            output = output.replaceAll(" ", "");
            System.out.println(output);
            return true;
        } else { return false; }

    }
}
