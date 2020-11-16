package ch.zli.m223.punchclock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/***
 * This class was created by Jason Banyer
 * Date: 08.11.2020
 *
 * Description of this class:
 * This class contains the existing Users, along with their ID.
 * While these Users exist in this list, they do not exist as actual accounts, where one can login.
 *
 */
@RestController
@RequestMapping("/benutzer")
public class BenutzerController {

    private static final List<Benutzer> BENUTZER = Arrays.asList(
            new Benutzer(1, "Thomas"),
            new Benutzer(2, "Stella"),
            new Benutzer(3, "Tobias"),
            new Benutzer(4, "Sarah"),
            new Benutzer(5, "Lina"),
            new Benutzer(6, "Lora"),
            new Benutzer(7, "Adrian"),
            new Benutzer(8, "Bob"),
            new Benutzer(9, "Marvin"),
            new Benutzer(10, "Tristan"),
            new Benutzer(11, "Sebastian"),
            new Benutzer(12, "Robin"),
            new Benutzer(13, "Laura"),
            new Benutzer(14, "Gina"),
            new Benutzer(15, "Michael"),
            new Benutzer(16, "Olga"),
            new Benutzer(17, "Tamara"),
            new Benutzer(18, "Stefan"),
            new Benutzer(19, "Valentin")
    );

    public static List<Benutzer> getAllBENUTZER() {
        return BENUTZER;
    }

    @GetMapping(path = "/{benutzerId}")
    public Benutzer getBenutzer(@PathVariable("benutzerId") Integer benutzerId) {

        return BENUTZER.stream()
                    .filter(benutzer -> benutzerId.equals(benutzer.getBenutzerId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Benutzer: " + benutzerId + " existiert nicht"));
        }
    @RequestMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Benutzer> getEveryBenutzer() {

        return BenutzerController.getAllBENUTZER();
    }
}
