//package main.lianyuntongdaplus.commen.utils.result.satoken;
//
//import cn.dev33.satoken.exception.SaTokenException;
//import cn.dev33.satoken.stp.StpUtil;
//
//import java.util.List;
//
//public class SaPermissionUtils {
//
//    /**
//     * 检查当前登录用户是否包含任一指定角色（必须包含其中一个）
//     * @param roles 角色列表
//     */
//    public static void checkHasAnyRole(String... roles) {
//        if (!StpUtil.hasRoleAnd(roles)) {
//            throw new SaTokenException("无访问权限：需要包含指定角色之一");
//        }
//    }
//
//    /**
//     * 检查当前登录用户是否包含所有指定角色（必须全部包含）
//     * @param roles 角色列表
//     */
//    public static void checkHasAllRoles(String... roles) {
//        if (!StpUtil.hasRoleAnd(roles)) {
//            throw new SaTokenException("无访问权限：需要包含全部指定角色");
//        }
//    }
//
//    /**
//     * 检查当前登录用户是否不包含指定角色中的任意一个（即排除这些角色）
//     * @param excludedRoles 要排除的角色列表
//     */
//    public static void checkNotInRoles(String... excludedRoles) {
//        List<String> userRoles = StpUtil.getRoleList();
//        for (String role : excludedRoles) {
//            if (userRoles.contains(role)) {
//                throw new SaTokenException("访问拒绝：您属于被限制的角色【" + role + "】");
//            }
//        }
//    }
//
//}