package com.algen;

import com.algen.algorithm.Algen;
import com.algen.program.common.Program;
import com.algen.program.common.ProgramStrategy;
import com.algen.model.TestSuite;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgenPluginApplication {

    public static void main(String[] args) {
//		SpringApplication.run(AlgenPluginApplication.class, args);

        Algen algen = new Algen();
        if (args.length == 0) {
            System.out.println("Kesalahan Input (Harap Ini Nama Program)");
            return;
        }
        Program program = ProgramStrategy.getProgram(args[0]);
        if (program == null) {
            System.out.println("Kesalahan Input (Harap Isi nama Program yang Valid)");
            return;
        }
        Long waktuMulai = System.nanoTime();
        TestSuite testSuite = algen.testSuiteGeneration(program);
        Long waktuSelesai = System.nanoTime();
        System.out.println("Waktu Eksekusi: " + ((waktuSelesai - waktuMulai) * Math.pow(10, -9)) + " detik");
    }

}
