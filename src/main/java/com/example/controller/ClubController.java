package com.example.controller;

import com.example.dto.ClubDTO;
import com.example.services.ClubService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@ResponseBody
public class ClubController {
    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }
    @GetMapping("say")
    public String say()
    {
        return "Hello World";
    }
    @GetMapping("clubs")
    public String listClub(@NotNull Model model)
    {
        List<ClubDTO> list=clubService.findAllClub();
        model.addAttribute("clubs",list);
        return "club-list";
    }
}
