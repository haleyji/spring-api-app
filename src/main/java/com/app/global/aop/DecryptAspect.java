//package com.app.global.aop;
//
//import lombok.RequiredArgsConstructor;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
///**
// *  ~RequestDto 의 @Encrypt 어노테이션이 붙은 필드의 암복호화
// */
//@Aspect
//@Component
//@RequiredArgsConstructor
//public class DecryptAspect {
//
//  private final EncryptionKeyRepository encryptionKeyRepository;
//
//    @Around("execution(* com.example.demo.service.*.*(..)) && args(requestDto)")
//    public Object decryptFields(ProceedingJoinPoint joinPoint, BaseRequest requestDto) throws Throwable {
//        String mId = requestDto.getMId();
//        String encryptionKey = encryptionKeyRepository.findKeyByMId(mId);
//
//        if (encryptionKey == null) {
//            throw new CustomBadRequestException("C-001", "mId 오류");
//        }
//
//        BaseRequest decryptedDto = DecryptUtil.decryptFields(requestDto, encryptionKey);
//        // 새로운 DTO로 교체
//        Object[] args = joinPoint.getArgs();
//        for (int i = 0; i < args.length; i++) {
//            if (args[i] == requestDto) {
//                args[i] = decryptedDto;
//            }
//        }
//        return joinPoint.proceed(args);
//    }
//}
