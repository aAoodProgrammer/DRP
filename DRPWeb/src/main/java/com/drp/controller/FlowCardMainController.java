package com.drp.controller;

import com.drp.repository.FlowCardMainRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/flowCard")
public class FlowCardMainController {
    @Resource
    private FlowCardMainRepository flowCardMainRepository;

}
