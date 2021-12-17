package com.anyicomplex.util4j;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/**
 * Simple utility class that prevents user from running more than one instances of the same application. File-based.
 */
public class SingleInstanceLock {

    /**
     * Exit if other current application's instances running, depends on lock file with appId.
     *
     * @param appId application id, can be any words, cannot be null.
     * @param exitCode exit code, will be call by {@link System}.exit(int status);
     */
    public static synchronized void exitIfOtherInstancesRunning (String appId, int exitCode) {
        if (appId == null) throw new NullPointerException("AppId cannot be null.");
        String tmpDir = System.getProperty("java.io.tmpdir");
        String userName = System.getProperty("user.name");
        final File file = new File(tmpDir, appId + "." + userName + ".lock");
        try {
            final RandomAccessFile lockFile = new RandomAccessFile(file, "rw");
            final FileLock fileLock = lockFile.getChannel().tryLock();
            if (fileLock != null) {
                Runtime.getRuntime().addShutdownHook(new Thread() {
                    public void run() {
                        try {
                            fileLock.release();
                            lockFile.close();
                            boolean success = file.delete();
                            if (!success) System.err.println("Unable to remove lock: \n" + "Failed to delete lock.");
                        }
                        catch (IOException e) {
                            System.err.println("Unable to remove lock: \n" + e.getMessage());
                        }
                    }
                });
                return;
            }
        }
        catch (IOException e) {
            System.err.println("Unable to create lock: \n" + e.getMessage());
        }
        System.exit(exitCode);
    }

    /**
     * Exit with code 0 if other current application's instances running, depends on lock file with appId.
     *
     * @param appId application id, can be any words, cannot be null.
     */
    public static void exitIfOtherInstancesRunning (String appId) {
        exitIfOtherInstancesRunning(appId, 0);
    }

}
