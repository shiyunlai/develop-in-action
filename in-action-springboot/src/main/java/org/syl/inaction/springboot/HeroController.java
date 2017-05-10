/**
 * 
 */
package org.syl.inaction.springboot;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * ng2学习
 * 
 * 提供Hero的服务端http接口
 * 
 * 查询所有记录 GET    http://ip:port/hero
 * 查询翻页记录 POST   http://ip:port/hero/page
 * 新增记录    POST   http://ip:port/hero
 * 根据ID查记录 GET    http://ip:port/hero/{id}
 * 根据ID删记录 DELETE http://ip:port/hero/{id}
 * 根据ID改记录 PUT    http://ip:port/hero/{id}
 * 
 * </pre>
 * @author megapro
 *
 */
@RestController()
@RequestMapping("/hero")
public class HeroController {
	
	/**
	 * 查询所有记录(谨慎调用，服务端根据记录数量考虑是否对外提供)
	 * @return
	 */
	@GetMapping
	public String listAll(){
		return ""  ;
	}

	/**
	 * 查询记录，带翻页功能
	 * @return
	 */
	@PostMapping("/page")
	public String listByPage(){
		return ""  ;
	}

	/**
	 * 根据ID查询记录
	 * @return
	 */
	@GetMapping("/{id}")
	public String getById(String id){
		return ""  ;
	}
	
	/**
	 * 根据ID删除记录
	 * @return
	 */
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id")String id){
		return ""  ;
	}
	
	/**
	 * 新增记录
	 * @return
	 */
	@PostMapping
	public String create(){
		return ""  ;
	}

	/**
	 * 修改记录
	 * @return
	 */
	@PutMapping
	public String update(){
		return ""  ;
	}
}
