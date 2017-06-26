package Beans;

import DAO.templateDAO;
import DAO.websiteDAO;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Template;
import models.Website;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.zeroturnaround.zip.ByteSource;
import org.zeroturnaround.zip.FileSource;
import org.zeroturnaround.zip.ZipEntrySource;
import org.zeroturnaround.zip.ZipUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by reda-benchraa on 26/06/17.
 */
@ManagedBean
@ViewScoped
public class GenerationBean {
    private Collection<Template> templates;
    private Template template;
    String value;
    private StreamedContent file;
    public static String SOURCE_FOLDER;
    Website website;
    ArrayList<String> fileList;
    @PostConstruct
    void init(){
        value =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        website = new websiteDAO().getWebsite(Integer.parseInt(value));
        templates = new templateDAO().getTemplates();
    }

    public void generateFile(){
        System.out.println("Template : "+ template);
        SOURCE_FOLDER = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")+"/Templates/"+template.getLink();
        fileList = new ArrayList<String>();
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")+ "/Templates/";
        String imagesPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")+ "/uploads/";
        ZipUtil.pack(new File(imagesPath), new File(path+website.getName()+"Images.zip"));
        ZipEntrySource[] entries = new ZipEntrySource[] {
                new FileSource("uploads.zip", new File(path+website.getName()+"Images.zip")),
                new ByteSource("data.json",getJSON().getBytes())
        };
        ZipUtil.pack(new File(SOURCE_FOLDER), new File(path+website.getName()+".zip"));
        ZipUtil.addEntries(new File(path+website.getName()+".zip"), entries, new File(path+website.getName()+"1.zip"));
    }

    public String getJSON() {
        Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        Website website = new websiteDAO().getWebsite(Integer.parseInt(value));
        StringBuilder json = new StringBuilder();
        json.append(gson.toJson(website));
        return json.toString();
    }

    public Collection<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(Collection<Template> templates) {
        this.templates = templates;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
    public void setTe(Template te){
        this.template = te;
    }
    public StreamedContent getFile() {
        return file;
    }

}
