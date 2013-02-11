/*
 * The MIT License
 *
 * Copyright 2013 Manuel Gauto.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.mgenterprises.java.bukkit.gmcfps.Core.BasicCommands;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mgenterprises.java.bukkit.gmcfps.Core.FPSCore;
import org.mgenterprises.java.bukkit.gmcfps.Core.GameManagement.GameManager;
import org.mgenterprises.java.bukkit.gmcfps.Core.Scores.PlayerStats;

/**
 *
 * @author Manuel Gauto
 */
public class ScoreCommands implements CommandExecutor{

    private GameManager gm;
    
    public ScoreCommands(GameManager gm){
        this.gm = gm;
    }
    
    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if(string.equalsIgnoreCase(Commands.TOP.toString())){
            if(cs instanceof Player){
                Player p = (Player)cs;
                return executeTop(p);
            }
        } else if(string.equalsIgnoreCase(Commands.SCORE.toString())){
            if(cs instanceof Player){
                Player p = (Player)cs;
                return executeScore(p);
            }
        }
        return false;
    }
    
    private boolean executeTop(Player p){
        if(gm.getPlayerGame(p) == null){
            p.sendRawMessage(ChatColor.RED+"You are not in a game!");
            return true;
        }
        if(!p.hasPermission("gfps.top")){
            p.sendRawMessage("You do not have permission to do that!");
            return true;
        }
        FPSCore core = gm.getPlayerGame(p).getFPSCore();
        ArrayList<PlayerStats> stats = core.getScoreManager().getSortedPlayerStatsMap();
        core.getScoreManager().printTopScores(p, stats);
        return true;
    }
    
    private boolean executeScore(Player p){
        if(gm.getPlayerGame(p) == null){
            p.sendRawMessage(ChatColor.RED+"You are not in a game!");
            return true;
        }
        if(!p.hasPermission("gfps.top")){
            p.sendRawMessage("You do not have permission to do that!");
            return true;
        }
        FPSCore core = gm.getPlayerGame(p).getFPSCore();
        PlayerStats pStats = core.getScoreManager().getPlayerStats(p);
        p.sendRawMessage(ChatColor.BLUE+ "Your Stats: Kills: "+pStats.getKills()+" Deaths: "+pStats.getDeaths()+" K/D: "+pStats.getKillDeathRatio());
        return true;
    }
}
