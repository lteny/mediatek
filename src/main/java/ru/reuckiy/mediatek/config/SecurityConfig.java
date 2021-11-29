package ru.reuckiy.mediatek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.reuckiy.mediatek.security.JwtConfigurer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtConfigurer jwtConfigurer;

    public SecurityConfig(JwtConfigurer jwtConfigurer) {
        this.jwtConfigurer = jwtConfigurer;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/news/**").permitAll()
                .antMatchers("/post/**").permitAll()
                .antMatchers("/upload/**").permitAll()
                .antMatchers("/download/**").permitAll()
                .antMatchers("/multiple/**").permitAll()
                .antMatchers("/json").permitAll()
                .antMatchers("/json_file").permitAll()
                .antMatchers("/products/**").permitAll()
                .antMatchers("/param/**").permitAll()
                .antMatchers("/email/**").permitAll()
                .antMatchers("/contact").permitAll()
                .antMatchers("/pdf/**").permitAll()

                .antMatchers("/product/**").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/content/**").permitAll()
                .antMatchers("/file/**").permitAll()
                .antMatchers("/admin/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .apply(jwtConfigurer);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}