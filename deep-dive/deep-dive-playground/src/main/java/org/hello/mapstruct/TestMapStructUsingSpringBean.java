package org.hello.mapstruct;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {TestConvertService.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public abstract class TestMapStructUsingSpringBean {

    public record TestValueModel(String value) {
    }

    public record TestIdModel(Long id) {
    }

    @Autowired
    public TestConvertService testConvertService;

    @Mapping(target = "value", expression = "java(testConvertService.getValueById(testIdModel.id()))")
    public abstract TestValueModel convert(TestIdModel testIdModel);
}
