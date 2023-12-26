package com.algen.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kromosom {

    public Kromosom() {
        binaryData = new ArrayList<>();
        decimalData = new ArrayList<>();
        realData = new ArrayList<>();
    }

    public List<Integer> binaryData;
    public List<Integer> decimalData;
    public List<Double> realData;
    public Double fitness;
    public int nodeCovered;
    public double rft;
    public double cft;
    public Random random = new Random();

    public void initBinData(int max) {
        for (int x = 0; x < max; x++) {
            binaryData.add(random.nextInt(2));
        }
    }

    public void binToDec(int max) {
        for (int x = 0; x < max; x++) {
            for (int c = (5 * x); c < (5 * (x + 1)); c++) {
                if (binaryData.get(c) == 1) {
                    decimalData.add(x, decimalData.get(x) + ((Double) Math.pow(2, 5 - 1 - (c % 5))).intValue());
                }
            }
        }
    }

    public void decToReal(int value, int max) {
        for (int x = 0; x < value; x++) {
            realData.add(x, 1 + (decimalData.get(x) * (19.0 / Math.pow(2, max) - 1)));
        }
    }
}
