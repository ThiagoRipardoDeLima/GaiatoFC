package br.com.gaiatosfc.beans;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean
public class buttonView {
    
    private UploadedFile file;
    private String stringFile = "imagens/download.png";
    
    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String getStringFile(){
        return stringFile;
    }
    
    public UploadedFile getFile(){
            return file;
    }
    
    public void setFile(UploadedFile file){
        this.file = file;
    }
    
    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    
}