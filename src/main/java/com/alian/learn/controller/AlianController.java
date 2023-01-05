package com.alian.learn.controller;

import com.alian.learn.entity.Alian;
import com.alian.learn.repo.AlianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

@Controller
public class AlianController {

    @Autowired
    AlianRepo alianRepo;

    @GetMapping(path = "/home")
    public String home() {
        return "home.jsp";
    }

    @GetMapping(path = "/getAlian")
    public ModelAndView getAlian(@RequestParam("id") int aid) {

        ModelAndView mv = new ModelAndView("alianshow.jsp");
        Optional<Alian> alian = alianRepo.findById(aid);
        AtomicReference<Alian> alian1 = new AtomicReference<>();
        alian.ifPresent(alian2 -> {
            alian1.set(alian2);
        });
        mv.addObject("obj", alian1.toString());
        return mv;
    }

    @GetMapping(path = "/getAllAlians")
    public ModelAndView getAllAlians() {

        ModelAndView mv = new ModelAndView("alianshow.jsp");
        Iterable<Alian> all = alianRepo.findAll();
        StringBuilder builder = new StringBuilder("");
        all.forEach(alian -> {
            builder.append(alian.toString());
        });
        mv.addObject("obj", all);
        return mv;
    }


    @PostMapping("/saveAlian")
    public String getAlian(Alian alian) {
        alianRepo.save(alian);
        return "home.jsp";
    }

    @DeleteMapping("/deleteAlian")
    public String deleteAlian(@RequestParam("id") int deleteId) {
        try {
            alianRepo.delete(alianRepo.findById(deleteId).orElse(new Alian()));

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        System.out.println("deleted.");
        return "home.jsp";
    }


}
