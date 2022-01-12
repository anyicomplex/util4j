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

import com.anyicomplex.desktop.util.PathHelper;

public class PathHelperTest {

    public static void main(String[] args) {
        System.out.println(PathHelper.build("1", "2", "3", "4"));
        System.out.println(PathHelper.endsWithSeparator("5/"));
        System.out.println(PathHelper.endsWithSeparator(""));
        System.out.println(PathHelper.removeSeparatorAtEnd(""));
        System.out.println(PathHelper.buildAppDataPath("anyicomplex", "PathHelperTest"));
        System.out.println(PathHelper.buildAppConfigPath("anyicomplex", "PathHelperTest"));
        System.out.println(PathHelper.buildAppCachePath("anyicomplex", "PathHelperTest"));
        System.out.println(PathHelper.buildAppDataPath("anyicomplex", "Test", "PathHelperTest"));
        System.out.println(PathHelper.buildAppConfigPath("anyicomplex", "Test", "PathHelperTest"));
        System.out.println(PathHelper.buildAppCachePath("anyicomplex", "Test", "PathHelperTest"));
        System.out.println(PathHelper.buildAppDataPath("PathHelperTest"));
        System.out.println(PathHelper.buildAppConfigPath("PathHelperTest"));
        System.out.println(PathHelper.buildAppCachePath("PathHelperTest"));
        System.out.println(PathHelper.build("\\abcde/fghijkl\\mnop"));
    }

}
