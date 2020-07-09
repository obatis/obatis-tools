package com.obatis.convert.date;

import java.sql.Timestamp;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 获取时间底层库，旨在性能优化，该方法参考自GitHub
 * @author HuangLongPu
 */
public class TimeGenerator {
	
    private final long period;
    private final AtomicLong atomicLong;

    private TimeGenerator(long period) {
        this.period = period;
        this.atomicLong = new AtomicLong(System.currentTimeMillis());
        scheduleClockUpdating();
    }

    private static class InstanceHolder {
        public static final TimeGenerator INSTANCE = new TimeGenerator(1);
    }

    private static TimeGenerator instance() {
        return InstanceHolder.INSTANCE;
    }

    private void scheduleClockUpdating() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(runnable -> {
            Thread thread = new Thread(runnable, "System Clock");
            thread.setDaemon(true);
            return thread;
        });
        scheduler.scheduleAtFixedRate(() -> atomicLong.set(System.currentTimeMillis()), period, period, TimeUnit.MILLISECONDS);
    }

    private long currentTimeMillis() {
        return atomicLong.get();
    }
    
    protected static long getTimeMillis() {
        return instance().currentTimeMillis();
    }

    protected static Timestamp getTimestamp() {
        return new Timestamp(instance().currentTimeMillis());
    }
    
}
