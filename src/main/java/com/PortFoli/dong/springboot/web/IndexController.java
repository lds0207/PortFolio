package com.PortFoli.dong.springboot.web;

import com.PortFoli.dong.springboot.config.auth.LoginUser;
import com.PortFoli.dong.springboot.config.auth.dto.SessionUser;
import com.PortFoli.dong.springboot.domain.user.User;
import com.PortFoli.dong.springboot.service.PostsService;
import com.PortFoli.dong.springboot.web.dto.PostsListResponseDto;
import com.PortFoli.dong.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

/*   @GetMapping("/")
    public String index(){
        return "index";
    }
    */
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        List<PostsListResponseDto> list = postsService.findAllDesc();
        model.addAttribute("posts",postsService.findAllDesc());
       /* SessionUser user = (SessionUser) httpSession.getAttribute("user");*/
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts",dto);
        return "posts-update";
    }
}
