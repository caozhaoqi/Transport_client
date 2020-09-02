/*
 * Copyright 2009 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.zxing.oned.rss;

/**
 * Encapsulates a since character value in an RSS barcode, including its checksum information.
 */
public class DataCharacter {

    private final int value;
    private final int checksumPortion;

    public DataCharacter(int value, int checksumPortion) {
        this.value = value;
        this.checksumPortion = checksumPortion;
    }

    /**
     * Getter for property 'value'.
     *
     * @return Value for property 'value'.
     */
    public final int getValue() {
        return value;
    }

    /**
     * Getter for property 'checksumPortion'.
     *
     * @return Value for property 'checksumPortion'.
     */
    public final int getChecksumPortion() {
        return checksumPortion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return value + "(" + checksumPortion + ')';
    }

    /** {@inheritDoc} */
    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof DataCharacter)) {
            return false;
        }
        DataCharacter that = (DataCharacter) o;
        return value == that.value && checksumPortion == that.checksumPortion;
    }

    /** {@inheritDoc} */
    @Override
    public final int hashCode() {
        return value ^ checksumPortion;
    }

}
