package hellospringboot.session15.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.http.HttpMethod;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {



    // mã hóa password

    @Bean
    PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();

    }




    // cấu hình security

    @Bean
    SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http
                // dùng JWT nên tắt csrf

                .csrf(
                        csrf -> csrf.disable()
                )

                .authorizeHttpRequests(auth -> auth


                        .requestMatchers(
                                "/api/auth/**"
                        )
                        .permitAll()

                        // xem sản phẩm ai cũng được

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/products"
                        )
                        .permitAll()




                        // thêm sản phẩm

                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/products"
                        )
                        .hasAnyRole(
                                "ADMIN",
                                "STAFF"
                        )




                        // sửa sản phẩm

                        .requestMatchers(
                                HttpMethod.PUT,
                                "/api/products/**"
                        )
                        .hasAnyRole(
                                "ADMIN",
                                "STAFF"
                        )




                        // xóa sản phẩm

                        .requestMatchers(
                                HttpMethod.DELETE,
                                "/api/products/**"
                        )
                        .hasAnyRole(
                                "ADMIN",
                                "STAFF"
                        )

                        // CUSTOMER đặt hàng

                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/orders"
                        )
                        .hasRole(
                                "CUSTOMER"
                        )




                        // CUSTOMER xem lịch sử của mình

                        .requestMatchers(
                                "/api/orders/my"
                        )
                        .hasRole(
                                "CUSTOMER"
                        )




                        // STAFF + ADMIN xem tất cả đơn

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/orders"
                        )
                        .hasAnyRole(
                                "STAFF",
                                "ADMIN"
                        )




                        //cập nhật trạng thái

                        .requestMatchers(
                                HttpMethod.PUT,
                                "/api/orders/**"
                        )
                        .hasRole(
                                "STAFF"
                        )


                        .anyRequest()
                        .authenticated()

                );

        return http.build();

    }

}