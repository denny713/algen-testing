package com.algen.function;

import com.algen.model.Kromosom;
import com.algen.model.Path;

import java.util.List;

public class Fitness {

    private Fitness() {
        super();
    }

    public static float hitungTotalFitness(List<Kromosom> populasiSaatIni) {
        float totalFitness = 0;
        for (Kromosom current : populasiSaatIni)
            totalFitness += current.fitness;
        return totalFitness;
    }

    public static double fitnessTestCase(Path exePath, Path domPath) {
        int nomorNodeTercoover = 0;
        int nomorNodeDom = 0;
        for (int x = 0;
             (exePath.getNode(x) != null && domPath.getNode(x) != null && exePath.getNode(x) == domPath.getNode(x));
             x++) {
            nomorNodeTercoover++;
        }
        for (int x = 0; domPath.getNode(x) != null; x++) {
            nomorNodeDom++;
        }
        return (double) nomorNodeTercoover / (double) nomorNodeDom;
    }
}
