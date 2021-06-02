package org.wecancoeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class QuarterbackController {

    @Resource
    private QuarterbackRepository quarterbackRepo;

    @RequestMapping("/quarterbacks")
    public String findAllQuarterbacks(Model model){
        model.addAttribute("quarterbacksModel", quarterbackRepo.findAll());
        return "quarterbacksTemplate";
    }

    @RequestMapping("/quarterback")
    public String findOneQuarterback(@RequestParam(value = "id") Long id, Model model) throws QuarterbackNotFoundException {

        if (quarterbackRepo.findOne(id) == null){
            throw new QuarterbackNotFoundException();
        }

        model.addAttribute("quarterbackModel", quarterbackRepo.findOne(id));
        return "quarterbackTemplate";
    }

}
