package com.israelsoto.SpringAPI.controller;

import com.israelsoto.SpringAPI.SpringApiApplication;
import org.apache.commons.io.IOUtils;
import com.israelsoto.SpringAPI.model.Image;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ImageController {

    public static Map<String,Image> imageStore = new HashMap<>();
    static {
        Image car = new Image();
        car.setId("1");
        car.setName("Car");
        car.setImagePath("images/Image01.jpg");
        imageStore.put(car.getId(), car);

        Image truck = new Image();
        truck.setId("2");
        truck.setName("Truck");
        truck.setImagePath("images/Image02.jpg");
        imageStore.put(truck.getId(), truck);
    };

    // http://localhost:8080/api/images/2
    @RequestMapping(value = "/api")
    public ResponseEntity<Object> getImages(){
        return new ResponseEntity<>(imageStore.values(),HttpStatus.OK);
    }

    @RequestMapping(value = "/api/images/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable("id") String id) throws IOException {

        InputStream in = new FileInputStream("/Users/israelsoto/IdeaProjects/SpringAPI/src/main/resources/" +
                imageStore.get(id).getImagePath());
         return IOUtils.toByteArray(in);
    }

}
