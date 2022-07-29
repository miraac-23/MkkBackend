package gabim.permissionTrackingApplication.configs;

import gabim.permissionTrackingApplication.service.UserDetailsSeviceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.util.Base64;

import static gabim.permissionTrackingApplication.configs.TokenInfo.SECRET;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsSeviceImpl userDetailsSevice;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String token = header.split(" ")[1].trim();

        Key key = new SecretKeySpec(Base64.getDecoder().decode(SECRET),
                SignatureAlgorithm.HS256.getJcaName());
        Jws<Claims> claimsJws = null;
        String email;
        try {
            claimsJws = Jwts.parserBuilder().setSigningKey(key)
                    .build().parseClaimsJws(token);
            email = (String) claimsJws.getBody().get("sub");
            if (email == null || email.isEmpty()) {
                filterChain.doFilter(request, response);
                return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        UserDetails userDetails = userDetailsSevice.loadUserByUsername(email);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
