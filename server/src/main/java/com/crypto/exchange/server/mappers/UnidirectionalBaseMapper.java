package com.crypto.exchange.server.mappers;

public interface UnidirectionalBaseMapper<A, B> {
    A mapObject(B B);
}