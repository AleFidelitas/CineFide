package com.cinefide;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
// esto es como el router.web
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/index").setViewName("index");
        registro.addViewController("/login").setViewName("login");
//        registro.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
    }
    
    
    //en este metodo se establece la estructura de seguridad del sitio
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> 
                request.requestMatchers("/","/login","/js/**","webjars/**","/registro/**", "/cartelera/**","/horarios/**",
                        "/promocion/**", "/proximosestrenos/**")
                        .permitAll()
//                .requestMatchers("/categoria/listado")
//                        .hasRole("VENDEDOR")
                .requestMatchers("/usuario/**")
                        .hasRole("ADMIN")
                .requestMatchers("/pagos/**", "/reservas/**", "/valoracion/**", "/reservas/modifica/**")
                        .hasRole("USER")
        ).formLogin((form) -> form.loginPage("/login").permitAll()).logout((logout) ->logout.permitAll());
        
        return http.build();
    }
    //no se usa en produccion
//    @Bean
//    public UserDetailsService users(){
//        UserDetails admin = User.builder().username("juan").password("{noop}123").roles("USER","VENDEDOR","ADMIN").build();
//        UserDetails vendedor = User.builder().username("rebeca").password("{noop}456").roles("USER","VENDEDOR").build();
//        UserDetails usuario = User.builder().username("usuario").password("{noop}789").roles("USER").build(); 
//        return new InMemoryUserDetailsManager(usuario,vendedor,admin);
//    }
    
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
        build.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
    
    
    
    
    
    
    
}
