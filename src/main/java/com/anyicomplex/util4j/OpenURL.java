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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Simple utility class that opens url using system's default browser.
 */
public class OpenURL {

    /**
     * Opens url using system's default browser depends on url string.
     * @param url url string
     */
    public static void fromString(String url) {
        try {
            from(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens url using system's default browser depends on url object.
     * @param url url object
     */
    public static void from(URL url) {
        if (url == null) throw new NullPointerException("Url cannot be null.");
        String baseCommand;
        switch (OSValidator.getOSType()) {
            case WINDOWS:
                baseCommand = "start";
                break;
            case LINUX:
                baseCommand = "xdg-open";
                break;
            case MAC:
                baseCommand = "open";
                break;
            default:
                throw new IllegalStateException("Unsupported platform.");
        }
        try {
            Runtime.getRuntime().exec(baseCommand + " " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
