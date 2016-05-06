package org.primefaces.showcase.view.file;
 
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.commons.io.FilenameUtils;
 
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean
public class FileUploadView {
 
    public void handleFileUpload(FileUploadEvent e) throws IOException{
        UploadedFile uploadedPhoto=e.getFile();
		
		String filePath="C:/fotos/";
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
