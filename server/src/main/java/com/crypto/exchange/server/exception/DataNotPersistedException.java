package com.crypto.exchange.server.exception;

import org.springframework.dao.DataAccessException;


public class DataNotPersistedException extends DataAccessException {
    public DataNotPersistedException(String msg) {
        super(msg);
    }
}
