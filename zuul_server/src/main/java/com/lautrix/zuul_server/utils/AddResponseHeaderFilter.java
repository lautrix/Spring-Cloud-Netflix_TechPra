package com.lautrix.zuul_server.utils;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_RESPONSE_FILTER_ORDER;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;

public class AddResponseHeaderFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return POST_TYPE;
  }

  @Override
  public int filterOrder() {
    return SEND_RESPONSE_FILTER_ORDER - 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext context = RequestContext.getCurrentContext();
    HttpServletResponse servletResponse = context.getResponse();
    servletResponse.addHeader("X-Sample", UUID.randomUUID().toString());
    return null;
  }
}
