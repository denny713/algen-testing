package com.algen.program.common;

import com.algen.program.core.*;

public class ProgramStrategy {

    public static Program getProgram(String programName) {
        Program program = null;
        if ("KlasifikasiSegitiga".equalsIgnoreCase(programName)) {
            program = new KlasifikasiSegitiga();
        } else if ("GanjilGenap".equalsIgnoreCase(programName)) {
            program = new GanjilGenap();
        } else if ("TahunKabisat".equalsIgnoreCase(programName)) {
            program = new TahunKabisat();
        } else if ("Penanda".equalsIgnoreCase(programName)) {
            program = new Penanda();
        } else if ("MaksimalTiga".equalsIgnoreCase(programName)) {
            program = new MaksimalTiga();
        } else if ("LingkaranTitik".equalsIgnoreCase(programName)) {
            program = new LingkaranTitik();
        } else if ("Kuadran".equalsIgnoreCase(programName)) {
            program = new Kuadran();
        } else if ("PersamaanKuadrat".equalsIgnoreCase(programName)) {
            program = new PersamaanKuadrat();
        } else if ("Sisa".equalsIgnoreCase(programName)) {
            program = new Sisa();
        }
        return program;
    }
}
