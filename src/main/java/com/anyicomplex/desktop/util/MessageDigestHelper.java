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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Simple utility class that wraps {@link MessageDigest} to help generate string hash.
 * @see MessageDigest
 */
public final class MessageDigestHelper {

    private MessageDigestHelper(){}

    /**
     * Hash types that {@link MessageDigest} supports.
     */
    public static final class HashType {

        private HashType(){}

        public static String MD2 = "MD2";
        public static String MD5 = "MD5";
        public static String SHA1 = "SHA-1";
        public static String SHA224 = "SHA-224";
        public static String SHA256 = "SHA-256";
        public static String SHA384 = "SHA-384";
        public static String SHA512 = "SHA-512";
    }

    /**
     * Generate hash of input data depends on type.
     * 
     * @param type hash type
     * @param input the input data
     * @return hash
     */
    public static byte[] hash(String type, byte[] input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(type);
            return messageDigest.digest(input);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Generate hash of input data depends on type.
     * @see MessageDigestHelper#hash(String, byte[]) 
     * 
     * @param type hash type
     * @param input the input data
     * @return hash
     */
    public static byte[] hash(String type, String input) {
        return hash(type, input.getBytes());
    }

    /**
     * Generate md2 hash of input data.
     * 
     * @param input the input data
     * @return md2 hash
     */
    public static String md2(byte[] input) {
        return byteArray2HexString(hash(HashType.MD2, input));
    }

    /**
     * Generate md2 hash of input data.
     * @see MessageDigestHelper#md2(byte[]) 
     *
     * @param input the input data
     * @return md2 hash
     */
    public static String md2(String input) {
        return md2(input.getBytes());
    }

    /**
     * Generate md5 hash of input data.
     *
     * @param input the input data
     * @return md5 hash
     */
    public static String md5(byte[] input) {
        return byteArray2HexString(hash(HashType.MD5, input));
    }

    /**
     * Generate md5 hash of input data.
     * @see MessageDigestHelper#md5(byte[])
     *
     * @param input the input data
     * @return md5 hash
     */
    public static String md5(String input) {
        return md5(input.getBytes());
    }

    /**
     * Generate sha-1 hash of input data.
     *
     * @param input the input data
     * @return sha-1 hash
     */
    public static String sha1(byte[] input) {
        return byteArray2HexString(hash(HashType.SHA1, input));
    }

    /**
     * Generate sha-1 hash of input data.
     * @see MessageDigestHelper#sha1(byte[]) 
     *
     * @param input the input data
     * @return sha-1 hash
     */
    public static String sha1(String input) {
        return sha1(input.getBytes());
    }

    /**
     * Generate sha-224 hash of input data.
     *
     * @param input the input data
     * @return sha-224 hash
     */
    public static String sha224(byte[] input) {
        return byteArray2HexString(hash(HashType.SHA224, input));
    }

    /**
     * Generate sha-224 hash of input data.
     * @see MessageDigestHelper#sha224(byte[])
     *
     * @param input the input data
     * @return sha-224 hash
     */
    public static String sha224(String input) {
        return sha224(input.getBytes());
    }

    /**
     * Generate sha-256 hash of input data.
     *
     * @param input the input data
     * @return sha-256 hash
     */
    public static String sha256(byte[] input) {
        return byteArray2HexString(hash(HashType.SHA256, input));
    }

    /**
     * Generate sha-256 hash of input data.
     * @see MessageDigestHelper#sha256(byte[])
     *
     * @param input the input data
     * @return sha-256 hash
     */
    public static String sha256(String input) {
        return sha256(input.getBytes());
    }

    /**
     * Generate sha-384 hash of input data.
     *
     * @param input the input data
     * @return sha-384 hash
     */
    public static String sha384(byte[] input) {
        return byteArray2HexString(hash(HashType.SHA384, input));
    }

    /**
     * Generate sha-384 hash of input data.
     * @see MessageDigestHelper#sha384(byte[])
     *
     * @param input the input data
     * @return sha-384 hash
     */
    public static String sha384(String input) {
        return sha384(input.getBytes());
    }

    /**
     * Generate sha-512 hash of input data.
     *
     * @param input the input data
     * @return sha-512 hash
     */
    public static String sha512(byte[] input) {
        return byteArray2HexString(hash(HashType.SHA512, input));
    }

    /**
     * Generate sha-512 hash of input data.
     * @see MessageDigestHelper#sha512(byte[])
     *
     * @param input the input data
     * @return sha-512 hash
     */
    public static String sha512(String input) {
        return sha512(input.getBytes());
    }

    private static String byteArray2HexString(byte[] input) {
        StringBuilder hex = new StringBuilder();
        for (byte b : input) {
            hex.append(String.format("%02X", b));
        }
        while (hex.length() < 32) hex.insert(0, '0');
        return hex.toString();
    }

}
