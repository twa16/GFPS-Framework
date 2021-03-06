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
package org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Events;

import java.util.EventObject;
import org.bukkit.entity.Player;
import org.mgenterprises.java.bukkit.gmcfps.Core.GameManagement.Game;
import org.mgenterprises.java.bukkit.gmcfps.Core.Teams.Team;

/**
 *
 * @author Manuel Gauto
 */
public class PlayerJoinedTeamEvent extends EventObject{
    private Team teamJoined;
    private Player p;
    private Game game;
    
    public PlayerJoinedTeamEvent(Object source, Player player, Team team, Game game){
        super(source);
        this.teamJoined = team;
        this.p = player;
        this.game = game;
    }
    
    public Game getGame(){
        return this.game;
    }
    
    public Team getTeamJoined(){
        return this.teamJoined;
    }
    
    public Player getPlayer(){
        return this.p;
    }
    
}
