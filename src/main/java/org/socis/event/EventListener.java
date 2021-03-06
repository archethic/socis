/**
 * Created by naijun on 2022/02/15
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package org.socis.event;

import lombok.NonNull;
import org.socis.event.message.MessageEvent;

/**
 * EventListener interface
 * @author naijun
 */
public interface EventListener {

    void callEvent(@NonNull MessageEvent event);

}
