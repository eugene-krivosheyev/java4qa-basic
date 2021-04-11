package demo;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static java.math.BigDecimal.valueOf;

public strictfp class FPPresicionDemo {
    public strictfp static void main(String[] args) {
        //IEEE 754: как хранить + арифметика
        System.out.println(.2 + .1); //BigDecimal
        BigDecimal db = valueOf(1.); //Factory Method -> constructor alt.
    }
}
