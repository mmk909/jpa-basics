package com.example.crud.exceptions;


public class VersionIDException extends  Exception {
    public VersionIDException(Long id, Long version){
        super("resource with id=" + id + " and version=" + version + " does not exist");
    }
}
