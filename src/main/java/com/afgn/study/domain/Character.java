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

import static java.util.Set.copyOf;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private UUID myId;

    @Column(name = "name")
    private String myName;

    @OneToMany(mappedBy = "myCharacter", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<CharacterJob> myJobs;

    private Character() {}

    private Character(Builder builder) {
        myName = builder.myName;
        myJobs = builder.myJobs;
    }

    public UUID getId() {
        return myId;
    }

    public String getName() {
        return myName;
    }

    public Set<CharacterJob> getJobs() {
        return myJobs;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilderFromCurrent(Character character) {
        return new Builder(character);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Character character = (Character) o;
        return myId.equals(character.myId) &&
               myName.equals(character.myName) &&
               myJobs.equals(character.myJobs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myId, myName, myJobs);
    }

    public static class Builder {
        private UUID myId;
        private String myName;
        private Set<CharacterJob> myJobs;

        private Builder() {}

        private Builder(Character character) {
            myId = character.getId();
            myName = character.getName();
            myJobs = character.getJobs();
        }

        public Builder withName(String name) {
            myName = name;
            return this;
        }

        public Builder withJobs(Set<CharacterJob> jobs) {
            myJobs = copyOf(jobs);
            return this;
        }

        public Character build() {
            return new Character(this);
        }
    }
}
