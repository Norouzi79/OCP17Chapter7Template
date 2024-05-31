package ir.dotin.ocp17chapter7template.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.locks.ReentrantLock;

public abstract class ObjectUtility {
    private static volatile ObjectMapper instance = null;
    private static final ReentrantLock lock = new ReentrantLock();

    private ObjectUtility() {
    }

    public static ObjectMapper getObjectMapperInstance() {
        if (instance == null) {
            lock.lock();
            try {
                // Double check
                if (instance == null) {
                    instance = new ObjectMapper();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }
}
