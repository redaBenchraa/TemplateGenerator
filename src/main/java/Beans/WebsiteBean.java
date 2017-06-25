package Beans;

import DAO.websiteDAO;
import models.Link;
import models.Project;
import models.Service;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by reda-benchraa on 25/06/17.
 */
@ManagedBean

public class WebsiteBean {
    private List<Link> links;
    private List<Project> projects;
    private List<Service> services;
    @PostConstruct
    public void init() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

    }
    public void delete(int id){

        RequestContext context = RequestContext.getCurrentInstance();

        FacesMessage message = null;
        if(new websiteDAO().deleteWebsite(id) != -1){
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Website deleted", "Website deleted");
        }else{
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error deleting websites", "Erro deleting websites");
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error deleting websites", "Erro deleting websites");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("delete", true);
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
