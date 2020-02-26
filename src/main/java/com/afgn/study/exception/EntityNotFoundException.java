package com.afgn.study.exception;

public class EntityNotFoundException extends RuntimeException {

    private final String myEntityName;
    private final String myField;
    private final String myValue;
    private final String myMessage;

    public EntityNotFoundException(String entityName, String field, String value) {
        myEntityName = entityName;
        myField = field;
        myValue = value;
        myMessage = entityName + " with " + field + " with value " + value + " does not exist.";
    }

    public EntityNotFoundException(String entityName, String field, String value, String message) {
        myEntityName = entityName;
        myField = field;
        myValue = value;
        myMessage = message;
    }

    public String getMyEntityName() {
        return myEntityName;
    }

    public String getMyField() {
        return myField;
    }

    public String getMyValue() {
        return myValue;
    }

    public String getMyMessage() {
        return myMessage;
    }
}
