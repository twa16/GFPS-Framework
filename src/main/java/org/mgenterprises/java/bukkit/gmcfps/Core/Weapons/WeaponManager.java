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
package org.mgenterprises.java.bukkit.gmcfps.Core.Weapons;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.mgenterprises.java.bukkit.gmcfps.Core.FPSCore;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Events.WeaponFiredEvent;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Listeners.WeaponFiredListener;

/**
 *
 * @author Manuel Gauto
 */
public class WeaponManager implements WeaponFiredListener {
    private HashMap<String, Weapon> weapons = new HashMap<String, Weapon>();
    public ArrayList<String> waiting = new ArrayList<String>();
    private FPSCore fpsCore;
    
    public Weapon getWeaponByName(String name) {
        return weapons.get(name);
    }
    
    public Weapon getWeaponByType(Material m){
        ArrayList<Weapon> weaponsArray = new ArrayList<Weapon>(weapons.values());
        
        for(Weapon w : weaponsArray){
            if(m == w.getMaterial()){
                return w;
            }
        }
        
        return null;
    }
    
    public FPSCore getFPSCore(){
        return this.fpsCore;
    }
    
    public void onPlayerInteract(PlayerInteractEvent event){
        ArrayList<Weapon> weaponsArray = new ArrayList<Weapon>(weapons.values());
        
        for(Weapon w : weaponsArray){
            if(event.getItem().getType() == w.getMaterial()){
                w.onWeaponRightClick(event);
                break;
            }
        }
    }

    @Override
    public void onWeaponFiredEvent(WeaponFiredEvent event) {
        Player player = event.getPlayer();
        Weapon weapon = event.getWeaponUsed();
        //Location location = event.getLocation(); //May never be used?
        
        String playerName = player.getName();
        String weaponName = weapon.getName();
    }
    
    
}
