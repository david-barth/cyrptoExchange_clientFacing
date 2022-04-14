package com.crypto.exchange.server.mappers;

public interface BaseMapper<DTO, Entity> {
    DTO mapDTOtoEntity(Entity entity);
    Entity mapEntityToDTO(DTO dto);
}