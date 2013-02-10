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
package org.mgenterprises.java.bukkit.gmcfps.Core;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.mgenterprises.java.bukkit.gmcfps.Core.GameManagement.Game;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.FPSEventManager;
import org.mgenterprises.java.bukkit.gmcfps.Core.Scores.ScoreManager;
import org.mgenterprises.java.bukkit.gmcfps.Core.Teams.TeamManager;
import org.mgenterprises.java.bukkit.gmcfps.Core.Weapons.WeaponManager;

/**
 *
 * @author Manuel Gauto
 */
public class FPSCore {
    private ScoreManager scoreManager = new ScoreManager();
    private WeaponManager weaponManager = new WeaponManager();
    private FPSEventManager eventManager = new FPSEventManager();
    private TeamManager teamManager = new TeamManager(this);
    private Game gameReference;
    private JavaPlugin plugin;
    
    public FPSCore(Game game){
        this.gameReference = game;
    }
    
    public JavaPlugin getPluginReference(){
        return this.plugin;
    }
    
    public ScoreManager getScoreManager(){
        return this.scoreManager;
    }
    
    public FPSEventManager getEventManager(){
        return this.eventManager;
    }
    
    public WeaponManager getWeaponManager(){
        return this.weaponManager;
    }
    
    public TeamManager getTeamManager(){
        return this.teamManager;
    }
    
    public Game getGameReference(){
        return this.gameReference;
    }
    
    public void registerPlayer(Player p){
        teamManager.registerPlayer(p);
    }
    
}
