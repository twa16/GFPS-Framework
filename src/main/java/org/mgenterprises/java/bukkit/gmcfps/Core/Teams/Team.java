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
package org.mgenterprises.java.bukkit.gmcfps.Core.Teams;

import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 *
 * @author Manuel Gauto
 */
public class Team {
    private ArrayList<Player> members = new ArrayList<Player>();
    private String name;
    private Location spawn;
    
    public Team(String name){
        this.name = name;
    }
    
    public void setSpawn(Location loc){
        this.spawn = loc;
    }
    
    public Location getSpawn(){
        return spawn;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void addMember(Player p){
        this.members.add(p);
    }
    
    public void removeMember(Player p){
        this.members.remove(p);
    }
    
    public boolean isMember(Player p){
        for(Player pi : members){
            if(pi.getName().equals(p.getName())){
                return true;
            }
        }
        return false;
    }
    
    public Player[] getMembers(){
        Player[] template = new Player[members.size()];
        return members.toArray(template);
    }
    
    public int size(){
        return this.members.size();
    }
}
