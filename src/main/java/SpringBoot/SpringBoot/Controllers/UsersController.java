package SpringBoot.SpringBoot.Controllers;


import SpringBoot.SpringBoot.model.PeopleModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/users")
public class UsersController {
    private List<PeopleModel> USERS = Stream.of(
            new PeopleModel(1,"log1","pass", "Ivan","Ivanov","M",23, 1222, 321123, "89008763425"),
            new PeopleModel(2, "log2","pass","Sergey","Ivanovich","M",33, 1222, 321123, "89003333425"),
            new PeopleModel(3, "log3","pass","Ai","Abdulov","M",23, 1442, 321123, "88008763425")
    ).collect(Collectors.toList());

    @GetMapping
    public List<PeopleModel> getAll(){
        return USERS;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public PeopleModel getById(@PathVariable int id) {
        return USERS.stream().filter(people -> Objects.equals(people.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    public PeopleModel create(@RequestBody PeopleModel people) {
        this.USERS.add(people);
        return people;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void deleteById(@PathVariable int id) {
        this.USERS.removeIf(people -> Objects.equals(people.getId(), id));
    }
}
