package Beans;

import DAO.ServiceDAO;
import DAO.linkDAO;
import DAO.projectDAO;
import DAO.websiteDAO;
import models.Link;
import models.Project;
import models.Service;
import models.Website;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by reda-benchraa on 25/06/17.
 */
@ManagedBean
@ViewScoped
public class WebsiteBean {
    private Website website;
    String value;
    @PostConstruct
    public void init() {
        value =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        website = new websiteDAO().getWebsite(Integer.parseInt(value));
    }
    public void deletelink(int id){
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        if(new linkDAO().deleteLink(id) != -1){
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "link deleted", "link deleted");
        }else{
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error deleting link", "Error deleting link");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("delete", true);
        String url = "website.xhtml?id="+value ;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteService(int id){
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        if(new ServiceDAO().deleteService(id) != -1){
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "service deleted", "service deleted");
        }else{
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error deleting service", "Error deleting service");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("delete", true);
        String url = "website.xhtml?id="+value ;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteProject(int id){
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        if(new projectDAO().deleteProject(id) != -1){
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Project deleted", "Project deleted");
        }else{
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error deleting Project", "Error deleting Project");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("delete", true);
        String url = "website.xhtml?id="+value ;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editlink(int id){
        String url = "updateLink.xhtml?id="+id ;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editService(int id){
        String url = "updateService.xhtml?id="+id ;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editProject(int id){
        String url = "updateProject.xhtml?id="+id ;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addlink(int id){
        String url = "addLink.xhtml?id="+id ;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void edit(int id){
        String url = "updateWebsite.xhtml?id="+id ;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addService(int id){
        String url = "addService.xhtml?id="+id ;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addProject(int id){
        String url = "addProject.xhtml?id="+id ;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

}
