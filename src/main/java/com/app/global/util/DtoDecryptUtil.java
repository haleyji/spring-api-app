//package com.app.global.util;
//
//import java.lang.reflect.Field;
//
//public class DtoDecryptUtil {
//    public static <T> T decryptFields(T dto, String key) {
//        T dtoCopy = copyDto(dto); // DTO 복사 (빌더 패턴 사용)
//        Field[] fields = dtoCopy.getClass().getDeclaredFields();
//
//        for (Field field : fields) {
//            if (field.isAnnotationPresent(Encrypt.class)) { //어노테이션 추가
//                field.setAccessible(true);
//                try {
//                    String encryptedValue = (String) field.get(dtoCopy);
//                    String decryptedValue = ""; //AESUtil.decrypt(key, encryptedValue);
//                    field.set(dtoCopy, decryptedValue);
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException("필드 접근 오류", e);
//                }
//            }
//        }
//        return dtoCopy;
//    }
//
//    private static <T> T copyDto(T dto) {
//        try {
//            return (T) dto.getClass().getMethod("toBuilder").invoke(dto).getClass().getMethod("build").invoke(dto.getClass().getMethod("toBuilder").invoke(dto));
//        } catch (Exception e) {
//            throw new RuntimeException("DTO 복사 오류", e);
//        }
//    }
//}
