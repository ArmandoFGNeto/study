package com.afgn.study.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    public void shouldBuildNewJobWithNameAndLevel() {
        Job job = Job.newBuilder()
                .withName("someName")
                .withLevel(3)
                .build();

        assertThat(job).extracting("name", "level").containsExactly("someName", 3);
    }

    @Test
    public void shouldBuildNewJobWithName() {
        Job job = Job.newBuilder()
                .withName("someName")
                .build();

        assertThat(job).extracting("name", "level").containsExactly("someName", 0);
    }

    @Test
    public void shouldBuildNewJobWithLevel() {
        Job job = Job.newBuilder()
                .withLevel(3)
                .build();

        assertThat(job).extracting("name", "level").containsExactly(null, 3);
    }
}