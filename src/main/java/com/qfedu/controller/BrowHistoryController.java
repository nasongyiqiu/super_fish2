package com.qfedu.controller;

import com.qfedu.service.IBrowHistoryService;
import com.qfedu.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowHistoryController {
    @Autowired
    private IBrowHistoryService browHistoryService;

    @GetMapping("/findAllBH.do")
    public PageBean findAllBrowHistory(int page, int size) {
        return browHistoryService.findAllBrowHistoty(page, size);
    }
}
