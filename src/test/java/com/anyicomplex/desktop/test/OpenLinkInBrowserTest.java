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

import com.anyicomplex.desktop.util.OpenLinkInBrowser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OpenLinkInBrowserTest {

    public static void main(String[] args) {
        final String WEB_LINK = "https://github.com";
        OpenLinkInBrowser.fromString(WEB_LINK);
        try {
            final URI WEB_LINK_URI = new URI(WEB_LINK);
            OpenLinkInBrowser.fromURI(WEB_LINK_URI);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        final String FILE_NAME = "OpenLinkTestFile.html";
        final File FILE = new File(System.getProperty("java.io.tmpdir"), FILE_NAME);
        if (FILE.exists()) if (!FILE.delete()) return;
        final String HTML = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Open Link Test</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            writer.write(HTML);
            writer.flush();
            final String FILE_LINK = "file://" + FILE.getAbsolutePath();
            OpenLinkInBrowser.fromString(FILE_LINK);
            final URI FILE_LINK_URI = new URI(FILE_LINK);
            OpenLinkInBrowser.fromURI(FILE_LINK_URI);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
