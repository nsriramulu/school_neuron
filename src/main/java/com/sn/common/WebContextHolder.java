package com.sn.common;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.context.Theme;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.sn.entity.ClassSubjectTeacher;
import com.sn.entity.School;
import com.sn.entity.User;
import com.sn.vo.UserProfileVO;

/**
 * The Class WebContextHolder holds spring request, session... objects.
 */
public final class WebContextHolder {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(WebContextHolder.class);

    /** The instance. */
    private static WebContextHolder INSTANCE = new WebContextHolder();

    /**
     * Gets the.
     *
     * @return the web context holder
     */
    public static WebContextHolder get() {
        return INSTANCE;
    }

    /**
     * Instantiates a new web context holder.
     */
    private WebContextHolder() {
        super();
    }

    /**
     * Gets the request.
     *
     * @return the request
     */
    public HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attributes.getRequest();
    }

    /**
     * Gets the session.
     *
     * @return the session
     */
    public HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * Gets the session.
     *
     * @param create the create
     * @return the session
     */
    public HttpSession getSession(boolean create) {
        return getRequest().getSession(create);
    }

    /**
     * Gets the session id.
     *
     * @return the session id
     */
    public String getSessionId() {
        return getSession().getId();
    }

    /**
     * Gets the servlet context.
     *
     * @return the servlet context
     */
    public ServletContext getServletContext() {
        return getSession().getServletContext();    // servlet2.3
    }

    /**
     * Gets the locale.
     *
     * @return the locale
     */
    public Locale getLocale() {
        return RequestContextUtils.getLocale(getRequest());
    }

    /**
     * Gets the theme.
     *
     * @return the theme
     */
    public Theme getTheme() {
        return RequestContextUtils.getTheme(getRequest());
    }

    /**
     * Gets the application context.
     *
     * @return the application context
     */
    public ApplicationContext getApplicationContext() {
        return WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    /**
     * Gets the application event publisher.
     *
     * @return the application event publisher
     */
    public ApplicationEventPublisher getApplicationEventPublisher() {
        return (ApplicationEventPublisher) getApplicationContext();
    }

    /**
     * Gets the locale resolver.
     *
     * @return the locale resolver
     */
    public LocaleResolver getLocaleResolver() {
        return RequestContextUtils.getLocaleResolver(getRequest());
    }

    /**
     * Gets the theme resolver.
     *
     * @return the theme resolver
     */
    public ThemeResolver getThemeResolver() {
        return RequestContextUtils.getThemeResolver(getRequest());
    }

    /**
     * Gets the resource loader.
     *
     * @return the resource loader
     */
    public ResourceLoader getResourceLoader() {
        return (ResourceLoader) getApplicationContext();
    }

    /**
     * Gets the resource pattern resolver.
     *
     * @return the resource pattern resolver
     */
    public ResourcePatternResolver getResourcePatternResolver() {
        return (ResourcePatternResolver) getApplicationContext();
    }

    /**
     * Gets the message source.
     *
     * @return the message source
     */
    public MessageSource getMessageSource() {
        return (MessageSource) getApplicationContext();
    }

    /**
     * Gets the conversion service.
     *
     * @return the conversion service
     */
    public ConversionService getConversionService() {
        return getBeanFromApplicationContext(ConversionService.class);
    }

    /**
     * Gets the data source.
     *
     * @return the data source
     */
    public DataSource getDataSource() {
        return getBeanFromApplicationContext(DataSource.class);
    }

    /**
     * Gets the active profiles.
     *
     * @return the active profiles
     */
    public Collection<String> getActiveProfiles() {
        return Arrays.asList(getApplicationContext().getEnvironment().getActiveProfiles());
    }

    /**
     * Gets the bean class loader.
     *
     * @return the bean class loader
     */
    public ClassLoader getBeanClassLoader() {
        return ClassUtils.getDefaultClassLoader();
    }

    /**
     * Gets the bean from application context.
     *
     * @param <T> the generic type
     * @param requiredType the required type
     * @return the bean from application context
     */
    private <T> T getBeanFromApplicationContext(Class<T> requiredType) {
        try {
            return getApplicationContext().getBean(requiredType);
        } catch (NoUniqueBeanDefinitionException e) {
            LOGGER.error(e.getMessage(), e);
            throw e;
        } catch (NoSuchBeanDefinitionException e) {
            LOGGER.warn(e.getMessage());
            return null;
        }
    }
    
    public School getLoggedInUserSchool(){
    	UserProfileVO userProfileVO = (UserProfileVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	return userProfileVO.getSchool();
    }
    
    public UserProfileVO getLoggedInUserProfile(){
    	UserProfileVO userProfileVO = (UserProfileVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	return userProfileVO;
    }
    
    public User getLoggedInUser(){
    	UserProfileVO userProfileVO = (UserProfileVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = userProfileVO.getUser();
    	return user;
    }
    
    public List<ClassSubjectTeacher> getRespectiveClasses(){
    	UserProfileVO userProfileVO = (UserProfileVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	List<ClassSubjectTeacher> classSubjectTeachers = userProfileVO.getClasses();
    	return classSubjectTeachers;
    }
}