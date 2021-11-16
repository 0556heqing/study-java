package com.heqing.java.convert;

import com.alibaba.fastjson.JSONObject;
import com.heqing.java.convert.model.Address;
import com.heqing.java.convert.model.PersonBO;
import com.heqing.java.convert.model.PersonDTO;
import com.heqing.java.convert.model.PersonEnum;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;

public class BaseConvert {

    PersonBO personBO = new PersonBO();
    List<PersonDTO> personDTOList = new ArrayList<>();

    @BeforeEach
    public void base() {
        JSONObject remark = new JSONObject();
        remark.put("number", 1);
        remark.put("string", "test");
        Address address = new Address();
        address.setProvice("安徽");
        address.setCity("安庆");
        address.setArea("宿松");
        personBO.setId(1L);
        personBO.setName("贺小白");
        personBO.setSex(1);
        personBO.setDate(new Date());
        List<String> nameParts = new ArrayList<>();
        nameParts.add("贺");
        nameParts.add("小白");
        personBO.setNameParts(nameParts);
        Map<String, Object> map = new HashMap<>();
        map.put("number", 1);
        map.put("string", "test");
        personBO.setRemarkMap(map);
        personBO.setAddress(address);
        personBO.setType(PersonEnum.ADULT);
        personBO.setRemarkJson(remark.toJSONString());

        for(int i=0; i<3; i++) {
            PersonDTO personDTO = new PersonDTO();
            personDTO.setId(1L+i);
            personDTO.setName("贺小白"+i);
            personDTO.setGender("1");
            remark = new JSONObject();
            remark.put("number", 1+i);
            remark.put("string", "test"+i);
            personDTO.setRemarkJson(remark.toJSONString());
            personDTO.setDate("2020-09-09 19:37:41");
            personDTO.setFirstName("贺"+i);
            personDTO.setLastName("测试"+i);
            map = new HashMap<>();
            map.put("number", 1+i);
            map.put("string", "test"+i);
            personDTO.setRemarkMap(map);
            personDTO.setType(PersonEnum.ADULT);
            personDTOList.add(personDTO);
        }

    }
}
