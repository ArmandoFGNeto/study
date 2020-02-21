package com.afgn.study.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private UUID myId;

    @Column(name = "name")
    private String myName;

    @Column(name = "level")
    private int myLevel;

    @OneToMany(mappedBy = "myJob", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<CharacterJob> myCharacters;

    private Job() {}

    private Job(Builder builder) {
        myName = builder.myName;
        myLevel = builder.myLevel;
        myCharacters = builder.myCharacters;
    }

    public UUID getId() {
        return myId;
    }

    public String getName() {
        return myName;
    }

    public int getLevel() {
        return myLevel;
    }

    public Set<CharacterJob> getCharacters() {
        return myCharacters;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilderFromCurrent(Job job) {
        return new Builder(job);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Job job = (Job) o;
        return myLevel == job.myLevel &&
               myId.equals(job.myId) &&
               myName.equals(job.myName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myId, myName, myLevel);
    }

    public static class Builder {
        private String myName;
        private int myLevel;
        private Set<CharacterJob> myCharacters;

        private Builder() {}

        private Builder(Job job) {
            myName = job.getName();
            myLevel = job.getLevel();
            myCharacters = job.getCharacters();
        }

        public Builder withName(String name) {
            myName = name;
            return this;
        }

        public Builder withLevel(int level) {
            myLevel = level;
            return this;
        }

        public Builder withCharacters(Set<CharacterJob> characters) {
            myCharacters = characters;
            return this;
        }

        public Job build() {
            return new Job(this);
        }
    }
}