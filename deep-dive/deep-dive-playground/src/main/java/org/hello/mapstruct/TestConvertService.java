package org.hello.mapstruct;

import org.springframework.stereotype.Service;

@Service
public class TestConvertService {

    public String getValueById(Long id) {
        return "No: " + id;
    }
}
