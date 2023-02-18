package com.rabbit.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getNoticeList() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<NoticeDTO> ar = noticeService.getNoticeList();
		
		mv.setViewName("notice/list");
		mv.addObject("notice", ar);
		return mv;
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getNoticeDetail(NoticeDTO noticeDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		noticeDTO = noticeService.getNoticeDetail(noticeDTO);
		
		mv.setViewName("notice/detail");
		mv.addObject("dto", noticeDTO);
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView setNoticeAdd() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/add");
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView setNoticeAdd(NoticeDTO noticeDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setNoticeAdd(noticeDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setNoticeUpdate(NoticeDTO noticeDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeDTO = noticeService.getNoticeDetail(noticeDTO);
		mv.setViewName("notice/update");
		mv.addObject("dto", noticeDTO);
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView setNoticeUpdate(NoticeDTO noticeDTO, ModelAndView mv) throws Exception{
		int result = noticeService.setNoticeUpdate(noticeDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView setNoticeDelete(NoticeDTO noticeDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setNoticeDelete(noticeDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
}
