//package com.app.global.util;
//
//public class EncryptUtil {
//    public static <T> T encryptFields(T dto, String key) {
//        try {
//            Object builder = dto.getClass().getMethod("toBuilder").invoke(dto);
//            Field[] fields = dto.getClass().getDeclaredFields();
//
//            for (Field field : fields) {
//                if (field.isAnnotationPresent(Encrypt.class)) {
//                    field.setAccessible(true);
//                    String value = (String) field.get(dto);
//                    String encryptedValue = AESUtil.encrypt(key, value);
//                    builder.getClass().getMethod(field.getName(), String.class).invoke(builder, encryptedValue);
//                }
//            }
//
//            return (T) builder.getClass().getMethod("build").invoke(builder);
//        } catch (Exception e) {
//            throw new RuntimeException("DTO 복사 오류", e);
//        }
//    }
//}
