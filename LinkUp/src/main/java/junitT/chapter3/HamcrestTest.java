package junitT.chapter3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.hasItem;

public class HamcrestTest {
    private List<String> values;

    @Before
    public void setUpList() {
        values = new ArrayList<>();
        values.add("x");
        values.add("y");
        values.add("z");
    }

    /**
     * hamcrest 匹配器
     */
    @Test
    public void testWithoutHamcrest() {
//        assertTrue(values.contains("one") || values.contains("two") || values.contains("three"));
        assertThat(values, hasItem(anyOf(equalTo("One"), equalTo("Two"), equalTo("Three"))));
    }

    /**
     * 常用的 hamcrest匹配器
     */
    @Test
    public void testGeneralHamcrest() {
        assertThat(values, anything("x"));
    }
}
