package com.crypto.exchange.server.mappers;

public interface BaseMapper<DTO, Entity> {
    Entity mapDTOtoEntity(DTO dto);
    DTO mapEntityToDTO(Entity entity);
}