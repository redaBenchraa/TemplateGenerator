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
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

    public StreamedContent generateFile(){
        System.out.println("Template : "+ template);
        SOURCE_FOLDER = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")+"/Templates/"+template.getLink();
        fileList = new ArrayList<String>();
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")+ "/Templates/";
        String imagesPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")+ "/uploads/";
        String fileName = path + website.getName() + new Date().getTime();

        ZipUtil.pack(new File(imagesPath), new File(fileName+"Images"));
        ZipEntrySource[] entries = new ZipEntrySource[] {
                new FileSource("uploads.zip", new File(fileName+"Images")),
                new ByteSource("data.json",getJSON().getBytes())
        };
        ZipUtil.pack(new File(SOURCE_FOLDER), new File(fileName));
        ZipUtil.addEntries(new File(fileName), entries, new File(fileName+".zip"));
        new File(fileName).delete();
        new File(fileName+"Images").delete();
        InputStream is = null;
        try {
            is = new ByteArrayInputStream( Files.readAllBytes(new File(fileName+".zip").toPath()) );
        } catch (IOException e) {
            e.printStackTrace();
        }
        file = new DefaultStreamedContent(is, "text", website.getName()+".zip");
        return file;
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
