package com.algen.function;

import com.algen.model.Kromosom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Selection {

    private Selection() {
        super();
    }

    public static void seleksiInduk(List<Kromosom> populasiSaatIni, int size, Random rand) {
        List<Kromosom> induk = new ArrayList<>();
        float totalFitness = Fitness.hitungTotalFitness(populasiSaatIni);
        for (int x = 0; x < populasiSaatIni.size(); x++) {
            populasiSaatIni.get(x).rft = totalFitness;
            if (x == 0) {
                populasiSaatIni.get(x).cft = 0;
            } else {
                populasiSaatIni.get(x).cft = populasiSaatIni.get(x - 1).cft;
            }
        }
        for (int i = 0, j = 0; i < size; i++, j++) {
            float r = rand.nextFloat();
            if (r < populasiSaatIni.get(0).cft) {
                induk.add(populasiSaatIni.get(0));
            } else {
                for (int k = 0; k < populasiSaatIni.size(); k++) {
                    if ((populasiSaatIni.get(k).cft < r && populasiSaatIni.get(k + 1).cft > r)) {
                        induk.add(populasiSaatIni.get(k));
                    }
                }
            }
        }
    }

    public static List<Kromosom> seleksiPersilangan(List<Kromosom> populasiSaatIni, int len, Random random, double over) {
        List<Kromosom> kromosomSilang = new ArrayList<>();
        for (Kromosom Kromosom : populasiSaatIni) {
            float r = random.nextFloat();
            if (r < over) {
                kromosomSilang.add(Kromosom);
                len++;
            }
        }
        if (kromosomSilang.get(0) == null) {
            System.exit(99);
        }
        return kromosomSilang;
    }
}
