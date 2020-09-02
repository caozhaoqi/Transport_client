/*
 * Copyright 2008 ZXing authors
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

package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

/**
 * @author satorux@google.com (Satoru Takabayashi) - creator
 * @author dswitkin@google.com (Daniel Switkin) - ported from C++
 */
public final class QRCode {

    public static final int NUM_MASK_PATTERNS = 8;

    private Mode mode;
    private ErrorCorrectionLevel ecLevel;
    private Version version;
    private int maskPattern;
    private ByteMatrix matrix;

    /**
     * Constructs a new QRCode.
     */
    public QRCode() {
        maskPattern = -1;
    }

    // Check if "mask_pattern" is valid.
    public static boolean isValidMaskPattern(int maskPattern) {
        return maskPattern >= 0 && maskPattern < NUM_MASK_PATTERNS;
    }

    /**
     * Getter for property 'mode'.
     *
     * @return Value for property 'mode'.
     */
    public Mode getMode() {
        return mode;
    }

    /**
     * Setter for property 'mode'.
     *
     * @param value Value to set for property 'mode'.
     */
    public void setMode(Mode value) {
        mode = value;
    }

    /**
     * Getter for property 'ECLevel'.
     *
     * @return Value for property 'ECLevel'.
     */
    public ErrorCorrectionLevel getECLevel() {
        return ecLevel;
    }

    /**
     * Setter for property 'ECLevel'.
     *
     * @param value Value to set for property 'ECLevel'.
     */
    public void setECLevel(ErrorCorrectionLevel value) {
        ecLevel = value;
    }

    /**
     * Getter for property 'version'.
     *
     * @return Value for property 'version'.
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Setter for property 'version'.
     *
     * @param version Value to set for property 'version'.
     */
    public void setVersion(Version version) {
        this.version = version;
    }

    /**
     * Getter for property 'maskPattern'.
     *
     * @return Value for property 'maskPattern'.
     */
    public int getMaskPattern() {
        return maskPattern;
    }

    /**
     * Setter for property 'maskPattern'.
     *
     * @param value Value to set for property 'maskPattern'.
     */
    public void setMaskPattern(int value) {
        maskPattern = value;
    }

    /**
     * Getter for property 'matrix'.
     *
     * @return Value for property 'matrix'.
     */
    public ByteMatrix getMatrix() {
        return matrix;
    }

    /**
     * Setter for property 'matrix'.
     *
     * @param value Value to set for property 'matrix'.
     */
    public void setMatrix(ByteMatrix value) {
        matrix = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(200);
        result.append("<<\n");
        result.append(" mode: ");
        result.append(mode);
        result.append("\n ecLevel: ");
        result.append(ecLevel);
        result.append("\n version: ");
        result.append(version);
        result.append("\n maskPattern: ");
        result.append(maskPattern);
        if (matrix == null) {
            result.append("\n matrix: null\n");
        } else {
            result.append("\n matrix:\n");
            result.append(matrix);
        }
        result.append(">>\n");
        return result.toString();
    }

}
