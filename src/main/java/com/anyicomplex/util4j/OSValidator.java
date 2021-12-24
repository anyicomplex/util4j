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

package com.anyicomplex.util4j;

/**
 * Simple utility class that validates system type.
 */
public class OSValidator {

    /**
     * System types
     */
    public enum OSType {
        WINDOWS,
        MAC,
        LINUX,
        SOLARIS,
        AIX,
        OTHER_UNIX,
        UNKNOWN
    }

    private static final OSType osType;

    /**
     * Gets system type.
     * @return system type
     */
    public static OSType getOSType() {
        return osType;
    }

    static {
        final String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) osType = OSType.WINDOWS;
        else if (osName.contains("nux")) osType = OSType.LINUX;
        else if (osName.contains("mac")) osType = OSType.MAC;
        else if (osName.contains("sunos")) osType = OSType.SOLARIS;
        else if (osName.contains("aix")) osType = OSType.AIX;
        else if (osName.contains("nix")) osType = OSType.OTHER_UNIX;
        else osType = OSType.UNKNOWN;
    }

    /**
     * Validates whether system is Windows.
     * @return whether system is Windows
     */
    public static boolean isWindows() {
        return osType == OSType.WINDOWS;
    }

    /**
     * Validates whether system is Linux.
     * @return whether system is Linux
     */
    public static boolean isLinux() {
        return osType == OSType.LINUX;
    }

    /**
     * Validates whether system is Mac.
     * @return whether system is Mac
     */
    public static boolean isMac() {
        return osType == OSType.MAC;
    }

    /**
     * Validates whether system is Solaris.
     * @return whether system is Solaris
     */
    public static boolean isSolaris() {
        return osType == OSType.SOLARIS;
    }

    /**
     * Validates whether system is Aix.
     * @return whether system is Aix
     */
    public static boolean isAix() {
        return osType == OSType.AIX;
    }

    /**
     * Validates whether system is Unix.
     * Note: Mac is Unix, Linux Is Not UniX.
     * @return whether system is Unix
     */
    public static boolean isUnix() {
        return (isMac() || isSolaris() || isAix() || osType == OSType.OTHER_UNIX);
    }

}
