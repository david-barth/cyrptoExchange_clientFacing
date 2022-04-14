package com.crypto.exchange.server.mappers.impl;

import com.crypto.exchange.server.mappers.BaseMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class AssetProfileMapper<DTO, Entity> implements BaseMapper<DTO, Entity> {

    //Hold fields gained from Breadth-first traversal
    List<Object> fieldList = new ArrayList<>();

    //Hold nested objects:
    List<Object> nestObjects = new ArrayList<>();


    public DTO mapDTOtoEntity(Entity entity) {

    };

    public Entity mapEntityToDTO(DTO dto) {


    };

    //Get Fields from objects:
    private List<Object> getFields(Object rootObject) {

        Field[] objectFields = rootObject.getClass().getFields();

        boolean isOnlyPrimitive = true;

        while (isOnlyPrimitive) {


            //Do some more stuff
            


        }



    };

    private boolean containsOnlyPrimitives(Field[] objectFields) {
        boolean hasOnlyPrimitives = true;
        for (Field field : objectFields) {
            Class<?> fieldType = field.getType();
            if (!fieldType.isPrimitive()) {
                hasOnlyPrimitives = false;
            }
        }
        return hasOnlyPrimitives;
    }


}
