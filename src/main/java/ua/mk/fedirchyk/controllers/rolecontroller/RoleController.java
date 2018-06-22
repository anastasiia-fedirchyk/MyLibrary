package ua.mk.fedirchyk.controllers.rolecontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.mk.fedirchyk.entity.Role;

@Controller
@RequestMapping(path = "/role")
public class RoleController {
    @RequestMapping(path = "/get/{roleId}", method = RequestMethod.GET)
    public ResponseEntity roleGetById(@PathVariable long RoleId) {
        return ResponseEntity.ok("Role created");
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity rolesGetAll () {
        return ResponseEntity.ok("Roles created");
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity roleCreate (@RequestBody Role role) {
        return ResponseEntity.ok("Role created");
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity roleUpdate (@RequestBody Role role) {
        return ResponseEntity.ok("Role updated");
    }

    @RequestMapping(path = "/delete/{roleId}", method = RequestMethod.DELETE)
    public ResponseEntity roleDelete (@PathVariable(name = "roleId")Long roleId) {
        return ResponseEntity.ok("Role deleted");
    }
}
