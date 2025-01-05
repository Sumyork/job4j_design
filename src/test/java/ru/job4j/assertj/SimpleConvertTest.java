package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("java", "c++", "python", "java");
        assertThat(list).isNotEmpty()
                .hasSize(4)
                .contains("java", Index.atIndex(0))
                .containsOnly("python", "java", "c++")
                .containsExactly("java", "c++", "python", "java")
                .doesNotContain("go", "c#")
                .startsWith("java", "c++")
                .endsWith("python", "java")
                .containsSequence("c++", "python");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("cat", "dog", "ferret", "duck", "fox", "wolf", "pig", "squirrel");
        assertThat(set).hasSize(8)
                .contains("cat")
                .containsAnyOf("mosquito", "squirrel", "spider")
                .containsExactlyInAnyOrder("cat", "squirrel", "ferret", "dog", "pig", "duck", "wolf", "fox")
                .doesNotContain("hyena");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap(
                "first", "second", "three", "four");
        assertThat(map).hasSize(4)
                .containsKeys("second", "four")
                .containsValues(3, 2, 1)
                .doesNotContainKey("five")
                .doesNotContainValue(5)
                .containsEntry("first", 0);
    }
}