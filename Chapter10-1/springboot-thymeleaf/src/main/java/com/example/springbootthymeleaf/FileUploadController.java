package com.example.springbootthymeleaf;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class FileUploadController implements HandlerExceptionResolver {



  public static final String UPLOADS_DIR = "E:/uploads/";

  @RequestMapping({"/fileUpload"})
  public String home(Model model){
    return "fileUpload";
  }

  @RequestMapping(value="/uploadMyFile", method = POST)
  public String handleFileUpload(@RequestParam("myFile")MultipartFile file,
                                 RedirectAttributes redirectAttributes) {

    if(!file.isEmpty()) {
      String name = file.getOriginalFilename();
      try{
        byte[] bytes = file.getBytes();
        File uploadingDir = new File(UPLOADS_DIR);
        if(!uploadingDir.exists()){
          uploadingDir.mkdirs();
        }
        Files.write(new File(UPLOADS_DIR + name).toPath(),bytes);
        redirectAttributes.addFlashAttribute("msg","File "+ name + "başarılı");

      } catch (Exception e){
        redirectAttributes.addFlashAttribute("msg","Failed to upload file" + name + ".Cause: " + e.getMessage());

      }
    }
    return "redirect:/fileUpload";
  }


  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                       Object handler, Exception ex)     {
    Map<String, Object> model = new HashMap<String, Object>();
    if (ex instanceof MultipartException)
    {
      model.put("msg", "MultipartException: "+ex.getMessage());
    } else
    {
      model.put("msg", "Unexpected error: " + ex.getMessage());
    }

    return new ModelAndView("fileUpload", model);
  }
}
