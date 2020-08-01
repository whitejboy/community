package com.forum.commuity.controller;

import com.forum.commuity.dto.AccessTokenDTO;
import com.forum.commuity.dto.GithubUser;
import com.forum.commuity.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName:AuthorizController
 * Package:com.forum.commuity.controller
 *
 * @Date:2020/8/1 10:04
 */
@Controller
public class AuthorizController {
    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.url}")
    private String redirectUrl;
@GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name = "state")String state){
    AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
    accessTokenDTO.setClient_id("clientId");
    accessTokenDTO.setClient_secret("clientSecret");
    accessTokenDTO.setCode(code);
    accessTokenDTO.setRedirect_url("redirectUrl");
    accessTokenDTO.setState(state);
    String accessToken = githubProvider.getAccessToken(accessTokenDTO);
    GithubUser user = githubProvider.getUser(accessToken);
    System.out.println(user.getName());
    return "index";
}

}
