package com.daisuzz.samplethymeleaftodo.configuration

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.validation.Validator
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.web.filter.HiddenHttpMethodFilter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

@Configuration
class ApplicationConfiguration(private val messageSource: MessageSource) : WebMvcConfigurationSupport() {

    override fun getValidator(): Validator {
        return validator()
    }

    // Bean validationのエラーメッセージをValidationMessages.propertiesではなく、
    // SpringのMessageSourceに設定したファイルから取得するための設定
    @Bean
    fun validator(): LocalValidatorFactoryBean {
        return LocalValidatorFactoryBean().apply {
            setValidationMessageSource(messageSource)
        }
    }

    // PUT, DELETEメソッドに変換するServletFilterをBeanとして設定
    @Bean
    fun hiddenHttpMethodFilter(): FilterRegistrationBean<HiddenHttpMethodFilter> {
        val filterRegistrationBean = FilterRegistrationBean(HiddenHttpMethodFilter())
        filterRegistrationBean.urlPatterns = listOf("/*")
        return filterRegistrationBean
    }
}
