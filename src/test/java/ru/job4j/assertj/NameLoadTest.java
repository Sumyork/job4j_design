package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkArraysIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        String[] names = new String[0];
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    @Test
    void checkSymbol() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {"key=value", "key1 = value1", "key2:value2"};
        String name = "key2:value2";
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(name)
                .hasMessageContaining("key2:value2");
    }

    @Test
    void checkKey() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {" key=value", "=key1value1", "key2=value2"};
        String name = "=key1value1";
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(name);
    }

    @Test
    void checkValue() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {"keyvalue  =", "=key1value1", "key2=value2"};
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("keyvalue  =");
    }
}