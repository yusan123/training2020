package com.yu.day0519;

import java.util.Objects;

/**
 * @Author yu
 * @DateTime 2020/5/19 12:36
 */
public class EqualTest {

    private String name;

    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualTest equalTest = (EqualTest) o;
        return age == equalTest.age &&
                Objects.equals(name, equalTest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
