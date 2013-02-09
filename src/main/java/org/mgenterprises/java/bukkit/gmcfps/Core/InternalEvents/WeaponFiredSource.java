/*
 * The MIT License
 *
 * Copyright 2013 Chris.
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

import java.util.ArrayList;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Events.WeaponFiredEvent;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Listeners.WeaponFiredListener;

/**
 *
 * @author Chris
 */
public class WeaponFiredSource extends FPSEventSource{
    private List _listeners = new ArrayList();
    /*
     * Generate Event Listener
     * 
     * @param listner
     */
    public synchronized void addEventListener(WeaponFiredListener listener) {
        _listeners.add(listener);
    }
    
    /*
     * Remove event listener
     * 
     * @param listener
     */
    public synchronized void removeEventListener(WeaponFiredListener listener) {
        _listeners.remove(listener);
    }
    
    /*
     * Trigger Weapon Fired event
     * 
     * @param event
     */
    @Override
    public void fireEvent(EventObject event) {
        WeaponFiredEvent e = (WeaponFiredEvent) event;
        Iterator i = _listeners.iterator();
        while (i.hasNext()) {
            ((WeaponFiredListener) i.next()).onWeaponFiredEvent(e);
        }
    }
    
}
