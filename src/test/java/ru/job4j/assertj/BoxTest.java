package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .containsIgnoringCase("sphere")
                .doesNotContain("cube")
                .startsWith("Sp")
                .startsWithIgnoringCase("s")
                .endsWith("re")
                .isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 2);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .containsIgnoringCase("cube")
                .doesNotContain("Tetrahedron")
                .startsWith("C")
                .startsWithIgnoringCase("c")
                .endsWith("e")
                .isEqualTo("Cube");
    }

    @Test
    void isThisCubeArea() {
        Box box = new Box(8, 4);
        Double area = box.getArea();
        assertThat(area).isNotZero()
                .isPositive()
                .isGreaterThan(95)
                .isLessThan(100)
                .isEqualTo(96);
    }

    @Test
    void isThisTetrahedronArea() {
        Box box = new Box(4, 2);
        Double area = box.getArea();
        assertThat(area).isEqualTo(6.93d, withPrecision(0.005d))
                .isCloseTo(6.91d, withPrecision(0.02d))
                .isCloseTo(6.91d, Percentage.withPercentage(1.0d))
                .isGreaterThan(6.91d)
                .isLessThan(6.93d);
    }
}