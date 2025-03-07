package com.msislab.robot_ai.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.msislab.robot_ai.model.CommonType;
import com.msislab.robot_ai.service.CommonTypeService;;;

@RestController
@RequestMapping("/api/common-types")
public class CommonTypeController {

    @Autowired
    private CommonTypeService commonTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommonType createCommonType(@RequestBody CommonType commonType) {
        // Call the service to create a new CommonType
        return commonTypeService.createCommonType(commonType);
    }
}