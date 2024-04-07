//package com.example.demo.configure;
//
//import io.github.resilience4j.retry.RetryConfig;
//import org.springframework.retry.RetryContext;
//import org.springframework.retry.RetryPolicy;
//
//public class CustomRetryPolicy implements RetryPolicy {
//    private final RetryConfig retryConfig;
//
//    public CustomRetryPolicy(RetryConfig retryConfig) {
//        this.retryConfig = retryConfig;
//    }
//
//    @Override
//    public boolean canRetry(RetryContext context) {
//        // Your condition to decide whether to retry or not
//        return context.getRetryCount() < retryConfig.getMaxAttempts();
//    }
//
//    @Override
//    public RetryContext open(RetryContext parent) {
////        return new DefaultRetryContext(parent);
//    }
//
//    @Override
//    public void close(RetryContext context) {
//        // Any cleanup code
//    }
//
//    @Override
//    public void registerThrowable(RetryContext context, Throwable throwable) {
//        // Any handling code
//    }
//}
