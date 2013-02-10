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
package org.mgenterprises.java.bukkit.gmcfps.Core.Spawns;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mgenterprises.java.bukkit.gmcfps.Core.Exceptions.LobbyNotDefinedException;
import org.mgenterprises.java.bukkit.gmcfps.Core.FPSCore;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Events.PlayerLeftTeamEvent;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Listeners.PlayerLeftTeamListener;

/**
 *
 * @author Manuel Gauto
 */
public class SpawnManager implements PlayerLeftTeamListener{
    ArrayList<Location> spawns = new ArrayList<Location>();
    private Location lobby;
    private FPSCore core;
    
    public SpawnManager(FPSCore core){
        this.core = core;
    }
    
    public void setLobby(Location newLobby){
        this.lobby = newLobby;
    }

    private void checkForDefinedLobby() throws LobbyNotDefinedException{
        if(lobby == null){
            throw new LobbyNotDefinedException(core.getGameReference());
        }
    }
    
    @Override
    public void onPlayerLeftTeamEvent(PlayerLeftTeamEvent event) {
        try {
            teleportToBaseSpawn(event.getPlayer());
        } catch (LobbyNotDefinedException ex) {
            Logger.getLogger(SpawnManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void teleportToBaseSpawn(Player p) throws LobbyNotDefinedException{
        checkForDefinedLobby();
        p.teleport(lobby);
    }
}
