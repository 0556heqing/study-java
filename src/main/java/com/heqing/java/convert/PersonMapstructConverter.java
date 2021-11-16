package com.heqing.java.convert;

import com.heqing.java.convert.model.PersonBO;
import com.heqing.java.convert.model.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author heqing
 */
@Mapper(uses= DateMapstructMapper.class)
public interface PersonMapstructConverter {

    PersonMapstructConverter INSTANCE = Mappers.getMapper(PersonMapstructConverter.class);

    /**
     * 对象类型转化
     * @param personBo
     * @return
     */
    @Mappings({
            @Mapping(source = "sex", target = "gender"),
            @Mapping(source = "date", target = "date", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    PersonDTO do2dto(PersonBO personBo);

    /**
     * 对象类型转化
     * @param personDTO
     * @return
     */
    @Mappings({
            @Mapping(source = "gender", target = "sex"),
            @Mapping(source = "date", target = "date", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    PersonBO dto2do(PersonDTO personDTO);

    /**
     * 对象类型转化
     * @param personDtoList
     * @return
     */
    List<PersonBO> dtos2dos(List<PersonDTO> personDtoList);

}
