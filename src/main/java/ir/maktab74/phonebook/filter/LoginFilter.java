package ir.maktab74.phonebook.filter;

import ir.maktab74.phonebook.base.exception.BadCredentialRuntimeException;
import ir.maktab74.phonebook.entity.User;
import ir.maktab74.phonebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class LoginFilter implements Filter {

    private final UserService userService;
    @Value(value = "${login.process.path}")
    private String path;

    @Value(value = "${login.cookie.name}")
    private String cookieName;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if (httpServletRequest.getMethod().equalsIgnoreCase("post") &&
                path.equals(httpServletRequest.getServletPath())) {

            String username = httpServletRequest.getParameter("username");
            String password = httpServletRequest.getParameter("password");

            User user = userService.findByUsernameAndPassword(username, password);

            if (user != null) {

                String userInfo = user.getId() + ":" + user.getFirstName() + ":" + user.getUsername();

                String cookieValue = Base64.getEncoder().encodeToString(userInfo.getBytes(StandardCharsets.UTF_8));

                Cookie cookie = new Cookie(cookieName, cookieValue);
                cookie.setMaxAge((int) TimeUnit.DAYS.toSeconds(2));
                httpServletResponse.addCookie(cookie);


            } else {
                throw new BadCredentialRuntimeException("wrong username or password");
            }
        } else {
            filterChain.doFilter(request, response);
        }

    }
}
