package com.kh.app07.home;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
public class HomeController {

    @GetMapping("home")
    public void home(){}


    @PostMapping("test")
    @ResponseBody
    public void test(@RequestParam(required = false) MultipartFile f, HttpServletRequest req) throws IOException {
        String filePath = "D:\\dev\\uploads\\";
        String fileName = System.currentTimeMillis()+"_"+UUID.randomUUID();
        String ext = f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf("."));
        File targetFile = new File(filePath+fileName+ext);
        f.transferTo(targetFile );
    }

    @PostMapping("tetete")
    public void tetest(List<MultipartFile> f) throws IOException {

        for (MultipartFile file : f){
            String filePath = "D:\\dev\\uploads";
            String fileName = System.currentTimeMillis()+"_"+UUID.randomUUID();
            String dot = file.getOriginalFilename();
            String ext = dot.substring(dot.lastIndexOf("."));
            File targetFile = new File(filePath+fileName+ext);
            file.transferTo(targetFile);
        }


    }












}
