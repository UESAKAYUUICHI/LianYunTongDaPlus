//package main.lianyuntongdaplus.commen.exception;
//
//import cn.dev33.satoken.exception.NotLoginException;
//import cn.dev33.satoken.exception.NotPermissionException;
//import cn.dev33.satoken.exception.NotRoleException;
//import cn.dev33.satoken.exception.SaTokenException;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    public Object handleException(HttpServletRequest request, Exception e) {
//        // 打印异常信息
//        e.printStackTrace();
//
//        // 判断请求头是否为 AJAX 请求
//        String accept = request.getHeader("Accept");
//        boolean isAjax = accept != null && accept.contains(MediaType.APPLICATION_JSON_VALUE);
//
//        if (isAjax) {
//            // 返回 JSON 响应
//            Map<String, Object> res = new HashMap<>();
//            res.put("code", 500);
//            res.put("message", e.getMessage());
//            return ResponseEntity.status(500).body(res);
//        } else {
//            // 返回错误页面
//            ModelAndView mav = new ModelAndView("error");
//            mav.addObject("status", "500");
//            mav.addObject("message", e.getMessage());
//            return mav;
//        }
//    }
//    @ExceptionHandler(NotLoginException.class)
//    public ModelAndView handleNotLoginException(NotLoginException e) {
//        ModelAndView mav = new ModelAndView("noPermission");
//        mav.addObject("message", "您尚未登录，请登录后访问。");
//        return mav;
//    }
//
//    @ExceptionHandler({NotRoleException.class, NotPermissionException.class})
//    public ModelAndView handleNoRolePermissionException(Exception e) {
//        ModelAndView mav = new ModelAndView("noPermission");
//        mav.addObject("message", "您暂无权限查看此部分。");
//        return mav;
//    }
//
//    @ExceptionHandler(SaTokenException.class)
//    public ModelAndView handleSaTokenException(SaTokenException e) {
//        ModelAndView mav = new ModelAndView("noPermission");
//        mav.addObject("message", e.getMessage());
//        return mav;
//    }
//
//
//
//
//
//}
//
