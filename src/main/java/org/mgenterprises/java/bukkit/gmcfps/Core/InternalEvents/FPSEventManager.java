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
package org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents;

import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Events.ScoreStreakReachedEvent;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Sources.PlayerHurtByPlayerSource;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Sources.PlayerJoinedTeamSource;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Sources.PlayerKilledByPlayerSource;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Sources.PlayerLeftTeamSource;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Sources.ScoreStreakReachedSource;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Sources.WeaponFiredSource;

/**
 *
 * @author Manuel Gauto
 */
public class FPSEventManager {
    private PlayerKilledByPlayerSource playerKilledSource = new PlayerKilledByPlayerSource();
    private PlayerHurtByPlayerSource playerHurtSource = new PlayerHurtByPlayerSource();
    private PlayerJoinedTeamSource playerJoinedTeam = new PlayerJoinedTeamSource();
    private WeaponFiredSource wfs = new WeaponFiredSource();
    private PlayerLeftTeamSource playerLeftTeam = new PlayerLeftTeamSource();
    private ScoreStreakReachedSource scoreStreakSource = new ScoreStreakReachedSource();
    
    public WeaponFiredSource getWeaponFiredSource(){
        return this.wfs;
    }
    
    public ScoreStreakReachedSource getScoreStreakSource(){
        return scoreStreakSource;
    }
    
    public PlayerKilledByPlayerSource getPlayerKilledSource(){
        return this.playerKilledSource;
    }
    
    public PlayerHurtByPlayerSource getPlayerHurtSource(){
        return this.playerHurtSource;
    }
    
    public PlayerJoinedTeamSource getPlayerJoinedTeamSource(){
        return this.playerJoinedTeam;
    }
    
    public PlayerLeftTeamSource getPlayerLeftTeamSource(){
        return this.playerLeftTeam;
    }
}
