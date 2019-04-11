# StudyJavaWeb_msg_02
第一个版本可以分页，jsp原生敲的，新版本做出修改。使用ThreadLocal，分页框架

使用了ThreadLocal来传递分页信息
通过Filter来完成对分页信息的过滤
使用jsp分页工具pager-taglib来完成分页

异常：在登录的时候，后台会报错：java.lang.NumberFormatException: null
异常定位到过滤器的:servletChain.doFilter(request,response)
不影响程序运行，但是为什么呢？太菜了，等以后再看吧。
