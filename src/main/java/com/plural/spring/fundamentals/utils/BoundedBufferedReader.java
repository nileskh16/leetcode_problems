package com.plural.spring.fundamentals.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoundedBufferedReader extends BufferedReader {

    private static final int DEFAULT_MAX_LINE_LENGTH = 1024;
    private final int readerMaxLineLen;

    public BoundedBufferedReader(InputStreamReader reader, int maxLineLen) {
        super(reader);
        if (maxLineLen <= 0)
            throw new IllegalArgumentException("BoundedBufferedReader - maximum line length must be greater than 0");

        readerMaxLineLen = maxLineLen;
    }

    public BoundedBufferedReader(InputStreamReader reader) {
        super(reader);
        readerMaxLineLen = DEFAULT_MAX_LINE_LENGTH;
    }

    @Override
    public String readLine() throws IOException {

        int currentPos = 0;
        char[] data = new char[readerMaxLineLen];
        final int CR = 13;
        final int LF = 10;
        int currentCharVal = super.read();

        while ((currentCharVal != CR) && (currentCharVal != LF) && (currentCharVal >= 0)) {
            data[currentPos++] = (char) currentCharVal;
            if (currentPos < readerMaxLineLen) currentCharVal = read();
            else break;
        }

        if (currentCharVal < 0) {
            if (currentPos > 0) {
                return new String(data, 0, currentPos);
            } else return null;
        } else {
            if (currentCharVal == CR) {
                super.mark(1);
                if (super.read() != LF) super.reset();
            } else if (currentCharVal != LF) {
                int nextCharVal = super.read();
                while (nextCharVal != CR && nextCharVal != LF) {
                    nextCharVal = super.read();
                    if (nextCharVal < 0) break;
                }
                if (nextCharVal == CR) {
                    super.mark(1);
                    if (super.read() != LF)
                        super.reset();
                }
            }
            return currentPos >= 0 ? new String(data, 0, currentPos) : null;
        }
    }
}