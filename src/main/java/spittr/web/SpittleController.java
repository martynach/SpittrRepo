package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spittr.Spittle;
import spittr.data.ISpittleRepository;

@Controller
@RequestMapping("/spittr/spittles")
public class SpittleController {

    private ISpittleRepository spittleRepository;

    @Autowired
    public SpittleController(ISpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }


   // @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    @GetMapping("/{spittleId}")
    public String spittle(Model model,
                          @PathVariable(value = "spittleId") long spittleId) {
        Spittle sp = spittleRepository.findOne(spittleId);
        System.out.println();
        System.out.println("Spittle: " + sp.getId() + ", " + sp.getMessage());
        System.out.println();
        model.addAttribute("spittle", sp);
        return "spittle";
    }

    /**
     * Model is a map - a collection of key-value pairs that will be handed off to the view
     * so that the data can be can be rendered to the client;
     * When addAttribute() is called without specifying a key, the key is inferred from the type
     * of object being set as value (List<Spittle> type == "spittleList" key)
     * Following commented example shows spittles method with obligatory params
     * @return
     */
//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(
//            Model model,
//            @RequestParam("max") long max,
//            @RequestParam("count") int count)
//    {
//        model.addAttribute(spittleRepository.findSpittles(max, count));
//        return "spittles";
//    }
    @RequestMapping(method = RequestMethod.GET)
    public String spittles(
            @RequestParam(value = "max", required = false) Long max,
            @RequestParam(value = "count", defaultValue = "20") int count,
            Model model)
    {
        if(max == null) {
            max = Long.MAX_VALUE;
        }
        model.addAttribute(spittleRepository.findSpittles(max, count));
        return "spittles";
    }

    private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);

}
