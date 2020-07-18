package com.dreamix.travelers.utility;

public class ImageBase64Utility {
    public static ImageInfoBase64 getImageSourceAndContentTypeFromBase64String(String imageBase64) {
        String[] splitedImageSource = imageBase64.split(",");

        return new ImageInfoBase64(splitedImageSource[1], splitedImageSource[0]);
    }

    public static String generateBase64ImageFromSourceAndContentType(String source, String contentType) {
        String imageAsBase64 = contentType.concat(",").concat(source);

        return imageAsBase64;
    }
}

