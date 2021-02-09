package com.springbootexample.exampleproject.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAlltopics(){
		return topicService.getAlltopics();
	}
	// there are some limitations on using get method like maximum 
	//range should not extend range of 2,048 characters
	//in internet explorer when we send payload in pathvariables so 
	//we can do post request instead of get request(send payload in body).this will gives security
	@RequestMapping(method=RequestMethod.POST, value="/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@PathVariable String id,@RequestBody Topic topic) {
		 topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void updateTopic(@PathVariable String id) {
		 topicService.deleteTopic(id);
	}
	

 }
