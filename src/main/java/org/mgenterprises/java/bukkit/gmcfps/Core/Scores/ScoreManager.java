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
package org.mgenterprises.java.bukkit.gmcfps.Core.Scores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import org.bukkit.entity.Player;
import org.mgenterprises.java.bukkit.gmcfps.Core.FPSCore;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Events.PlayerKilledByPlayerEvent;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Listeners.PlayerKilledByPlayerListener;

/**
 * Manages scores for the games.
 *
 * @author Manuel Gauto
 */
public class ScoreManager implements PlayerKilledByPlayerListener {

    private HashMap<String, PlayerStats> stats = new HashMap<String, PlayerStats>();
    private FPSCore core;

    /**
     * System for recording scores during the game.
     *
     * @param core
     */
    public ScoreManager(FPSCore core) {
        this.core = core;
    }

    /**
     * Override method for PlayerKilledByPlayerEvent
     *
     * @param event Event instance passed in
     */
    @Override
    public void onPlayerKilledByPlayerEvent(PlayerKilledByPlayerEvent event) {
        //lets start converting
        String killerName = event.getKiller().getName();
        PlayerStats killerStats = stats.get(killerName);
        killerStats.registerKill(event);
        this.stats.put(killerName, killerStats);

        String victimName = event.getVictim().getName();
        PlayerStats victimStats = stats.get(victimName);
        victimStats.registerDeath();
        this.stats.put(victimName, victimStats);
    }

    public PlayerStats getPlayerStats(Player p) {
        return this.stats.get(p.getName());
    }
    
    public ArrayList<PlayerStats> getSortedPlayerStatsMap(){
        ArrayList psList = new ArrayList<PlayerStats>(stats.values());
        Collections.sort(psList , new PlayerStatsComparator());
        return psList;
    }
    
    public void printTopScores(ArrayList<PlayerStats> statsList){
        for(PlayerStats ps : statsList){
            System.out.println();
            
        }
    }
}

class PlayerStatsComparator implements Comparator<PlayerStats> {

    @Override
    public int compare(PlayerStats a, PlayerStats b) {
        if (a.getKills() >= b.getKills()) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}