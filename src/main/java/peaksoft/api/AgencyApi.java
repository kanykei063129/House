package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Agency;
import peaksoft.exception.MyException;
import peaksoft.service.AgencyService;

@Controller
@RequestMapping("/agencies")
public class AgencyApi {
    private final AgencyService agencyService;

    @Autowired
    public AgencyApi(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping("/new")
    public String createAgency(Model model) {
        model.addAttribute("agency", new Agency());
        return "newAgency";
    }

    @PostMapping("/save")
    public String saveAgency(@ModelAttribute("agencies") Agency agency) {
        agencyService.saveAgency(agency);
        return "redirect:/agencyPage";
    }

    @GetMapping
    public String getAllAgencies(Model model) {
        model.addAttribute("agencies", agencyService.getAllAgency());
        return "agencyPage";
    }

    @GetMapping("{id}/edit")
    public String getById(@PathVariable Long id, Model model) throws MyException {
        model.addAttribute("agency", agencyService.getAgencyById(id));
        return "updateAgency";
    }


    public String updateAgency(@PathVariable Long id, @ModelAttribute("agency") Agency agency) {
        agencyService.updateAgencyById(id, agency);
        return "redirect:/agencies";
    }
}
