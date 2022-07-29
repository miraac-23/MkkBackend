package gabim.permissionTrackingApplication.api.controllers;

import gabim.permissionTrackingApplication.dto.AuthenticationRequest;
import gabim.permissionTrackingApplication.payload.JwtResponse;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletResponse;
import java.security.Key;
import java.util.*;

import static gabim.permissionTrackingApplication.configs.TokenInfo.ISSUER;
import static gabim.permissionTrackingApplication.configs.TokenInfo.SECRET;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public ResponseEntity<?> loginUser(@RequestBody AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        User user = (User) authentication.getPrincipal();

        Key key = new SecretKeySpec(Base64.getDecoder().decode(SECRET),
                SignatureAlgorithm.HS256.getJcaName());

        long currentMillis = System.currentTimeMillis();
        Date now = new Date(currentMillis);
        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(now)
                .setSubject(user.getUsername())
                .setIssuer(ISSUER)
                //.setExpiration() //TODO: Bitiş süresi hesaplanıp ayarlanacak
                .signWith(key);

        return  ResponseEntity.ok(new JwtResponse(builder.compact(),user.getUsername(), grantedAuthoritiesConvertString(user.getAuthorities())));


                //builder.compact();


        //Set-Cookie
        //new ResponseEntity<String>()
    }

    private static List<String> grantedAuthoritiesConvertString(Collection<? extends GrantedAuthority> grantedAuthorities){
        List<String> role = new ArrayList<>();
        for (GrantedAuthority grantedAuthority:grantedAuthorities){
            role.add(grantedAuthority.getAuthority());
        }
        return role;
    }



    @RequestMapping("/admin")
    public String loginAdmin() {
        return "Admin kullanıcı girişi başarılı";
    }


}
