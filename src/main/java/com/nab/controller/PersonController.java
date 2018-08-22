package com.nab.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nab.entities.Person;
import com.nab.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/view-list", method = RequestMethod.GET)
	public ModelAndView listPerson() {
		ModelAndView mav = new ModelAndView("list-person");
		return mav;
	}
	//return search-person page
	@RequestMapping(value = "/search-person")
	public ModelAndView searchPerson() {
		ModelAndView mav = new ModelAndView("search-person");
		return mav;
	}
	//delete person
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public ModelAndView deletePerson(@PathVariable("id") int id) {
		ModelAndView mav=new ModelAndView("list-person");
		personService.delete(id);
		return mav;
	}
	//serch person
	@GetMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public JSONObject searchPersons(@RequestParam("key") String name,@RequestParam("page") int page,@RequestParam("pageSize") int pageSize){
		JSONObject json=new JSONObject();
		int position = (page-1) * pageSize;
		List<Person> list=personService.searchPersons(name,position,pageSize);
		float totalRow=(int) personService.countTotalRecord(name);
		int totalPage=(int) Math.ceil(totalRow/pageSize);;
		json.put("data", list);
		json.put("totalPage", totalPage);
		return json;
	}
	@GetMapping(value="/getData", produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<Person> getPersons(@RequestParam(value="page") int page, @RequestParam(value="pageSize") int pageSize) {
		int position = (page-1) * pageSize;
		List<Person> list=personService.getPersons(position, pageSize);
		return list;
	}
	@RequestMapping(value="/getTotalPages",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public int getTotalPages(@RequestParam(value="pageSize") int pageSize) {
		float totalRow=personService.countTotalRecord();
		int totalPage= (int) Math.ceil(totalRow/pageSize);
		return totalPage;
	}
	@RequestMapping(value="/getTotal",method = RequestMethod.GET)
	@ResponseBody
	public int getTotalPages(@RequestParam(value="key") String name,@RequestParam(value="pageSize") int pageSize) {
		long totalRow=personService.countTotalRecord(name);
		int totalPage= (int) Math.ceil(totalRow/pageSize);
		System.out.println(totalPage);
		return totalPage;
	}
	// Display form page
		@RequestMapping(value = "/add-person", method = RequestMethod.GET)
		public ModelAndView addEmployee() {
			ModelAndView mav = new ModelAndView("add-person");
			mav.addObject("person", new Person());
			return mav;
		}

		// Handing form
		@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
		public ModelAndView doAddPerson(@RequestParam("file") MultipartFile file, @ModelAttribute("Employee") Person person) {
			ModelAndView mav = new ModelAndView("add-done");
			String imageBase64=uploadImage(file);
			person.setAvatar(imageBase64);
			personService.save(person);
			mav.addObject("name", person.getName());
			return mav;
		}
		@RequestMapping(value = "/view-detail/{id}")
		public ModelAndView viewDetail(@PathVariable long id) {
			ModelAndView mav = new ModelAndView("view-detail");
			Person person = personService.findById(id);
			System.out.println(person.getName());
			mav.addObject("person", person);
			return mav;
		}
		//Change image to Base64
		static private String uploadImage(MultipartFile file) {
			String image;
			if (!file.isEmpty()) {
				try {
					byte imageData[] = file.getBytes();
					image = Base64.getEncoder().encodeToString(imageData);
					return image;

				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("File is Empty");
			}
			return null;		
		}
}
