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

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Set;

public class ScoreboardExportCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("exportscoreboard")){

            System.out.println("command recognised");
            ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
            System.out.println(scoreboardManager.toString());
            Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
            System.out.println(scoreboard.toString());
            HashMap<String, Integer> scoresMap = new HashMap<String, Integer>();
            Set<Objective> objectives = scoreboard.getObjectives();
            Set<String> entries = scoreboard.getEntries();
            if (args[0] != null) {

                Objective currentObjective = scoreboard.getObjective(args[0]);

                System.out.println(currentObjective.getName());
                for (String entryName : entries) {
                    if (entryName != null) {
                        Score entryScore = currentObjective.getScore(entryName);
                        int entryIntScore = entryScore.getScore();
                        scoresMap.put(entryName, entryIntScore);
                    }
                    else
                    {
                        sender.sendMessage("The scoreboard does not have any entries.");
                    }
                }
            } else
            {
                sender.sendMessage("Add an argument please!");
            }




            System.out.println(scoresMap);
            //System.out.println(objectives);
//            Objective objective = scoreboard.getObjective("TicksPlayed");
//            Score score = objective.getScore("DominanceTM");
//            System.out.println(score.getScore());
        }
        return true;
    }
}
