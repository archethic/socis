/**
 * Created by naijun on 2022/02/15
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package org.socis;

import lombok.NonNull;
import org.socis.event.EventManager;
import org.socis.network.Server;

/**
 * Socis Client
 * @author naijun
 */
public class SocisClient extends Thread {

    private final int port;
    private Server server;

    public SocisClient() {
        this(3000);
    }

    public SocisClient(int port) {
        this.port = port;
        this.server = null;
    }

    public SocisClient addListener(@NonNull Object eventListener) {
        EventManager.instance.register(eventListener);
        return this;
    }

    @Override
    public void run() {
        super.run();
        if (EventManager.instance.getLength() == 0) throw new RuntimeException("There are no registered event listeners.");
        this.server = new Server(this.port);
        this.server.start();
    }

}
