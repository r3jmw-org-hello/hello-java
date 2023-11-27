package org.hello.converter;

import org.hello.converter.model.TestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public abstract class ObjectToGenericTypeConverter {
    ObjectToGenericTypeConverter instance = Mappers.getMapper(ObjectToGenericTypeConverter.class);


//    @Mapping(target = "id", expression = """
//            java( java.util.Objects.nonNull(obj.get("id")) ? Long.valueOf(obj.get("id").toString()): null)
//            """)
//    @Mapping(target = "test", expression = """
//            java((String) obj.get("test"))
//            """)
//    abstract TestModel converter(LinkedHashMap<String, Object> obj);
//
//    abstract List<TestModel> converter(List<LinkedHashMap<String, Object>> obj);


}
