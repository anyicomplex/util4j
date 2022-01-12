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

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Simple utility class that reads I18N texts from resources files. Default locale is {@link Locale#getDefault()}, baseName is "Messages".
 */
public final class I18NResourceBundle {

    private I18NResourceBundle(){}

    public static final String DEFAULT_BASENAME = "Messages";

    private volatile static Locale locale = Locale.getDefault();
    private volatile static String baseName = DEFAULT_BASENAME;

    /**
     * Returns {@link I18NResourceBundle#locale}.
     *
     * @return current locale
     */
    public static Locale getLocale() {
        return locale;
    }

    /**
     * Sets {@link I18NResourceBundle#locale}. It will be used by {@link I18NResourceBundle#getText(String)}.
     *
     * @param locale locale will be set
     */
    public static void setLocale(Locale locale) {
        if (locale == null) throw new NullPointerException("Locale cannot be null.");
        I18NResourceBundle.locale = locale;
    }

    /**
     * Returns {@link I18NResourceBundle#baseName}.
     *
     * @return current baseName
     */
    public static String getBaseName() {
        return baseName;
    }

    /**
     * Sets {@link I18NResourceBundle#baseName}. It will be used by {@link I18NResourceBundle#getText(Locale, String)}.
     *
     * @param baseName baseName will be set
     */
    public static void setBaseName(String baseName) {
        if (baseName == null) throw new NullPointerException("Unable to get text: \nBaseName cannot be null.");
        if (baseName.length() < 1) throw new IllegalArgumentException("Unable to get text: \nInvalid baseName.");
        I18NResourceBundle.baseName = baseName;
    }

    /**
     * Returns text string by key depends on specific baseName and locale.
     *
     * @param baseName baseName
     * @param locale specific locale
     * @param key specific key
     * @return text string value
     */
    public static String getText(String baseName, Locale locale, String key) {
        if (baseName == null) throw new NullPointerException("Unable to get text: \nBaseName cannot be null.");
        if (locale == null) throw new NullPointerException("Unable to get text: \nLocale cannot be null.");
        if (key == null) throw new NullPointerException("Unable to get text: \nKey cannot be null.");
        if (key.length() < 1) throw new IllegalArgumentException("Unable to get text: \nInvalid key.");
        return ResourceBundle.getBundle(baseName, locale).getString(key);
    }

    /**
     * Returns text string by key depends on {@link I18NResourceBundle#baseName} and specific locale.
     * @see I18NResourceBundle#getText(String, Locale, String)
     *
     * @param locale specific locale
     * @param key specific key
     * @return text string value
     */
    public static String getText(Locale locale, String key) {
        return getText(getBaseName(), locale, key);
    }

    /**
     * Returns text string by key depends on {@link I18NResourceBundle#baseName} and {@link I18NResourceBundle#locale}.
     * @see I18NResourceBundle#getText(Locale, String)
     *
     * @param key specific key
     * @return text string value
     */
    public static String getText(String key) {
        return getText(getLocale(), key);
    }

}
