/*
 * MIT License
 *
 * Copyright (c) 2021 Yi An
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.anyicomplex.desktop.util;

import java.io.File;
import java.io.IOException;

/**
 * Simple utility class that prevents user from running more than one instances of the same application. File-based.
 */
public final class SingleInstanceLock {

    private SingleInstanceLock(){}

    private volatile static boolean keepLockExists = false;

    /**
     * Exit if other current application's instances running, depends on lock file with appId.
     *
     * @param appId application id, can be any words, cannot be null.
     * @param exitCode exit code, will be call by {@link System#exit(int)}.
     */
    public static synchronized void exitIfOtherInstancesRunning (String appId, int exitCode) {
        if (appId == null) throw new NullPointerException("Unable to create lock: \nappId cannot be null.");
        String userName = System.getProperty("user.name");
        File file = new File(SystemPath.temporary(),
                MessageDigestHelper.md5(appId).toLowerCase() +
                MessageDigestHelper.md5(userName).toLowerCase() + ".lock");
        if (file.exists()) System.exit(exitCode);
        else {
            try {
                if (file.createNewFile()) {
                    keepLockExists = true;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (keepLockExists) {
                                if (!file.exists()) {
                                    try {
                                        if (!file.createNewFile()) {
                                            System.err.println("Unable to create lock: \nFailed to create lock file.");
                                            break;
                                        }
                                    } catch (IOException e) {
                                        System.err.println("Unable to create lock: \n" + e.getMessage());
                                        break;
                                    }
                                }
                            }
                        }
                    }).start();
                    Runtime.getRuntime().addShutdownHook(new Thread() {
                        public void run() {
                            keepLockExists = false;
                            if (!file.delete()) System.err.println("Unable to remove lock: \n" + "Failed to delete lock file.");
                        }
                    });
                }
                else {
                    System.err.println("Unable to create lock: \nFailed to create lock file.");
                }
            } catch (IOException e) {
                System.err.println("Unable to create lock: \n" + e.getMessage());
            }
        }
    }

    /**
     * Exit with code 0 if other current application's instances running, depends on lock file with appId.
     * @see SingleInstanceLock#exitIfOtherInstancesRunning(String, int)
     *
     * @param appId application id, can be any words, cannot be null.
     */
    public static void exitIfOtherInstancesRunning (String appId) {
        exitIfOtherInstancesRunning(appId, 0);
    }

}
