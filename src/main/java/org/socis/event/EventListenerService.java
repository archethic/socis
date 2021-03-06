/**
 * Created by naijun on 2022/02/14
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package org.socis.event;

import lombok.NonNull;
import org.socis.event.message.MessageEvent;

/**
 * Event Listener Service
 * @author naijun
 */
public abstract class EventListenerService implements EventListener {

    public void onMessage(@NonNull MessageEvent event) {}

    @Override
    public final void callEvent(@NonNull MessageEvent event) {
        try {
            onMessage(event);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred while processing the event.");
        }
    }

}
