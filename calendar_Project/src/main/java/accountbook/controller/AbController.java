package accountbook.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import accountbook.bean.MakeCalendar;

@Controller
@RequestMapping("/accountbook")
public class AbController {
	@GetMapping("/accountbook")
	public String accountbook() {
		return "accountBook/accountBook";
	}
	
	@PostMapping("/makeCalendar")
	@ResponseBody
	public Map<String, Object> makeCalendar(int year, int month) {
		System.out.println(year + ", " + month);
		MakeCalendar mc = new MakeCalendar();
		
		mc.makeDays(year, month);
		Map<String, Object> map = new HashMap<>();
		for(int i = 0; i < mc.getDays().length; i++) {
			map.put(i+1+"", mc.getMonths()[i]+"."+mc.getDays()[i]);
		}
		return map;
	}
}


