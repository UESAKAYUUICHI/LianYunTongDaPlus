//package main.lianyuntongdaplus.config;
//
//import cn.dev33.satoken.interceptor.SaInterceptor;
//import cn.dev33.satoken.router.SaRouter;
//import cn.dev33.satoken.stp.StpUtil;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import static main.lianyuntongdaplus.commen.utils.result.satoken.SaPermissionUtils.checkNotInRoles;
//
//@Configuration
//public class SaTokenConfigure implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SaInterceptor(handler -> {
//
//            SaRouter
//                    .match("/**")
//                    .notMatch(
//                            "/doLogin",
//                            "/produceServer",
//                            "/aboutUs",
//                            "/API",
//                            "/LSP",
//                            "/index",
//                            "/register",
//                            "/register/**",
//                            "/forgetPassword",
//                            "/forgetPassword/**",
//                            "/resetPassword",
//                            "/resetPassword/**",
//                            // 放行静态资源
//                            "/css/**",
//                            "/javascript/**",
//                            "/img/**",
//                            "/fonts/**",
//                            "/static/**",
//                            "/document/**",
//                            "/img-2/**",
//                            "favicon.ico"
//
//                    )
//                    .check(r -> StpUtil.checkLogin());
//            // 权限控制： Only 管理员允许访问
//            SaRouter.match("/role", r -> StpUtil.checkRole("admin"));
//            SaRouter.match("/userManagement", r -> StpUtil.checkRole("admin"));
//            SaRouter.match("/apiManagement", r -> StpUtil.checkRole("admin"));
//
//            //不允许普通用户访问
//            SaRouter.match("/outIn", r -> checkNotInRoles("user"));
//            SaRouter.match("/bilView", r -> checkNotInRoles("user"));
//            SaRouter.match("/orderManage", r -> checkNotInRoles("user"));
//            SaRouter.match("/costManagement", r -> checkNotInRoles("user"));
//            SaRouter.match("/record", r -> checkNotInRoles("user"));
//        })).addPathPatterns("/**");
//    }
//}