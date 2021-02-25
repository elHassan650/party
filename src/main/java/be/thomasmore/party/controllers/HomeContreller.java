package be.thomasmore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeContreller {
   private String appName="Let's Party!!";
   private final String [] venueNames={"De Club","De Loods","De Hanger","Zapoi","Kuub","Cuba Libre"};
    private final String [] parties={"Big Spring Party","Liberty 2021","Uppercuts","Zoetzuur","Oldies but goldies"};
    @GetMapping({"/","/home"})
    public String home(Model model) {
        model.addAttribute("appName",appName);
        return "home";
    }

    @GetMapping("/venuelist")
    public String venuelist(Model model){
        model.addAttribute("appName",appName);
        model.addAttribute("venueNames",venueNames);
        return"venuelist";
    }

    @GetMapping({"/venuedetails", "/venuedetails/{venueName}"})
    public String venueDetails(Model model, @PathVariable(required = false) String venueName) {
        model.addAttribute("venuename", venueName==null ? "--no venue specified--" : venueName);
        return "venuedetails";
    }
    @GetMapping({"/venuedetailsbyindex", "/venuedetailsbyindex/{venueId}"})
    public String venueDetails(Model model, @PathVariable(required = false) Integer venueId) {
        model.addAttribute("venuename", (venueId>=0 && venueId < venueNames.length) ? venueNames[venueId] : null);
        String venueName;
        Integer prevIndex=venueId-1;
        Integer nextIndex=venueId+1;
        if(venueId!=null) {
            if(venueId >= 0 & venueId < venueNames.length){
                venueName= venueNames[venueId];
                if(venueId==0){
                    prevIndex=venueNames.length-1;
                }
                else {
                    prevIndex=venueId-1;
                }
                if (venueId==venueNames.length-1){
                    nextIndex=0;
                }
                else {
                    nextIndex=venueId+1;
                }
            }
            else venueName= null;
        }
        else venueName=null;

        model.addAttribute("venueName",venueName);
        model.addAttribute("prevIndex",prevIndex);
        model.addAttribute("nextIndex",nextIndex);

        return "venuedetails";
    }

    @GetMapping("/partylist")
    public String partylist(Model model){
        model.addAttribute("appName",appName);
        model.addAttribute("parties",parties);
        return"partylist";
    }

    @GetMapping({"/partydetailsbyindex", "/partydetailsbyindex/{partyId}"})
    public String partyDetails(Model model, @PathVariable(required = false) Integer partyId) {
        model.addAttribute("party", (partyId>=0 && partyId < parties.length) ? parties[partyId] : null);
        String party;
        Integer prevIndex=partyId-1;
        Integer nextIndex=partyId+1;
        if(partyId!=null) {
            if(partyId >= 0 & partyId < parties.length){
                party= parties[partyId];
                if(partyId==0){
                    prevIndex=parties.length-1;
                }
                else {
                    prevIndex=partyId-1;
                }
                if (partyId==parties.length-1){
                    nextIndex=0;
                }
                else {
                    nextIndex=partyId+1;
                }
            }
            else party= null;
        }
        else party=null;

        model.addAttribute("venueName",party);
        model.addAttribute("prevIndex",prevIndex);
        model.addAttribute("nextIndex",nextIndex);

        return "partydetails";
    }

    @GetMapping({"/partydetails\", \"/partydetails/{party}"})
    public String partydetails(Model model, @PathVariable(required = false) String party) {
        model.addAttribute("party", party==null ? "--no venue specified--" : party);
        return "partydetails";
    }

    @GetMapping("/artistlist")
    public String artistslist(Model model){
        model.addAttribute("appName",appName);
        return"artistlist";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("appName",appName);

        return"about";
    }



    }


