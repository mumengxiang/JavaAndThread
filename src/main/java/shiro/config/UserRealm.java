package shiro.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import shiro.dao.base.UserDO;
import shiro.domain.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创建Realm
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    UserDO userDO;

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //编写shiro判断逻辑，判断用户名和密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //得到输入的用户名
        String inName = token.getUsername();
        //根据输入的用户名查询数据库得到密码
        List<User> userList = userDO.getPwdByName(inName);
        if(userList.size() > 0){
            //得到密码
            String pwd = userList.get(0).getPassword();
            //验证密码(第二个参数为数据库里面的密码)
            return new SimpleAuthenticationInfo("",pwd,"");
        }else {
            return null;
        }

    }
}
