package com.zeus.rcode.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zeus.rcode.models.Image;
import com.zeus.rcode.repositories.ImageRepository;

@Service
public class ImageServices {
	private ImageRepository imageRepository;
	public ImageServices(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}
	public List<Image> getAll(){
		return imageRepository.findAll();
	}
	public Image getImage(Long id) {
		return imageRepository.findOne(id);
	}
	public void addImage(Image image) {
		imageRepository.save(image);
	}
	public void deleteImage(Long id) {
		imageRepository.delete(id);
	}
}
