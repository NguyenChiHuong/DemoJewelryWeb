package com.webbanhang.service.impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {
	 private final Cloudinary cloudinary;

	    @Autowired
	    public CloudinaryService(Cloudinary cloudinary) {
	        this.cloudinary = cloudinary;
	    }

	    @SuppressWarnings("unchecked")
		public Map<String, Object> uploadFile(MultipartFile file) throws IOException {
	        return cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
	    }
}
