package com.algen.function;

import com.algen.model.Kromosom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Crossover {

    private Crossover() {
        super();
    }

    public static List<Kromosom> persilangan(List<Kromosom> populasiSaatIni, List<Kromosom> kromosomSilang, int len, Random random, int m) {
        int pos, temp;
        for (int x = 0; x < len; x++) {
            for (int c = 0; c < len; c++) {
                if (x == c) {
                    continue;
                }
                pos = random.nextInt(m - 2) + 1;
                for (int k = pos; k < m; k++) {
                    temp = kromosomSilang.get(x).binaryData.get(k);
                    kromosomSilang.get(x).binaryData.set(k, kromosomSilang.get(c).binaryData.get(k));
                    kromosomSilang.get(c).binaryData.set(k, temp);
                }
            }
        }
        List<Kromosom> populasiBaru = new ArrayList<>();
        populasiBaru.addAll(populasiSaatIni);
        for (int i = 0; i < kromosomSilang.size(); i++) {
            if (kromosomSilang.get(i) != null) {
                populasiBaru.set(i, kromosomSilang.get(i));
            }
        }
        return populasiBaru;
    }
}
