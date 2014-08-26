package com.hxj.websimplejava.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxj.websimplejava.workflow.SequenceProcessor;

/**
 * @author xiangjun.hexj
 * @date 2014年8月25日 下午5:11:36
 */
@Controller
public class ProcessorController {

    @Resource(name = "sequenceProcess1")
    private SequenceProcessor sequenceProcessor;

    @RequestMapping("/processor")
    public String processor(Model model) {
        String message = "process";
        sequenceProcessor.doActivities();
        model.addAttribute("message", message);
        return "processor";
    }
}
