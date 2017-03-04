package indi.orange1438.managementsystem.web.system.login;

import java.util.HashMap;
import java.util.Map;

import indi.orange1438.managementsystem.dao.entity.UserEntity;
import indi.orange1438.managementsystem.service.system.UserService;
import indi.orange1438.managementsystem.util.Const;
import indi.orange1438.managementsystem.util.TableProperties;
import indi.orange1438.managementsystem.util.DateUtils;
import indi.orange1438.managementsystem.util.IpUtils;
import indi.orange1438.managementsystem.util.StringUtils;
import indi.orange1438.managementsystem.web.system.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/*
 * 总入口
 */
@Controller
public class LoginController extends BaseController {

    @Resource(name = "userService")
    UserService userService;

    /**
     * 访问登录页
     */
    @RequestMapping(value = "/login_toLogin")
    public ModelAndView toLoginPage() throws Exception {
        Map map = new HashMap();
        map.put("SysName", "Orange"); //填入系统名称
        map.put("BasePath", this.getBasePath()); // 根目录地址，为动静分离资源做准备，可能需要单独的静态服务器而准备的

        ModelAndView mv = new ModelAndView();
        mv.setViewName("system/admin/login");
        mv.addAllObjects(map);
        return mv;
    }

    /**
     * 请求登录接口，验证用户
     */
    @RequestMapping(value = "/login_login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object loginApi() throws Exception {
        Map requestMap = this.getParameterMap();
        String userName = null == requestMap.get("loginName") ? null : requestMap.get("loginName").toString();
        String password = null == requestMap.get("password") ? null : requestMap.get("password").toString();
        String code = null == requestMap.get("code") ? null : requestMap.get("code").toString();

        String resultInfo = "";
        if (null != userName && null != password) {
            if (null == code || "".equals(code)) {
                resultInfo = "nullcode"; //验证码为空
            } else {
                // 获取session
                HttpServletRequest request = this.getRequest();
                HttpSession session = request.getSession();
                String sessionCode = session != null ? session.getAttribute(Const.SESSION_SECURITY_CODE).toString() : "";

                if (StringUtils.notEmpty(sessionCode) && sessionCode.equalsIgnoreCase(code)) {
                    UserEntity userEntity = userService.getUserEntityByNameAndPwd(userName, password);
                    if (null != userEntity) {
                        userEntity.setLastLoginTime(DateUtils.getDateTimeNow());
                        userEntity.setLoginIp(IpUtils.getIpAddr(request));
                        userEntity.setLoginCount(userEntity.getLoginCount() + 1L);
                        TableProperties.modifyProperties(userEntity, userEntity.getTrueName());
                        userService.updateUserByUserId(userEntity);

                        session.setAttribute(Const.SESSION_USER, userEntity);
                        session.removeAttribute(Const.SESSION_SECURITY_CODE);
                    } else {
                        resultInfo = "usererror";       //用户名或密码有误
                    }
                } else {
                    resultInfo = "codeerror";                    //验证码输入有误
                }
                if (StringUtils.isEmpty(resultInfo)) {
                    resultInfo = "success";                    //验证成功
                }
            }
        } else {
            resultInfo = "error";    //缺少参数
        }

        Map<String, String> map = new HashMap<String, String>();
        map.put("result", resultInfo);
        return map;
    }

    /**
     * 访问系统首页
     */
    @RequestMapping(value = "/main/{changeMenu}")
    public ModelAndView loginIndexPage(@PathVariable("changeMenu") String changeMenu) {
        ModelAndView mv = new ModelAndView();

        try {
            HttpSession session = this.getSession();
            UserEntity userEntity = (UserEntity) session.getAttribute(Const.SESSION_USER);
            if (userEntity != null) {
                mv.setViewName("system/admin/index");
                mv.addObject("user", userEntity);
            } else {
                mv.setViewName("system/admin/login");//session失效后跳转登录页面
            }
        } catch (Exception e) {
            mv.setViewName("system/admin/login");
            logger.error(e.getMessage(), e);
        }

        Map map = new HashMap();
        map.put("SysName", "Orange"); //填入系统名称
        map.put("BasePath", this.getBasePath()); // 根目录地址，为动静分离资源做准备，可能需要单独的静态服务器而准备的
        mv.addAllObjects(map);
        return mv;
    }

    /**
     * 进入tab标签
     *
     * @return
     */
    @RequestMapping(value = "/tab")
    public String tab() {
        return "system/admin/tab";
    }

    /**
     * 进入首页后的默认页面
     *
     * @return
     */
    @RequestMapping(value = "/login_default")
    public String defaultPage() {
        return "system/admin/default";
    }

    /**
     * 用户注销
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/logout")
    public ModelAndView logout() {
        return null;
    }


}
