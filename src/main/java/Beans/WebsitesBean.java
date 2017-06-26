package Beans;

import DAO.userDAO;
import DAO.websiteDAO;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.User;
import models.Website;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.xml.ws.WebEndpoint;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Rabab Chahboune on 6/22/2017.
 */
@ManagedBean
@ViewScoped
public class WebsitesBean implements Serializable {
    private List<Website> websites;
    User user;
    private StreamedContent file;

    @PostConstruct
    public void init() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        user = new userDAO().getUser(Integer.parseInt(String.valueOf(servletContext.getAttribute("idUser"))));
        websites = (List<Website>) user.getWebsites();
    }

    public List<Website> getWebsites() {
        return websites;
    }
    public void delete(int id){
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        if(new websiteDAO().deleteWebsite(id) != -1){
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Website deleted", "Website deleted");
        }else{
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error deleting websites", "Erro deleting websites");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("delete", true);
    }
    public void add(){
        String url = "addWebsite.xhtml" ;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void view(int id){
        String url = "website.xhtml?id="+id ;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public StreamedContent getJSON(int id) {

        Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .excludeFieldsWithoutExposeAnnotation()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        Website website = new websiteDAO().getWebsite(id);
        StringBuilder json = new StringBuilder();
        json.append(gson.toJson(website));
        System.out.println(json);
        InputStream is = new ByteArrayInputStream( json.toString().getBytes() );
        file = new DefaultStreamedContent(is, "text", website.getName()+".json");
        return file;
    }
    public void generate(int id){
        String url = "generation.xhtml?id="+id ;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public StreamedContent getFile() {
        return file;
    }
}
