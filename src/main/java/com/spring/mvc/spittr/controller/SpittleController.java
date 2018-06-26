package com.spring.mvc.spittr.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.spittr.data.SpittleRepository;
import com.spring.mvc.spittr.pojo.Spittle;
import com.spring.mvc.spittr.pojo.SpittleForm;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private static final String MAX_LONG_AS_STRING = "9223372036854775807";

	private SpittleRepository spittleRepository;

	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		System.out.println("=======================SpittleController create =====================");
		this.spittleRepository = spittleRepository;
	}

	/**
	 * "/spittles"GET请求
	 * @param max
	 * @param count
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Spittle> spittles(
				@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
				@RequestParam(value = "count", defaultValue = "20") int count) {
		return spittleRepository.findSpittles(max, count);
	}

	/**
	 * "/spittles/2" 将参数放在请求路径的GET请求
	 * @param spittleId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
	public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
		model.addAttribute(spittleRepository.findOne(spittleId));
		return "spittle";
	}

	
	/**
	 *"/spittles"表单提交POST请求
	 * @param form
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String saveSpittle(SpittleForm form, Model model) throws Exception {
		spittleRepository.save(new Spittle(null, form.getMessage(), new Date(), form.getLongitude(), form.getLatitude()));
		return "redirect:/spittles";  //redirect:能使请求重定向到/spittles，才能执行spittles方法返回结果列表，否则直接就返回到模型，没有返回数据。
	}

}
