package com.rahul.movieapibackend.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements  FileService {



    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {

        //get name of the file
        String fileName = file.getOriginalFilename(); //this method is inbuilt to get the filename

        //to get the file path
        String filePath = path + File.separator + fileName; // this File.separator is an inbuilt
        // method from File work's as an identifications  these two thing s to  be appended

        // create a file object
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        //copy the file or upload the file to the path
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

    @Override
    public InputStream getResourceFile(String path, String fileName) throws FileNotFoundException {


        String filePath = path + File.separator + fileName;
        File file = new File(filePath);
        if(!file.exists()){
            throw new FileNotFoundException("File not found"+filePath);
        }

        return new FileInputStream(file);
    }
}
