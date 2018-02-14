package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.CircleDAO;
import com.niit.model.Circle;



@RestController
@RequestMapping(value="/circle")
public class CircleController {
	@Autowired
	CircleDAO circledao;
	
	//All circles fetching
	@RequestMapping(value = "/allCircles", method = RequestMethod.GET)
    public ResponseEntity<List<Circle>> listAllCircles() 
    {
        List<Circle> circles = circledao.getAllCircles();
        if(circles.isEmpty())
        {
            return new ResponseEntity<List<Circle>>(HttpStatus.NO_CONTENT);
        }
        else
        {
        	return new ResponseEntity<List<Circle>>(circles, HttpStatus.OK);
        }
    }
	
	//Create Circle
	@RequestMapping(value = "/createCircle", method = RequestMethod.POST)
    public ResponseEntity<Circle> createCircle(@RequestBody Circle circle)
    {
		circledao.createCircle(circle);
        	return new ResponseEntity<Circle>(circle, HttpStatus.OK);
    }
	
	
	//Deactivate
	@RequestMapping("/deactivate/{cicleId}")
    public ResponseEntity<Circle> deleteUser(@PathVariable("cicleId") int cicleId)
	{
       
		Circle circle = circledao.deactivateCircle(cicleId);
        if (circle == null) 
        {
            System.out.println("Unable to deactivate....circle " + circle.getEmail() + " not found");
            return new ResponseEntity<Circle>(HttpStatus.NOT_FOUND);
        }
        else
        {
        	circledao.deactivateCircle(circle);
        return new ResponseEntity<Circle>(circle,HttpStatus.OK);
        }
    }
	
	
	
	
}
