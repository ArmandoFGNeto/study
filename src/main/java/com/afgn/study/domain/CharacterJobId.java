package com.afgn.study.domain;

import java.io.Serializable;
import java.util.Objects;

public class CharacterJobId implements Serializable {

    private Character myCharacter;
    private Job myJob;

    public CharacterJobId() {}

    public CharacterJobId(Character character, Job job) {
        myCharacter = character;
        myJob = job;
    }

    public Character getMyCharacter() {
        return myCharacter;
    }

    public void setMyCharacter(Character myCharacter) {
        this.myCharacter = myCharacter;
    }

    public Job getMyJob() {
        return myJob;
    }

    public void setMyJob(Job myJob) {
        this.myJob = myJob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CharacterJobId that = (CharacterJobId) o;
        return myCharacter.equals(that.myCharacter) &&
               myJob.equals(that.myJob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myCharacter, myJob);
    }
}
