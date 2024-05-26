//package com.app.global.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//
//public class EncryptAspect {
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
//        Object[] args = joinPoint.getArgs();
//        for (int i = 0; i < args.length; i++) {
//            if (args[i] == requestDto) {
//                args[i] = decryptedDto;
//            }
//        }
//        return joinPoint.proceed(args);
//    }
//}
