package com.algen.function;

import com.algen.model.*;
import com.algen.program.common.Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Population {

    public static List<Kromosom> initialPopulasi(Program program, int size, int m) {
        for (int i = 0; i < program.numberOfInputVariables; i++) {
            m += 5;
        }
        List<Kromosom> initPopulasi = new ArrayList<>();
        for (int j = 0; j < size; j++) {
            Kromosom populasi = new Kromosom();
            populasi.initBinData(m);
            initPopulasi.add(populasi);
        }
        return initPopulasi;
    }

    public static List<Kromosom> evaluasiPopulasi(List<Kromosom> initialPopulation, Node leaf, int size, Program program, TestSuite testSuite) {
        List<Kromosom> currentPopulation = new ArrayList<>();
        for (int i = 0, j = 0; j < size; i++, j++) {
            currentPopulation.add(initialPopulation.get(i));
            currentPopulation.get(j).binToDec(program.numberOfInputVariables);
            currentPopulation.get(j).decToReal(program.numberOfInputVariables, 5);
        }
        for (Kromosom kromosom : currentPopulation) {
            int nodeNo = program.getLeafByEvaluation(kromosom);
            int pathNo = program.decisionTreePaths.getPathNumberHavingNode(nodeNo);
            Path exePath = program.decisionTreePaths.getPathHavingPathNumber(pathNo);
            pathNo = program.decisionTreePaths.getPathNumberHavingNode(leaf.lineNumber);
            Path domPath = program.decisionTreePaths.getPathHavingPathNumber(pathNo);
            kromosom.fitness = Fitness.fitnessTestCase(exePath, domPath);
            if (leaf.lineNumber == nodeNo) {
                leaf.visited = true;
                tambahTestCaseKeSuite(kromosom, nodeNo, testSuite, program);
                kromosom.nodeCovered = nodeNo;
            }
        }
        return currentPopulation;
    }

    public static void populasiBaru(List<Kromosom> populasiSaatIni, Random random, double over, double mut, int m) {
        int len = 0;
        List<Kromosom> kromosomSilang = Selection.seleksiPersilangan(populasiSaatIni, len, random, over);
        List<Kromosom> populasiBaru = Crossover.persilangan(populasiSaatIni, kromosomSilang, len, random, m);
        Mutate.mutasi(populasiBaru, m, random, mut);
    }

    public static void tambahTestCaseKeSuite(Kromosom populasiSaatIni, int nodeNo, TestSuite testSuite, Program program) {
        boolean tanda = false;
        for (TestCase testCase : testSuite.getTestCases()) {
            if (testCase.getVariable(0) == populasiSaatIni.realData.get(0)
                    && testCase.getVariable(1) == populasiSaatIni.realData.get(1)
                    && testCase.getVariable(2) == populasiSaatIni.realData.get(2)) {
                tanda = true;
            }
        }
        if (!tanda) {
            TestCase testCase = new TestCase();
            for (int x = 0; x < program.numberOfInputVariables; x++) {
                testCase.addValue(populasiSaatIni.realData.get(x).intValue());
            }
            testCase.satisfyingNode = nodeNo;
            testSuite.addTestCase(testCase);
        }
    }
}
