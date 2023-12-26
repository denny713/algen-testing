package com.algen.function;

import com.algen.model.Kromosom;

import java.util.List;
import java.util.Random;

public class Mutate {

    private Mutate() {
        super();
    }

    public static void mutasi(List<Kromosom> populasiBaru, int m, Random random, double px) {
        if (populasiBaru.get(0) == null) {
            System.exit(15);
        }
        for (Kromosom kromosom : populasiBaru) {
            if (kromosom != null) {
                for (int i = 0; i < m; i++) {
                    float r = random.nextFloat();
                    if (r < px) {
                        kromosom.binaryData.set(i, (kromosom.binaryData.get(i) + 1) % 2);
                    }
                }
            }
        }
    }
}
