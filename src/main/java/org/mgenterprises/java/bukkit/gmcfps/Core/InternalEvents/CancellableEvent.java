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

import java.util.EventObject;
import org.bukkit.event.Cancellable;

/**
 *
 * @author Manuel Gauto
 */
public abstract class CancellableEvent extends EventObject{
    private boolean isCancelled = false;
    private Cancellable triggerEvent;
    public CancellableEvent(Object source){
        super(source);
    }
    
    public CancellableEvent(Object source, Cancellable triggerEvent){
        super(source);
        this.triggerEvent = triggerEvent;
    }
    
    public boolean isCancelled(){
        return isCancelled;
    }
    
    public void setCancelled(boolean isCancelled){
        this.isCancelled = isCancelled;
        this.triggerEvent.setCancelled(isCancelled);
    }
    
}
