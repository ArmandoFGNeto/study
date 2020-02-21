package com.afgn.study.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterTest {

    @Test
    public void shouldBuildNewCharacterWithNameAndJob() {
        Job job = Job.newBuilder()
                .withName("Squire")
                .withLevel(2)
                .build();
        Character character = Character.newBuilder()
                .withName("someName")
                .withJobs(Collections.singleton(
                        CharacterJob.newBuilder()
                                .withJob(job)
                                .build()))
                .build();

        assertThat(character.getName()).isEqualTo("someName");
        assertThat(character.getJobs().size()).isEqualTo(1);
        assertThat(character.getJobs().contains(job));
    }
}