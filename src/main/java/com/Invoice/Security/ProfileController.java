package com.Invoice.Security;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/auth")
public class ProfileController {
	private final String UPLOAD_DIR = "src/main/resources/static/uploads/";

	@PostMapping("/upload")
	public String uploadProfilePicture(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return "Please select a file to upload.";
		}

		try {
			// Save the file to the specified directory
			Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
			Files.createDirectories(path.getParent());
			Files.write(path, file.getBytes());

			// Construct the URL to access the uploaded file
			String fileUrl = "uploads/" + file.getOriginalFilename();
			return fileUrl; // Return the URL of the uploaded file
		} catch (IOException e) {
			e.printStackTrace();
			return "Failed to upload file: " + e.getMessage();
		}
	}
}