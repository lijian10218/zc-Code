package com.lijian.home;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Date:2020-12-20
 * @Author:lijian
 **/
@RestController
public class HtmlController {

    @GetMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index2";
    }


}
