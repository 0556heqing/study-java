package com.heqing.java.convert;

import com.alibaba.fastjson.JSONObject;
import com.heqing.java.convert.model.PersonBO;
import com.heqing.java.convert.model.PersonDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudyMapstruct extends BaseConvert {

    @Test
    public void testObject() {
        System.out.println("BO --> "+personBO);
        PersonDTO personDTO = PersonMapstructConverter.INSTANCE.do2dto(personBO);
        System.out.println("DTO --> "+personDTO);
    }

    @Test
    public void testObjectList() {
        System.out.println("DTO --> "+JSONObject.toJSONString(personDTOList));
        List<PersonBO> personBOList = PersonMapstructConverter.INSTANCE.dtos2dos(personDTOList);
        System.out.println("BO --> "+JSONObject.toJSONString(personBOList));
    }

}
