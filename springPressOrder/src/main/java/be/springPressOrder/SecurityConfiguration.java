package be.springPressOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.activation.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /*@Autowired
    private AccessDeniedHandler accessDeniedHandler;*/

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { auth.userDetailsService(userDetailsService); }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/favicon.ico", "/login*", "/images/**", "/css/**", "/storage", "/", "/storage/json", "/order").permitAll()
                .antMatchers("/h2/**", "/**")   .permitAll()
                .antMatchers("/orders/**")      .hasAnyRole("ADMIN")
                .antMatchers("/schedule")       .permitAll()
                .antMatchers("/technician")     .hasAnyRole("TECHNICIAN")
                .antMatchers("/machines")       .hasAnyRole("TECHNICIAN","PRESSER")
                .antMatchers("/machines/**")    .hasAnyRole("PRESSER")
                .antMatchers("/request")        .hasAnyRole("USER")
                .antMatchers("/request/**")     .hasAnyRole("USER")
                .antMatchers("/pressorders")    .hasAnyRole("USER","PRESSER")
                .antMatchers("/pressorders/**") .hasAnyRole("USER","PRESSER")
                .antMatchers("/pressorder/**")  .hasAnyRole("USER", "PRESSER")
                .antMatchers("/order/**")       .hasAnyRole("USER")

                .anyRequest().hasAnyRole("USER","ADMIN").and()
                    .formLogin().loginPage("/login").failureUrl("/login-error")
                        .defaultSuccessUrl("/",true).permitAll().and()
                    .logout().invalidateHttpSession(true).logoutSuccessUrl("/login").permitAll();
        http.exceptionHandling().accessDeniedPage("/403");
       //http.authorizeRequests().anyRequest().permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

  @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("pv")         .password("presser")        .roles("PRESSER")
                .and()
                .withUser("presser")    .password(("presser"))      .roles("USER")
                .and()
                .withUser("technician").password(("technician"))    .roles("TECHNICIAN");
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
