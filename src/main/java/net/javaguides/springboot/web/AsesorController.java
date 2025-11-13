package net.javaguides.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AsesorController {

    @GetMapping("/asesor/home")
    public String asesorHome() {
        return "asesor_home"; // busca la vista asesor_home.html
    }
}
