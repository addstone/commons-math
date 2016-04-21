/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.math4.rng.internal.source32;

import org.apache.commons.math4.exception.OutOfRangeException;
import org.apache.commons.math4.rng.internal.util.NumberFactory;
import org.apache.commons.math4.rng.internal.BaseProvider;

/**
 * Base class for all implementations that provide an {@code int}-based
 * source randomness.
 */
public abstract class IntProvider
    extends BaseProvider
    implements RandomIntSource {

    /** {@inheritDoc} */
    @Override
    public abstract int next();

    /** {@inheritDoc} */
    @Override
    public int nextInt() {
        return next();
    }

    /** {@inheritDoc} */
    @Override
    public boolean nextBoolean() {
        return NumberFactory.makeBoolean(nextInt());
    }

    /** {@inheritDoc} */
    @Override
    public double nextDouble() {
        return NumberFactory.makeDouble(nextInt(), nextInt());
    }

    /** {@inheritDoc} */
    @Override
    public float nextFloat() {
        return NumberFactory.makeFloat(nextInt());
    }

    /** {@inheritDoc} */
    @Override
    public long nextLong() {
        return NumberFactory.makeLong(nextInt(), nextInt());
    }

    /** {@inheritDoc} */
    @Override
    public void nextBytes(byte[] bytes) {
        nextBytesFill(this, bytes, 0, bytes.length);
    }

    /** {@inheritDoc} */
    @Override
    public void nextBytes(byte[] bytes,
                          int start,
                          int len) {
        if (start < 0 ||
            start >= bytes.length) {
            throw new OutOfRangeException(start, 0, bytes.length);
        }
        if (len < 0 ||
            len > bytes.length - start) {
            throw new OutOfRangeException(len, 0, bytes.length - start);
        }

        nextBytesFill(this, bytes, start, len);
    }

    /**
     * Generates random bytes and places them into a user-supplied array.
     *
     * <p>
     * The array is filled with bytes extracted from random {@code int} values.
     * This implies that the number of random bytes generated may be larger than
     * the length of the byte array.
     * </p>
     *
     * @param source Source of randomness.
     * @param bytes Array in which to put the generated bytes. Cannot be null.
     * @param start Index at which to start inserting the generated bytes.
     * @param len Number of bytes to insert.
     */
    static void nextBytesFill(RandomIntSource source,
                              byte[] bytes,
                              int start,
                              int len) {
        int index = start; // Index of first insertion.

        // Index of first insertion plus multiple of 4 part of length
        // (i.e. length with 2 least significant bits unset).
        final int indexLoopLimit = index + (len & 0x7ffffffc);

        // Start filling in the byte array, 4 bytes at a time.
        while (index < indexLoopLimit) {
            final int random = source.next();
            bytes[index++] = (byte) random;
            bytes[index++] = (byte) (random >>> 8);
            bytes[index++] = (byte) (random >>> 16);
            bytes[index++] = (byte) (random >>> 24);
        }

        final int indexLimit = start + len; // Index of last insertion + 1.

        // Fill in the remaining bytes.
        if (index < indexLimit) {
            int random = source.next();
            while (true) {
                bytes[index++] = (byte) random;
                if (index < indexLimit) {
                    random >>>= 8;
                } else {
                    break;
                }
            }
        }
    }
}
