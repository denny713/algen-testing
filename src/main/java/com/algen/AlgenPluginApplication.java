package com.algen;

import com.algen.algorithm.Algen;
import com.algen.program.Program;
import com.algen.program.ProgramStrategy;
import com.algen.model.TestSuite;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgenPluginApplication {

    public static void main(String[] args) {
//		SpringApplication.run(AlgenPluginApplication.class, args);

        Algen algen = new Algen();
        if (args.length == 0) {
            System.out.println("Invalid command line input (Provide program name)");
            return;
        }
        Program program = ProgramStrategy.getProgram(args[0]);
        if (program == null) {
            System.out.println("Invalid command line input (Provide valid program name)");
            return;
        }
        Long waktuMulai = System.nanoTime();
        TestSuite testSuite = algen.testSuiteGeneration(program);
        Long waktuSelesai = System.nanoTime();
        System.out.println("Waktu Eksekusi: " + ((waktuSelesai - waktuMulai) * Math.pow(10, -9)) + " detik");
    }

}
