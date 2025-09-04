package com.gucci;

import com.gucci.data.FakeData;
import org.assertj.core.api.SoftAssertions;

public class Main {
    public static void main(String[] args) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat("Kairat").as("Karat==Kairat?").isEqualTo("Kairat");

    }
}
