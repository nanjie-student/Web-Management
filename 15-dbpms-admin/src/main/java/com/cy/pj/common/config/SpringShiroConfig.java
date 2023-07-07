package com.cy.pj.common.config;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration //此注解描述的类为spring中的配置类
public class SpringShiroConfig {
    /**
     * Session 是什么?
     * 此对象是在服务端记录客户端与服务端会话状态的一个对象,
     * 这个对象一般是一个会话创建一个,并且会有一个唯一标识(JSESSIONID).
     * 可以通过这样的对象来记录登录用户信息,记录购物车信息,记录验证码信息
     * SessionManager 是什么?管理session的一个对象
     * @return
     */
    @Bean
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager=new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(60*60*1000);//设置超时时间为1个小时
        //session对象由谁服务端创建,
        //但这个对象创建好以后,会将其jsessionid以会话cookie的形式写到客户端
        //客户端再访问服务器时,会携带jsessionid到服务端,然后基于这个id找到session.
        sessionManager.setSessionIdUrlRewritingEnabled(false);//关闭url重写.
        //一般假如浏览器禁用了cookie,我们可重写url,
        //此时会在url的后面添加一个jsessionid,服务端可以基于这个id为客户端找到对应session
        return sessionManager;
    }


    @Bean
    public RememberMeManager rememberMeManager(){
        CookieRememberMeManager rManager=new CookieRememberMeManager();
        SimpleCookie cookie=new SimpleCookie("rememberMe");
        cookie.setMaxAge(7*24*60*60);
        //假如没有设置maxAge,此cookie对象为会话cookie,此cookie会在浏览器关闭时生命周期结束
        rManager.setCookie(cookie);
        //rManager.setCipherKey(Base64.decode("6ZmI6I2j3Y+R1aSn5BOlAA=="));
        return rManager;
    }
    /**
     * 配置CacheManager对象,此对象中管理着一个Cache对象,此cache可以
     * 存储授权时获取的用户权限信息,下次在授权时可以直接从缓存取用户权限,
     * 这样可以减少对数据库的访问压力,并提高其授权性能.
     * FAQ?我们知道此管理器内置一个Cache对象,那请问谁来调用此管理器并获取cache呢?
     * SecurityManager (因为此对象负责授权,授权就需要获取用户权限.)
     * @return
     */
     @Bean
     public CacheManager shiroCacheManager(){
        return new MemoryConstrainedCacheManager();
     }
     /** 配置授权对应的Advisor对象,此对象会在spring启动时加载,并且通过此
      * 对象可以找到@RequiresPermissions注解描述的方法,然后这些方法在运
      * 行时,由此Advisor对象,调用SecurityManager中的checkPermissions方法
      * 检查用户权限,并为访问目标切入点方法的用户做授权操作.
      * */
     @Bean
     public AuthorizationAttributeSourceAdvisor
           authorizationAttributeSourceAdvisor(SecurityManager securityManager){
           AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
           advisor.setSecurityManager(securityManager);
           return advisor;
     }
    /**
     * 构建并初始化SecurityManager对象,然后将此对象交给spring管理.
     * 说明:@Bean注解应用于@Configuration注解描述的类的内部,通过此注解描述的方法,
     * 方法的返回值会交给spring管理,默认bean的名字为方法名.
     * @return 返回值shiro中的安全管理器对象,是shiro框架的核心,此对象中实现了
     * 认证,授权,会话,缓存,加密等一列功能的实现.
     */
       @Bean //bean的名字默认为方法名
       //@Scope("singleton")//默认
       public SecurityManager securityManager(Realm realm,
                                              CacheManager cacheManager,
                                              RememberMeManager rememberMeManager,
                                              SessionManager sessionManager){
           DefaultWebSecurityManager securityManager=
                   new DefaultWebSecurityManager();
           securityManager.setRealm(realm);
           securityManager.setCacheManager(cacheManager);
           securityManager.setRememberMeManager(rememberMeManager);
           securityManager.setSessionManager(sessionManager);
           return securityManager;
       }

       /**构建并初始化ShiroFilterFactoryBean对象通过此对象,
        * 创建过滤器工厂,进而通过过滤器工厂创建过滤器(filter),
        * 并通过过滤器对请求信息进行过滤,例如检测此请求是否需要
        * 认证或此请求是否已认证.
        * */
       @Bean
       //@Autowired //可以省略
       public ShiroFilterFactoryBean shiroFilterFactoryBean(
               SecurityManager securityManager){
           ShiroFilterFactoryBean fBean=new ShiroFilterFactoryBean();
           //设置securityManager,基于此对象进行认证检测
           fBean.setSecurityManager(securityManager);
           fBean.setLoginUrl("/doLoginUI");//前面的斜杠不能丢
           //定义map指定请求过滤规则(哪些资源允许匿名访问,哪些必须认证访问)
           LinkedHashMap<String,String> map= new LinkedHashMap<>();
           //静态资源允许匿名访问:"anon"
           map.put("/bower_components/**","anon");//AnonFilter
           map.put("/build/**","anon");
           map.put("/dist/**","anon");
           map.put("/plugins/**","anon");
           map.put("/user/doLogin","anon");//放行登录操作
           map.put("/doLogout","logout");//退出操作
           //除了匿名访问的资源,其它都要认证("authc")后访问
           //map.put("/**","authc");//这句话要写在匿名访问的后面(有顺序要求)
           map.put("/**","user");//可以从用户浏览器cookie中读取账号信息进行身份认证
           fBean.setFilterChainDefinitionMap(map);
           return fBean;
       }
}
/**
 1.HTTP协议是一种无状态协议,无法存储客户端与服务端的会话状态.
 2.客户端与与服务端通讯过程中产生的会话状态信息存储到哪里?(cookie或session)
 3.cookie对象由服务端创建,但是是在客户端保存信息的一个对象.
 4.cookie对象的类型有两种:会话cookie和持久cookie(我们手动设置了生命周期)
 5.会话Cookie在浏览器关闭时,生命周期自动结束.
 6.Session对象由服务端创建,并在服务端保存状态信息的一个对象.
 7.session对象创建以后会将session对象的id以会话cookie形式写到客户端,客户端可以
 再访问服务器时基于这个id找到服务端的session.
 8.浏览器关闭,会话cookie结束,写到客户端的jsessionid也就无效了,此时客户端再访问服务
 器无法基于jsessionid找到对应的session了(服务端的session可能还是存在的).
 */
