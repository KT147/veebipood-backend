package ee.kevin.veebipood_backend.controller;

import ee.kevin.veebipood_backend.entity.Picture;
import ee.kevin.veebipood_backend.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class PictureController {

    @Autowired
    private PictureRepository pictureRepository;

    @GetMapping("pictures")
    public List<Picture> getPictures() {
        return pictureRepository.findAll(); // Tagataustal: select * from pictures;
    }

    @PostMapping("pictures")
    public List<Picture> savePictures(@RequestBody Picture picture) {
        pictureRepository.save(picture); // Tagataustal: insert values into pictures
        return pictureRepository.findAll(); // Tagataustal: select * from pictures;
    }
}