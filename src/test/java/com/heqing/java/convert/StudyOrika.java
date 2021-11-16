package com.heqing.java.convert;

import com.alibaba.fastjson.JSONObject;
import com.heqing.java.convert.model.PersonBO;
import com.heqing.java.convert.model.PersonDTO;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudyOrika extends BaseConvert {

    private final static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();

    private static MapperFacade mapperFacade;

    @BeforeEach
    public void mapperRegister() {
        // 注意该classMap 只能注册一次。 否则会 java.lang.OutOfMemoryError: PermGen space
        mapperFactory.getConverterFactory().registerConverter("dateOrikaMapper", new DateOrikaMapper());
        mapperFactory.classMap(PersonBO.class, PersonDTO.class)
                .field("sex", "gender")
                .field("nameParts[0]", "firstName")
                .field("nameParts[1]", "lastName")
                .fieldMap("date", "date").converter("dateOrikaMapper").add()
                .byDefault().register();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Test
    public void testObject() {
        System.out.println("BO --> "+personBO);
        PersonDTO personDTO = new PersonDTO();
        mapperFacade.map(personBO, personDTO);
        System.out.println("DTO --> "+personDTO);
    }

    @Test
    public void testObjectList() {
        System.out.println("DTO --> "+JSONObject.toJSONString(personDTOList));
        List<PersonBO> personBOList = mapperFacade.mapAsList(personDTOList, PersonBO.class);
        System.out.println("BO --> "+JSONObject.toJSONString(personBOList));
    }
}
