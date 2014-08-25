package com.hxj.websimplejava.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloSpringMvc {

    /**
     * ���������Խ��ܵĲ���(����������˳��û������)�� HttpServletRequest,HttpServletResponse,HttpSession(session�����ǿ��õ�) ,PrintWriter,Map,Model,@PathVariable(������)�� @RequestParam������������ @CookieValue ������������@RequestHeader��Object��pojo���� ,BindingResult�ȵ�
     * 
     * ����ֵ�����ǣ�String(��ͼ��)��void������ֱ��response����ModelAndView��Map ��Model�����������������͵Ķ���Ĭ�Ϸ���model�У����Ƽ����͵�����ĸ�ĳ�Сд������ͼ��Ĭ��������·��
     */
    @RequestMapping("/helloWorld")
    public ModelAndView helloWorld() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        mav.addObject("message", "Hello World!");
        return mav;
    }
}
