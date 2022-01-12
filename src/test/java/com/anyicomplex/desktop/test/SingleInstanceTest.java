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

package com.anyicomplex.desktop.test;

import com.anyicomplex.desktop.util.MessageDigestHelper;
import com.anyicomplex.desktop.util.SingleInstanceLock;
import com.anyicomplex.desktop.util.SystemPath;

import java.io.File;

public class SingleInstanceTest {

    public static void main(String[] args) {
        String appId = SingleInstanceTest.class.getCanonicalName();
        String userName = System.getProperty("user.name");
        SingleInstanceLock.exitIfOtherInstancesRunning(appId);
        System.out.println("main(String[] args) {}");
        File lock = new File(SystemPath.temporary(), MessageDigestHelper.md5(appId).toLowerCase() +
                MessageDigestHelper.md5(userName).toLowerCase() + ".lock");
        System.out.println(lock.delete());
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        main(args);
    }

}
