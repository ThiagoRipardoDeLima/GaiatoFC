package net.javaonline.jsf.primefaces.fileupload.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;


@ManagedBean(name="fileUploadBean")
@RequestScoped

public class FileUploadBean implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	private String name;
	private UploadedFile resume;

	
	public UploadedFile getResume() {
		return resume;
	}

	public void setResume(UploadedFile resume) {
		this.resume = resume;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	
	
	public String uploadResume() throws IOException{
		
		UploadedFile uploadedPhoto=getResume();
		//System.out.println("Name " + getName());
		//System.out.println("tmp directory" System.getProperty("java.io.tmpdir"));
		//System.out.println("File Name " + uploadedPhoto.getFileName());
		//System.out.println("Size " + uploadedPhoto.getSize());
		String filePath="C:/";
        byte[] bytes=null;

            if (null!=uploadedPhoto) {
                bytes = uploadedPhoto.getContents();
                String filename = FilenameUtils.getName(uploadedPhoto.getFileName());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath+filename)));
                stream.write(bytes);
                stream.close();
            }
           
        return "successo";
	}
	
	/* 	The above code is for file upload using simple mode. if you set mode ="advanced" in the <p:fileupload> component, then the above  code is not required including properties (i.e. name & photo).  */
	
	
	
	
	
	//This below code is for file upload with advanced mode.
	
	public void uploadPhoto(FileUploadEvent e) throws IOException{

		UploadedFile uploadedPhoto=e.getFile();
		
		String filePath="C:/";
        byte[] bytes=null;

            if (null!=uploadedPhoto) {
                bytes = uploadedPhoto.getContents();
                String filename = FilenameUtils.getName(uploadedPhoto.getFileName());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath+filename)));
                stream.write(bytes);
                stream.close();
            }
           
		
        FacesContext.getCurrentInstance().addMessage("messages",new FacesMessage(FacesMessage.SEVERITY_INFO,""+ uploadedPhoto.getFileName()+ " de "+ uploadedPhoto.getSize()+ "bites foi upado com sucesso", ""));
	}
	
	

	
	

}
