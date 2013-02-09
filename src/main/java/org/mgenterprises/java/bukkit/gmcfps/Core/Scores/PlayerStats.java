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

import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Events.PlayerKilledByPlayerEvent;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 *
 * @author Manuel Gauto
 */
public class PlayerStats implements Serializable{
    private int deaths = 0;
    private int kills = 0;
    private HashMap<String, Integer> weaponKills = new HashMap<String, Integer>();
   
    public int getDeaths(){
        return this.deaths;
    }
    
    public int getKills(){
        return this.kills;
    }
    
    public void registerKill(PlayerKilledByPlayerEvent pk){
        this.kills++;
        int oldWeaponKillNum = this.weaponKills.get(pk.getWeaponUsed().getName());
        weaponKills.put(pk.getKiller().getName(), oldWeaponKillNum+1);
    }
    
    public void registerDeath(){
        this.deaths++;
    }
    
    public double getKillDeathRatio(){
        double kd = (float)kills/deaths;
        return round(kd, 2);
    }
    
    public static double round(double d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(d);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
}
