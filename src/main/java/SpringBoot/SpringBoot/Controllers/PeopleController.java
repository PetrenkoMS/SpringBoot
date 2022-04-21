package SpringBoot.SpringBoot.Controllers;

import SpringBoot.SpringBoot.DB.PeopleRepository;
import SpringBoot.SpringBoot.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import SpringBoot.SpringBoot.model.PeopleModel;

@Controller
public class PeopleController {
    private PeopleService peopleService = new PeopleService();

    @Autowired
    private PeopleRepository peopleRepository;

//    @PostMapping("/people")
//    public @ResponseBody String addNewPeople (@RequestParam String name, @RequestParam String secondName) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

//        PeopleModel n = new PeopleModel();
//        n.setName(name);
//        n.setSecondName(secondName);
//        peopleRepository.save(n);
//        return "Saved";
//    }

    @GetMapping("/registration")
    public String peopleForm(Model model) {
        model.addAttribute("people", new PeopleModel());
        return "registration";
    }

    @PostMapping("/people")
    public String peopleSubmit(@ModelAttribute PeopleModel people, Model model) {
        model.addAttribute("people", people);
        String name = people.getName();
        String secondName = people.getSecondName();
        int age = people.getAge();
        String gender = people.getGender();
        int series = people.getSeriesPassport();
        int number = people.getNumberPassport();
        String telephone = people.getTelephone();

        PeopleModel peopleNew = new PeopleModel();
        peopleNew.setName(name);
        peopleNew.setSecondName(secondName);
        peopleNew.setAge(age);
        peopleNew.setGender(gender);
        peopleNew.setSeriesPassport(series);
        peopleNew.setNumberPassport(number);
        peopleNew.setTelephone(telephone);


        peopleRepository.save(peopleNew);
        return "people";
    }

//    @RequestMapping("/people")
//    public @ResponseBody String welcome(){
//        PeopleModel people = peopleService.list();
//        String name = people.get(0).getName();
//        int age = people.get(0).getAge();
//        String secondName = people.get(0).getSecondName();
//
//        String peoples = name + " " + secondName + " " + age;
//        return peoples;
//    }

//    @GetMapping(path = "/people")
//    public List<PeopleModel> list() {
//        return peopleService.list();
//    }
}
