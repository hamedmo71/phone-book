package ir.maktab74.phonebook.filter;

import ir.maktab74.phonebook.entity.User;
import ir.maktab74.phonebook.util.SecurityContext;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Component
public class SecurityAccessFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String servletPath = request.getServletPath();
        if (
                Arrays.stream(getPermitAllPaths())
                        .anyMatch(path -> servletPath.equals(path) || servletPath.startsWith(path))
        ) {
            filterChain.doFilter(request, response);
        } else if (
                Arrays.stream(getAdminPermitPaths())
                        .anyMatch(path -> servletPath.equals(path) || servletPath.startsWith(path))
        ) {
            User currentUser = SecurityContext.getCurrentUser();
            if (currentUser == null) {
                response.sendRedirect("/access-denied");
            } else {
                filterChain.doFilter(request, response);
            }
        }

    }

    private String[] getPermitAllPaths() {
        return new String[]{
                "/assets", "/login", "/login-process",
                "/access-denied", "/swagger", "/webjars",
                "/v2/api-docs", "/user"
        };
    }

    private String[] getAdminPermitPaths() {
        return new String[]{
                "/admin-panel", "/api"
        };
    }

}
