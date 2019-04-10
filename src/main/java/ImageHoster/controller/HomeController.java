package ImageHoster.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ImageHoster.service.ImageService;
import ImageHoster.model.Image;
import java.util.List;



@Controller
public class HomeController {
//Write the code to inject the ImageService bean
    @Autowired
    private ImageService imageService;
@RequestMapping("/")
public String getAllImages(Model model) {
    //Call getAllImages() method in ImageService class to get the list of all images
    List<Image> images =imageService.getAllImages();
    //Add the list of images in the model with the key as "images"
    model.addAttribute("images",images);
    return "index";
}

}
