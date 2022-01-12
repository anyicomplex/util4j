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

import com.anyicomplex.desktop.util.SystemInfo;

public class SystemInfoTest {

    public static void main(String[] args) {
        System.out.println("Current OS Name: " + SystemInfo.NAME);
        System.out.println("Current OS Version: " + SystemInfo.VERSION);
        System.out.println("Current OS Arch: " + SystemInfo.ARCH);
        System.out.println("Current OS Type: " + SystemInfo.getSystemType().name());
        System.out.println("Current OS is Windows: " + SystemInfo.isWindows());
        System.out.println("Current OS is Windows 2000: " + SystemInfo.isWindows2000());
        System.out.println("Current OS is Windows XP: " + SystemInfo.isWindowsXP());
        System.out.println("Current OS is Windows 7: " + SystemInfo.isWindows7());
        System.out.println("Current OS is Windows 8: " + SystemInfo.isWindows8());
        System.out.println("Current OS is Windows 8.1: " + SystemInfo.isWindows8_1());
        System.out.println("Current OS is Windows 10: " + SystemInfo.isWindows10());
        System.out.println("Current OS is Windows 11: " + SystemInfo.isWindows11());
        System.out.println("Current OS is Linux: " + SystemInfo.isLinux());
        System.out.println("Current OS is Solaris: " + SystemInfo.isSolaris());
        System.out.println("Current OS is Aix: " + SystemInfo.isAix());
        System.out.println("Current OS is Mac: " + SystemInfo.isMac());
        System.out.println("Current OS is Unix: " + SystemInfo.isUnix());
        System.out.println("Current OS is Unix-like: " + SystemInfo.isUnixLike());
        System.out.println("Current OS is 64 bit: " + SystemInfo.is64Bit());
    }

}
