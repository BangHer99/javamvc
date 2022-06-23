package santri.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import santri.dto.SearchFromData;
import santri.entity.NamaSantri;
import santri.services.SantriService;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private SantriService santriService;

    @GetMapping
    public String welcome(Model model) {
        String messages = "Santri Balap";
        model.addAttribute("msg", messages);
        model.addAttribute("searchfrom", new SearchFromData());
        model.addAttribute("santries", santriService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String Add(Model model, String string) {
        model.addAttribute("santri", new NamaSantri());
        return "add";
    }

    @PostMapping("/save")
    public String save(NamaSantri namaSantri, Model model) {
        santriService.addSantri(namaSantri);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        santriService.deleteById(id);
        return "redirect:/";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("santri", santriService.findById(id));
        return "edit";

    }

    @PostMapping("/update")
    public String update(NamaSantri namaSantri, Model model) {
        santriService.updateSantri(namaSantri);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(SearchFromData searchFromData, Model model) {
        String messages = "Santri Balap";
        model.addAttribute("msg", messages);
        model.addAttribute("searchfrom", searchFromData);
        model.addAttribute("santries", santriService.findByName(searchFromData.getKeyword()));
        return "index";
    }

}
