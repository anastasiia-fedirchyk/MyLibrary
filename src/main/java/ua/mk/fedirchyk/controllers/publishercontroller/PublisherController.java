package ua.mk.fedirchyk.controllers.publishercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.mk.fedirchyk.controllers.authorcontroller.CreateAuthorRequest;
import ua.mk.fedirchyk.entity.Publisher;
import ua.mk.fedirchyk.services.publisher.PublisherService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/publisher")
public class PublisherController {
    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @RequestMapping("/")
    public String viewPublisher(Model model) {
        model.addAttribute("publisher", new CreatePublisherRequest());
        return "publisher";
    }

    @RequestMapping(path = "/get/{namePublisher}", method = RequestMethod.GET)
    public ResponseEntity publisherGetByName(@PathVariable String namePublisher) {
        return ResponseEntity.ok("Publisher created");
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity publishersGetAll() {
        return ResponseEntity.ok("Publisher created");
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity publisherCreate (ModelAndView modelAndView,
                                           @ModelAttribute("publisher") CreatePublisherRequest publisher,
                                           BindingResult bindingResult,
                                           HttpServletRequest request) {
        Publisher savedPublisher = publisherService.create(publisher);
        return ResponseEntity.ok("Publisher was created  - " + savedPublisher.getNamePublisher());
    }


    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity publisherUpdate(@RequestBody Publisher publisher) {
        return ResponseEntity.ok("publisher updated");
    }

    @RequestMapping(path = "/delete/{publisherName}", method = RequestMethod.DELETE)
    public ResponseEntity publisherDelete(@PathVariable(name = "publiserName") String publisherName) {
        return ResponseEntity.ok("publisher deleted");
    }


}
