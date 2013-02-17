/*
 * The MIT License
 *
 * Copyright 2013 MANUEL.
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
package org.mgenterprises.java.bukkit.gmcfps.Core.Scores.ScoreStreaks;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.entity.Player;
import org.mgenterprises.java.bukkit.gmcfps.Core.FPSCore;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Events.PlayerKilledByPlayerEvent;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Listeners.PlayerKilledByPlayerListener;

/**
 *
 * @author MANUEL
 */
public class ScoreStreakManager implements PlayerKilledByPlayerListener {

    private HashMap<String, Integer> streaks = new HashMap<String, Integer>();
    private FPSCore core;
    private HashMap<Integer, ScoreStreak> streakTriggers = new HashMap<Integer, ScoreStreak>();
    
    
    public ScoreStreakManager(FPSCore core) {
        this.core = core;
    }
    
    public void addTrigger(ScoreStreak ss){
        //this.streakTriggers.put(, ss)
    }

    @Override
    public void onPlayerKilledByPlayerEvent(PlayerKilledByPlayerEvent event) {
        checkIfEntryExists(event.getKiller());
        int oldStreak = streaks.get(event.getKiller().getName());
        streaks.put(event.getKiller().getName(), oldStreak+1);
        checkForStreak(event.getKiller());
        
        checkIfEntryExists(event.getVictim());
        streaks.remove(event.getVictim().getName());
    }

    private void checkForStreak(Player p){
        //for(Integer trigger : streakTriggers){
          //  if()
        //}
    }
    
    private void checkIfEntryExists(Player p) {
        if (!streaks.containsKey(p.getName())) {
            streaks.put(p.getName(), 0);
        }
    }
}
