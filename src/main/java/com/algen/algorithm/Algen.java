package com.algen.algorithm;

import com.algen.function.Population;
import com.algen.function.Selection;
import com.algen.model.*;
import com.algen.program.Program;

import java.util.List;
import java.util.Random;

public class Algen {

    private final int MAX_GENERASI = 100;
    private final double PXOVER = 0.8;
    private final double PXMUTATION = 0.15;
    private int sizePopulasi = 20;
    private Program program;
    private TestSuite testSuite;
    private int m = 0;
    private Random random = new Random();

    public TestSuite testSuiteGeneration(Program program) {
        this.program = program;
        testSuite = new TestSuite();
        for (Node leaf : program.leaves) {
            if (!leaf.visited) {
                int noGenerasi = 0;
                List<Kromosom> populasiAwal = Population.initialPopulasi(program, sizePopulasi, m);
                List<Kromosom> populasiSaatIni = Population.evaluasiPopulasi(populasiAwal, leaf, sizePopulasi, program, testSuite);
                while (!leaf.visited && noGenerasi <= MAX_GENERASI) {
                    Selection.seleksiInduk(populasiSaatIni, sizePopulasi, random);
                    Population.populasiBaru(populasiSaatIni, random, PXOVER, PXMUTATION, m);
                    Population.evaluasiPopulasi(populasiAwal, leaf, sizePopulasi, program, testSuite);
                    noGenerasi++;
                    System.out.println("Nomor Generasi: " + noGenerasi);
                }
                if (noGenerasi > MAX_GENERASI) {
                    System.exit(1);
                }
            }
        }
        return testSuite;
    }
}
