/*
 * Copyright (C) 2010 ZXing authors
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

package com.google.zxing.oned.rss.expanded;

import java.util.ArrayList;
import java.util.List;

/**
 * One row of an RSS Expanded Stacked symbol, consisting of 1+ expanded pairs.
 */
final class ExpandedRow {

    private final List<ExpandedPair> pairs;
    private final int rowNumber;
    /**
     * Did this row of the image have to be reversed (mirrored) to recognize the pairs?
     */
    private final boolean wasReversed;

    ExpandedRow(List<ExpandedPair> pairs, int rowNumber, boolean wasReversed) {
        this.pairs = new ArrayList<>(pairs);
        this.rowNumber = rowNumber;
        this.wasReversed = wasReversed;
    }

    /**
     * Getter for property 'pairs'.
     *
     * @return Value for property 'pairs'.
     */
    List<ExpandedPair> getPairs() {
        return this.pairs;
    }

    /**
     * Getter for property 'rowNumber'.
     *
     * @return Value for property 'rowNumber'.
     */
    int getRowNumber() {
        return this.rowNumber;
    }

    /**
     * Getter for property 'reversed'.
     *
     * @return Value for property 'reversed'.
     */
    boolean isReversed() {
        return this.wasReversed;
    }

    boolean isEquivalent(List<ExpandedPair> otherPairs) {
        return this.pairs.equals(otherPairs);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "{ " + pairs + " }";
    }

    /**
     * Two rows are equal if they contain the same pairs in the same order.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExpandedRow)) {
            return false;
        }
        ExpandedRow that = (ExpandedRow) o;
        return this.pairs.equals(that.getPairs()) && wasReversed == that.wasReversed;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return pairs.hashCode() ^ Boolean.valueOf(wasReversed).hashCode();
    }

}
