package com.clinic;

import com.clinic.config.HikariConnectionPool;
import com.clinic.ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        try {
            new ConsoleMenu().start();
        } finally {
            // Close the pool cleanly when the app exits
            HikariConnectionPool.shutdown();
        }
    }
}
