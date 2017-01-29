/**
 * 
 */
package org.syl.inaction.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.syl.inaction.springboot.exceptionstatus.ResourceNotFoundException;

/**
 * 
 * @author megapro
 *
 */
//为了能够进行模板渲染，需要将@RestController改成@Controller：
@Controller
public class GreetingController {
	
	/**
	 * 使用模版渲染，将java逻辑与view展示能力分离
	 * @param name
	 * @param model
	 * @return 模版名称
	 */
	@GetMapping("/greeting/{userName}")
	public String greeting(@PathVariable("userName") String name,Model model){
		model.addAttribute("name", name);
		return "hello" ; //返回模版名称，对应 hello.html
	}
	
	
	@RequestMapping(value="/resource/{GUID}", method=RequestMethod.GET)
	public String getResource( @PathVariable("GUID") String guid, Model model){
		if ( ! guid.equals("123") ) throw new ResourceNotFoundException();
		model.addAttribute("name", guid);
		return "hello" ; //返回资源的详情界面 模版
	}
}
