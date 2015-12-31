package com.joeracosta.mvptest.Persistent;

/**
 * Created by Joe on 12/30/2015.
 */

/**
 * Maintains a singleton instance for obtaining the bus. Ideally this would be replaced with a more efficient means
 * such as through injection directly into inNterested classes.
 */
public final class BusProvider {
    private static final MainBus BUS = new MainBus();

    public static MainBus getInstance() {
        return BUS;
    }

    private BusProvider() {
        // No instances.
    }
}