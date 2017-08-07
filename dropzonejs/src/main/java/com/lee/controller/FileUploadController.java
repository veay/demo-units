package com.lee.controller;

import com.lee.model.UploadedFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class FileUploadController {

  @Value("${file.upload.path}")
  private String uploadPath;

  @RequestMapping("/")
  public Object home(Model model) {

    return "fileUploader";
  }

  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  public @ResponseBody
  List<UploadedFile> upload(MultipartHttpServletRequest request,
                            HttpServletResponse response) throws IOException {

    Map<String, MultipartFile> fileMap = request.getFileMap();

    List<UploadedFile> uploadedFiles = new ArrayList<UploadedFile>();


    for (MultipartFile multipartFile : fileMap.values()) {

      saveFileToLocalDisk(multipartFile);

      UploadedFile fileInfo = getUploadedFileInfo(multipartFile);

      uploadedFiles.add(fileInfo);
    }

    return uploadedFiles;
  }




  private void saveFileToLocalDisk(MultipartFile multipartFile) throws IOException,
      FileNotFoundException {

    String outputFileName = getOutputFilename(multipartFile);

    FileCopyUtils.copy(multipartFile.getBytes(), new FileOutputStream(outputFileName));
  }


  private String getOutputFilename(MultipartFile multipartFile) {

    return getDestinationLocation() + multipartFile.getOriginalFilename();
  }

  private UploadedFile getUploadedFileInfo(MultipartFile multipartFile) throws IOException {

    UploadedFile fileInfo = new UploadedFile();
    fileInfo.setName(multipartFile.getOriginalFilename());
    fileInfo.setSize(multipartFile.getSize());
    fileInfo.setType(multipartFile.getContentType());
    fileInfo.setLocation(getDestinationLocation());

    return fileInfo;
  }

  private String getDestinationLocation() {
    return uploadPath;
  }
}
