package com.LBWK.SystemLBWK.exception;

public class PartUnavailableException extends RuntimeException{
    public PartUnavailableException(String part){
        super("Part unavailable or insufficient in stock: " + part);
    }
}