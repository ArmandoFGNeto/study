package com.afgn.study.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "characters_jobs")
@IdClass(CharacterJobId.class)
public class CharacterJob implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character myCharacter;

    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job myJob;

    private CharacterJob() {}

    private CharacterJob(Builder builder) {
        myCharacter = builder.myCharacter;
        myJob = builder.myJob;
    }

    public Character getCharacter() {
        return myCharacter;
    }

    public Job getJob() {
        return myJob;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Character myCharacter;
        private Job myJob;

        public Builder() {}

        public Builder(CharacterJob characterJob) {
            myCharacter = characterJob.myCharacter;
            myJob = characterJob.myJob;
        }

        public Builder withCharacter(Character character) {
            myCharacter = character;
            return this;
        }

        public Builder withJob(Job job) {
            myJob = job;
            return this;
        }

        public CharacterJob build() {
            return new CharacterJob(this);
        }
    }
}
