package com.vehicle.insurance.management.system.security;

import com.vehicle.insurance.management.system.security.jwt.AuthEntryPointJwt;
import com.vehicle.insurance.management.system.security.jwt.AuthTokenFilter;
import com.vehicle.insurance.management.system.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
//@EnableWebSecurity
@EnableMethodSecurity
//(securedEnabled = true,
//jsr250Enabled = true,
//prePostEnabled = true) // by default
public class WebSecurityConfig { // extends WebSecurityConfigurerAdapter {
  @Autowired
  UserDetailsServiceImpl userDetailsService;

  @Autowired
  private AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

//  @Override
//  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       
      authProvider.setUserDetailsService(userDetailsService);
      authProvider.setPasswordEncoder(passwordEncoder());
   
      return authProvider;
  }
  
//  @Bean
//  @Override
//  public AuthenticationManager authenticationManagerBean() throws Exception {
//    return super.authenticationManagerBean();
//  }
  
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.cors().and().csrf().disable()
//      .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//      .authorizeRequests().antMatchers("/api/auth/**").permitAll()
//      .antMatchers("/api/test/**").permitAll()
//      .anyRequest().authenticated();
//
//    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//  }
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth ->

          auth.requestMatchers("/api/auth/**").permitAll()
              .requestMatchers("/api/test/**").permitAll()
              .requestMatchers("/api/auth/signupAgent").permitAll()
                  .requestMatchers("/api/email/send").permitAll()
                  .requestMatchers("/api/email/verify").permitAll()
                  .requestMatchers("/api/email/changepassword").permitAll()
                  .requestMatchers("/api/personal-details/findbycnic").permitAll()
                  .requestMatchers("/api/personal-details/addPersonalDetails").permitAll()
                  .requestMatchers("/api/addDriverDetails").permitAll()
                  .requestMatchers("/api/addVehicleDetails").permitAll()
                  .requestMatchers("/api/findbycnic").permitAll()
                  .requestMatchers("/api/getDriverDetailsByEmail").permitAll()
                  .requestMatchers("/api/findbylicense").permitAll()
                  .requestMatchers("/api/findByRegistrationNumber").permitAll()
                  .requestMatchers("/api/choose-package/save").permitAll()
                  .requestMatchers("/api/addPaymentDetails").permitAll()
                  .requestMatchers("/api/getAllByRole").permitAll()
                  .requestMatchers("/api/activateAgent").permitAll()
                  .requestMatchers("/api/getAllVehicles").permitAll()
                  .requestMatchers("/api/backup/execute").permitAll()
                  .requestMatchers("/api/getAllDrivers").permitAll()
                  .requestMatchers("/api/getVehiclesByEmail").permitAll()
                  .requestMatchers("/api/getDriverByEmail").permitAll()
                  .requestMatchers("/api/personal-details/getAllPersonalDetails").permitAll()
                  .requestMatchers("/api/personal-details/getPersonalDetailsByEmail").permitAll()
                  .requestMatchers("/api/getCombinedDetails").permitAll()
                  .requestMatchers("/api/getCombinedDetailsByEmail").permitAll()
              .anyRequest().authenticated()
        );



    
    http.authenticationProvider(authenticationProvider());

    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    
    return http.build();
  }
}
