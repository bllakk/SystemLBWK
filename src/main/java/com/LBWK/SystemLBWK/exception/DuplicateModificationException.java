package com.LBWK.SystemLBWK.exception;

public class DuplicateModificationException extends RuntimeException{
    public DuplicateModificationException(String modificationName) {
        super("Modification already exists: " + modificationName);
    }
}